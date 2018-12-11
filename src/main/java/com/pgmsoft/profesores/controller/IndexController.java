package com.pgmsoft.profesores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	public String index () {
		String response = "Bienvenido al Sistema de Gestión de Cursos";
		return response;
	}
}
