package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.CustomerDTO;
import com.ClientManagement.domain.service.CustomerService;
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
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:5500")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    @ApiOperation("Get All Customer")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a Customer with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "Customer not found")
    })
    public ResponseEntity<CustomerDTO> getProduct(@ApiParam(value = "The id of the Customer"
            ,required = true,example = "2")@PathVariable("id") int customerId){

        return customerService.getCustomer(customerId).map(customer -> new ResponseEntity<>(customer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save Customer")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer){

      return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete Customer")
    public ResponseEntity delete(@PathVariable("id") int customerId){

        if (customerService.delete(customerId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    @ApiOperation("Update Customer")
    public CustomerDTO update(@RequestBody CustomerDTO customer){
        return customerService.update(customer);
    }


}
