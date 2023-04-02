package com.questionarium.repository;

import com.questionarium.model.Question;
import com.questionarium.repository.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.questionarium.repository.queries.QuestionQuery.*;

@Repository("questionDaoPDB")
public class QuestionDataAccessPDB implements QuestionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDataAccessPDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Question> get(int id) {
        Question question = jdbcTemplate.queryForObject(
                FIND_BY_ID,
                (resultSet, i) -> Question.builder()
                            .id(resultSet.getInt("id"))
                            .topic(resultSet.getString("topic"))
                            .text(resultSet.getString("text"))
                            .build(),
                id);
        return Optional.ofNullable(question);
    }

    @Override
    public void save(Question question) {
        jdbcTemplate.update(SAVE_QUEST, question.getTopic(), question.getText());
    }

    @Override
    public Integer update(Integer id, Question question) {
        return jdbcTemplate.update(UPDATE_QUEST, question.getTopic(), question.getText(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    @Override
    public List<Question> getByTopic(String topic) {
        return jdbcTemplate.query(
                FIND_BY_TOPIC,
                (resultSet, i) -> Question.builder()
                        .id(resultSet.getInt("id"))
                        .topic(resultSet.getString("topic"))
                        .text(resultSet.getString("text"))
                        .build(),
                topic);
    }

    @Override
    public List<Question> getAllQuestions() {
        return jdbcTemplate.query(GET_ALL_QUEST, (resultSet, i) ->
                Question.builder()
                .id(resultSet.getInt("id"))
                .topic(resultSet.getString("topic"))
                .text(resultSet.getString("text"))
                .build());
    }

    @Override
    public Optional<Question> getRndByTopic(String topic) {
        Question question = jdbcTemplate.queryForObject(
                GET_RND_BY_TOPIC,
                (resultSet, i) -> Question.builder()
                        .id(resultSet.getInt("id"))
                        .topic(resultSet.getString("topic"))
                        .text(resultSet.getString("text"))
                        .build(),
                topic);
        return Optional.ofNullable(question);
    }
}
