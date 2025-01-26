package fi.haagahelia.sp2.web;

import fi.haagahelia.sp2.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping("/hello")
    public String hello(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "age", required = false, defaultValue = "-1") int age,
        Model model
    ) {
        if (name != null && age > 0) {
            model.addAttribute("name", name);
            model.addAttribute("age", age);
            return "hello"; // render the 1st ex template
        } else {
            List<Student> students = new ArrayList<>();
            students.add(new Student("Kate", "Cole"));
            students.add(new Student("Dan", "Brown"));
            students.add(new Student("Mike", "Mars"));

            model.addAttribute("students", students);
            return "students"; // render the 2nd ex template
        }
    }

    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greetingSubmit(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	return "error";
        }
        
    	model.addAttribute("message", student);
        return "result";
    }
}
