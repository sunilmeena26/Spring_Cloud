package com.telusko.SpringMVCDemo;

import java.awt.image.AreaAveragingScaleFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.SpringMVCDemo.dao.AlienRepository;
import com.telusko.SpringMVCDemo.model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	} 
	
//	@RequestMapping("/add")
//	public String add(HttpServletRequest req) {
//		int i=Integer.parseInt(req.getParameter("num1"));
//		int j=Integer.parseInt(req.getParameter("num2"));
//		
//		int num3=i+j;
//		HttpSession session=req.getSession();
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
	
	//Using RequestParam
//	@RequestMapping("/add")
//	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j, HttpSession session) {
//		
//		int num3=i+j;
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
	
	//Using ModelAndView
//	@RequestMapping("/add")
//	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("result.jsp");
//		int num3=i+j;
//		mv.addObject("num3", num3);
//		return mv;
//	}
	
//	//Using Preffix and suffix
//		@RequestMapping("/add")
//		public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j) {
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("result");
//			int num3=i+j;
//			mv.addObject("num3", num3);
//			return mv;
//		}
		
	//Using Model and ModelMap
//	@RequestMapping("/add")
//	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,ModelMap m) {
//		int num3=i+j;
//		m.addAttribute("num3", num3);
//		return "result";
//	}
	
	
	//Need Of Model Attributes
//	@RequestMapping("/addAlien")
//	public String addAlien(@RequestParam("aid") int aid,@RequestParam("aname") String aname, Model m) {
//		Alien a=new Alien();
//		a.setAid(aid);
//		a.setAname(aname);
//		m.addAttribute("alien",a);
//		return "result";
//	}
	
	//Model Attributes
//	@RequestMapping("/addAlien")
//	public String addAlien(@ModelAttribute Alien a, Model m) {
//		
//		m.addAttribute("alien",a);
//		return "result";
//	}
	
	//Simplify ModelAttribute
//	@RequestMapping("/addAlien")
//	public String addAlien(@ModelAttribute("alien") Alien a) {
//		return "result";
//	}
	
	//Without using ModelAttribute but It will when in result.jsp alien is same otherwise It will give erro
//	@RequestMapping("addAlien")
//	public String addAlien(Alien a) {
//		return "result";
//	}
	
	//Create a other method to assign value of result.jsp attributes And Here We @ModelAtttribute annotation It annotation is use of method level
//	@ModelAttribute
//	public void modelData(Model m) {
//		m.addAttribute("name","Sunil Meena");
//	}
	
	@Autowired
	AlienRepository alienRepository;
	//Using @GetMapping Annotation to access all data from database
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		m.addAttribute("result",alienRepository.findAll());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid,Model m) {
		m.addAttribute("result",alienRepository.findById(aid));
		return "showAliens";
	}
	
//	@GetMapping("getAlienByName")
//	public String getAlienByName(@RequestParam String aname,Model m) {
//		m.addAttribute("result",alienRepository.findB(aname));
//		return "showAliens";
//	}
	
	@PostMapping(value ="addAlien")
	public String addAlien(@ModelAttribute Alien a) {
		alienRepository.save(a);
		return "result";
	}
}
