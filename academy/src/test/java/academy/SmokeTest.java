package academy;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import controller.EntrantsController;
import controller.FacultyController;
import controller.RegistrationController;
import controller.UserController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private EntrantsController entrantsController;
	@Autowired
	private FacultyController facultyController;
	@Autowired
	private RegistrationController registrationForFacultyController;
	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(entrantsController).isNotNull();
		assertThat(facultyController).isNotNull();
		assertThat(registrationForFacultyController).isNotNull();
		assertThat(userController).isNotNull();
	}
}