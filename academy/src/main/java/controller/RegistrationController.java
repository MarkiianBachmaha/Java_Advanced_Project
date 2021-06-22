package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import domain.Faculty;
import domain.RegistrationFormFaculty;
import domain.User;
import mapper.RegistrationAtFacultyDtoMapper;
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

	@Autowired
	private RegistrationAtFacultyDtoMapper registrationAtFacultyDtoMapper;

	@GetMapping("/registration_at_faculty")
	public ModelAndView registrationAtFaculty(@RequestParam("facultyId") Integer id,
			@RequestParam("email") String email) {
		Faculty faculty = facultyService.findById(id).get();
		User user = userService.findByEmail(email).get();
		RegistrationFormFaculty registrationAtFaculty = new RegistrationFormFaculty();
		registrationAtFaculty.setFaculty(faculty);
		registrationAtFaculty.setUser(user);
		ModelAndView modelAndView = new ModelAndView("registrationAtFaculty");
		modelAndView.addObject("facultyRegistration", registrationAtFaculty);
		modelAndView.addObject("currentUser", user);
		return modelAndView;
	}

	@PostMapping("/registration_at_faculty")
	public ModelAndView addRegistration(
			@Validated @ModelAttribute("registrationAtFaculty") RegistrationFormFaculty registrationAtFaculty,
			@RequestParam MultipartFile userPhoto, @RequestParam MultipartFile documentPhoto,
			BindingResult bindingResult) throws IOException {
		Faculty faculty = facultyService.findById(registrationAtFaculty.getFacultyId()).get();
		User user = userService.findByEmail(registrationAtFaculty.getEmail()).get();
		registrationAtFaculty.setFaculty(faculty);
		registrationAtFaculty.setUser(user);
		RegistrationFormFaculty entity = registrationAtFacultyDtoMapper.createEntity(userPhoto, documentPhoto, faculty,
				user, registrationAtFaculty.getMarks());

		registrationAtFacultyService.save(entity);
		return new ModelAndView("redirect:/home");
	}
}