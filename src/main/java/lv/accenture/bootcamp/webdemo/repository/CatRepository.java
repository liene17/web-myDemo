package lv.accenture.bootcamp.webdemo.repository;

import lv.accenture.bootcamp.webdemo.model.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatRepository {

    private List<Cat> cats = new ArrayList<>();

    public CatRepository(){
        cats.add(new Cat(1L, "Kūpers"));
        cats.add(new Cat(2L, "Mīce"));
        cats.add(new Cat(6L, "Pīka"));
        cats.add(new Cat(3L, "Muris"));
    }

    public List<Cat> findAll(){
        return cats;
    }

}
