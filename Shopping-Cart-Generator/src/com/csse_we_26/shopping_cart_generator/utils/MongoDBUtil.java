package com.csse_we_26.shopping_cart_generator.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoDBUtil {

	private static volatile MongoDBUtil instance;

	private static final String MONGO_URI = "mongodb://localhost:27017";
	private static final String DB_NAME = "shopping";
//	private static final String COLLECTION_NAME = "cart";

	private final MongoClient mongoClient;
	private final MongoDatabase mongoDatabase;
	private final MongoCollection<Document> mongoCollection;

	private MongoDBUtil() {
		MongoClientURI uri = new MongoClientURI(MONGO_URI);
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase(DB_NAME);
//		mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
		this.mongoCollection = null;
	}

	public static MongoDBUtil getInstance() {
		MongoDBUtil result = instance;
		System.out.println("came here");
		if (result == null) {
			synchronized (MongoDBUtil.class) {
				if (instance == null) {
					System.out.println("came here as well");
					instance = new MongoDBUtil();
					System.out.println(instance);
				}
				result = instance;
			}
		}
		System.out.println("came here too :)" + result.toString());
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
