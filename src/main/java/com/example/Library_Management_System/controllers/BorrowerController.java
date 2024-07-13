package com.example.Library_Management_System.controllers;

import com.example.Library_Management_System.Services.BorrowerService;
import com.example.Library_Management_System.models.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping("")
    public List<Borrower> getAllBorrowers(){
        return borrowerService.getAllBorrowers();
    }

    @PostMapping("")
    public Borrower addNewBorrower(@RequestBody Borrower borrower){
        return borrowerService.addBorrower(borrower);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Borrower updateBorrowerById(@RequestBody Borrower borrower, Long id){
        return borrowerService.updateBorrower(borrower, id);
    }

    @DeleteMapping("id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBorrowerById(@PathVariable Long id){
        borrowerService.deleteBorrower(Long.valueOf(id));
    }
}
