package com.questionarium.service;

import com.questionarium.repository.dao.QuestionDao;
import com.questionarium.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionService(@Qualifier("questionDaoIM") QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public void save(Question question) {
        questionDao.save(question);
    }

    public Optional<Question> getQuestionById(int id) {
        return questionDao.get(id);
    }

    public void deleteQuestionById(int id) {
        questionDao.delete(id);
    }

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    public void updateQuestion(Integer id, Question question) {
        questionDao.update(id, question);
    }

    public Optional<Question> getRndQuestionByTopic(String topic) {
        List<Question> questions = questionDao.getByTopic(topic);
        return Optional.ofNullable(getRandom(questions));
    }

    private Question getRandom(List<Question> questions) {
        if (questions.size() != 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, questions.size());
            return questions.get(randomNum);
        }
        return null;
    }


}
