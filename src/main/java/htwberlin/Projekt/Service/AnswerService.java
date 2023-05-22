package htwberlin.Projekt.Service;

import htwberlin.Projekt.Entitys.Answer;
import htwberlin.Projekt.Repositorys.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer getAnswerById(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            throw new EntityNotFoundException("Answer not found with id: " + id);
        }
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public void updateAnswer(Long id, Answer answer) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            Answer existingAnswer = optionalAnswer.get();
            existingAnswer.setAnswerText(answer.getAnswerText());
            existingAnswer.setCorrect(answer.isCorrect());
            answerRepository.save(existingAnswer);
        } else {
            throw new EntityNotFoundException("Answer not found with id: " + id);
        }
    }

    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }


}
