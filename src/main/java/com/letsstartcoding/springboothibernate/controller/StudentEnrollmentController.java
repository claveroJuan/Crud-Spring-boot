package com.letsstartcoding.springboothibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.letsstartcoding.springboothibernate.dao.StudentDAO;
import com.letsstartcoding.springboothibernate.model.Student;



@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping(value="/agregar",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "agregar";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegistration(@Valid Student student,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "agregar";
		}
	
		studentDao.save(student);
		
		return "redirect:/vista";
	}
	
	
	@RequestMapping(value="/vista")
	public ModelAndView getAll() {
		
		List<Student> list=studentDao.findAll();
		return new ModelAndView("vista","list",list);
	}
	
	
	@RequestMapping(value="/editar/{id}")
	public String edit (@PathVariable int id,ModelMap model) {
		
		Student student=studentDao.findOne(id);
		model.addAttribute("student",student);
		return "editar";
	}
	
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student p) {
		
		Student student=studentDao.findOne(p.getId());
		
		student.setFirstName(p.getFirstName());
		student.setLastName(p.getLastName());
		student.setCountry(p.getCountry());
		student.setEmail(p.getEmail());
		student.setSection(p.getSection());
		student.setSex(p.getSex());
		
		studentDao.save(student);
		return new ModelAndView("redirect:/vista");
	}
	
	@RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		Student student=studentDao.findOne(id);
		studentDao.delete(student);
		return new ModelAndView("redirect:/vista");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteAll() {
		studentDao.deleteAll();
		return new ModelAndView("redirect:/vista");
	}
	

	@ModelAttribute("sections")
	public List<String> intializeSections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Magister");
		sections.add("Pregrado");
		sections.add("Doctorado");
		return sections;
	}
	
	

	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("CHILE");
		countries.add("ARGENTINA");
		countries.add("CANADA");
		countries.add("PERU");
		countries.add("ALEMANIA");
		countries.add("ITALIA");
		countries.add("OTRO");
		return countries;
	}

	
	
	

}
