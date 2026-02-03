package models.people;

public abstract class Person {

    private Long id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    ;

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (this.getClass() == o.getClass()) {
            return true;
        }

        Person person = (Person) o;
        if (this.id.equals(person.getId())
                && this.firstName.equals(person.getFirstName())
                && this.lastName.equals(person.getLastName())) {
            return true;
        }

        return false;
    }

    public abstract String getRole();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

