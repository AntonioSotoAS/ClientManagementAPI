package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import com.ClientManagement.domain.service.ClientPorfolioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientPorfolio")
public class ClientPorfolioController {

    @Autowired
    ClientPorfolioService clientPorfolioService;

    @GetMapping("/all")
    @ApiOperation("Get All ClientPorfolios")
    public ResponseEntity<List<ClientPorfolioDTO>> getAll(){
        return new ResponseEntity<>(clientPorfolioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a ClientPorfolios with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "ClientPorfolio not found")
    })
    public ResponseEntity<ClientPorfolioDTO> getUser(@ApiParam(value = "The id of the ClientPorfolio"
            ,required = true,example = "2")@PathVariable("id") int clientPorfolioId){
        return clientPorfolioService.getClientPorfolio(clientPorfolioId).map(clientPorfolio -> new ResponseEntity<>(clientPorfolio,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/sellerId/{sellerId}")
    public ResponseEntity<List<ClientPorfolioDTO>> getBySeller(@PathVariable("sellerId") int sellerId){
        return clientPorfolioService.getBySellerId(sellerId).map(clientPorfolio -> new ResponseEntity<>(clientPorfolio,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save ClientPorfolio")
    public ResponseEntity<ClientPorfolioDTO> save(@RequestBody ClientPorfolioDTO clientPorfolio){

        return new ResponseEntity<>(clientPorfolioService.save(clientPorfolio),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete ClientPorfolio")
    public ResponseEntity delete(@PathVariable("id") int clientPorfolioId){

        if (clientPorfolioService.delete(clientPorfolioId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update ClientPorfolio")
    public ClientPorfolioDTO update(@RequestBody ClientPorfolioDTO clientPorfolio){
        return clientPorfolioService.update(clientPorfolio);
    }

}
