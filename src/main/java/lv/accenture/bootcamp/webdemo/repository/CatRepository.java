package lv.accenture.bootcamp.webdemo.repository;

import lv.accenture.bootcamp.webdemo.model.Cat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatRepository {
    private List<Cat> cats = new ArrayList<>();

    public CatRepository() {
        cats.add(new Cat(1L, "Kūpers", "3", "https://tinyurl.com/yx86rwtn"));
        cats.add(new Cat(2L, "Pīka", "6", "https://tinyurl.com/trkgacc"));
    }

    public List<Cat> findAll() {
        return cats;
    }

    public void add(Cat cat) {
        Long idMax = 0L;
        for (Cat i : cats) {
            if (i.getId() > idMax) {
                idMax = i.getId();
            }
        }
        idMax = idMax + 1;
        cat.setId(idMax);
        cats.add(cat);
    }

    public Cat findById(Long id) {
        for (Cat i : cats) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        throw new IllegalArgumentException("cat by Id: " + id + "not found!");
    }

    public void update(Cat editedCat) {
        int i = 0;
        for (i = 0; i < cats.size(); i++) {
            Cat cat = cats.get(i);
            if (cat.getId().equals(editedCat.getId())) {
                cats.set(i, editedCat);
            }
        }
        //throw new IllegalArgumentException("cat by Id: " + editedCat.getId() + "not found!");
    }

    public void delete(Long id) {
        Cat cat = findById(id);
        cats.remove(cat);
    }
    public List<Cat> findByNickname(String catName){
        List<Cat> matchedCats = new ArrayList<Cat>();
        for (Cat cat : cats){
            if(cat.getNickname().equalsIgnoreCase(catName)){
                matchedCats.add(cat);
            }
        }
        return matchedCats;
    }
}