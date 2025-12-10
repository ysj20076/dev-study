package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!");
        //hello.html로 감 - 스프링(정확히는 뷰 리졸버)이 resources/templates 밑의 hello.html을 찾아서 처리
        return "hello";
    }
}
