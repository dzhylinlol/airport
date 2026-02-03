package models.infrastructure;

public class Gate {
    private Integer number;// nullable

    /// private boolean boardingOpen;

    public Gate(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "gate" + " " + number;
    }

//    public void openBoarding() {
//        boardingOpen = true;
//        System.out.println("Boarding opened at gate " + number);
//    }
//
//    public void closeBoarding() {
//        boardingOpen = false;
//        System.out.println("Boarding closed at gate " + number);
//    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

//    public boolean isBoardingOpen() {
//        return boardingOpen;
//    }
//}

