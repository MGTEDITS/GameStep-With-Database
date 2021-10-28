package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class criarconta extends AppCompatActivity {

ImageButton btncriarc;
EditText txtnu;
EditText txtpass;
EditText txtemail;
EditText txtcpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criarconta);

        btncriarc=findViewById(R.id.btncriarconta);
        txtnu=findViewById(R.id.txtnu);
        txtemail=findViewById(R.id.txtemail);
        txtpass=findViewById(R.id.txtpass);
        List <Contas> contas;
        contas= new ArrayList<Contas>();
        btncriarc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nu = txtnu.getText().toString();
                String mail = txtemail.getText().toString();
                String pass = txtpass.getText().toString();





                if (nu.matches("")||mail.matches("")||pass.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Falta preencher espaços",Toast.LENGTH_LONG);
                }
                else
                {
                    Contas c1= new Contas(txtnu.getText().toString(),txtpass.getText().toString());
                    contas.add(c1);
                    Intent intent = new Intent(criarconta.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}