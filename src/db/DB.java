package db;

import bean.AnswerBean;
import bean.QuestionBean;
import bean.QuizBean;
import bean.UserBean;

import java.util.ArrayList;
import java.util.List;
public class DB {
    private static List<UserBean> users = new ArrayList<>();
    private static List<QuizBean> quizzes = new ArrayList<>();
    private static List<QuestionBean> questions = new ArrayList<>();
    private static List<AnswerBean> answers = new ArrayList<>();
    public static UserBean session = null;

    public static List<QuestionBean> getQuestions() {
        return questions;
    }

    public static void setQuestions(List<QuestionBean> questions) {
        DB.questions = questions;
    }

    public static List<AnswerBean> getAnswers() {
        return answers;
    }

    public static void setAnswers(List<AnswerBean> answers) {
        DB.answers = answers;
    }

    public static List<QuizBean> getQuizzes() {
        return quizzes;
    }

    public static void setQuizzes(List<QuizBean> quizzes) {
        DB.quizzes = quizzes;
    }

    public static List<UserBean> getUsers() {
        return users;
    }
    public static void setUsers(List<UserBean> users) {
        DB.users = users;
    }
}
