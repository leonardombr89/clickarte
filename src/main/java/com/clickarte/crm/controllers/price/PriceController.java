package com.clickarte.crm.controllers.price;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.price.CreatePriceDto;
import com.clickarte.crm.dtos.price.DetailPriceDto;
import com.clickarte.crm.dtos.price.ListPriceDto;
import com.clickarte.crm.services.PriceService;
import com.clickarte.crm.utils.ControllerUtil;
import com.clickarte.crm.utils.constantes.ApiPaths;

@RestController
public class PriceController implements PriceApi {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<DetailPriceDto> create(CreatePriceDto createPrice,
            UriComponentsBuilder uriComponentsBuilder) {

        var price = priceService.create(createPrice);
        var url = ControllerUtil.getUri(uriComponentsBuilder, ApiPaths.PRICE_BY_ID, price.id());
        return ResponseEntity.created(url).body(price);


    }

    @Override
    public ResponseEntity<DetailPriceDto> findById(Long id) {

        var price = priceService.findDetailPriceById(id);
        return ResponseEntity.ok(price);
    }

    @Override
    public Page<ListPriceDto> list(Pageable pageable) {

        return priceService.list(pageable);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        priceService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
