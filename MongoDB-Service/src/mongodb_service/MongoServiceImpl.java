package mongodb_service;

import com.mongodb.client.MongoDatabase;

public class MongoServiceImpl implements MongoService {

	@Override
	public MongoDatabase getDatabase() {
		return MongoDBUtil.getInstance().getDatabase();
	}

}
