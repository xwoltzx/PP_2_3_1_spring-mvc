package web.entity;


public class Car {
    private String model;
    private Integer year;
    private String owner;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", owner='" + owner + '\'' +
                '}';
    }

    public Car(String model, Integer year, String owner) {
        this.model = model;
        this.year = year;
        this.owner = owner;
    }
}
