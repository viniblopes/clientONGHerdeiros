package com.vbllopes.ongherdeiros;

/**
 * Created by vinciusbecker on 6/4/17.
 */

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.vbllopes.ongherdeiros.R.id.tvEvento;

public class EventoListAdapter extends ArrayAdapter<EventoUpload>{

    private Activity context;
    private int resource;
    private List<EventoUpload> listEvento;

    public EventoListAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<EventoUpload> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        listEvento = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View v = inflater.inflate(resource, null);
        TextView tvNome = (TextView) v.findViewById(tvEvento);
        tvNome.setText(listEvento.get(position).getNome() + " - " + listEvento.get(position).getData());

        return v;

    }

}
