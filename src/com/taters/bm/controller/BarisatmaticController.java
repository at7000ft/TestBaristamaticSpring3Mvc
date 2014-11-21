package com.taters.bm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taters.bm.domain.Drink;
import com.taters.bm.domain.InventoryEntry;
import com.taters.bm.services.IBaristaService;

/**
 * <p>
 * Title: BarisatmaticController.java
 * </p>
 * <p>
 * Description:
 * 
 * </p>
 * <p>
 * Nov 18, 2010
 * </p>
 * 
 * @author RHOLLAND DRS Technologies Inc.
 * 
 * 
 */
// Make this class a SpringMvc controller
@Controller
@RequestMapping("/barista")
public class BarisatmaticController {

	private IBaristaService baristaService;

	/**
	 * @param baristaService
	 */
	@Autowired
	public BarisatmaticController(IBaristaService baristaService) {
		super();
		System.out.println("BarisatmaticController>>constDDD: called, baristaService - " + baristaService);
		this.baristaService = baristaService;
	}

	// Invoked at http://localhost:8080/TestBaristamaticSpring3Mvc/barista/welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		System.out.println("BarisatmaticController>>welcome: called, baristaService - " + baristaService);
		Date today = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}

	// Invoked at http://localhost:8080/TestBaristamaticSpring3Mvc/barista/restock
	@RequestMapping(value = "/restock", method = RequestMethod.GET)
	public String restock() {
		System.out.println("BarisatmaticController>>restockYY: called");
		baristaService.reStockInventory();
		return "redirect:/barista";
	}

	// Invoked at http://localhost:8080/TestBaristamaticSpring3Mvc/barista
	@RequestMapping(method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println("BarisatmaticController>>main: called");
		List<Drink> drinks = baristaService.getDrinks();
		model.addAttribute("drinks", drinks);
		List<InventoryEntry> inventory = baristaService.getInventoryAvailable();
		model.addAttribute("inventory", inventory);
		return "main";
	}

	//Invoked at http://localhost:8080/TestBaristamaticSpring3Mvc/barista/2
	@RequestMapping(value = "{drinkNumber}", method = RequestMethod.GET)
	public String order(@PathVariable("drinkNumber")
	String drinkNumber) {
		System.out.println("BarisatmaticController>>order: called with " + drinkNumber);
		baristaService.orderDrink(drinkNumber);
		return "redirect:/barista";
	}
}
