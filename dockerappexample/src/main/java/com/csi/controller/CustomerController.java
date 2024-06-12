package com.csi.controller;

import com.csi.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    List<Customer> customerList = Stream.of(new Customer(121, "SWARA", "PUNE", 79000.22),
            new Customer(122, "RAM", "PUNE", 99000.22),
            new Customer(111, "LAKSHMI", "USA", 19000.22),
            new Customer(191, "VENKAT", "PUNE", 59000.22),
            new Customer(125, "APARNA", "JAPAN", 49000.22)).toList();

    @GetMapping("/listofcustomers")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Customer>> sortbyid() {
        return ResponseEntity.ok(customerList.stream().sorted(Comparator.comparing(Customer::getCustId)).toList());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortbyname() {
        return ResponseEntity.ok(customerList.stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

    @GetMapping("/searchbyname/{custName}")
    public ResponseEntity<List<Customer>> searchByName(@PathVariable String custName) {
        return ResponseEntity.ok(customerList.stream().filter(cust -> cust.getCustName().equals(custName)).toList());
    }


}
