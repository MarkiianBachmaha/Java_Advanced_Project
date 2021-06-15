package domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "faculty_registration")
public class RegistrationFormFaculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;

	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ElementCollection
	private List<Integer> marks;

	@Column(name = "upload_photo")
	private String uploadPhoto;

	@Column(name = "upload_document")
	private String uploadDocument;

	@Transient
	private String email;

	@Transient
	private int facultyId;

	public RegistrationFormFaculty() {

	}

	public RegistrationFormFaculty(Faculty faculty, User user, List<Integer> marks) {
		this.faculty = faculty;
		this.user = user;
		this.marks = marks;
	}

	public RegistrationFormFaculty(Integer id, Faculty faculty, User user, List<Integer> marks) {
		;
		this.id = id;
		this.faculty = faculty;
		this.user = user;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	public String getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	public String getUploadDocument() {
		return uploadDocument;
	}

	public void setUploadDocument(String uploadDocument) {
		this.uploadDocument = uploadDocument;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + facultyId;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((uploadDocument == null) ? 0 : uploadDocument.hashCode());
		result = prime * result + ((uploadPhoto == null) ? 0 : uploadPhoto.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationFormFaculty other = (RegistrationFormFaculty) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (facultyId != other.facultyId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
			return false;
		if (uploadDocument == null) {
			if (other.uploadDocument != null)
				return false;
		} else if (!uploadDocument.equals(other.uploadDocument))
			return false;
		if (uploadPhoto == null) {
			if (other.uploadPhoto != null)
				return false;
		} else if (!uploadPhoto.equals(other.uploadPhoto))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistrationFormFaculty [id=" + id + ", faculty=" + faculty + ", user=" + user + ", marks=" + marks
				+ ", uploadPhoto=" + uploadPhoto + ", uploadDocument=" + uploadDocument + ", email=" + email
				+ ", facultyId=" + facultyId + "]";
	}
}