package service;

import java.util.List;
import java.util.Optional;

import domain.Subject;

public interface SubjectService {

	public Subject save(Subject subject);

	public List<Subject> findAll();

	public Optional<Subject> findById(Integer id);
}