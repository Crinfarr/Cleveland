package com.crinfarr.cleveland;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.crinfarr.cleveland.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod("cleveland")
public class Core {
    public static final String MOD_ID  = "cleveland";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public Core() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
        ItemInit.ITEMS.register(modBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    }
}
