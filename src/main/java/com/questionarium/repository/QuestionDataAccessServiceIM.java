package com.questionarium.repository;

import com.questionarium.model.Question;
import com.questionarium.repository.dao.QuestionDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Repository("questionDaoIM")
public class QuestionDataAccessServiceIM implements QuestionDao {

    private final List<Question> DB = new ArrayList<>();
    @Override
    public Optional<Question> get(int id) {
        return DB.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public void save(Question question) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        Question newQuestion = new Question(randomNum, question.getTopic(), question.getText());
        DB.add(newQuestion);
    }

    @Override
    public Integer update(Integer id, Question question) {
        return get(id)
                .map(q -> {
                    int index = DB.indexOf(q);
                    if (index >= 0) {
                        DB.set(index, new Question(q.getId(), question.getTopic(), question.getText()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public void delete(int id) {
        DB.removeIf(q -> get(id).isPresent());
    }

    @Override
    public List<Question> getByTopic(String topic) {
        System.out.println(topic);
        return DB.stream()
                .filter(q -> q.getTopic().equals(topic))
                .toList();
    }

    @Override
    public List<Question> getAllQuestions() {
        return DB;
    }

    @Override
    public Optional<Question> getRndByTopic(String topic) {
        return null;
    }
}
