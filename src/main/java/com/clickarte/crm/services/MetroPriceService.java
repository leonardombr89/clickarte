package com.clickarte.crm.services;

import org.springframework.stereotype.Service;

import com.clickarte.crm.repositories.MetroPriceRepository;

@Service
public class MetroPriceService {

    private final MetroPriceRepository metroPriceRepository;

    public MetroPriceService(MetroPriceRepository metroPriceRepository) {
        this.metroPriceRepository = metroPriceRepository;
    }
}
