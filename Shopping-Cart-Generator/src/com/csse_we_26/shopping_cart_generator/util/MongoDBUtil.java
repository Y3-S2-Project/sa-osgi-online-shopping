package com.csse_we_26.shopping_cart_generator.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
	
	private static volatile MongoDBUtil instance;

	private static final String MONGO_URI = "mongodb://localhost:27017";
	private static final String DB_NAME = "shopping";


	private final MongoClient mongoClient;
	private final MongoDatabase mongoDatabase;
	private final MongoCollection<Document> mongoCollection;

	private MongoDBUtil() {
		MongoClientURI uri = new MongoClientURI(MONGO_URI);
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase(DB_NAME);
		this.mongoCollection = null;
	}

	public static MongoDBUtil getInstance() {

        MongoDBUtil result = instance;
        if (result == null) {
            synchronized(MongoDBUtil.class) {
                if (instance == null) {
                    instance = new MongoDBUtil();
                }
                result = instance;
            }
        }
        return result;
    }

	public MongoDatabase getDatabase() {

		return mongoDatabase;
	}

	public void closeConnection() {
		mongoClient.close();
	}

	public MongoCollection<Document> getCartCollection() {
		return mongoCollection;
	}

}
