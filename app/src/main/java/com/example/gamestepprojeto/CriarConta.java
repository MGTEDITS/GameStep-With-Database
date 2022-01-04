package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class CriarConta extends AppCompatActivity {

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
        txtcpass=findViewById(R.id.txtconfpass);

        UtilizadorDAO utilizadorDAO = new UtilizadorDAO(this);
        DbHelper dbHelper = new DbHelper(this);
        Intent intent = new Intent(CriarConta.this, MainActivity.class);
        btncriarc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                //Testar se existe espaços em branco
                if (txtnu.getText().toString().matches("")||txtemail.getText().toString().matches("")||txtpass.getText().toString().matches("") || txtcpass.getText().toString().matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Falta preencher espaços",Toast.LENGTH_LONG).show();
                    Log.d("TAG", "onClick: ");
                }
                else
                {
                    //Testar se a password Coincide
                    if (txtpass.getText().toString().matches(txtcpass.getText().toString()))
                    {

                            Contas conta = new Contas(txtnu.getText().toString(), txtpass.getText().toString(), txtemail.getText().toString() );
                            dbHelper.inserirUtilizador(conta);
                            startActivity(intent);
                            enviaremail();

                    }
                    else {

                        Toast.makeText(getApplicationContext(),"A password não condiz com a confirmação",Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onClick2: ");
                    }
                }
            }
        });

    }

    private void enviaremail(){
        String mail = txtemail.getText().toString().trim();
        Toast.makeText(getApplicationContext(), ""+txtemail.getText().toString(), Toast.LENGTH_SHORT).show();
        String Subject = "Verificar Conta";
        Random r = new Random();
        Integer i = r.nextInt((999999 - 100000) +1) + 1000;
        String Mensagem = i.toString();
        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, Subject ,Mensagem);
        javaMailAPI.execute();
    }
}