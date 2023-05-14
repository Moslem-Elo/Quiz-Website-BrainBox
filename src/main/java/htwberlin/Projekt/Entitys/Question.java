package htwberlin.Projekt.Entitys;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;



public class Question {


    private String text;

    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String text) {
        this.text = text;
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
