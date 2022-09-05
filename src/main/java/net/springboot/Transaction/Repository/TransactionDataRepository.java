package net.springboot.Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.Transaction.Entity.TransactionData;

public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {

}
