package db;

import bean.QuizBean;

import java.util.List;

public class QuizRepository implements CRUD<QuizBean> {
    List<QuizBean> quizzes = DB.getQuizzes();
    @Override
    public Integer add(QuizBean bean) {
        for (int i = 0; i < quizzes.size(); i++) {
            if(quizzes.get(i).getName().equals(bean.getName())){
                return null;
            }
        }
        bean.setId(quizzes.size());
        quizzes.add(bean);
        return bean.getId();
    }

    @Override
    public QuizBean get(Integer id) {
        if(id < 0 || id > quizzes.size()){
            return null;
        }
        return quizzes.get(id);
    }

    @Override
    public Boolean update(QuizBean newBean) {
        if(newBean.getId() < 0 || newBean.getId() > quizzes.size()){
            return false;
        }
        quizzes.set(newBean.getId(), newBean);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        if(id < 0 || id > quizzes.size()){
            return false;
        }else {
            quizzes.remove(id);
            return true;
        }
    }
}
