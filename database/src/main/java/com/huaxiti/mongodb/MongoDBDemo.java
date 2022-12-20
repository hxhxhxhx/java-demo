package com.huaxiti.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.ClientSession;
import com.mongodb.client.internal.MongoDatabaseImpl;

public class MongoDBDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        ClientSession clientSession = mongoClient.startSession();
        clientSession.startTransaction();
        clientSession.commitTransaction();
        clientSession.abortTransaction();
    }
}
