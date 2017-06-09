package org.example;

import java.util.List;
import java.util.Map;

import org.example.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private ArticlesRepository articlesRepository;

    @RequestMapping("/")
    public ModelAndView index(Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Type> types = articlesRepository.findAllTypes();
        model.put("types", types);
        modelAndView.setViewName("index");
        modelAndView.addObject("myForm", new MyForm());
        return modelAndView;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute MyForm myForm, Map<String, Object> model) {
        List<Result> result = articlesRepository.findArticlesAndRelatedTextCountByType(myForm.getTypeId());
        model.put("result", result);
        return "result";
    }

}