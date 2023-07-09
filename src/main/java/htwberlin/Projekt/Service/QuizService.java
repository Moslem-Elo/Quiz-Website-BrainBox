package htwberlin.Projekt.Service;

import htwberlin.Projekt.Entitys.Quiz;
import htwberlin.Projekt.Repositorys.QuestionRepository;
import htwberlin.Projekt.Repositorys.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public Quiz save(Quiz quiz) {

        return quizRepository.save(quiz);
    }


    public Quiz update(Long id, Quiz quiz){
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz existingQuiz = optionalQuiz.get();
            existingQuiz.setTitle(quiz.getTitle());
            existingQuiz.setDifficulty(quiz.getDifficulty());
            existingQuiz.setTheme(quiz.getTheme());
            existingQuiz.setQuestion(quiz.getQuestion());
            return quizRepository.save(existingQuiz);
        } else {
            return null; // oder eine Exception werfen, wenn das Quiz nicht gefunden wurde
        }
    }

    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }

    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    public List<Quiz> findAll() {
        Iterable<Quiz> iterable = quizRepository.findAll();
        List<Quiz> quiz = new ArrayList<>();
        iterable.forEach(quiz::add);
        return quiz;
    }

    public List<Quiz> findByTitle(String title) {
        return quizRepository.findByTitleContainingIgnoreCase(title);
    }



    public List<Quiz> findByDifficulty(String difficulty) {
        return quizRepository.findByDifficulty(difficulty);
    }
}

