package com.uhmily.rawplayermod.Items;

import com.uhmily.rawplayermod.RawPlayerMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RawPlayerMod.MOD_ID);

    public static final RegistryObject<Item> RAW_PLAYER = ITEMS.register("raw_player",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(1.8f).build()))
    );

    public static final RegistryObject<Item> COOKED_PLAYER = ITEMS.register("cooked_player",
            () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(8).saturation(12.8f).build()))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
