package db;

import bean.User;

import java.util.List;

public class UserRepository implements BaseCrudRepository<User> {
    List<User> users = DataBase.getUsers();

    @Override
    public User add(User bean) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(bean.getUsername())){
                return null;
            }
        }
        bean.setId(users.size());
        users.add(bean);
        return bean;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(User newBean) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    public User getUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if(user.getPassword().equals(users.get(i).getPassword()) &&
                    user.getUsername().equals(users.get(i).getUsername())){
                return users.get(i);
            }
        }
        return null;
    }
}
