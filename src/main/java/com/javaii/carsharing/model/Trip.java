package com.javaii.carsharing.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long tripId;

    private boolean confirmed, finished;
    private int scheduledId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "driverId", referencedColumnName = "driverId")
    @ToString.Exclude
    private Driver driver;

    private Instant createdDate;

    @OneToMany(fetch = LAZY)
    @ToString.Exclude
    private List<User> riders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trip trip = (Trip) o;

        return Objects.equals(tripId, trip.tripId);
    }

    @Override
    public int hashCode() {
        return 368711113;
    }
}

