package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate issueDate;
    private LocalDate returnDate;
    private Long userId;
    private Long bookId;

    // Constructors
    public Loan() {
    }

    public Loan(LocalDate issueDate, LocalDate returnDate, Long userId, Long bookId) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.userId = userId;
        this.bookId = bookId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }


}
