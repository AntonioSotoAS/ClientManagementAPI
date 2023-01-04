package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.service.BrandService;
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
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/all")
    @ApiOperation("Get All brands")
    public ResponseEntity<List<BrandDTO>> getAll(){
        return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a brand with an ID")
    @ApiResponses({
                    @ApiResponse(code = 200,message = "OK"),
                    @ApiResponse(code = 404,message = "Brand not found")
    })
    public ResponseEntity<BrandDTO> getProduct(@ApiParam(value = "The id of the brand"
    ,required = true,example = "2") @PathVariable("id") int produtId){
        return brandService.getBrand(produtId).map(brand -> new ResponseEntity<>(brand,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    @ApiOperation("Save brand")
    public ResponseEntity<BrandDTO> save(@RequestBody BrandDTO brand){
        return new ResponseEntity<>(brandService.save(brand),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete brand")
    public ResponseEntity delete(@PathVariable("id") int brandId){

        if (brandService.delete(brandId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update brand")
    public BrandDTO update(@RequestBody BrandDTO brand){
        return brandService.update(brand);
    }


}
