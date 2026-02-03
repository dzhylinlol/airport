package models.people;
import java.util.List;

public class FlightAttendant extends CrewMember {
    private List<String> languages;
    private Boolean isPurser;

    public FlightAttendant() {}

    public FlightAttendant(Long id,
                           String firstName,
                           String lastName,
                           String employeeId,
                           Integer yearsOfExperience,
                           List<String> languages,
                           Boolean isPurser) {
        super(id, firstName, lastName, employeeId, yearsOfExperience);
        this.languages = languages;
        this.isPurser = isPurser;
    }

    @Override
    public String getRole() {
        return "Flight Attendant" + (isPurser ? " (Purser)" : "");
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Boolean getIsPurser() {
        return isPurser;
    }

    public void setIsPurser(Boolean isPurser) {
        this.isPurser = isPurser;
    }

}

