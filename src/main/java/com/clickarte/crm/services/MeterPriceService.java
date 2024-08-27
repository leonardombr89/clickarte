package com.clickarte.crm.services;

import org.springframework.stereotype.Service;

import com.clickarte.crm.repositories.MeterPriceRepository;

@Service
public class MeterPriceService {

    private final MeterPriceRepository metroPriceRepository;

    public MeterPriceService(MeterPriceRepository metroPriceRepository) {
        this.metroPriceRepository = metroPriceRepository;
    }
}
