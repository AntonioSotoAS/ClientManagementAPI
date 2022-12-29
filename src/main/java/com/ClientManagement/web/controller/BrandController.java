package com.ClientManagement.web.controller;

import com.ClientManagement.domain.dto.BrandDTO;
import com.ClientManagement.domain.service.BrandService;
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
    public ResponseEntity<List<BrandDTO>> getAll(){
        return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getProduct(@PathVariable("id") int produtId){
        return brandService.getBrand(produtId).map(brand -> new ResponseEntity<>(brand,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //For now, this list is not necessary for the functionality of the api.
    // Yes, as the project progresses, I don't use it, I better remove it.
    @GetMapping("/brandId/{brandId}")
    public ResponseEntity<List<BrandDTO>> getByCategory(@PathVariable("brandId") int brandId){
        return brandService.getByBrand(brandId).map(brand -> new ResponseEntity<>(brand,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<BrandDTO> save(@RequestBody BrandDTO brand){
        return new ResponseEntity<>(brandService.save(brand),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int brandId){

        if (brandService.delete(brandId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public BrandDTO update(@RequestBody BrandDTO brand){
        return brandService.update(brand);
    }


}
