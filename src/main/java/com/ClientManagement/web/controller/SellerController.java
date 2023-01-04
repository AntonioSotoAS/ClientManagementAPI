package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.SellerDTO;
import com.ClientManagement.domain.service.SellerService;
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
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private  SellerService sellerService;

    @GetMapping("/all")
    @ApiOperation("Get All Sellers")
    public ResponseEntity<List<SellerDTO>> getAll(){
        return new ResponseEntity<>(sellerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Seller with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "Seller not found")
    })
    public ResponseEntity<SellerDTO> getSeller(@ApiParam(value = "The id of the Seller"
            ,required = true,example = "2")@PathVariable("id") int sellerId){
        return sellerService.getSeller(sellerId).map(seller -> new ResponseEntity<>(seller,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save brand")
    public ResponseEntity<SellerDTO> save(@RequestBody SellerDTO seller){

        return new ResponseEntity<>(sellerService.save(seller),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete brand")
    public ResponseEntity delete(@PathVariable("id") int sellerId){

        if (sellerService.delete(sellerId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update brand")
    public SellerDTO update(@RequestBody SellerDTO seller){
        return sellerService.update(seller);
    }

}
