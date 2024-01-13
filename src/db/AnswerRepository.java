package db;

import bean.AnswerBean;

import java.util.List;

public class AnswerRepository implements CRUD<AnswerBean> {
    List<AnswerBean> answers = DB.getAnswers();
    @Override
    public Integer add(AnswerBean bean) {
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).getAnswer().equals(bean.getAnswer())){
                return null;
            }
        }
        bean.setId(answers.size());
        answers.add(bean);
        return bean.getId();
    }

    @Override
    public AnswerBean get(Integer id) {
        if(id < 0 || id > answers.size()){
            return null;
        }
        return answers.get(id);
    }

    @Override
    public Boolean update(AnswerBean newBean) {
        if(newBean.getId() < 0 || newBean.getId() > answers.size()){
            return false;
        }
        answers.set(newBean.getId(), newBean);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        if(id < 0 || id > answers.size()){
            return false;
        }else {
            answers.remove(id);
            return true;
        }
    }
}
