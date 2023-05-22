package htwberlin.Projekt.Entitys;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Theme theme;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private List<Question> question = new ArrayList<>();


    public Quiz() {
    }

    public Quiz(String title, Difficulty difficulty,Theme theme) {
        this.title = title;
        this.difficulty = difficulty;
        this.theme = theme;
    }


    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
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

    public void setTitle(String title) {
        this.title = title;
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



    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", theme=" + theme +
                ", difficulty=" + difficulty +
                ", question=" + question +
                '}';
    }
}
