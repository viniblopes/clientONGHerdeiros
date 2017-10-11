package com.vbllopes.ongherdeiros.Activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.vbllopes.ongherdeiros.ImageListAdapter;
import com.vbllopes.ongherdeiros.ImageUpload;
import com.vbllopes.ongherdeiros.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinciusbecker on 5/28/17.
 */

public class querodoar extends Fragment {


    private DatabaseReference mDatabaseRef;

    private List<ImageUpload> imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;
    public static final String FB_DATABASE_PATH = "itens";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.querodoar, container, false);
        imgList = new ArrayList<>();
        lv = (ListView) v.findViewById(R.id.lvItens);
        //Show progress dialog during list image loading
        progressDialog = new ProgressDialog(v.getContext());
        progressDialog.setMessage(getResources().getString(R.string.baixandoItens));
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //Fetch image data from firebase database
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUpload class require default constructor
                    ImageUpload img = snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }


                //Init adapter
                adapter = new ImageListAdapter(querodoar.this.getActivity(), R.layout.listaitens, imgList);
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
