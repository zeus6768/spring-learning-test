package cholog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    @GetMapping("/hello")
    public String world(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/json")
    @ResponseBody
    public Person json() {
        // TODO: /json 요청 시 {"name": "brown", "age": 20} 데이터를 응답할 수 있도록 설정하세요.
        return new Person("brown", 20);
    }
}
