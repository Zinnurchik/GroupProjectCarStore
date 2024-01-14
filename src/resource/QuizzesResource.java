package resource;

import bean.ApiResponce;
import bean.QuizBean;
import db.DB;

import java.util.List;

public class QuizzesResource implements BaseCrudResource<QuizBean>{
    public QuizzesResource() {
    }

    public ApiResponce add(QuizBean bean) {
        Integer newId = DB.addQuiz(bean);
        return newId == null ? new ApiResponce(400, "Error!", (Object)null) : new ApiResponce(200, "Successfully created", newId);
    }

    public ApiResponce get(Integer id) {
        QuizBean quiz = DB.getQuiz(id);
        return quiz == null ? new ApiResponce(400, "Error", quiz) : new ApiResponce(200, "Success", quiz);
    }

    public ApiResponce update(QuizBean newBean) {
        boolean ok = DB.setQuiz(newBean);
        return !ok ? new ApiResponce(400, "Error!", ok) : new ApiResponce(200, "Successfully Updated", ok);
    }

    public ApiResponce delete(Integer id) {
        return null;
    }

    public ApiResponce getQuizzes(Integer userId) {
        List<QuizBean> quizzes = DB.getUserQuizzes(userId);
        return quizzes == null ? new ApiResponce(400, "Error", (Object)null) : (quizzes.size() == 0 ? new ApiResponce(200, "Empty List", (Object)null) : new ApiResponce(200, "Successfully", quizzes));
    }
}
