package academy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dao.FacultyRepository;
import dao.SubjectRepository;
import dao.UserRepository;
import service.FacultyService;
import service.RegistrationAtFacultyService;
import service.SubjectService;
import service.UserService;

@SpringBootTest
public class AcademyApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private RegistrationAtFacultyService registrationForFacultyService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectRepository subjectRepository;

	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}
}