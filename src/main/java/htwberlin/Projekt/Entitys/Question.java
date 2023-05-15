package htwberlin.Projekt.Entitys;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;


    @ManyToMany
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
