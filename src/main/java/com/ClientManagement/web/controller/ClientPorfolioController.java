package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.ClientPorfolioDTO;
import com.ClientManagement.domain.service.ClientPorfolioService;
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
    public ResponseEntity<List<ClientPorfolioDTO>> getAll(){
        return new ResponseEntity<>(clientPorfolioService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientPorfolioDTO> getUser(@PathVariable("id") int clientPorfolioId){
        return clientPorfolioService.getClientPorfolio(clientPorfolioId).map(clientPorfolio -> new ResponseEntity<>(clientPorfolio,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/sellerId/{sellerId}")
    public ResponseEntity<List<ClientPorfolioDTO>> getBySeller(@PathVariable("sellerId") int sellerId){
        return clientPorfolioService.getBySellerId(sellerId).map(clientPorfolio -> new ResponseEntity<>(clientPorfolio,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ClientPorfolioDTO> save(@RequestBody ClientPorfolioDTO clientPorfolio){

        return new ResponseEntity<>(clientPorfolioService.save(clientPorfolio),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int clientPorfolioId){

        if (clientPorfolioService.delete(clientPorfolioId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public ClientPorfolioDTO update(@RequestBody ClientPorfolioDTO clientPorfolio){
        return clientPorfolioService.update(clientPorfolio);
    }

}
