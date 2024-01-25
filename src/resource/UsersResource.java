package resource;

import bean.ApiResponce;
import bean.User;
import db.UserRepository;

public class UsersResource implements BaseCrudResource<User>{
    UserRepository repository = new UserRepository();
    @Override
    public ApiResponce add(User bean) {
        User newUser = repository.add(bean);
        return newUser == null ? new ApiResponce(400, "User already exist", null) :
                new ApiResponce(200, "Successfully created", newUser);
    }

    @Override
    public ApiResponce get(Integer id) {
        return null;
    }

    @Override
    public ApiResponce update(User newBean) {
        return null;
    }

    @Override
    public ApiResponce delete(Integer id) {
        return null;
    }
    public ApiResponce login(User user) {
        UserRepository repository = new UserRepository();
        User newUser = repository.getUser(user);
        return newUser == null ? new ApiResponce(400, "User not found", null) :
                new ApiResponce(200, "Success", newUser);
    }
}
