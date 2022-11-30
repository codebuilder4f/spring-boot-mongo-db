package com.codebuilder.mongodb.controller;

import com.codebuilder.mongodb.model.Expense;
import com.codebuilder.mongodb.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllExpense() {
        return ResponseEntity.ok(expenseService.getAllExpense());
    }


    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpenses(@PathVariable String id) {
        expenseService.deleteExpenses(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
