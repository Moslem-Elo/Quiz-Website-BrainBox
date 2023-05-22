package htwberlin.Projekt.Repositorys;

import htwberlin.Projekt.Entitys.Quiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

    List<Quiz> findByTitleContainingIgnoreCase(String title);



    List<Quiz> findByDifficulty (String Difficulty);

}
