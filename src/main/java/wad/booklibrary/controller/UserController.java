/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.booklibrary.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wad.booklibrary.User;
import wad.booklibrary.service.UserService;

/**
 *
 * @author Teemu
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="userform", method = RequestMethod.GET)
    public String show(@ModelAttribute User user){
        return "userform";
    }
    
    @RequestMapping(value="userform", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute(value="user") User user,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            return "userform";
        }
        if(userService.findByUsername(user.getUsername()) != null){
            model.addAttribute("error", "Username is already in use.");
            user.setUsername("");
            return "userform";
        }
        user.setEnabled(1);
        user.setAuthority("user");
        userService.create(user);    
        redirectAttributes.addFlashAttribute("message", "New user registered!");
        return "redirect:/app/userform";
    }
    
    
    
}
