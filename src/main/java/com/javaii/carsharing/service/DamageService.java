package com.javaii.carsharing.service;

import com.javaii.carsharing.model.Damage;

import java.util.List;

public interface DamageService {
    Long saveDamage(Damage damage);
    List<Damage> findAll();
    Damage findDamageById(long id);
}
