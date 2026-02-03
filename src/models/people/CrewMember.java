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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CrewMember сrewMember = (CrewMember) o;

        if (this.hashCode() != сrewMember.hashCode()) return false;
        return Objects.equals(employeeId, сrewMember.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employeeId);
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
