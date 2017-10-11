package com.vbllopes.ongherdeiros;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vbllopes.ongherdeiros.Activity.querodoar;

import java.util.List;

import static com.vbllopes.ongherdeiros.R.id.tvItem;

/**
 * Created by NgocTri on 3/11/2017.
 */

public class ImageListAdapter extends ArrayAdapter<ImageUpload> {
    private Activity context;
    private int resource;
    private List<ImageUpload> listImage;

    public ImageListAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<ImageUpload> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        listImage = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View v = inflater.inflate(resource, null);
        TextView tvName = (TextView) v.findViewById(tvItem);
        ImageView img = (ImageView) v.findViewById(R.id.imgItem);

        tvName.setText(listImage.get(position).getNome());
        Glide.with(context).load(listImage.get(position).getUrl()).into(img);

        return v;

    }
}
