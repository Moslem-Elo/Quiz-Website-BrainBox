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
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/{quizId}")
    public Optional<Quiz> getQuiz(@PathVariable Long quizId) {
        return quizService.findById(quizId);

    }

    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.save(quiz);
        return ResponseEntity.created(URI.create("/quizzes/" + createdQuiz.getId())).body(createdQuiz);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.update(id, quiz);
        if (updatedQuiz != null) {
            return ResponseEntity.ok(updatedQuiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public void  deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @GetMapping("/title")
    public List<Quiz> getQuizzesByTitle(@RequestParam(name = "title", required = false) String title) {
        if (title != null) {
            return quizService.findByTitle(title);
        } else {
            return quizService.findAll();
        }
    }

}

