package dao.user;

import data.Connector;
import entity.user.Location;
import entity.user.User;
import org.bson.Document;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public class UserDataImpl implements IUserData {

    @Override
    public String insert(User user) {
        Connector connector = new Connector();
        connector.getDb().getCollection("user").insertOne(userToDocument(user));

        return null;
    }

    @Override
    public User get(String id) {
        Connector connector = new Connector();
        return dockumentToUser(connector.getDb().getCollection("user").find(new Document("_id", id)).first());
    }

    private User dockumentToUser(Document document) {
        User user = new User();
        user.setUserId(document.getObjectId("_id").toString());
        user.setGender(document.getString("gender"));
        user.setAge(document.getInteger("age"));
        user.setLocation(toLocationUser((Document) document.get("location")));
        return user;
    }

    private Location toLocationUser(Document document) {
        Location location = new Location();
        location.setCity(document.getString("city"));
        location.setCountry(document.getString("country"));
        return location;
    }

    private Document userToDocument(User user) {
        Document document = new Document();
        document.append("gender", user.getGender());
        document.append("age", user.getAge());
        document.append("location", toLocationDoc(user));
        return document;
    }

    private Document toLocationDoc(User user) {
        Document document = new Document();
        document.append("city", user.getLocation().getCity());
        document.append("country", user.getLocation().getCountry());
        return document;
    }
}
