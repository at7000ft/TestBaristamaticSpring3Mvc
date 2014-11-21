package com.taters.bm.dao;

import java.util.List;

import com.taters.bm.domain.Drink;

/**
 * <p>
 * Title: IDrinkDao.java
 * </p>
 * <p>
 * Description:
 * 
 * </p>
 * <p>
 * Oct 3, 2010
 * </p>
 * 
 * @author RHOLLAND DRS Technologies Inc.
 * 
 * 
 */
public interface IDrinkDao {

	public List<Drink> getDrinks();

	// public BigDecimal getCost(String name, IInventoryDao inventoryDao);
	public Drink getDrinkByNumber(String number);

	public Drink getDrinkByName(String name);
}
