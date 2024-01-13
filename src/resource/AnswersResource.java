package resource;

import bean.AnswerBean;
import bean.ApiResponce;
import db.AnswerRepository;

public class AnswersResource implements BaseCrudResource<AnswerBean> {
    AnswerRepository repository = new AnswerRepository();
    @Override
    public ApiResponce add(AnswerBean bean) {
        Integer newId = repository.add(bean);
        if(newId == null){
            System.out.println("User already exist");
        }else {
            System.out.println("Successfully created with id: " + newId);
        }
        return null;
    }

    @Override
    public ApiResponce get(Integer id) {
        AnswerBean bean = repository.get(id);
        if(bean == null){
            System.out.println("User already exist");
        }else {
            System.out.println("Successfully created with id: " + bean);
        }
        return null;
    }

    @Override
    public ApiResponce update(AnswerBean newBean) {
        Boolean bool = repository.update(newBean);
        if(Boolean.TRUE.equals(bool)){
            System.out.println("User already exist");
        }else {
            System.out.println("Successfully created with id: " + newBean);
        }
        return null;
    }

    @Override
    public ApiResponce delete(Integer id) {
        Boolean delete = repository.delete(id);
        if(!Boolean.TRUE.equals(delete)){
            System.out.println("id out of bound");
        }else {
            System.out.println("Successfully created with id: " + delete);
        }
        return null;
    }
}
