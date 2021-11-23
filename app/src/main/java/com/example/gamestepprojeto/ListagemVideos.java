package com.example.gamestepprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class ListagemVideos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_videos);

        ListView listVideos = findViewById(R.id.list_videos);

        //Coloquei todos os tipos de video dentro desta array de Strings
        String listaVideosArray[]
                = { "Far Cry 6 Cinematic Trailer", "Halo Infinite Campaign Trailer",
                "Doom Enternal Horde Mode Trailer", "Battlefield 2042 Gameplay Trailer",
                "Call of Duty Vanguard Trailer", "Grand Theft Auto: Trilogy Remastered Trailer",
                "Dying Light 2 Stay Human Gameplay Trailer", "Saints Row Map trailer"};

        //Aqui defeni o layout da listview
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listaVideosArray);
        listVideos.setAdapter(arr);


        listVideos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                //aqui faço o teste se executei o Battlefield 20..... e abro a atividade de leitor de videos por youtube

                String inlink="";
                if (item.equals("Battlefield 2042 Gameplay Trailer")) {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="WomAGoEh-Ss";
                    intent.putExtra("link",inlink);
                    intent.putExtra("titulo","Battlefield 2042 Gameplay Trailer");
                    startActivity(intent);
                }
                else if (item.equals("Far Cry 6 Cinematic Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="6UaWhlkpT7g";
                    intent.putExtra("link",inlink);
                    intent.putExtra("titulo","Far Cry 6 Cinematic Trailer");
                    startActivity(intent);
                }
                else if (item.equals("Halo Infinite Campaign Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="XCbMVbeKlCg";
                    intent.putExtra("titulo","Halo Infinite Campaign Trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }
                else if (item.equals("Doom Enternal Horde Mode Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="ySMxOmPM4kI";
                    intent.putExtra("titulo","Doom Enternal Horde Mode Trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }
                else if (item.equals("Call of Duty Vanguard Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="OQ1CwPhE8KQ";
                    intent.putExtra("titulo","Call of Duty Vanguard Trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }
                else if (item.equals("Grand Theft Auto: Trilogy Remastered Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="bZ_0E4yWbBI";
                    intent.putExtra("titulo","Grand Theft Auto: Trilogy Remastered Trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }
                else if (item.equals("Dying Light 2 Stay Human Gameplay Trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="UwJAAy7tPhE";
                    intent.putExtra("titulo","Dying Light 2 Stay Human Gameplay Trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }
                else if (item.equals("Saints Row Map trailer"))
                {
                    Intent intent = new Intent(ListagemVideos.this, LeitorVideo.class);
                    inlink="_xtIe2on9ZI";
                    intent.putExtra("titulo","Saints Row Map trailer");
                    intent.putExtra("link",inlink);
                    startActivity(intent);
                }

            }
        });

    }


}