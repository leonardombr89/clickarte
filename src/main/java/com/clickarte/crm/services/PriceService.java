package com.clickarte.crm.services;

import com.clickarte.crm.repositories.PriceRepository;

public class PriceService {


    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

}
