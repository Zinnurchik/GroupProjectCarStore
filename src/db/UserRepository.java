package db;

import bean.UserBean;

import java.util.List;

public class UserRepository {
    public static UserBean addUser(UserBean user) {
        return DB.addUser(user);
    }

    public static UserBean getUser(int userId) {
        return DB.getUser(userId);
    }

    public static boolean updateUser(UserBean newUser) {
        return DB.setUser(newUser);
    }

    public static boolean deleteUser(int userId) {
        return DB.deleteUser(userId);
    }

    public static UserBean loginUser(UserBean user) {
        return DB.getUser(user.getLogin(), user.getPassword());
    }

    public static List<UserBean> getAllUsers() {
        return DB.getUserList();
    }
}
