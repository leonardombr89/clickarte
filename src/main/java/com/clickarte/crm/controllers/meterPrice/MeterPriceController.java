package com.clickarte.crm.controllers.meterPrice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.clickarte.crm.dtos.meterPrice.CreateMeterPriceDto;
import com.clickarte.crm.entities.MeterPrice;
import com.clickarte.crm.services.MeterPriceService;
import com.clickarte.crm.utils.ControllerUtil;
import com.clickarte.crm.utils.constantes.ApiPaths;

@RestController
public class MeterPriceController implements MeterPriceApi {

    private final MeterPriceService meterPriceService;

    public MeterPriceController(MeterPriceService meterPriceService) {
        this.meterPriceService = meterPriceService;
    }

    @Override
    public ResponseEntity<MeterPrice> create(CreateMeterPriceDto createMeterPrice,
            UriComponentsBuilder uriComponentsBuilder) {
        var price = meterPriceService.create(createMeterPrice);
        var url = ControllerUtil.getUri(uriComponentsBuilder, ApiPaths.PRICE_BY_ID, price.getId());
        return ResponseEntity.created(url).body(price);
    }

    @Override
    public ResponseEntity<MeterPrice> findById(Long id) {
        var price = meterPriceService.find(id);
        return ResponseEntity.ok().body(price);
    }

    @Override
    public Page<MeterPrice> list(Pageable pageable) {
        return meterPriceService.list(pageable);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        meterPriceService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
