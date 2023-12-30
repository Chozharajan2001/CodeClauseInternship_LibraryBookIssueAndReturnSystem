package com.example.library.controller;

import com.example.library.model.Loan;
import com.example.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        return "loans/index";
    }

    @GetMapping("/{id}")
    public String getLoanById(@PathVariable Long id, Model model) {
        Loan loan = loanService.getLoanById(id);

        if (loan == null) {
            // Handle loan not found
            return "error";
        }

        model.addAttribute("loan", loan);
        return "loans/details";
    }

    @GetMapping("/new")
    public String showNewLoanForm(Model model) {
        model.addAttribute("loan", new Loan());
        // Add logic to populate dropdowns or input fields with available users and books
        return "loans/new";
    }

    @PostMapping("/new")
    public String addNewLoan(@ModelAttribute("loan") Loan loan) {
        loanService.saveLoan(loan);
        return "redirect:/loans";
    }

    @GetMapping("/{id}/edit")
    public String showEditLoanForm(@PathVariable Long id, Model model) {
        Loan loan = loanService.getLoanById(id);

        if (loan == null) {
            // Handle loan not found
            return "error";
        }

        model.addAttribute("loan", loan);
        return "loans/edit";
    }

    @PostMapping("/{id}/edit")
    public String editLoan(@PathVariable Long id, @ModelAttribute("loan") Loan loan) {
        Loan existingLoan = loanService.getLoanById(id);

        if (existingLoan == null) {
            // Handle loan not found
            return "error";
        }

        existingLoan.setUserId(loan.getUserId());
        existingLoan.setBookId(loan.getBookId());


        loanService.saveLoan(existingLoan);
        return "redirect:/loans";
    }

    @GetMapping("/{id}/delete")
    public String deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return "redirect:/loans";
    }
}
