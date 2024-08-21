package com.clickarte.crm.controllers.price;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.clickarte.crm.dtos.price.CreatePriceDto;
import com.clickarte.crm.dtos.price.DetailPriceDto;
import com.clickarte.crm.dtos.price.ListPriceDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/price")
@Tag(name = "Price")
public interface PriceApi {


        @PostMapping
        ResponseEntity<DetailPriceDto> create(@RequestBody(required = true,
                        description = "Create a new detail price",
                        content = @Content(mediaType = "application/json",
                                        schema = @Schema(implementation = CreatePriceDto.class

                                        ))) @org.springframework.web.bind.annotation.RequestBody @Valid CreatePriceDto createPrice,
                        UriComponentsBuilder uriComponentsBuilder);

        @GetMapping("{id}")
        ResponseEntity<DetailPriceDto> findById(
                        @PathVariable(name = "id", required = true) Long id);

        @GetMapping
        Page<ListPriceDto> list(Pageable pageable);


        @DeleteMapping("{id}")
        ResponseEntity<Void> deleteById(@PathVariable(required = true, name = "id") Long id);

}
