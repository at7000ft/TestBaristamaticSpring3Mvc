package com.taters.bm.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.taters.bm.domain.Drink;
import com.taters.bm.domain.InventoryEntry;

/**
 * <p>
 * Title: TestBaristaService.java
 * </p>
 * <p>
 * Description:
 * 
 * </p>
 * <p>
 * Nov 17, 2010
 * </p>
 * 
 * @author RHOLLAND DRS Technologies Inc.
 * 
 * 
 */
public class TestBaristaService {

	private IBaristaService bs;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bs = new BaristaService();
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#getDrinkCost(java.lang.String)}.
	 */
	@Test
	public void testGetDrinkCost() {
		System.out.println("testGetDrinkCost: " + bs.getDrinkCost("coffee"));
		assertEquals(bs.getDrinkCost("coffee"), BigDecimal.valueOf(1.25));
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#getDrink(java.lang.String)}.
	 */
	@Test
	public void testGetDrink() {
		assertEquals(bs.getDrink("1").getName(), "coffee");
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#getDrinks()}.
	 */
	@Test
	public void testGetDrinks() {
		List<Drink> drinks = bs.getDrinks();
		assertEquals(drinks.size(), 6);
		assertTrue(drinks.get(0).getInStock());
		for (Drink drink : drinks) {
			if (drink.getNumber() == 1) {
				assertEquals(drink.getCost(), BigDecimal.valueOf(1.25));
			}
		}
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#getInventoryAvailable()}.
	 */
	@Test
	public void testGetInventoryAvailable() {
		assertEquals(bs.getInventoryAvailable().size(), 9);
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#areIngredientsAvailable(java.lang.String)}.
	 */
	@Test
	public void testAreIngredientsAvailable() {
		assertTrue(bs.areIngredientsAvailable("1"));
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#orderDrink(java.lang.String)}.
	 */
	@Test
	public void testOrderDrink() {
		bs.orderDrink("1");
		List<InventoryEntry> lst = bs.getInventoryAvailable();
		for (InventoryEntry inventoryEntry : lst) {
			if (inventoryEntry.getName().equals("coffee")) {
				assertEquals(inventoryEntry.getCount(), 7);
			}
		}
	}

	/**
	 * Test method for {@link com.taters.bm.services.BaristaService#reStockInventory()}.
	 */
	@Test
	public void testReStockInventory() {
		bs.orderDrink("1");
		bs.orderDrink("1");
		bs.reStockInventory();
		List<InventoryEntry> lst = bs.getInventoryAvailable();
		for (InventoryEntry inventoryEntry : lst) {
			if (inventoryEntry.getName().equals("coffee")) {
				assertEquals(inventoryEntry.getCount(), 10);
			}
		}
	}
}
