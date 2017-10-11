package com.vbllopes.ongherdeiros.Activity;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TabHost;
import android.widget.TextView;

import com.vbllopes.ongherdeiros.R;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarTab();
        //Arruma texto do TabHost
        TextView x1 = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x1.setTextSize(12);
        TextView x2 = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        x2.setTextSize(5);
        x2.setGravity(Gravity.CENTER);
        TextView x3 = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        x3.setTextSize(8);
        x3.setGravity(Gravity.CENTER);
        TextView x4 = (TextView) tabHost.getTabWidget().getChildAt(3).findViewById(android.R.id.title);
        x4.setTextSize(10);
        x4.setGravity(Gravity.CENTER);
        TextView x5 = (TextView) tabHost.getTabWidget().getChildAt(4).findViewById(android.R.id.title);
        x5.setTextSize(9);


    }

    private void inicializarTab() {
        tabHost = (FragmentTabHost) findViewById(R.id.TbHost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //Criar as Tabs
        Resources res = getResources();
        TabHost.TabSpec tab1 = tabHost.newTabSpec("video");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("apoie");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("doar");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("doarItem");
        TabHost.TabSpec tab5 = tabHost.newTabSpec("eventos");
        tab1.setIndicator(res.getString(R.string.telaVideo),null);
        tab2.setIndicator(res.getString(R.string.apoie),null);
        tab3.setIndicator(res.getString(R.string.doar), null);
        tab4.setIndicator(res.getString(R.string.doarItem),null);
        tab5.setIndicator(res.getString(R.string.eventos),null);

        tabHost.addTab(tab1, video.class, null);
        tabHost.addTab(tab2, apoie.class, null);
        tabHost.addTab(tab3, doar.class, null);
        tabHost.addTab(tab4, querodoar.class, null);
        tabHost.addTab(tab5, eventos.class, null);




    }
    
}
