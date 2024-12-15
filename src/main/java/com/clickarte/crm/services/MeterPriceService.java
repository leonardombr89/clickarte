package com.clickarte.crm.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickarte.crm.dtos.meterPrice.CreateMeterPriceDto;
import com.clickarte.crm.entities.MeterPrice;
import com.clickarte.crm.repositories.MeterPriceRepository;
import com.clickarte.crm.utils.converters.MeterPriceConverter;


@Service
public class MeterPriceService {

    private final MeterPriceRepository metroPriceRepository;

    public MeterPriceService(MeterPriceRepository metroPriceRepository) {
        this.metroPriceRepository = metroPriceRepository;
    }

    @Transactional
    public MeterPrice create(CreateMeterPriceDto priceDto) {
        var price = MeterPriceConverter.CreateMeterPriceDtoToMeterPrice(priceDto);
        return metroPriceRepository.save(price);
    }

    @Transactional(readOnly = true)
    public MeterPrice find(Long id) {
        return metroPriceRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void delete(Long id) {
        metroPriceRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<MeterPrice> list(Pageable page) {
        return metroPriceRepository.findAll(page);
    }



}
