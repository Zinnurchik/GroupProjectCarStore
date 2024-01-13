package db;

import bean.UserBean;

import java.util.List;

public class UserRepository implements CRUD<UserBean> {
    List<UserBean> users = DB.getUsers();
    public Integer add(UserBean bean){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getLogin().equals(bean.getLogin())){
                return null;
            }
        }
        bean.setId(users.size());
        users.add(bean);
        return bean.getId();
    }

    public UserBean get(Integer id) {
        if(id < 0 || id > users.size()){
            return null;
        }
        return users.get(id);
    }
    public Boolean update(UserBean newBean) {
        if(newBean.getId() < 0 || newBean.getId() > users.size()){
            return false;
        }
        users.set(newBean.getId(), newBean);
        return true;
    }

    public Boolean delete(Integer id) {
        if(id < 0 || id > users.size()){
            return false;
        }else {
            users.remove(id);
            return true;
        }
    }

    public UserBean getUser(UserBean userBean) {
        for (int i = 0; i < users.size(); i++) {
            if(userBean.getPassword().equals(users.get(i).getPassword()) &&
                    userBean.getLogin().equals(users.get(i).getLogin())){
                return users.get(i);
            }
        }
        return null;
    }
}
