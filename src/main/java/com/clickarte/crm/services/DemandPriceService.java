package com.clickarte.crm.services;

import org.springframework.stereotype.Service;

import com.clickarte.crm.repositories.DemandPriceRepository;

@Service
public class DemandPriceService {

    private final DemandPriceRepository demandPriceRepository;

    public DemandPriceService(DemandPriceRepository demandPriceRepository) {
        this.demandPriceRepository = demandPriceRepository;
    }

}
