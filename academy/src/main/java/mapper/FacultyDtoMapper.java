package mapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import dao.SubjectRepository;
import domain.Faculty;
import domain.Subject;
import service.FileService;

@Controller
public class FacultyDtoMapper {

	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private FileService fileService;

	public Faculty createEntity(MultipartFile file, String name, Integer numberOfStudents, List<Subject> subjects)
			throws IOException {

		Faculty faculty = new Faculty();
		List<String> collect = subjects.stream().map(subject -> subject.getName()).collect(Collectors.toList());
		List<Subject> allByNameLike = subjectRepository.getAllByName(collect);
		mapSubjects(subjects, allByNameLike);
		faculty.setName(name);
		faculty.setNumberOfStudents(numberOfStudents);
		faculty.setLogoUrl(fileService.saveFile(file, faculty.getName()));
		faculty.setSubjects(subjects);
		return faculty;
	}

	private void mapSubjects(List<Subject> needSubjects, List<Subject> existSubjects) {

		for (Subject needSubject : needSubjects) {
			for (Subject existSubject : existSubjects) {
				if (needSubject.getName().equalsIgnoreCase(existSubject.getName())) {
					needSubject.setId(existSubject.getId());
				}
			}
		}

	}
}