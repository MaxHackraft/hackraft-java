package net.hackraft.core.domain.user;

import entity.user.User;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public interface IUser {

    String insert(User user);

    User get(String id);
}
