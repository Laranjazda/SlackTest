package com.example.SlackTest;

public class SlackConnection implements Connection {

    @Override
    public void connectionsDB() {
    }

    @Override
    public void connectionsSlask() {
        System.out.println("Conexão Slack ainda não existe");
    }
}
