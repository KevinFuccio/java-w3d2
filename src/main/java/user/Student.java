package user;

import java.util.Date;

public class Student {
	private Long id;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", birthdate="
				+ birthdate + ", avg=" + avg + ", minVote=" + minVote + ", maxVote=" + maxVote + "]";
	}

	private String name;
	private String lastName;
	private String gender;
	private Date birthdate;
	private Integer avg;
	private Integer minVote;
	private Integer maxVote;
	
	public Student(String name, String lastName, String gender, Date birthdate,Integer minVote,Integer maxVote) {
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = (minVote+maxVote)/2;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}
	
	public Student(Long id, String name, String lastName, String gender, Date birthdate, Integer avg, Integer minVote,
			Integer maxVote) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.avg = avg;
		this.minVote = minVote;
		this.maxVote = maxVote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getAvg() {
		return avg;
	}


	public Integer getMinVote() {
		return minVote;
	}

	public void setMinVote(Integer minVote) {
		this.minVote = minVote;
	}

	public Integer getMaxVote() {
		return maxVote;
	}

	public void setMaxVote(Integer maxVote) {
		this.maxVote = maxVote;
	}

	public Long getId() {
		return id;
	}
	
	
}
