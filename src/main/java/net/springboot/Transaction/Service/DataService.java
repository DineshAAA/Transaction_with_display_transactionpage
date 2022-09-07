package net.springboot.Transaction.Service;

import net.springboot.Transaction.Entity.TransactionData;
import net.springboot.Transaction.Repository.TransactionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    TransactionDataRepository transactionDataRepository;

    public TransactionData CreateData(TransactionData transactionData){
        return transactionDataRepository.save(transactionData);

    }

}
