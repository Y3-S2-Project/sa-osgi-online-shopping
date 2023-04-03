package com.csse_we_26.product_listing_generator.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * This class is used to create a connection to the database
 * 
 * @author CHAMATH
 *
 */
public class MongoDBUtil {
	// Singleton instance
	private static volatile MongoDBUtil instance;
    // MongoDB connection details
	private static final String MONGO_URI = "mongodb://localhost:27017";
	private static final String DB_NAME = "shopping";

    // MongoDB collections
	private final MongoClient mongoClient;
	private final MongoDatabase mongoDatabase;
	private final MongoCollection<Document> mongoCollection;
     // Constructor where the connection is created
	private MongoDBUtil() {
		MongoClientURI uri = new MongoClientURI(MONGO_URI);
		mongoClient = new MongoClient(uri);
		mongoDatabase = mongoClient.getDatabase(DB_NAME);
		this.mongoCollection = null;
	}
   
	// get the instance of the class
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
   // get the database
	public MongoDatabase getDatabase() {

		return mongoDatabase;
	}
   // close the connection
	public void closeConnection() {
		mongoClient.close();
	}
  // get the collection
	public MongoCollection<Document> getCartCollection() {
		return mongoCollection;
	}

}
