package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SubjectRepository;
import domain.Subject;
import service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	public List<Subject> getAllFaculties() {
		return subjectRepository.findAll();
	}

	public Subject findById(Integer id) {
		return subjectRepository.findById(id).get();
	}
}