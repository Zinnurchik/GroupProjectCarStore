package resource;

import bean.ApiResponce;
import bean.UserBean;
import db.DB;

public class UsersResource implements BaseCrudResource<UserBean>{
    public UsersResource() {
    }

    public ApiResponce add(UserBean bean) {
        UserBean newUser = DB.addUser(bean);
        return newUser == null ? new ApiResponce(400, "User already exist!", (Object)null) : new ApiResponce(200, "Successfully created", newUser);
    }

    public ApiResponce get(Integer id) {
        UserBean user = DB.getUser(id);
        if (user == null) {
            System.out.println("User does not exist!");
        } else {
            System.out.println(user);
        }

        return null;
    }

    public ApiResponce update(UserBean newBean) {
        boolean ok = DB.setUser(newBean);
        if (!ok) {
            System.out.println("User update failed!");
        } else {
            System.out.println(newBean);
        }

        return null;
    }

    public ApiResponce delete(Integer id) {
        boolean ok = DB.deleteUser(id);
        if (!ok) {
            System.out.println("User delete failed!");
        } else {
            System.out.println("User has been successfully deleted!");
        }

        return null;
    }

    public ApiResponce login(UserBean user) {
        UserBean user1 = DB.getUser(user.getLogin(), user.getPassword());
        return user1 == null ? new ApiResponce(400, "user not found", (Object)null) : new ApiResponce(200, "success", user1);
    }
}
