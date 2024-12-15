package com.clickarte.crm.controllers.meterPrice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.clickarte.crm.dtos.meterPrice.CreateMeterPriceDto;
import com.clickarte.crm.entities.MeterPrice;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("meter-prices")
@Tag(name = "MeterPrice")
public interface MeterPriceApi {

        @ApiResponses({@ApiResponse(responseCode = "201", description = "Meter price created",
                        content = @io.swagger.v3.oas.annotations.media.Content(
                                        mediaType = "application/json")),
                        @ApiResponse(responseCode = "400", description = "Validation error",
                                        content = @io.swagger.v3.oas.annotations.media.Content),
                        @ApiResponse(responseCode = "500", description = "Internal server error",
                                        content = @io.swagger.v3.oas.annotations.media.Content)})
        ResponseEntity<MeterPrice> create(@RequestBody(content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(
                                        implementation = CreateMeterPriceDto.class))) @org.springframework.web.bind.annotation.RequestBody CreateMeterPriceDto createMeterPrice,
                        UriComponentsBuilder uriComponentsBuilder);

        @GetMapping("{id}")
        ResponseEntity<MeterPrice> findById(@PathVariable(required = true) Long id);

        Page<MeterPrice> list(Pageable pageable);

        @DeleteMapping("{id}")
        ResponseEntity<Void> delete(@PathVariable(required = true) Long id);
}
