package dao.action;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import data.Connector;
import entity.action.ActionMouse;
import entity.action.Speed;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 */
public class ActionDataImpl implements IActionData {

    public List<ActionMouse> insert(List<ActionMouse> actionMouseList) {
        Connector connector = new Connector();
        return toActionMouseList(connector.getDb().getCollection("action_mouse").aggregate(toDocumentList(actionMouseList)));
    }

    public List<ActionMouse> get(String id) {
        Connector connector = new Connector();
        return toActionMouseList(connector.getDb().getCollection("action_mouse").find(new Document("user_id", id)));
    }

    private List<ActionMouse> toActionMouseList(FindIterable<Document> documentFindIterable) {
        List<ActionMouse> actionMouseList = new ArrayList<>();
        for (Document document: documentFindIterable) {
            actionMouseList.add(toActionMouse(document));
        }
        return actionMouseList;
    }

    private List<ActionMouse> toActionMouseList(AggregateIterable<Document> documentAggregateIterable) {
        List<ActionMouse> actionMouseList = new ArrayList<>();
        for (Document document: documentAggregateIterable) {
            actionMouseList.add(toActionMouse(document));
        }
        return actionMouseList;
    }

    private ActionMouse toActionMouse(Document document) {
        ActionMouse actionMouse = new ActionMouse();
        actionMouse.setActionId(document.getObjectId("_id").toString());
        actionMouse.setUserId(document.getObjectId("user_id").toString());
        actionMouse.setX(document.getInteger("x"));
        actionMouse.setY(document.getInteger("y"));
        actionMouse.setStamp(new BigInteger(document.get("stamp").toString()));
        actionMouse.setTarget(document.getString("target"));
        actionMouse.setSpeed(toSpeed((Document) document.get("speed")));
        return actionMouse;
    }

    private List<Bson> toDocumentList(List<ActionMouse> actionMouseList) {
        List<Bson> documentList = new ArrayList<>();
        for (ActionMouse actionMouse: actionMouseList) {
            documentList.add(toDocument(actionMouse));
        }
        return documentList;
    }

    private Document toDocument(ActionMouse actionMouse) {
        Document document = new Document();
        document.append("user_id", new ObjectId(actionMouse.getUserId()));
        document.append("x", actionMouse.getX());
        document.append("y", actionMouse.getY());
        document.append("stamp", actionMouse.getStamp());
        document.append("target", actionMouse.getTarget());
        document.append("speed", new Document()
                .append("speed_x", actionMouse.getSpeed().getX())
                .append("speed_y", actionMouse.getSpeed().getY()));
        return document;
    }

    private Speed toSpeed(Document document) {
        Speed speed = new Speed();
        speed.setX(document.getDouble("speed_x"));
        speed.setY(document.getDouble("speed_y"));
        return speed;
    }
}
