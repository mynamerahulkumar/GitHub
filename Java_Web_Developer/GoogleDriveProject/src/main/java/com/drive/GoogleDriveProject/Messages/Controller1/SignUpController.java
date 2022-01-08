package com.drive.GoogleDriveProject.Messages.Controller1;

import com.drive.GoogleDriveProject.Messages.Services.UserService;
import com.drive.GoogleDriveProject.Messages.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private  final UserService userService;
    public SignUpController(UserService userService){
        this.userService=userService;
    }
    @GetMapping()
    public String signUpView(){
        return "signup";
    }
    @PostMapping()
    public String signUpUser(@ModelAttribute  User user, Model model){
        String signupError=null;
        if(!userService.isUserAvailable(user.getusername())){
            signupError="username already exists";
        }
        if(signupError==null){
            int rowsAdded=userService.createUser(user);
            if(rowsAdded<0){
                signupError="There was an error signing you up,please try again";
            }
        }
        if(signupError==null){
            model.addAttribute("signupSuccess",true);
        }
        else{
            model.addAttribute("signupError",signupError);
        }
        return "signup";
    }
}
