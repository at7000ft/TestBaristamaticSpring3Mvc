package com.taters.bm.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.taters.bm.domain.InventoryEntry;

/**
 * <p>
 * Title: IInventoryDao.java
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
public interface IInventoryDao {

	// public boolean ingredientAvailable(String name, int count);
	public List<InventoryEntry> getInventoryEntries();

	public void removeIngredients(Map<String, Integer> ingredientMap);

	public BigDecimal getIngredientCost(String name);

	public int getIngredientCount(String iname);

	public InventoryEntry getInventoryEntry(String name);

	public void updateInventoryEntry(InventoryEntry entry);
}
