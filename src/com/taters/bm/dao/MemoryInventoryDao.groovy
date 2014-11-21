package com.taters.bm.dao

import com.taters.bm.domain.InventoryEntry;

import com.taters.bm.domain.InventoryEntry;






import com.taters.bm.domain.*;


import java.util.Map;

import java.util.List;




/**
 * <p> Title: MemoryInventoryDao.java </p>
 * <p> Description:   
 *
 * </p>
 * <p> Oct 3, 2010</p>
 * @author RHOLLAND
 * DRS Technologies Inc.
 *
 *
 */
class MemoryInventoryDao implements IInventoryDao {
	def inventory;
	
	public MemoryInventoryDao() {
		super();
		inventory = ["cocoa":new InventoryEntry(displayName: "Cocoa", name: "cocoa", cost: 0.90, count: 10),
						"coffee":new InventoryEntry(displayName: "Coffee", name: "coffee", cost: 0.75, count: 10),
						"decafCoffee":new InventoryEntry(displayName: "DecafCoffee", name: "decafCoffee", cost: 0.75, count: 10),
						"sugar":new InventoryEntry(displayName: "Sugar", name: "sugar", cost: 0.25, count: 10),
						"cream":new InventoryEntry(displayName: "Cream", name: "cream", cost: 0.25, count: 10),
						"steamedMilk":new InventoryEntry(displayName: "Steamed Milk", name: "steamedMilk", cost: 0.35, count: 10),
						"foamedMilk":new InventoryEntry(displayName: "Foamed Milk", name: "foamedMilk", cost: 0.35, count: 10),
						"espresso":new InventoryEntry(displayName: "Espresso", name: "espresso", cost: 1.10, count: 10),
						"whippedCream":new InventoryEntry(displayName: "Whipped Cream", name: "whippedCream", cost: 1.00, count: 10)]
	}
	
	//	boolean ingredientAvailable(String iname, int icount) {
	//		inventory[iname].count > icount
	//	}
	
	List<InventoryEntry> getInventoryEntries() {
		inventory.collect{assoc -> assoc.value }
	}
	
	BigDecimal getIngredientCost(String iname) {
		inventory[iname].cost
	}
	
	int getIngredientCount(String iname) {
		inventory[iname].count
	}
	
	//	boolean areIngredientsAvailable(Drink drink) {
	//		Map recipe = drink.recipe
	//		for (each in recipe) {
	//			def cnt = inventory[each.key].count
	//			//println "Recipe needs ${each.value}  count - ${cnt}"
	//			if (each.value > cnt) {
	//				return false;
	//			}
	//		}
	//		return true
	//	}
	
	void removeIngredients(Map ingredientMap) {
		for (assoc in ingredientMap) {
			InventoryEntry inventoryEntry = inventory[assoc.key]
			inventoryEntry.consumeIngredient(assoc.value)
		}
	}
	
	InventoryEntry getInventoryEntry(String name) {
		return inventory[name]
	}
	
	void updateInventoryEntry(InventoryEntry entry) {
		inventory[entry.name] = entry;
	}
}
