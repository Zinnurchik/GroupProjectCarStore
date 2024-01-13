package resource;

import bean.ApiResponce;
import bean.UserBean;
import db.UserRepository;

public class UsersResource implements BaseCrudResource<UserBean> {
    UserRepository repository = new UserRepository();
    @Override
    public ApiResponce add(UserBean bean) {
        Integer newId = repository.add(bean);

        return newId == null ? new ApiResponce(400, "User already exist", null) :
                new ApiResponce(200, "Successfully created", newId);
    }

    @Override
    public ApiResponce get(Integer id) {
        UserBean bean = repository.get(id);
        if(bean == null){
            System.out.println("User already exist");
        }else {
            System.out.println("Successfully got with id: " + bean);
        }
        return null;
    }
    @Override
    public ApiResponce update(UserBean newBean) {
        Boolean bool = repository.update(newBean);
        if(Boolean.TRUE.equals(bool)){
            System.out.println("User already exist");
        }else {
            System.out.println("Successfully updated: " + newBean);
        }
        return null;
    }

    @Override
    public ApiResponce delete(Integer id) {
        Boolean delete = repository.delete(id);
        if(!Boolean.TRUE.equals(delete)){
            System.out.println("id out of bound");
        }else {
            System.out.println("Successfully deleted with id: " + delete);
        }
        return null;
    }

    public ApiResponce login(UserBean userBean) {
        UserBean newUser = repository.getUser(userBean);
        return newUser == null ? new ApiResponce(400, "User not found", null) :
                new ApiResponce(200, "Success", newUser);
    }
}
