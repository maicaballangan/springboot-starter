package com.cordisys.web.controllers;

import com.cordisys.web.models.Employee;
import com.cordisys.web.repositories.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@Autowired
	private ModelService<Employee> service;

	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("list", service.getAll());
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "newemployee";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		return "redirect:/";
	}

	@GetMapping("/{id}")
	public String update(@PathVariable(value = "id") long id, Model model) {
		Employee employee = service.getById(id);
		model.addAttribute("employee", employee);
		return "update";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		service.delete(id);
		return "redirect:/";
	}
}
