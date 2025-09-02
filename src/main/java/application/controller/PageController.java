package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // default landing page → login.html
    @GetMapping("/")
    public String defaultPage() {
        return "index";  // serve login.html
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";  // serve home.html
    }
    
    @GetMapping("/dataview")
    public String getData(Model model)
    {
    	List<String> backendData = new ArrayList<>();
    	for(int i=0;i<10;i++)
    		backendData.add(String.valueOf(i));
    	
    	model.addAttribute("backendData",backendData);
    	
    	return "data";
    }
    
    @GetMapping("/reports")
    public String getReports(Model model)
    {
    	return "reports";
    }
}

