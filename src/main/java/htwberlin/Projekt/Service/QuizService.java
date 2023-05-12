package htwberlin.Projekt.Service;

import htwberlin.Projekt.Entitys.Quiz;
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

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz update(Long id, Quiz quiz){

        return quizRepository.save(quiz);
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

    public List<Quiz> findByTheme(String theme) {
        return quizRepository.findByTopic(theme);
    }

    public List<Quiz> findByDifficulty(String difficulty) {
        return quizRepository.findByDifficulty(difficulty);
    }
}

