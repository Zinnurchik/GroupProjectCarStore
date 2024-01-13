package db;

import bean.QuestionBean;

import java.util.List;

public class QuestionRepository implements CRUD<QuestionBean> {
    List<QuestionBean> questions = DB.getQuestions();
    @Override
    public Integer add(QuestionBean bean) {
        for (int i = 0; i < questions.size(); i++) {
            if(questions.get(i).getQuestion().equals(bean.getQuestion())){
                return null;
            }
        }
        bean.setId(questions.size());
        questions.add(bean);
        return bean.getId();
    }

    @Override
    public QuestionBean get(Integer id) {
        if(id < 0 || id > questions.size()){
            return null;
        }
        return questions.get(id);
    }

    @Override
    public Boolean update(QuestionBean newBean) {
        if(newBean.getId() < 0 || newBean.getId() > questions.size()){
            return false;
        }
        questions.set(newBean.getId(), newBean);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        if(id < 0 || id > questions.size()){
            return false;
        }else {
            questions.remove(id);
            return true;
        }
    }
}
