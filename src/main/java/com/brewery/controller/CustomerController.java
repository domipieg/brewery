package com.brewery.controller;

import com.brewery.model.BeerDto;
import com.brewery.model.CustomerDto;
import com.brewery.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/api/v1/customer") // Api versioning allows you to evolve the API without breaking existing API consumers
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping({"/{customerId}"}) // by putting it in {} brackets it tells that it is @PathVariable parameter
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("customerId") UUID customerId) { // @PathVariable is optional in this case
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) { // RequestBody bounds request body to  parameter
        BeerDto savedDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) // ResponseEntity<>(HttpStatus.NO_CONTENT);
    public void handleDelete(UUID beerId) {
        customerService.deleteCustomer(beerId);
    }
}
