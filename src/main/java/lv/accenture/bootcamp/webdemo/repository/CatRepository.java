package lv.accenture.bootcamp.webdemo.repository;

import lv.accenture.bootcamp.webdemo.model.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

    //2.variants
    @Query ("SELECT c FROM Cat c WHERE c.nickname LIKE %:nickname%") //nedaudz cita sintakse ka sql (* vieta var vienalga ko rakstit)
    //parastais sql butu - SELECT * FROM Cat WHERE Cat.nickname like %nickname%

    List<Cat> findByNickname(@Param(value = "nickname") String nickname);
    //ka nomainit lai strada lidzigi "where name like..."
    // viens variants nomainit funkcijas nosaukumu vai @Query() - izpildes laika skatisies uz iekavas rakstito

    //1.variants
    List<Cat> findByNicknameContainingIgnoreCase(String nickname);

}