package com.clickarte.crm.controllers.fixPrice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.clickarte.crm.dtos.fixPrice.CreateFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.DetailFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.ListFixPriceDto;
import com.clickarte.crm.services.FixPriceService;
import com.clickarte.crm.utils.ControllerUtil;
import com.clickarte.crm.utils.constantes.ApiPaths;

import jakarta.validation.Valid;


@RestController
public class FixPriceController implements FixPriceApi {


    private final FixPriceService fixPriceService;

    public FixPriceController(FixPriceService fixPriceService) {
        this.fixPriceService = fixPriceService;

    }

    @Override
    public ResponseEntity<DetailFixPriceDto> create(@Valid CreateFixPriceDto createFIxPriceDto,
            UriComponentsBuilder uriComponentsBuilder) {
        var responseFixPrice = fixPriceService.createFixPrice(createFIxPriceDto);
        var uri = ControllerUtil.getUri(uriComponentsBuilder, ApiPaths.FIX_PRICE_BY_ID,
                responseFixPrice.id());
        return ResponseEntity.created(uri).body(responseFixPrice);
    }

    @Override
    public Page<ListFixPriceDto> list(Pageable pageable) {
        return fixPriceService.list(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        fixPriceService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @Override
    public ResponseEntity<DetailFixPriceDto> get(long id) {
        return ResponseEntity.ok().body(fixPriceService.findById(id));
    }
}
