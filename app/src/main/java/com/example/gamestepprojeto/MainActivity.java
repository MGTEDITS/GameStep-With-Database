package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Local onde se da as variaveis dos objetos do XML

    ImageButton btniniciarsessao;
    EditText txtnui , txtpassi;
    TextView registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Find aos objetos do XML

        setContentView(R.layout.activity_main);
        txtnui=findViewById(R.id.txtnui);
        txtpassi=findViewById(R.id.txtpassi);
        btniniciarsessao=findViewById(R.id.btniniciarsessao);
        registrar=findViewById(R.id.lbcriar);
        ArrayList<Contas> contas;

        contas = (ArrayList<Contas>) getIntent().getSerializableExtra("lista");
        //chamar a activity criarconta

        Intent intent = new Intent(MainActivity.this, CriarConta.class);


        btniniciarsessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Verificar se o Utilizador Existe
                for (Contas name : contas) {



                    if (txtnui.getText().toString().equals(name.getUtilizador().toString()))
                    {

                        //Verificar se a password está correta

                        if (txtpassi.getText().toString().equals(name.getPassword().toString()))
                        {
                            //Abrir a Atividade da pagina inicial
                            Intent intent1 = new Intent(MainActivity.this, PageInitialActivity.class);
                            startActivity(intent1);

                        } else {
                            Toast.makeText(getApplicationContext(), "Password Incorreta", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }

         });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Iniciar a atividade criar conta

                Intent intent = new Intent(MainActivity.this, CriarConta.class);
                intent.putExtra("listas",contas);
                startActivity(intent);
            }
        });


    }
}