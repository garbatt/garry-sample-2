package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

    
    @RequestMapping("/blessing")
    public String blessing(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "blessing";
    }
    
    @RequestMapping("/welcome")
    public String welcome(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
    
    @GetMapping("/permutations")
    public String permutationsForm(Model model) {
    	Combinations cmb = new Combinations();
        model.addAttribute("combinations", cmb);
        return "permutations";
    }
    
    // http://localhost:8080/permutations
    @PostMapping("/permutations")
    public String permutationsSubmit(@ModelAttribute Combinations dog) {
    	//permutations.startPermutation();
    	dog.permute();
        return "permresult";
    }

}