package lv.accenture.bootcamp.webdemo.repository;

import lv.accenture.bootcamp.webdemo.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    List<Cat> findByNickname(String nickname); //ka nomainit lai strada lidzigi "where name like..."
    // viens variants nomainit funkcijas nosaukumu vai @Query() - izpildes laika skatisies uz iekavas rakstito
}