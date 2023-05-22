package htwberlin.Projekt.Controller;


import htwberlin.Projekt.Entitys.Answer;
import htwberlin.Projekt.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/create")
    public Answer createAnswer(@RequestBody Answer answer) {
        Answer createdAnswer = answerService.createAnswer(answer);
        return answer;
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
