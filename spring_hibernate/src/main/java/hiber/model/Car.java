package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Car other = (Car) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.model, other.model)
                && Objects.equals(this.series, other.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, series);
    }
}
