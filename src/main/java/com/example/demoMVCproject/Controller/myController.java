package com.example.demoMVCproject.Controller;



import com.example.demoMVCproject.Entity.User;
import com.example.demoMVCproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller   // use alw controller when you use the html file for reload.
public class myController
{

    @Autowired
    UserService userService;

    @GetMapping("/person")
    public RedirectView person()
    {
        System.out.println("person is called");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/student");
        return redirectView;

                //"redirect:/student";
    }

    @GetMapping("/student")
    public String student()
    {
        System.out.println("student is called");
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("https://www.google.com/");
        return "form";
    }

    @GetMapping("/")
    public String home(Model model)
    {

        model.addAttribute("key","model object is working ");
        model.addAttribute("id",31);

        List<String> friends = new ArrayList<>();
        friends.add("keval");
        friends.add("sanny");
        friends.add("purav");



        model.addAttribute("friends",friends);

//        String str = null;
//
//        System.out.println(str.length());

        return "home";
    }


//    @ExceptionHandler(value = NullPointerException.class)
//    @ExceptionHandler(value = Exception.class)
//    public String exceptionHandling()
//    {
//       return "exception" ;
//    }
    @GetMapping("/help")
    public ModelAndView home1()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","Jay Shree Ram");
        modelAndView.addObject("number",108);
        modelAndView.addObject("time", LocalDateTime.now());
        modelAndView.setViewName("help");
        List<String> gods=new ArrayList<>();
        gods.add("Ram");
        gods.add("sita");
        gods.add("hanuman");
        gods.add("lakhan");

        modelAndView.addObject("gods",gods);
        return modelAndView;
    }

    @ModelAttribute
    public void commanFiled(Model model)
    {
        model.addAttribute("header","DONEHeading");
    }
    @GetMapping("/form")
    public String form()
    {
        return "form";
    }

    @PostMapping("/register")
    public String formDetails(@ModelAttribute User user, Model model,BindingResult bindingResult)
    {

//        if (bindingResult.hasErrors()) {
//            // handle validation errors
//            return "form";
//        }

        if(user.getEmail().isBlank()) // if email id is null then goeson form page redirect
        {
            return "redirect:/form";
        }

        System.out.println("hii");
        userService.savingUser(user);
        return "success";
    }

    // using @RequestParam from detail getting from view to model;
//    public String formDetails(@RequestParam("email") String userEmail,@RequestParam("name") String userName,@RequestParam("password") String password,Model model)
//    {
//        System.out.println(userEmail);
//        System.out.println(userName);
//        System.out.println(password);
//
//        model.addAttribute("userEmail",userEmail);
//        model.addAttribute("userName",userName);
//        model.addAttribute("password",password);
//
//          return "success";
//    }

}
