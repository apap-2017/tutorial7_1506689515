package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.CourseModel;
import com.example.service.CourseService;

@Controller
public class CourseController
{
    @Autowired
    CourseService courseDAO;

    
    @RequestMapping("/course/view/{id_course}")
    public String viewPath (Model model,
    		@PathVariable(value="id_course") String id_course) 
    {
    	CourseModel course = courseDAO.selectCourse(id_course);
    	
    	if(course != null) {
    		model.addAttribute("course",course);
    		return "viewcourse";
    	} else {
    		model.addAttribute("id_course",id_course);
    		return "not-found2";
    	}
    }
    
    
}
