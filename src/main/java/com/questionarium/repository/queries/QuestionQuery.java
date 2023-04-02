package com.questionarium.repository.queries;

public interface QuestionQuery {

    String GET_ALL_QUEST =
            """
                    SELECT ID, TOPIC, TEXT
                    FROM QUESTION
            """;

    String SAVE_QUEST =
            """
                    INSERT INTO QUESTION (TOPIC, TEXT)
                    VALUES (?, ?)
            """;

    String FIND_BY_ID =
            """
                    SELECT ID, TOPIC, TEXT
                    FROM QUESTION
                    WHERE ID = ?
            """;

    String UPDATE_QUEST =
            """
                    UPDATE QUESTION
                    SET TOPIC = ?, text = ?
                    WHERE ID = ?
            """;

    String DELETE_BY_ID =
            """
                    DELETE FROM QUESTION
                    WHERE ID = ?
            """;

    String FIND_BY_TOPIC =
            """
                    SELECT ID, TOPIC, TEXT
                    FROM QUESTION
                    WHERE TOPIC = ?
            """;

    String GET_RND_BY_TOPIC =
            """
                    SELECT ID, TOPIC, TEXT
                    FROM QUESTION
                    WHERE TOPIC = ?
                    ORDER BY RANDOM()
                    limit 1
            """;

}
