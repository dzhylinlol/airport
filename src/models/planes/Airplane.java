package models.planes;

public abstract class Airplane {
    private Long id;
    private String model;

    public Airplane() {};

    public Airplane(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public abstract void takeOff();

    public abstract void land();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}

