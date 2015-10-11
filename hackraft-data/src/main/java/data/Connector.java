package data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 */
public class Connector {

    private MongoDatabase db;

    public Connector()
    {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDatabase("harcraft");
    }

    public MongoDatabase getDb()
    {
        return db;
    }
}
