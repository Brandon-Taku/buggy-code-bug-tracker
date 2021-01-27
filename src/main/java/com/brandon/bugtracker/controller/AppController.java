package com.brandon.bugtracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.bugtracker.model.Bug;
import com.brandon.bugtracker.model.Employees;
import com.brandon.bugtracker.model.Project;
import com.brandon.bugtracker.model.User;
import com.brandon.bugtracker.repository.BugRepository;
import com.brandon.bugtracker.repository.EmployeeRepository;
import com.brandon.bugtracker.repository.ProjectRepository; 
import com.brandon.bugtracker.repository.UserRepository;
import com.brandon.bugtracker.service.BugImpl;
import com.brandon.bugtracker.service.EmployeeImpl;
import com.brandon.bugtracker.service.ProjectImpl;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BugRepository bugRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private EmployeeImpl employeeService;
	
	@Autowired
	private ProjectImpl projectService;
	
	@Autowired
	private BugImpl bugService;
	
	
	@GetMapping("/home")
	public String HomeView() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/dashboard")
	public String dashborad(Model model) {
		
		model.addAttribute("bug", new Bug());
		
		return "options";
	}
	
	@GetMapping("/add_bug")
	public String showAddBugForm(Model model) {
		
		model.addAttribute("bug", new Bug());
		
		return "addBug";
	}
	
	@PostMapping("/assign_bug")
	public String processBug(Bug bug) {
		bugRepo.save(bug);
		
		return "redirect:/bugs";
	}
	
	@GetMapping("/bugs")
	public String listOfBugs(Model model) {
		
		List<Bug> listBugs = bugRepo.findAll();
		model.addAttribute("listBugs", listBugs);
		
		return "bugsList";
	}
	
	@GetMapping("/admin/login")
	public String AdminPage(Model model) {
		
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	@GetMapping("/admin")
	public String showAdminDashboard(Model model) {
		
		model.addAttribute("bug", new Bug());
		
		return "adminBoard";
	}
	
	@GetMapping("/addProject")
	public String addProject(Model model) {
		
		model.addAttribute("project", new Project());
		
		return "addProject";
	}
	
	@PostMapping("/process_project")
	public String processProject(Project project) {
		
		projectRepo.save(project);
		
		return "redirect:/projects";
	}
	
	@GetMapping("/projects")
    public String viewProject(Model model) {
		
		List<Project> listProject = projectRepo.findAll();
		model.addAttribute("listProject", listProject);
	
		return "projectList";
	}
	
	@GetMapping("/new_employee")
	public String viewEmployeeForm(Model model) {
		
		model.addAttribute("employees", new Employees());
		
		return "newEmployee";
	}
	
	@PostMapping("/process_employee")
	public String processEmployee(Employees employee) {
		
		employeeRepo.save(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees")
	public String employees(Model model) {
		
		List<Employees> listEmployee = employeeRepo.findAll();
		model.addAttribute("listEmployee", listEmployee);
		
		return "employeesList";
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public String deleteEmployee (@PathVariable("id") long id)  {
		
		employeeService.delete(id);
		
		return "redirect:/employees";
		
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String employeeUpdate(@PathVariable("id") long id, Model model) {
		
		Employees employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employees", employee);
		
		return "updateEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String processEmployeeUpdate(@ModelAttribute("employee") Employees employee) {
		
		employeeService.saveEmployee(employee);
		
		return "redirect:/employees";
	}
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String deleteProject (@PathVariable("id") long id)  {
		
		projectService.delete(id);
		
		return "redirect:/projects";
		
	}
	
	@GetMapping("/updateProject/{id}")
	public String projectUpdate(@PathVariable("id") long id, Model model) {
		
		Project project = projectService.getProjectById(id);
		
		model.addAttribute("project", project);
		
		return "updateProject";
	}
	
	@PostMapping("/saveProject")
	public String processProjectUpdate(@ModelAttribute("employee") Project project) {
		
		projectService.saveProject(project);
		
		return "redirect:/projects";
	}
	
	@RequestMapping(value = "/bug/{id}", method = RequestMethod.GET)
	public String deleteBug (@PathVariable("id") long id)  {
		
		bugService.delete(id);
		
		return "redirect:/bugs";
		
	}
	
	@GetMapping("/updateBug/{id}")
	public String bugUpdate(@PathVariable("id") long id, Model model) {
		
		Bug bug = bugService.getBugById(id);
		
		model.addAttribute("bug", bug);
		
		return "updateBug";
	}
	
	@PostMapping("/saveBug")
	public String processBugUpdate(@ModelAttribute("employee") Bug bug) {
		
		bugService.saveBug(bug);
		
		return "redirect:/bugs";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
