package com.example.gamestepprojeto;

public class Contas {

    String utilizador;
    String password;

    public Contas(String utilizador, String password) {
        this.utilizador = utilizador;
        this.password = password;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}