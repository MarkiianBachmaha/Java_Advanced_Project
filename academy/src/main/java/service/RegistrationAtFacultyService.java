package service;

import java.util.List;

import domain.RegistrationFormFaculty;

public interface RegistrationAtFacultyService {

	public void save(RegistrationFormFaculty facultyRegistration);

	public List<RegistrationFormFaculty> showAllEntrants();
}