package net.springboot.Transaction.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.Transaction.Entity.TransactionData;
import net.springboot.Transaction.Repository.TransactionDataRepository;
import net.springboot.Transaction.Service.DataService;

@Controller
public class MainController {
	
	@Autowired
	TransactionDataRepository trRepo;
	
	@Autowired
	DataService dataservice;
	
	@GetMapping("/")
	public String showForm() {
		return "index";
	}


	@PostMapping("/addData")
	public String dataTransferFrom(@ModelAttribute TransactionData td,Model model) {



		System.out.println(td.getTransactionAmount());
		System.out.println(td.getTransactionDate());
		System.out.println(td.getTransactionMode());
		System.out.println(td.getAdditionalFees());
			
				
		Double taxAmount = td.setTaxAmount((td.getAdditionalFees()+td.getTransactionAmount())*(td.getTax()/100));
		System.out.println(taxAmount);
		
		Double totalAmount = td.setTotalAmount(td.getAdditionalFees()+td.getTransactionAmount()+td.getTaxAmount());
		System.out.println(totalAmount);


		dataservice.createData(td);
		return "Success";
		
	}
	

}