package htwberlin.Projekt.Controller;

import htwberlin.Projekt.Entitys.Quiz;
import htwberlin.Projekt.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/get-all")
    public List<Quiz> getAllQuiz(){
        return quizService.findAll();
    }

    @GetMapping("/{id}/get-quiz")
    public Optional<Quiz> getQuiz(@PathVariable Long id) {
        return quizService.findById(id);

    }

    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @PutMapping("/{id}/update")
    public Quiz updateQuiz(@PathVariable Long id, @RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.update(id, quiz);
        if (updatedQuiz != null) {
            return updatedQuiz;
        } else {
            throw new RuntimeException("Quiz not found");
        }
    }

    @DeleteMapping("/{id}/delete")
    public void  deleteQuiz(@PathVariable Long id) {

        quizService.deleteById(id);
    }



}

