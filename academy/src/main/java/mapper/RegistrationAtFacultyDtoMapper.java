package mapper;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import domain.Faculty;
import domain.RegistrationFormFaculty;
import domain.User;
import service.FileService;

@Controller
public class RegistrationAtFacultyDtoMapper {

	@Autowired
	private FileService fileService;

	public RegistrationFormFaculty createEntity(MultipartFile filePhoto, MultipartFile fileDocument, Faculty faculty,
			User user, List<Integer> marks) throws IOException {

		RegistrationFormFaculty registrationFormFaculty = new RegistrationFormFaculty();
		registrationFormFaculty.setFaculty(faculty);
		registrationFormFaculty.setUser(user);
		registrationFormFaculty.setMarks(marks);
		registrationFormFaculty.setUploadPhoto(
				fileService.saveFile(filePhoto, user.getFirstName() + "_" + user.getLastName() + "_photo"));
		registrationFormFaculty.setUploadDocument(
				fileService.saveFile(fileDocument, user.getFirstName() + "_" + user.getLastName() + "_document"));

		// faculty.setLogoUrl(fileService.saveFile(filePhoto , user.getFirstName() + "_"
		// + user.getLastName()));

		return registrationFormFaculty;
	}

//    private void mapSubjects(List<Subject> needSubjects , List<Subject> existSubjects){
//
//        for (Subject needSubject : needSubjects) {
//            for (Subject existSubject : existSubjects) {
//                if (needSubject.getName().equalsIgnoreCase(existSubject.getName())){
//                    needSubject.setId(existSubject.getId());
//                }
//            }
//        }
//
//    }
}