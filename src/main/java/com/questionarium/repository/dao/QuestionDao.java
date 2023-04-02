package com.questionarium.repository.dao;

import com.questionarium.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionDao {

    Optional<Question> get(int id);
    void save(Question question);
    Integer update(Integer id, Question question);
    void delete(int id);

    List<Question> getByTopic(String topic);

    List<Question> getAllQuestions();

    Optional<Question> getRndByTopic(String topic);

}
