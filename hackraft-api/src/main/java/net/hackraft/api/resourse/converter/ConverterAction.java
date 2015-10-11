package net.hackraft.api.resourse.converter;

import net.hackraft.api.model.action.ActionMouse;
import net.hackraft.api.model.action.Speed;
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
public class ConverterAction {

    public static ActionMouseBO convertorToActionMouseBO(ActionMouse actionMouse) {
        ActionMouseBO actionMouseBO = new ActionMouseBO();
        actionMouseBO.setActionId(actionMouse.getActionId());
        actionMouseBO.setUserId(actionMouse.getUserId());
        actionMouseBO.setX(actionMouse.getX());
        actionMouseBO.setY(actionMouse.getY());
        actionMouseBO.setStamp(actionMouse.getStamp());
        actionMouseBO.setTarget(actionMouse.getTarget());
        actionMouseBO.setSpeedBO(convertToSpeedBO(actionMouse.getSpeed()));
        return actionMouseBO;
    }

    private static SpeedBO convertToSpeedBO(Speed speed) {
        SpeedBO speedBO = new SpeedBO();
        speedBO.setX(speed.getX());
        speedBO.setY(speed.getY());
        return speedBO;
    }

    public static List<ActionMouse> toActionMouseList(List<ActionMouseBO> actionMouseListBO) {
        List<ActionMouse> actionMouseList = new ArrayList<>();
        for (ActionMouseBO actionMouseBO : actionMouseListBO) {
            actionMouseList.add(convertorToActionMouse(actionMouseBO));
        }
        return actionMouseList;
    }

    public static ActionMouse convertorToActionMouse(ActionMouseBO actionMouseBO) {
        ActionMouse actionMouse = new ActionMouse();
        actionMouse.setActionId(actionMouseBO.getActionId());
        actionMouse.setUserId(actionMouseBO.getUserId());
        actionMouse.setX(actionMouseBO.getX());
        actionMouse.setY(actionMouseBO.getY());
        actionMouse.setStamp(actionMouseBO.getStamp());
        actionMouse.setTarget(actionMouseBO.getTarget());
        actionMouse.setSpeed(convertToSpeed(actionMouseBO.getSpeedBO()));
        return actionMouse;
    }

    private static Speed convertToSpeed(SpeedBO speedBO) {
        Speed speed = new Speed();
        speed.setX(speedBO.getX());
        speed.setY(speedBO.getY());
        return speed;
    }
}
