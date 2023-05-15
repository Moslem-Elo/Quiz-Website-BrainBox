package htwberlin.Projekt.Service;

import htwberlin.Projekt.Entitys.Question;
import htwberlin.Projekt.Repositorys.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        Iterable<Question> iterable = questionRepository.findAll();
        List<Question> questions = new ArrayList<>();
        iterable.forEach(questions::add);
        return questions;
    }


    public Question getQuestionById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            throw new EntityNotFoundException("Question not found with id: " + id);
        }
    }

    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public void updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setText(updatedQuestion.getText());
            question.setAnswers(updatedQuestion.getAnswers());
            questionRepository.save(question);
        } else {
            throw new EntityNotFoundException("Question not found with id: " + id);
        }
    }


}

