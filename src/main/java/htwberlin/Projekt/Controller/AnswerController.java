package htwberlin.Projekt.Controller;


import htwberlin.Projekt.Entitys.Answer;
import htwberlin.Projekt.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/get-answers")
    public Iterable<Answer> getAllAnswers(){
       return answerService.getAllAnswers();
    }

    @PostMapping("/create")
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);

    }

    @GetMapping("/{id}/get-answer")
    public Answer getAnswerById(@PathVariable Long id) {
        Answer answer = answerService.getAnswerById(id);
        return answer;
    }

    @PutMapping("/{id}/update-answer")
    public void updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        answerService.updateAnswer(id, answer);
    }

    @DeleteMapping("/{id}/delete-answer")
    public void deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
    }


}
