package com.apap.tutorial8.controller;

import java.util.Locale;

import javax.validation.Valid;

import com.apap.tutorial8.model.ChangePasswordModel;
import com.apap.tutorial8.model.UserRoleModel;
import com.apap.tutorial8.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/user")
public class UserRoleController<GenericResponse> {
    @Autowired
    private UserRoleService userService;

    @PostMapping(value="/addUser")
    public String addUserSubmit(@ModelAttribute UserRoleModel user) {
        userService.addUser(user);
        return "home";
    }

    @GetMapping(value="/profile")
    public String viewUserProfile() {
        return "profile";
	}
	
	@GetMapping(value="/update-success")
	public String updateSuccess() {
		return "update-success";
	}
	
    @PostMapping("/updatePassword")
    private ModelAndView updatePass(@ModelAttribute ChangePasswordModel pass, Model model, RedirectAttributes redirect) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserRoleModel user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		
		String msg = "";
		
		if(pass.getPasswordBaru().equals(pass.getKonfirmasiPasswordBaru())) {
			if(passwordEncoder.matches(pass.getPasswordLama(), user.getPassword())) {
				userService.updatePassword(user, pass.getPasswordBaru());
				msg = "Password berhasil diubah!";
			}
			else {
				msg = "Password lama anda salah!";
			}
		}
		else {
			msg = "Password baru tidak sesuai!";
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/user/update-success");
		redirect.addFlashAttribute("msg", msg);
		return modelAndView;
    }
}