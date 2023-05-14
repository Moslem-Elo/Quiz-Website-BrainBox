package htwberlin.Projekt.Controller;

import htwberlin.Projekt.Entitys.Question;
import htwberlin.Projekt.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/question")
public class QuestionController {


        @Autowired
        private QuestionService questionService;

        @PostMapping("/quiz/question/create")
        public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
            Question createdQuestion = questionService.createQuestion(question);
            return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
            Question question = questionService.getQuestionById(id);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }

        @GetMapping("/quiz/{quizId}")
        public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long quizId) {
            List<Question> questions = questionService.getQuestionsByQuizId(quizId);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
            question.setId(id);
            questionService.updateQuestion(question);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


}