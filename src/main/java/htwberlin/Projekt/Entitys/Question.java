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

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "answer")
    private List<Answer> answers = new ArrayList<>();

    //Todo antworten in die question klasse implentieren answer als kLASSE UND dann in einen answer
    // ist packen mit dem Datentyp answer der den Boolean coreect beinhaltet

    //Todo Theme als enum deklarieren
    //ToDo question als Liste in Quiz implentieren der DatenTyp Question

    public Question() {
    }

    public Question(String text, Quiz quiz) {
        this.text = text;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
