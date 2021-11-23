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
        Intent intent = new Intent(CriarConta.this, MainActivity.class);
        ArrayList<Contas> contaNova = new ArrayList<Contas>();
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
                        if ((getIntent().getSerializableExtra("listas")) == null)
                        {
                            Contas c1 = new Contas(txtnu.getText().toString(), txtpass.getText().toString());
                            contaNova.add(c1);
                            intent.putExtra("lista", contaNova);
                            startActivity(intent);
                        }else{
                            ArrayList<Contas> contas;
                            contas = (ArrayList<Contas>) getIntent().getSerializableExtra("listas");
                            Contas c1 = new Contas(txtnu.getText().toString(), txtpass.getText().toString());
                            contas.add(c1);
                            intent.putExtra("lista", contas);
                            startActivity(intent);
                        }
                        //adicionar os valores a classe



                    }
                    else {

                        Toast.makeText(getApplicationContext(),"A password não condiz com a confirmação",Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "onClick2: ");
                    }
                }
            }
        });

    }
}