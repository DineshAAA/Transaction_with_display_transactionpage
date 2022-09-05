package net.springboot.Transaction.Service;

import org.springframework.stereotype.Service;

import net.springboot.Transaction.Entity.TransactionData;
import net.springboot.Transaction.Repository.TransactionDataRepository;

@Service
public class DataServiceImpl implements DataService {


	private TransactionDataRepository transactionDataRepository;


	public DataServiceImpl(TransactionDataRepository transactionDataRepository) {
		super();
		this.transactionDataRepository = transactionDataRepository;
	}


	@Override
	public void createData(TransactionData data) {
			this.transactionDataRepository.save(data);
			}
}