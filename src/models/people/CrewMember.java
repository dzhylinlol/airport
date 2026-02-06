package models.people;

import java.util.Objects;

public abstract class CrewMember extends Person {
    private String employeeId;
    private Integer yearsOfExperience;

    public CrewMember() {};

    public CrewMember(Long id,
                      String firstName,
                      String lastName,
                      String employeeId,
                      Integer yearsOfExperience) {
        super(id, firstName, lastName);
        this.employeeId = employeeId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
