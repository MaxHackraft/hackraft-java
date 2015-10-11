package dao.action;

import entity.action.ActionMouse;

import java.util.List;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public interface IActionData {

    List<ActionMouse> insert(List<ActionMouse> actionMouse);

    List<ActionMouse> get(String id);
}
