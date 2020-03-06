package lv.accenture.bootcamp.webdemo.controller;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.naming.Binding;
import java.util.List;

@Controller
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping("/cats")
    public String catIndex(Model model){
        List<Cat> cats = catRepository.findAll();
        model.addAttribute("cats", cats);
        return "cats-index";
    }
    @GetMapping("/cats/add")
    public String addCatPage(Model model, BindResult<Cat> bindResult){
        model.addAttribute("cat", new Cat());
        return "add-cat";

    }

}
