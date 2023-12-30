package com.example.library.service;

import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public void issueBook(Long userId, Long bookId) {
        // Implement logic to issue a book, set issueDate, and handle other details
        // Save the loan information to the database
        Loan loan = new Loan();
        loan.setUserId(userId);
        loan.setBookId(bookId);
        loanRepository.save(loan);
    }

    public void returnBook(Long loanId) {
        // Implement logic to return a book, set returnDate, and handle other details
        // Update the loan information in the database
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if (loan != null) {
            loan.setReturnDate(LocalDate.now());
            loanRepository.save(loan);
        }
    }

    public Loan getLoanById(Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.orElse(null);
    }

    public void saveLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    // You can add more business logic or custom methods as needed
}
