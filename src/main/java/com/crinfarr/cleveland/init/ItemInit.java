package com.crinfarr.cleveland.init;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import com.crinfarr.cleveland.Core;
import com.crinfarr.cleveland.item.Cleveland;
import com.crinfarr.cleveland.item.TestItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Core.MOD_ID);
    
    public static class CreativeTab extends ItemGroup {
    	private CreativeTab(int index, String label) {
    		super(index, label);
    	}
    	
    	@Override
    	public ItemStack makeIcon() {
    		return new ItemStack(TEST.get());
    	}
    }
    
    public static final CreativeTab creativeTab = new CreativeTab(ItemGroup.TABS.length, Core.MOD_ID);
    
    //Items below here
    public static final RegistryObject<Item> TEST = ITEMS.register("test_item", () -> new TestItem(new Item.Properties().tab(creativeTab)));
    public static final RegistryObject<Item> CLEVELAND = ITEMS.register("cleveland", () -> new Cleveland(new Item.Properties().tab(creativeTab)));
}