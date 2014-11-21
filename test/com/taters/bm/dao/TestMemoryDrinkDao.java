package com.taters.bm.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.taters.bm.domain.Drink;

/**
 * <p>
 * Title: TestMemoryDrinkDao.java
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
public class TestMemoryDrinkDao {

	private IDrinkDao ddao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ddao = new MemoryDrinkDao();
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryDrinkDao#getDrinks()}.
	 */
	@Test
	public void testGetDrinks() {
		assertEquals(6, ddao.getDrinks().size());
	}

	/**
	 * Test method for {@link com.taters.bm.dao.MemoryDrinkDao#getDrink(java.lang.String)}.
	 */
	@Test
	public void testGetDrink() {
		Drink drink = ddao.getDrinkByNumber("1");
		assertEquals(drink.getName(), "coffee");
		drink = ddao.getDrinkByName("coffee");
		assertEquals(drink.getName(), "coffee");
	}
}
