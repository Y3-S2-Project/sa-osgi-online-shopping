package mongodb_service;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoServiceImpl implements MongoService {
	 private static volatile MongoServiceImpl instance;

	    private static final String MONGO_URI = "mongodb://localhost:27017";
	    private static final String DB_NAME = "shopping";
	    private static final String COLLECTION_NAME = "product";

	    private final MongoClient mongoClient;
	    private final MongoDatabase  mongoDatabase;
	    private final MongoCollection<Document> mongoCollection;

	    private MongoServiceImpl() {
	    	System.out.println("Constructor");
	        MongoClientURI uri = new MongoClientURI(MONGO_URI);
	    	System.out.println("Mongo Clien URI");
	        this.mongoClient = new MongoClient(uri);
	        
	    	System.out.println("Mongo DB Name");
	        this.mongoDatabase = mongoClient.getDatabase(DB_NAME);
	       // mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
	    	System.out.println("Mongo collection");
			this.mongoCollection = null;
	    }

	    public static MongoServiceImpl getInstance() {
	    	MongoServiceImpl result = instance;
	        if (result == null) {
	            synchronized(MongoServiceImpl.class) {
	                if (instance == null) {
	                    instance = new MongoServiceImpl();
	                }
	                result = instance;
	            }
	        }
	        System.out.println("no issue here");
	        return result;
	    }
      
	  

	    public void closeConnection() {
	        mongoClient.close();
	    }

		@Override
		public MongoDatabase getDatabase() {
			// TODO Auto-generated method stub
			return mongoDatabase;
		}

}
