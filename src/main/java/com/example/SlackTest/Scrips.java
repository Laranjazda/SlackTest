package com.example.SlackTest;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;
import static java.util.Arrays.asList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Scrips{
    private Connection connectMongo;
    private Connection connectSlack;

    public void executeMongoConnect(){
        connectMongo = new MongoConnection();
        connectMongo.connectionsDB();
    }
    public void executeSlackConnect(){
        connectSlack = new SlackConnection();
        connectSlack.connectionsDB();
    }


    public void showdData(DB collection) {
        DBCursor cursor = collection.getCollection("products").find();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }

    public void InsertListData() {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
            MongoDatabase database = mongoClient.getDatabase("mongo_connection").withCodecRegistry(pojoCodecRegistry);

            //Inserir dados
            MongoCollection<Foods> productList = database.getCollection("product", Foods.class);
            List<Foods> foods = asList(
                    new Foods("Drink",false, "Bebida1", 22),
                    new Foods("Drink",false, "Bebida2", 12),
                    new Foods("Drink",false, "Bebida3", 45),
                    new Foods("Drink",false, "Bebida4", 22),
                    new Foods("Drink",false, "Bebida5", 12),
                    new Foods("Drink",false, "Bebida6", 1299)
            );
            productList.insertMany(foods);
            System.out.println(foods);
    }



//    public void showData() {
//

//    }
//
//    public void getBreakData(){
//        BasicDBObject gtQuery = new BasicDBObject();
//        gtQuery.put("price", new BasicDBObject("$gt", 15).append("$lt", 50));
//        DBCursor cursor = Connection.collection.find(gtQuery);
//        while(cursor.hasNext()) {
//            System.out.println(cursor.next());
//        }
//    }


}
