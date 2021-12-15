package com.example.gamestepprojeto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class UtilizadorDAO {

    private SQLiteDatabase dbUtilizador;
    private DbHelper dbHelper;
    private List<Contas> contasList;

    public UtilizadorDAO(Context context){
        dbHelper = new DbHelper(context);
        dbUtilizador = dbHelper.getWritableDatabase();

    }

}
