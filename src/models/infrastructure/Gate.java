package models.infrastructure;

public class Gate {
    private Integer number;// nullable

    public Gate(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "gate" + " " + number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

