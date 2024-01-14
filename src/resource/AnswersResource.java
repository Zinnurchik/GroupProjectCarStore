package resource;

import bean.AnswerBean;
import bean.ApiResponce;
import db.DB;

import java.util.List;

public class AnswersResource implements BaseCrudResource<AnswerBean>{
    public AnswersResource() {
    }

    public ApiResponce add(AnswerBean bean) {
        Integer newId = DB.addAnswer(bean);
        return newId == null ? new ApiResponce(400, "Error!", (Object)null) : new ApiResponce(200, "Successfully created", newId);
    }

    public ApiResponce get(Integer id) {
        return null;
    }

    public ApiResponce update(AnswerBean newBean) {
        return null;
    }

    public ApiResponce delete(Integer id) {
        return null;
    }

    public ApiResponce getAnswers(int questionId) {
        List<AnswerBean> list = DB.getAnswers(questionId);
        return new ApiResponce(200, "Success", list);
    }
}
