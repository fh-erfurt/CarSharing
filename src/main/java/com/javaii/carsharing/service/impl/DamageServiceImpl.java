package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.model.Damage;
import com.javaii.carsharing.repository.DamageRepository;
import com.javaii.carsharing.service.DamageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageServiceImpl implements DamageService {
    DamageRepository damageRepository;

    @Override
    public Long saveDamage(Damage damage) {
        damageRepository.save(damage);
        return damage.getId();
    }

    @Override
    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    @Override
    public Damage findDamageById(long id) {
        return damageRepository.getById(id);
    }

}
