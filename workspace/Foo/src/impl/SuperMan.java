package impl;

import java.time.LocalDateTime;

import anno.JsonName;
@JsonName(name="super_man")
public class SuperMan {
	
	private String name;
	
	@JsonName(name="date_of_birth")
    private LocalDateTime dateOfBirth;
	
	private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
}
