package service;

import java.util.Comparator;

import domain.RegistrationFormFaculty;

public class RegistrationMarksCompareService implements Comparator<RegistrationFormFaculty> {

	@Override
	public int compare(RegistrationFormFaculty t1, RegistrationFormFaculty t2) {
		Integer reduce1 = t1.getMarks().stream().reduce(0, Integer::sum);
		Integer reduce2 = t2.getMarks().stream().reduce(0, Integer::sum);

		return reduce1 < reduce2 ? 1 : -1;
	}
}