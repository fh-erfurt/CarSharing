package com.javaii.carsharing.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    @Id
    @NotBlank(message = "{notBlank}")
    @EqualsAndHashCode.Include
    private String registrationNr;

    @NotNull(message = "{notNull}")
    @Range(min = 1850, max = 2090, message = "{constructionYearError}")
    private Integer constructionYear;

    @NotNull(message = "{notNull}")
    @Min(value = 0, message = "{mileageError}")
    private Integer mileage;

    @NotBlank(message = "{notBlank}")
    private String model;

    @ManyToOne
    private Station station;

    public void setRegistrationNr(String registrationNr) {
        this.registrationNr = registrationNr.strip();
    }

    public void setModel(String model) {
        this.model = model.strip();
    }

    @Override
    public String toString() {
        return "(" + this.registrationNr + ") " + this.model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return Objects.equals(registrationNr, car.registrationNr);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
