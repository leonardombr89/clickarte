package com.clickarte.crm.controllers.fixPrice;

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

import com.clickarte.crm.dtos.fixPrice.CreateFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.DetailFixPriceDto;
import com.clickarte.crm.dtos.fixPrice.ListFixPriceDto;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RequestMapping(value = "/fixprice")
@Tag(name = "Fix Price")
@RestController
public interface FixPriceApi {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created with success a new fix price",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetailFixPriceDto.class)

                    )),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})

    @PostMapping
    ResponseEntity<DetailFixPriceDto> create(@Valid @RequestBody(required = true,
            description = "Create a new fix price",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = CreateFixPriceDto.class))) @org.springframework.web.bind.annotation.RequestBody CreateFixPriceDto createFIxPriceDto,
            UriComponentsBuilder uriComponentsBuilder);

    @GetMapping("{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found with success a fix price",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetailFixPriceDto.class)

                    )),
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    ResponseEntity<DetailFixPriceDto> get(@PathVariable(name = "id", required = true) long id);

    @GetMapping
    Page<ListFixPriceDto> list(Pageable pageable);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}


