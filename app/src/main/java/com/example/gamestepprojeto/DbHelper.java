package com.example.gamestepprojeto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {



    public static final String tableUtilizador = "create table utilizador (nomeUtilizador TEXT PRIMARY KEY, email TEXT not null, password TEXT not null)";

    public DbHelper(Context context) {
      super(context, "bdGameStep", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableUtilizador);
        Log.i("cd", "BD Criada Com sucesso");

    }

    public void inserirUtilizador(Contas contas){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nomeUtilizador",contas.getUtilizador());
        contentValues.put("email",contas.getEmail());
        contentValues.put("password", contas.getPassword());
        db.insert("utilizador", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       //db.execSQL("DROP TABLE IF EXISTS " + tableTeste);
       // onCreate(db);
    }

}
