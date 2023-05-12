package htwberlin.Projekt.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
public class Answer {


    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String answerText;


    private boolean correct;

    @ManyToOne()
    private Question question;

    public Answer() {}

    public Answer(String answerText, boolean correct, Question question) {
        this.answerText = answerText;
        this.correct = correct;
        this.question = question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer answer)) return false;
        return correct == answer.correct && id.equals(answer.id) && answerText.equals(answer.answerText) && question.equals(answer.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, answerText, correct, question);
    }
}
