package com.example.Library_Management_System.Services;

import com.example.Library_Management_System.models.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.Library_Management_System.repositories.BorrowerRepository;

import java.util.List;

@Service
public class BorrowerService {

    @Autowired
    BorrowerRepository borrowerRepository;

    public List<Borrower> getAllBorrowers() {
        return  borrowerRepository.findAll();
    }

    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }

    public Borrower updateBorrower(Borrower borrower, Long id) {
        if(!borrowerRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Borrower Not Found");
        }
        borrower.setId(id);
        addBorrower(borrower);
        return borrower;
    }

    public Borrower getBorrowerByName(String firstName, String lastName){
        return borrowerRepository.findBorrowerByFirstNameAndLastName(firstName, lastName);
    }
    public Borrower getBorrower(Long borrowerId) {
        return borrowerRepository.findById(borrowerId).get();
    }
}
