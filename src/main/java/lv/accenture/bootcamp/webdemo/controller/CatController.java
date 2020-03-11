package lv.accenture.bootcamp.webdemo.controller;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CatController {
    @Autowired
    private CatRepository catRepository;

    @GetMapping("/cats")
    public String catIndex(Model model) {
        Iterable<Cat> cats = catRepository.findAll();
        model.addAttribute("cats", cats);
        return "cats-index";
    }

    @GetMapping("/cats/add")
    public String addCatPage(Model model) {
        model.addAttribute("cat", new Cat());
        return "add-cat";
    }

    @PostMapping("/cats/add-cat")
    public String addCat(@Valid Cat catToAdd, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "add-cat";
        }
        catRepository.save(catToAdd);
        return "redirect:/cats";
    }

    @GetMapping("/cats/edit/{id}") //{id} - dinamiskais parametrs
    public String editCatPage(@PathVariable Long id, Model model) {
        Optional<Cat> catToEdit = catRepository.findById(id);
        model.addAttribute("cat", catToEdit.get());
        return "edit-cat";
    }

    @PostMapping("/cats/edit-cat/{id}")
    public String editCat(@PathVariable Long id, Cat editedCat, @Valid Cat catToEdit, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "edit-cat";
        }
        editedCat.setId(id);
        System.out.println("Changed id: " + editedCat.getId());
        System.out.println("Changed nickname: " + editedCat.getNickname());

        catRepository.save(editedCat);
        return "redirect:/cats";
    }

    @GetMapping("/cats/delete/{id}") //{id} - dinamiskais parametrs
    public String deleteCat(@PathVariable Long id) {
        // @PathVariable Long id // Spring anotacija @PathVariable pasaka, ka Long id vertiba ir ta, ko mes dabujam no {id}

        catRepository.deleteById(id);
        return "redirect:/cats";
    }

    @GetMapping("/cats/search")
    public String searchCats(@RequestParam String catName, Model model){
        List<Cat> matchedCats = catRepository.findByNickname(catName);
        model.addAttribute("cats", matchedCats);
        return "cats-index";
    }

}