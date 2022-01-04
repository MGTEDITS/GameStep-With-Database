package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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


        //chamar a activity criarconta

        Intent intent = new Intent(MainActivity.this, CriarConta.class);


        btniniciarsessao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilizadorDAO utilizadorDAO = new UtilizadorDAO(getApplicationContext());

                if (txtnui.getText().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Utilizador Vazio! Por Favor Insira", Toast.LENGTH_SHORT).show();
                }
                else if(txtpassi.getText().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Palavra-Passe Vazia! Por Favor Insira", Toast.LENGTH_SHORT).show();
                }
                else{
                    List<Contas> contas = utilizadorDAO.getConta(txtnui.getText().toString());
                    if (contas.size() == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Conta não Existe", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Contas contas1 = new Contas();
                        contas1.setEmail(contas.get(0).getEmail());
                        contas1.setPassword(contas.get(0).getPassword());
                        contas1.setUtilizador(contas.get(0).getUtilizador());
                        if (contas1.verifyPassword(contas1,txtpassi.getText().toString())){
                            Intent intent1 = new Intent(MainActivity.this,PageInitialActivity.class);
                            startActivity(intent1);
                        }else {
                            Toast.makeText(getApplicationContext(), "PassWord Incorreta!", Toast.LENGTH_SHORT).show();
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
                startActivity(intent);
            }
        });


    }
    public String hashPassword(String password){ try
    {
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(password.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format
        password = sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

        return password;
    }
}

