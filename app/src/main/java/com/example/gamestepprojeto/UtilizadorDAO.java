package com.example.gamestepprojeto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UtilizadorDAO {

    private SQLiteDatabase dbUtilizador;
    private DbHelper dbHelper;
    private List<Contas> contasList;

    public UtilizadorDAO(Context context){
        dbHelper = new DbHelper(context);
        dbUtilizador = dbHelper.getWritableDatabase();

    }

    @SuppressLint("Range")
    public List<Contas> getConta(String username) {
        String strSql = "select * from utilizador WHERE nomeUtilizador = '" + username + "'";
        ArrayList<Contas> contas = new ArrayList<Contas>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(strSql, null);
        if (c.moveToFirst()) {
            do {
                Contas contass = new Contas();
                contass.setUtilizador(c.getString(c.getColumnIndex("nomeUtilizador")));
                contass.setPassword(c.getString(c.getColumnIndex("password")));
                contass.setEmail(c.getString(c.getColumnIndex("email")));
                contas.add(contass);
            } while (c.moveToNext());
        }
        return contas;
    }

}
