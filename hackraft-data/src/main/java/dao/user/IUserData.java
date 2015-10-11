package dao.user;

import entity.user.User;

/**
 * Hackraft.
 *
 * @author Maxim Kheilik
 * Created by root on 11.10.15.
 */
public interface IUserData {

    String insert(User user);

    User get(String id);
}
