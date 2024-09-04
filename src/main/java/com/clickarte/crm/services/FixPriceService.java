package com.clickarte.crm.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickarte.crm.dtos.fixPrice.CreateFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.DetailFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.ListFixPriceDto;
import com.clickarte.crm.entities.FixPrice;
import com.clickarte.crm.entities.Price;
import com.clickarte.crm.repositories.FixPriceRepository;
import com.clickarte.crm.utils.converters.FixPriceConverter;



@Service
public class FixPriceService {

    private final FixPriceRepository fixPriceRepository;
    private final PriceService priceService;

    public FixPriceService(FixPriceRepository fixPriceRepository, PriceService priceService) {
        this.fixPriceRepository = fixPriceRepository;
        this.priceService = priceService;
    }


    @Transactional
    public FixPrice create(CreateFixPriceDto createFixPriceDto, Price price) {
        var fixPrice = FixPriceConverter.createFixPriceDtoToFixPrice(createFixPriceDto, price);
        fixPriceRepository.save(fixPrice);
        return fixPrice;
    }


    public DetailFixPriceDto createFixPrice(CreateFixPriceDto createFixPriceDto) {
        var price = priceService.findById(createFixPriceDto.priceId());
        var fixPrice = create(createFixPriceDto, price);
        return FixPriceConverter.fixPriceToDetailFixPriceDto(fixPrice);
    }

    @Transactional(readOnly = true)
    public Page<ListFixPriceDto> list(Pageable page) {
        return fixPriceRepository.findAll(page)
                .map(fixPrice -> FixPriceConverter.fixPriceToListFixPriceDto(fixPrice));
    }

    public DetailFixPriceDto findById(Long id) {
        var fixPrice = fixPriceRepository.findById(id).orElseThrow();
        return FixPriceConverter.fixPriceToDetailFixPriceDto(fixPrice);
    }



    @Transactional
    public void deleteById(Long id) {
        fixPriceRepository.deleteById(id);
    }
}
