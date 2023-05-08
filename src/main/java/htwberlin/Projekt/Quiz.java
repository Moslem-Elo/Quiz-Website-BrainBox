package htwberlin.Projekt;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Quiz {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String title;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    Theme theme;

    String difficulty;

    @OneToMany(mappedBy = "quiz")
    private List<Question> question = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(String title, Theme theme, String difficulty) {
        this.title = title;
        this.theme = theme;
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

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz quiz)) return false;
        return id.equals(quiz.id) && title.equals(quiz.title) && theme.equals(quiz.theme) && difficulty.equals(quiz.difficulty) && Objects.equals(question, quiz.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}