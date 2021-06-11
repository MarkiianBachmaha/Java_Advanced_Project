package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import service.RegistrationAtFacultyService;

@Controller
public class EntrantsController {

	@Autowired
	private RegistrationAtFacultyService registrationAtFacultyService;

	@GetMapping("/show-entrants")
	public ModelAndView showAllEntrants() {
		return new ModelAndView("showRegistrations", "facultyRegistrations",
				registrationAtFacultyService.showAllEntrants());
	}
}