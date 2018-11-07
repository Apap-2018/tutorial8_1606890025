package com.apap.tutorial8.model;

public class ChangePasswordModel {
    String username;

    String passwordLama;

    String passwordBaru;

    String konfirmasiPasswordBaru;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordLama() {
        return this.passwordLama;
    }

    public void setPasswordLama(String passwordLama) {
        this.passwordLama = passwordLama;
    }

    public String getPasswordBaru() {
        return this.passwordBaru;
    }

    public void setPasswordBaru(String passwordBaru) {
        this.passwordBaru = passwordBaru;
    }

    public String getKonfirmasiPasswordBaru() {
        return this.konfirmasiPasswordBaru;
    }

    public void setKonfirmasiPasswordBaru(String konfirmasiPasswordBaru) {
        this.konfirmasiPasswordBaru = konfirmasiPasswordBaru;
    }
}