package htwberlin.Projekt.Entitys;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    String title;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)        
    Difficulty difficulty;

    @OneToOne
    private List<Question> question = new ArrayList<>();


    public Quiz() {
    }

    public Quiz(String title, Difficulty difficulty) {
        this.title = title;
        this.difficulty = difficulty;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }



    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public enum Theme {
        Allgemeinwissen,
        Programmierkenntnisse,
        Mathematik,
        Sprachen,
        Logik
    }

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }
