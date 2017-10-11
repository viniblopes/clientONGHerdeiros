package com.vbllopes.ongherdeiros.Activity;


import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.vbllopes.ongherdeiros.R;

/**
 * Created by vinciusbecker on 5/28/17.
 */

public class video extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.video, container, false);
        VideoView vView = (VideoView) v.findViewById(R.id.videoHerdeiros);
        Uri src = Uri.parse("android.resource://com.vbllopes.ongherdeiros/raw/video");
        vView.setVideoURI(src);
        vView.setMediaController(new MediaController(v.getContext()));
        vView.start();

        return v;
    }
}
