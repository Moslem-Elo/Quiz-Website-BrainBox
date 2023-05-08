package htwberlin.Projekt;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizID;
    String titel;
    Theme theme;
    String difficulty;
    List<Question> questionList;
}
