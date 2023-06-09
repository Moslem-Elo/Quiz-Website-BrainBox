package htwberlin.Projekt.Controller;

import htwberlin.Projekt.Entitys.Answer;
import htwberlin.Projekt.Entitys.Question;
import htwberlin.Projekt.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {


        @Autowired
        private QuestionService questionService;

        @PostMapping("/create")
        public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
            Question createdQuestion = questionService.createQuestion(question);
            return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
        }

        @GetMapping("/get-all")
        public List<Question> getAllQuestions(){
            List<Question> questions = questionService.getAllQuestions();
            return questions;
        }

        @GetMapping("/{id}/get-question")
        public Question getQuestionById(@PathVariable Long id) {
            Question question = questionService.getQuestionById(id);
            return question;
        }


        @PutMapping("/{id}/update-question")
        public ResponseEntity<Void> updateQuestion(@PathVariable Long id, @RequestBody Question question) {

            questionService.updateQuestion(id, question);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/{id}/delete-question")
        public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


}
