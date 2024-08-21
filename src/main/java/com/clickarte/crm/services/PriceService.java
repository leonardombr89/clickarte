package com.clickarte.crm.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clickarte.crm.dtos.price.CreatePriceDto;
import com.clickarte.crm.dtos.price.DetailPriceDto;
import com.clickarte.crm.dtos.price.ListPriceDto;
import com.clickarte.crm.repositories.PriceRepository;
import com.clickarte.crm.utils.converters.PriceConverter;



@Service
public class PriceService {


    private final PriceRepository priceRepository;
    private final ProductService productService;

    public PriceService(PriceRepository priceRepository, ProductService productService) {
        this.priceRepository = priceRepository;
        this.productService = productService;
    }


    @Transactional
    public DetailPriceDto create(CreatePriceDto createPrice) {
        var product = productService.findById(createPrice.productId());
        var newPrice = PriceConverter.createPriceDtoToPrice(createPrice, product);
        priceRepository.save(newPrice);
        var detailPrice = PriceConverter.priceToDetailPriceDto(newPrice);
        return detailPrice;
    }

    @Transactional(readOnly = true)
    public DetailPriceDto findDetailPriceById(Long id) {
        var price = priceRepository.findById(id).orElseThrow();
        return PriceConverter.priceToDetailPriceDto(price);
    }


    @Transactional(readOnly = true)
    public Page<ListPriceDto> list(Pageable pageable) {
        return priceRepository.findAll(pageable)
                .map(price -> PriceConverter.priceToListPriceDto(price));
    }

    @Transactional
    public void deleteById(Long id) {
        priceRepository.deleteById(id);
    }

}
