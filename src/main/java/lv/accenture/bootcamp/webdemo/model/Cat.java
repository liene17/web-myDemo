package lv.accenture.bootcamp.webdemo.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Cat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 256, message = "Name must be between 2 and 256 characters!")
    private String nickname;

    @NotNull(message = "Must enter an age!")
    @PositiveOrZero(message = "Please enter an adequate age!")
    private Integer age;

    private String photo;

    public Cat() {
    }

    public Cat(Long id, String nickname, Integer age, String photo) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.photo = photo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}