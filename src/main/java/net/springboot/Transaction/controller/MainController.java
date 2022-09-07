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
import java.util.Arrays;
import java.util.List;

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
	public String dataTransferFrom(@Valid @ModelAttribute TransactionData td, Model model, BindingResult bindingResult) {
		model.addAttribute("td", td);
		Double totalAmount = td.setTotalAmount(td.getAdditionalFees()+td.getTransactionAmount());
		TransactionData savedData = dataservice.CreateData(td);
		if(bindingResult.hasErrors())
		{
			System.out.println(bindingResult);
			return "index";
		}
		return "success";

	}


}