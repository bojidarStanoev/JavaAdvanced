package softuni.bg.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.bg.mobilelele.model.entity.Model;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView test(ModelAndView modelAndView){
        modelAndView.addObject("personToGreet","Banda");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
