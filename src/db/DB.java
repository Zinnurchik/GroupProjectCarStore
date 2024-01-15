package db;

import bean.UserBean;

import java.util.ArrayList;
import java.util.List;
public class DB {
    private static List<UserBean> users = new ArrayList();
    private static List<QuizBean> quizzes = new ArrayList();
    private static List<QuestionBean> questions = new ArrayList();
    private static List<AnswerBean> answers = new ArrayList();
    public static UserBean session = null;

    public DB() {
    }

    public static UserBean addUser(UserBean bean) {
        for (UserBean user : users) {
            if (user.getLogin().equals(bean.getLogin())) {
                return null;
            }
        }

        bean.setId(users.size());
        users.add(bean);
        return bean;
    }

    public static UserBean getUser(String login, String password) {
        for (UserBean user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static UserBean getUser(Integer id) {
        return id >= 0 && id <= users.size() ? (UserBean)users.get(id) : null;
    }

    public static boolean setUser(UserBean newBean) {
        if (newBean.getId() >= 0 && newBean.getId() <= users.size()) {
            users.set(newBean.getId(), newBean);
            return true;
        } else {
            return false;
        }
    }

    public static boolean deleteUser(Integer id) {
        if (id >= 0 && id <= users.size()) {
            boolean remove = users.remove(id);
            return remove;
        } else {
            return false;
        }
    }

    public static Integer addQuiz(QuizBean bean) {
        bean.setId(quizzes.size());
        quizzes.add(bean);
        return bean.getId();
    }

    public static QuizBean getQuiz(Integer id) {
        return id >= 0 && id <= quizzes.size() ? (QuizBean)quizzes.get(id) : null;
    }

    public static boolean setQuiz(QuizBean newBean) {
        if (newBean.getId() >= 0 && newBean.getId() <= quizzes.size()) {
            quizzes.set(newBean.getId(), newBean);
            return true;
        } else {
            return false;
        }
    }

    public static List<QuizBean> getUserQuizzes(Integer userId) {
        List<QuizBean> quizBeans = new ArrayList();

        for(int i = 0; i < quizzes.size(); ++i) {
            if (((QuizBean)quizzes.get(i)).getCreatedUserId().equals(userId)) {
                quizBeans.add((QuizBean)quizzes.get(i));
            }
        }

        return quizBeans;
    }

    public static Integer addQuestion(QuestionBean bean) {
        bean.setId(questions.size());
        questions.add(bean);
        return bean.getId();
    }

    public static List<QuestionBean> getQuestions(Integer quizId) {
        List<QuestionBean> questionList = new ArrayList();

        for(int i = 0; i < questions.size(); ++i) {
            if (quizId.equals(((QuestionBean)questions.get(i)).getQuizId())) {
                questionList.add((QuestionBean)questions.get(i));
            }
        }

        return questionList;
    }

    public static Integer addAnswer(AnswerBean bean) {
        if (bean.getQuestionId() >= 0 && bean.getQuestionId() <= questions.size()) {
            bean.setId(answers.size());
            answers.add(bean);
            return bean.getId();
        } else {
            return null;
        }
    }

    public static List<AnswerBean> getAnswers(Integer questionId) {
        List<AnswerBean> list = new ArrayList<>();

        for (AnswerBean answer : answers) {
            if (questionId.equals(answer.getQuestionId())) {
                list.add(answer);
            }
        }

        return list;
    }
}
