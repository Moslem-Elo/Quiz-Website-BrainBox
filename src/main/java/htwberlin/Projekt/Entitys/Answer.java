package htwberlin.Projekt.Entitys;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answerText;

    private boolean correct;

    @ManyToMany(mappedBy = "answers")
    private List<Question> questions;

    public Answer() {
    }

    public Answer(String answerText, boolean correct) {
        this.answerText = answerText;
        this.correct = correct;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", correct=" + correct +
                '}';
    }
}
