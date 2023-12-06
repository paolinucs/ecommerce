package it.paolone.ecommerce.services;

import it.paolone.ecommerce.entities.Transaction;
import it.paolone.ecommerce.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransactionServices {

  private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionServices (TransactionRepository transactionRepository){
        this.transactionRepository= transactionRepository;
    }
    public Transaction getTransactionById(Long id){
        Optional<Transaction> fetchedTransaction= transactionRepository.findById(id);
        return fetchedTransaction.orElse(null);
    }
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction data){
        return transactionRepository.save(data);
    }
 }
