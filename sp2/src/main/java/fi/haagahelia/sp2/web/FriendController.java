package fi.haagahelia.sp2.web;

import fi.haagahelia.sp2.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    private final List<Friend> friends = new ArrayList<>();

    @GetMapping("/friends")
    public String listFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friends"; // render the html template
    }

    @PostMapping("/friends")
    public String addFriend(
        @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName
    ) {
        friends.add(new Friend(firstName, lastName));
        return "redirect:/friends"; // redir to refresh page
    }

    // @GetMapping("/add")
    // public String addFriendForm() {
    //     return "add-friend"; // render the form where we can send the post req
    // }

    // @PostMapping("/add")
    // public String addFriend(
    //     @RequestParam(name="firstName", required=true) String firstName,
    //     @RequestParam(name="lastName", required=true) String lastName
    // ) {
    //     friends.add(new Friend(firstName, lastName));
    //     return "redirect:/friends"; // redir back to showing the list
    // }

    // @RequestMapping(value="/hello", method=RequestMethod.POST)
    // public String greetingSubmit(@Valid Student student, BindingResult bindingResult, Model model) {
    //     if (bindingResult.hasErrors()) {
    //     	return "error";
    //     }
        
    // 	model.addAttribute("message", student);
    //     return "result";
    // }
}
