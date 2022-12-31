package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.SellerDTO;
import com.ClientManagement.domain.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private  SellerService sellerService;

    @GetMapping("/all")
    public ResponseEntity<List<SellerDTO>> getAll(){
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable("id") int sellerId){
        return sellerService.getSeller(sellerId).map(seller -> new ResponseEntity<>(seller,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //For now, this list is not necessary for the functionality of the api.
    // Yes, as the project progresses, I don't use it, I better remove it.
    @GetMapping("/sellerId/{sellerId}")
    public ResponseEntity<List<SellerDTO>> getBySeller(@PathVariable("sellerId") int sellerId){
        return sellerService.getBySeller(sellerId).map(seller -> new ResponseEntity<>(seller,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<SellerDTO> save(@RequestBody SellerDTO seller){

        return new ResponseEntity<>(sellerService.save(seller),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int sellerId){

        if (sellerService.delete(sellerId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public SellerDTO update(@RequestBody SellerDTO seller){
        return sellerService.update(seller);
    }

}
