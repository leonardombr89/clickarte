package com.clickarte.crm.services;

import org.springframework.stereotype.Service;

import com.clickarte.crm.repositories.FixPriceRepository;

@Service
public class FixPriceService {

    private final FixPriceRepository fixPriceRepository;

    public FixPriceService(FixPriceRepository fixPriceRepository) {
        this.fixPriceRepository = fixPriceRepository;
    }
}
