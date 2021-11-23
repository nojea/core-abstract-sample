package com.example.demo.controller;

import com.example.demo.dto.out.StockDTO;
import com.example.demo.facade.StockFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/stock")
@RequiredArgsConstructor
public class StockController {

  private final StockFacade stockFacade;

  @GetMapping
  public ResponseEntity<StockDTO> getStock(@RequestHeader Integer version){
    return ResponseEntity.ok(stockFacade.get(version).getStock());
  }

  @PatchMapping
  public ResponseEntity<Void> patchStock(@RequestBody @Valid StockDTO stockDTO, @RequestHeader Integer version){
    stockFacade.get(version).patchStock(stockDTO);
    return ResponseEntity.ok().build();
  }
}