package service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SubjectRepository;
import domain.Subject;
import service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

	@Autowired
	private SubjectRepository subjectRepository;

	public void save(Subject subject) {
		logger.info("Save subject: " + subject);
		subjectRepository.save(subject);
	}

	public List<Subject> getAllFaculties() {
		logger.info("Get all faculties");
		return subjectRepository.findAll();
	}

	public Subject findById(Integer id) {
		logger.info("Find subject by id: " + id);
		return subjectRepository.findById(id).get();
	}
}