package com.vbllopes.ongherdeiros.Activity;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.vbllopes.ongherdeiros.Email.SendMail;
import com.vbllopes.ongherdeiros.R;

/**
 * Created by vinciusbecker on 5/28/17.
 */

public class apoie extends Fragment {

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextCelular;
    private EditText editTextEmpresa;
    private EditText editTextSite;
    private EditText editTextMensagem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.apoie, container, false);

        editTextNome = (EditText) v.findViewById(R.id.editTextNome);
        editTextEmail = (EditText) v.findViewById(R.id.editTextEmail);
        editTextTelefone = (EditText) v.findViewById(R.id.editTextTelefone);
        editTextCelular = (EditText) v.findViewById(R.id.editTextCelular);
        editTextEmpresa = (EditText) v.findViewById(R.id.editTextEmpresa);
        editTextSite = (EditText) v.findViewById(R.id.editTextSite);
        editTextMensagem = (EditText) v.findViewById(R.id.editTextMensagem);
        ImageButton imageButtonEnviar = (ImageButton) v.findViewById(R.id.imageButtonEnviar);
        imageButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pegar conteudo do email e juntar no Corpo
                String email = "vbllopes@gmail.com";
                String subject = "Quero apoiar o Herdeiros do Futuro: " + editTextNome.getText().toString().trim();
                String message = "Nome: " + editTextNome.getText().toString().trim() + "\nEmail: " +
                        editTextEmail.getText().toString().trim() + "\nTelefone: " +
                        editTextTelefone.getText().toString().trim() + "\nCelular: " +
                        editTextCelular.getText().toString().trim() + "\nEmpresa: " +
                        editTextEmpresa.getText().toString().trim() + "\nSite: " +
                        editTextSite.getText().toString().trim() + "\nMensagem: " +
                        editTextMensagem.getText().toString().trim();

                //Criar o Objeto SendMail
                SendMail sm = new SendMail(apoie.this.getContext(), email, subject, message);

                //Executing sendmail to send email
                sm.execute();
            }
        });
        return v;
    }


}
