package net.hackraft.core.domain.action;

import dao.action.ActionDataImpl;
import dao.action.IActionData;
import entity.action.ActionMouse;
import entity.action.Speed;
import net.hackraft.core.model.action.ActionMouseBO;
import net.hackraft.core.model.action.SpeedBO;

import java.util.ArrayList;
import java.util.List;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public class ActionDomain implements IAction {

    private IActionData actionData = new ActionDataImpl();

    public List<ActionMouseBO> insert(List<ActionMouseBO> actionMouse) {
        return toActionMouseBOList(actionData.insert(toActionMouseList(actionMouse)));
    }

    public List<ActionMouseBO> get(String id) {
        return toActionMouseBOList(actionData.get(id));
    }

    private List<ActionMouseBO> toActionMouseBOList(List<ActionMouse> actionMouseList) {
        List<ActionMouseBO> actionMouseBOList = new ArrayList<ActionMouseBO>();
        for (ActionMouse actionMouse : actionMouseList) {
            actionMouseBOList.add(toActionMouseBO(actionMouse));
        }
        return actionMouseBOList;
    }

    private ActionMouseBO toActionMouseBO(ActionMouse actionMouse) {
        ActionMouseBO actionMouseBO = new ActionMouseBO();
        actionMouseBO.setActionId(actionMouse.getActionId());
        actionMouseBO.setUserId(actionMouse.getUserId());
        actionMouseBO.setX(actionMouse.getX());
        actionMouseBO.setY(actionMouse.getY());
        actionMouseBO.setTarget(actionMouse.getTarget());
        actionMouseBO.setStamp(actionMouse.getStamp());
        actionMouseBO.setSpeedBO(toSpeedBO(actionMouse.getSpeed()));
        return actionMouseBO;
    }

    private SpeedBO toSpeedBO(Speed speed) {
        SpeedBO speedBO = new SpeedBO();
        speedBO.setX(speed.getX());
        speedBO.setY(speed.getY());
        return speedBO;
    }

    private List<ActionMouse> toActionMouseList(List<ActionMouseBO> actionMouseBOList) {
        List<ActionMouse> actionMouseList = new ArrayList<ActionMouse>();
        for (ActionMouseBO actionMouseBO : actionMouseBOList) {
            actionMouseList.add(toActionMouse(actionMouseBO));
        }
        return actionMouseList;
    }

    private ActionMouse toActionMouse(ActionMouseBO actionMouseBO) {
        ActionMouse actionMouse = new ActionMouse();
        actionMouse.setActionId(actionMouseBO.getActionId());
        actionMouse.setUserId(actionMouseBO.getUserId());
        actionMouse.setX(actionMouseBO.getX());
        actionMouse.setY(actionMouseBO.getY());
        actionMouse.setTarget(actionMouseBO.getTarget());
        actionMouse.setStamp(actionMouseBO.getStamp());
        actionMouse.setSpeed(toSpeed(actionMouseBO.getSpeedBO()));
        return actionMouse;
    }

    private Speed toSpeed(SpeedBO speedBO) {
        Speed speed = new Speed();
        speed.setX(speedBO.getX());
        speed.setY(speedBO.getY());
        return speed;
    }
}
