package com.javaii.carsharing.repository;

import com.javaii.carsharing.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepository extends JpaRepository<Damage, Long> {
}
