package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	List<Subject> getAllByName(List<String> strings);
}