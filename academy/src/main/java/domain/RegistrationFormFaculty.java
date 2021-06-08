package domain;

import java.util.List;

public class RegistrationFormFaculty {

	private Integer id;
	private Faculty faculty;
	private User user;
	private String email;
	private List<Integer> marks;
	private Integer sumMarks;

	public RegistrationFormFaculty() {
		;
	}

	public RegistrationFormFaculty(Faculty faculty, User user, List<Integer> marks) {
		super();
		this.faculty = faculty;
		this.user = user;
		this.marks = marks;
	}

	public RegistrationFormFaculty(Integer id, Faculty faculty, User user, List<Integer> marks) {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	public Integer getSumMarks() {
		return sumMarks;
	}

	public void setSumMarks(Integer sumMarks) {
		this.sumMarks = sumMarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sumMarks == null) ? 0 : sumMarks.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sumMarks == null) {
			if (other.sumMarks != null)
				return false;
		} else if (!sumMarks.equals(other.sumMarks))
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
		return "RegistrationFormFaculty [id=" + id + ", faculty=" + faculty + ", user=" + user + ", email=" + email
				+ ", sumMarks=" + sumMarks + "]";
	}
}