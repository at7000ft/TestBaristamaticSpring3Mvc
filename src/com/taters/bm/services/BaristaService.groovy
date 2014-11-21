

package com.taters.bm.services

import com.taters.bm.dao.MemoryDrinkDao;
import com.taters.bm.dao.MemoryInventoryDao;

import java.util.List;

import com.taters.bm.domain.Drink;
import com.taters.bm.domain.InventoryEntry 



/**
 * <p> Title: BaristaService.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> Nov 17, 2010</p>
 * @author RHOLLAND
 * DRS Technologies Inc.
 *
 *
 */
class BaristaService implements IBaristaService {
	MemoryDrinkDao drinkDao = new MemoryDrinkDao();
	MemoryInventoryDao inventoryDao = new MemoryInventoryDao();
	
	BigDecimal getDrinkCost(String name) {
		Drink drink = drinkDao.getDrinkByName(name);
		
		Map recipe = drink.recipe
		def cost = 0.0
		for (each in recipe) {
			cost += inventoryDao.getIngredientCost(each.key)
		}
		return cost
	}
	
	Drink getDrink(String drinkNumber) {
		return drinkDao.getDrinkByNumber(drinkNumber);
	}
	
	//Return list of drinks and update cost and inStock in each
	List<Drink> getDrinks() {
		def drks = drinkDao.getDrinks().sort{it.number}
		drks.each {it.cost = getDrinkCost(it.name)}
		drks.each { it.inStock = areIngredientsAvailable(it.number.toString()) }
		//		for (Drink each : drks) {
		//			String x = each.number
		//			println each.number.toString()
		//			
		//			println areIngredientsAvailable(x)
		//			each.inStock = areIngredientsAvailable(x)
		//		}
		return drks;
	}
	
	
	List<InventoryEntry> getInventoryAvailable() {
		return inventoryDao.getInventoryEntries();
	}
	
	boolean areIngredientsAvailable(String drinkNumber) {
		def drink = drinkDao.getDrinkByNumber(drinkNumber)
		Map recipe = drink.recipe
		for (each in recipe) {
			def cnt = inventoryDao.getIngredientCount(each.key)
			//println "Recipe needs ${each.value}  count - ${cnt}"
			if (each.value > cnt) {
				return false;
			}
		}
		return true
	}
	
	void orderDrink(String drinkNumber) {
		def drink = drinkDao.getDrinkByNumber(drinkNumber)
		for (assoc in drink.recipe) {
			InventoryEntry inventoryEntry = inventoryDao.getInventoryEntry(assoc.key)
			inventoryEntry.consumeIngredient(assoc.value)
		}
	}
	
	void reStockInventory() {
		for (each in inventoryDao.getInventoryEntries()) {
			each.count = 10
			inventoryDao.updateInventoryEntry(each)
		}
	}
}
