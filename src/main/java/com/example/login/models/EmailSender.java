package com.example.login.models;

public interface EmailSender {
    void send(String to, String email);
}