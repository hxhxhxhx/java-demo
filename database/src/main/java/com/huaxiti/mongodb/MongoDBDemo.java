package com.huaxiti.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MongoDBDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("collection");
        FindIterable<Document> documents = collection.find();
        ClientSession clientSession = mongoClient.startSession();
        clientSession.startTransaction();
        clientSession.commitTransaction();
        clientSession.abortTransaction();
    }

    public void insertDocument(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到数据库
        MongoDatabase database = mongo.getDatabase("myDb");
        // 创建集合
        database.createCollection("tutorial");
        System.out.println("集合创建成功");
        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        System.out.println("集合选择成功");
        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.biancheng.net/mongodb/")
                .append("by", "编程帮");

        // 将文档插入到集合中
        collection.insertOne(document);
        System.out.println("文档插入成功");
    }

    public void findDocument(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
        System.out.println("数据库连接成功");

        // 连接到数据库
        MongoDatabase database = mongo.getDatabase("myDb");

        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        System.out.println("成功选择了集合 tutorial");
        Document document1 = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.biancheng.net/mongodb/")
                .append("by", "编程帮");
        Document document2 = new Document("title", "html")
                .append("description", "database")
                .append("likes", 200)
                .append("url", "http://www.biancheng.net/html/")
                .append("by", "编程帮");
        List<Document> list = new ArrayList<Document>();
        list.add(document1);
        list.add(document2);
        collection.insertMany(list);
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // 获取迭代器
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

    public void updateDocument(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
        System.out.println("数据库连接成功");
        // 连接到数据库
        MongoDatabase database = mongo.getDatabase("myDb");
        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        System.out.println("成功选择了集合 tutorial");
        collection.updateOne(Filters.eq("title", 1), Updates.set("likes", 150));
        System.out.println("文档更新成功...");
        // 更新后检索文档
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // 获取迭代器
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

    public void deleteDocument(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
        System.out.println("数据库连接成功");
        // 访问数据库
        MongoDatabase database = mongo.getDatabase("myDb");
        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        System.out.println("成功选择了集合 tutorial");
        // 删除文档
        collection.deleteOne(Filters.eq("title", "MongoDB"));
        System.out.println("文档删除成功...");
        // 更新后检索文档
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // 获取迭代器
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }

    public void dropCollection(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
        System.out.println("数据库连接成功");
        // 访问数据库
        MongoDatabase database = mongo.getDatabase("myDb");
        // 创建集合
        System.out.println("集合创建成功");
        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        // 删除集合
        collection.drop();
        System.out.println("集合删除成功");
    }

    public void listCollection(){
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
        System.out.println("数据库连接成功");
        // 访问数据库
        MongoDatabase database = mongo.getDatabase("myDb");
        System.out.println("集合创建成功");
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }
    }
}
