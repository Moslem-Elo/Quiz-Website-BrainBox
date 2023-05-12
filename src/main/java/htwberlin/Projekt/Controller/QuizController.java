package htwberlin.Projekt.Controller;
import htwberlin.Projekt.Entitys.Quiz;
import htwberlin.Projekt.Service.QuizService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz/getQuiz/{id}")
    public Optional<Quiz> getQuiz(@PathVariable Long id) {
        return quizService.findById(id);

    }

    @PostMapping("/quiz/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.save(quiz);
        return ResponseEntity.created(URI.create("/api/quiz/" + createdQuiz.getId())).body(createdQuiz);
    }

    @PutMapping("/quiz/update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.update(id, quiz);
        if (updatedQuiz != null) {
            return ResponseEntity.ok(updatedQuiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/quiz/delete/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @GetMapping("/")
    public List<Quiz> getQuizzesByTitle(@RequestParam(name = "title", required = false) String title) {
        if (title != null) {
            return quizService.findByTitle(title);
        } else {
            return quizService.findAll();
        }
    }

}

