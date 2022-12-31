package com.ClientManagement.web.controller;


import com.ClientManagement.domain.dto.CustomerDTO;
import com.ClientManagement.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getProduct(@PathVariable("id") int customerId){

        return customerService.getCustomer(customerId).map(customer -> new ResponseEntity<>(customer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //For now, this list is not necessary for the functionality of the api.
    // Yes, as the project progresses, I don't use it, I better remove it.
    @GetMapping("/customerId/{customerId}")
    public ResponseEntity<List<CustomerDTO>> getByCategory(@PathVariable("customerId") int customerId){
        return customerService.getByCustomer(customerId).map(customer -> new ResponseEntity<>(customer,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customer){

      return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int customerId){

        if (customerService.delete(customerId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update")
    public CustomerDTO update(@RequestBody CustomerDTO customer){
        return customerService.update(customer);
    }


}
