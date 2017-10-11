package com.vbllopes.ongherdeiros.Activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vbllopes.ongherdeiros.EventoListAdapter;
import com.vbllopes.ongherdeiros.EventoUpload;
import com.vbllopes.ongherdeiros.ImageListAdapter;
import com.vbllopes.ongherdeiros.ImageUpload;
import com.vbllopes.ongherdeiros.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinciusbecker on 5/28/17.
 */



public class eventos extends Fragment {

    private DatabaseReference mDatabaseRef;
    private List<EventoUpload> eventoList;
    private ListView lv;
    private EventoListAdapter adapter;
    private ProgressDialog progressDialog;
    public static final String FB_DATABASE_PATH = "event";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.eventos, container, false);
        eventoList = new ArrayList<>();
        lv = (ListView) v.findViewById(R.id.lvEventos);
        progressDialog = new ProgressDialog(v.getContext());
        progressDialog.setMessage(getResources().getString(R.string.baixandoEventos));
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetch image data from firebase database
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUpload class require default constructor
                    EventoUpload evento = snapshot.getValue(EventoUpload.class);
                    eventoList.add(evento);
                }


                //Init adapter
                adapter = new EventoListAdapter(eventos.this.getActivity(), R.layout.listaeventos, eventoList);
                //Set adapter for listview
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });

        return v;
    }
}
