package com.example.gamestepprojeto;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Contas implements Serializable {

    String utilizador;
    String email;
    String password;

    public Contas() {
    }

    public Contas(String utilizador, String password, String email) {
        this.utilizador = utilizador;
        this.email = email;
        this.password = hashPassword(password);
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
    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean verifyPassword (Object contas, String pass){

        Contas contasA = (Contas) contas;
        System.out.println("--------------->"+contasA.getPassword());
        if (hashPassword(pass).equals(contasA.getPassword())){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Contas{" +
                "utilizador='" + utilizador + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
