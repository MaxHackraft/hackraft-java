package net.hackraft.core.domain.action;

import net.hackraft.core.model.action.ActionMouseBO;

import java.util.List;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public interface IAction {

    List<ActionMouseBO> insert(List<ActionMouseBO> actionMouse);

    List<ActionMouseBO> get(String id);
}
