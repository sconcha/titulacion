package ec.edu.ug.erp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthController {

	@RequestMapping("/login")
	public String loginPage(){
		return "auht/login";
	}
}
