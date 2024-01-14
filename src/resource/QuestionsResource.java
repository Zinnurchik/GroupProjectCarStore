package resource;

import bean.ApiResponce;
import bean.QuestionBean;
import db.DB;

import java.util.List;

public class QuestionsResource implements BaseCrudResource<QuestionBean>{
    public QuestionsResource() {
    }

    public ApiResponce add(QuestionBean bean) {
        Integer newId = DB.addQuestion(bean);
        return newId == null ? new ApiResponce(400, "Error!", (Object)null) : new ApiResponce(200, "Successfully created", newId);
    }

    public ApiResponce get(Integer id) {
        return null;
    }

    public ApiResponce update(QuestionBean newBean) {
        return null;
    }

    public ApiResponce delete(Integer id) {
        return null;
    }

    public ApiResponce getQuestions(Integer quizId) {
        List<QuestionBean> list = DB.getQuestions(quizId);
        return new ApiResponce(200, "Success", list);
    }
}
