package com.example.SlackTest;

import com.mongodb.*;

public class MongoConnection implements Connection{


    @Override
    public void connectionsDB() {
        MongoClient connectionServer = new MongoClient("locahost", 27017);
        DB dataBase = connectionServer.getDB("mongo_connection");
        DBCollection collection = dataBase.getCollection("products");

        System.out.println("Conexão bem sucedida!\n"+"Por favor aguarde...");
    }

    @Override
    public void connectionsSlask() {
    }
}