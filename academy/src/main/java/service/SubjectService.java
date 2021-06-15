package service;

import java.util.List;

import domain.Subject;

public interface SubjectService {

	public void save(Subject subject);

	public List<Subject> getAllFaculties();

	public Subject findById(Integer id);
}