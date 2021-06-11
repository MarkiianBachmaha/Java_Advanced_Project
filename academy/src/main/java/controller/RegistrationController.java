package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Faculty;
import domain.RegistrationFormFaculty;
import domain.User;
import service.FacultyService;
import service.RegistrationAtFacultyService;
import service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private RegistrationAtFacultyService registrationAtFacultyService;

	@GetMapping("/registration-at-faculty")
	public ModelAndView registrationAtFaculty(@RequestParam("facultyId") Integer id,
			@RequestParam("email") String email) {
		Faculty faculty = facultyService.findById(id);
		User user = userService.findByEmail(email);
		RegistrationFormFaculty registrationAtFaculty = new RegistrationFormFaculty();
		registrationAtFaculty.setFaculty(faculty);
		registrationAtFaculty.setUser(user);
		ModelAndView modelAndView = new ModelAndView("registrationAtFaculty");
		modelAndView.addObject("facultyRegistration", registrationAtFaculty);
		return modelAndView;
	}

	@PostMapping("/registration-at-faculty")
	public ModelAndView addRegistration(
			@Validated @ModelAttribute("facultyRegistration") RegistrationFormFaculty registrationAtFaculty,
			BindingResult bindingResult) {
		Faculty faculty = facultyService.findById(registrationAtFaculty.getFacultyId());
		User user = userService.findByEmail(registrationAtFaculty.getEmail());
		registrationAtFaculty.setFaculty(faculty);
		registrationAtFaculty.setUser(user);
		registrationAtFacultyService.save(registrationAtFaculty);
		return new ModelAndView("redirect:/home");
	}
}