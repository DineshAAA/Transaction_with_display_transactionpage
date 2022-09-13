package net.springboot.Transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.springboot.Transaction.Entity.TransactionData;
import net.springboot.Transaction.Repository.TransactionDataRepository;
import net.springboot.Transaction.Service.DataService;



import javax.validation.Valid;



@Controller
public class MainController {

	@Autowired
	TransactionDataRepository trRepo;

	@Autowired
	DataService dataservice;

	@GetMapping("/addData")
	public String showForm(Model model) {
		model.addAttribute("td",new TransactionData());
		return "index";
	}


	@PostMapping("/addData")
	public String dataTransferFrom(@Valid @ModelAttribute("td") TransactionData td, Model model, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			//System.out.println(bindingResult);
			return "index";
		}
		model.addAttribute("td", td);

		Double  taxAmount = td.setTaxAmount((td.getAdditionalFees()+td.getTransactionAmount())*(td.getTaxpercentage()/100));
		Double  totalAmount = td.setTotalAmount(td.getAdditionalFees()+td.getTransactionAmount()+td.getTaxAmount());

		String currency = td.getFromCurrency();
		switch (currency){
			case "INR":
			{
				Double toAmount = td.setToAmount(td.getTotalAmount()/79.37);
				break;
			}
			case "EURO":
			{
				Double toAmount = td.setToAmount(totalAmount/1.01);
				break;
			}
			case "USD":
			{
				Double toAmount = td.setToAmount(totalAmount*1.0);
				break;
			}
		}

		td.setAccountStatus(true);
		TransactionData savedData = dataservice.CreateData(td);
		System.out.println(td);
		return "success";

	}


}