package com.vbllopes.ongherdeiros.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.vbllopes.ongherdeiros.R;

/**
 * Created by vinciusbecker on 5/28/17.
 */

public class doar extends Fragment {

    WebView wb;
    String paypal = "<form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\" align=\"center\">\n" +
            "<input type=\"hidden\" name=\"cmd\" value=\"_donations\">\n" +
            "<input type=\"hidden\" name=\"business\" value=\"vbllopes@gmail.com\">\n" +
            "<input type=\"hidden\" name=\"lc\" value=\"BR\">\n" +
            "<input type=\"hidden\" name=\"item_name\" value=\"ONG Herdeiros\">\n" +
            "<input type=\"hidden\" name=\"no_note\" value=\"0\">\n" +
            "<input type=\"hidden\" name=\"currency_code\" value=\"BRL\">\n" +
            "<input type=\"hidden\" name=\"bn\" value=\"PP-DonationsBF:btn_donateCC_LG.gif:NonHostedGuest\">\n" +
            "<input type=\"image\" src=\"https://www.paypalobjects.com/pt_BR/BR/i/btn/btn_donateCC_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - A maneira fácil e segura de enviar pagamentos online!\">\n" +
            "<img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/pt_BR/i/scr/pixel.gif\" width=\"1\" height=\"1\">\n" +
            "</form>";

    @Override
    public void onResume() {
        super.onResume();
        wb.loadData(paypal, "text/html",null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);




        View v = inflater.inflate(R.layout.doar, container, false);
        wb = (WebView) v.findViewById(R.id.webView);
        wb.loadData(paypal, "text/html",null);
        return v;
    }
}
