package com.taters.bm.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Title: TestMemoryInventoryDao.java
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
public class TestMemoryInventoryDao {

	IInventoryDao idao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		idao = new MemoryInventoryDao();
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryInventoryDao#getInventoryEntries()}.
	 */
	@Test
	public void testGetIngredientsAvailable() {
		assertEquals(idao.getInventoryEntries().size(), 9);
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryInventoryDao#getIngredientCost(java.lang.String)}.
	 */
	@Test
	public void testGetIngredientCost() {
		System.out.println("testGetIngredientCost: " + idao.getIngredientCost("sugar"));
		assertEquals(idao.getIngredientCost("sugar"), BigDecimal.valueOf(0.25));
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryInventoryDao#getIngredientCount(java.lang.String)}.
	 */
	@Test
	public void testGetIngredientCount() {
		assertEquals(idao.getIngredientCount("sugar"), 10);
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryInventoryDao#removeIngredients(java.util.Map)}.
	 */
	@Test
	public void testRemoveIngredients() {
		// ["coffee": 3, "sugar" : 1, "cream": 1]
		Map<String, Integer> recipe = new HashMap<String, Integer>();
		recipe.put("coffee", 3);
		recipe.put("sugar", 1);
		recipe.put("cream", 1);
		idao.removeIngredients(recipe);
		assertEquals(idao.getIngredientCount("coffee"), 7);
	}
}
