package com.crinfarr.cleveland.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TestItem extends Item {
	public TestItem(Properties properties) {
		super(properties.food(new Food.Builder().nutrition(8).saturationMod(4).build()));
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 1000;
	}
}
