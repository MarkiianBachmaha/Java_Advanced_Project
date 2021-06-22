package academy.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import dao.RegistrationFormRepository;
import domain.Faculty;
import domain.RegistrationFormFaculty;
import domain.Subject;
import domain.User;
import domain.UserRole;
import service.RegistrationAtFacultyService;

@SpringBootTest
public class RegistrationAtFacultyServiceTest {

	@Autowired
	private RegistrationAtFacultyService service;

	@MockBean
	private RegistrationFormRepository repository;

	@Test
	@DisplayName("Test findAll")
	void testFindAll() {
		User user1 = new User(0, "new@new1", "new", "user", UserRole.USER, "1");
		User user2 = new User(1, "new@new2", "new", "user", UserRole.USER, "1");
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Subject1"));
		subjects.add(new Subject("Subject2"));
		subjects.add(new Subject("Subject3"));
		Faculty faculty = new Faculty(1, "faculty1", 45, subjects);
		List<Integer> marks = new ArrayList<>();
		marks.add(180);
		marks.add(189);
		marks.add(188);
		List<Integer> marks1 = new ArrayList<>();
		marks.add(150);
		marks.add(180);
		marks.add(195);
		RegistrationFormFaculty registration1 = new RegistrationFormFaculty(faculty, user1, marks);
		RegistrationFormFaculty registration2 = new RegistrationFormFaculty(faculty, user2, marks1);

		doReturn(Arrays.asList(registration1, registration2)).when(repository).findAll();
		List<RegistrationFormFaculty> registrationFormFacultyList = service.showAllEntrants();
		// Assert the response
		Assertions.assertEquals(2, registrationFormFacultyList.size(), "findAll should return 2 registrations");
	}

	@Test
	@DisplayName("Test save faculty")
	void testSave() {
		User user1 = new User(0, "new@new1", "new", "user", UserRole.USER, "1");
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Subject1"));
		subjects.add(new Subject("Subject2"));
		subjects.add(new Subject("Subject3"));
		Faculty faculty = new Faculty(1, "faculty1", 45, subjects);
		List<Integer> marks = new ArrayList<>();
		marks.add(180);
		marks.add(189);
		marks.add(188);
		RegistrationFormFaculty registrationFormFaculty = new RegistrationFormFaculty(faculty, user1, marks);
		doReturn(registrationFormFaculty).when(repository).save(any());
		RegistrationFormFaculty returnedRegistration = service.save(registrationFormFaculty);
		// Assert the response
		Assertions.assertNotNull(returnedRegistration, "The saved registration should not be null");
	}

}