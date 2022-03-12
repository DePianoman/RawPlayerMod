package com.uhmily.rawplayermod.Events;

import com.uhmily.rawplayermod.Items.ModItems;
import com.uhmily.rawplayermod.RawPlayerMod;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = RawPlayerMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerDeath(LivingDropsEvent e) {

        if (!(e.getEntity() instanceof PlayerEntity)) return;

        PlayerEntity p = (PlayerEntity)e.getEntity();
        if (p.isAlive() || p.isCreative()) return;

        for (ItemEntity item : e.getDrops()) {
            item.remove();
        }

        ItemStack rawPlayerStack = ModItems.RAW_PLAYER.get().getDefaultInstance().copy();
        rawPlayerStack.setCount(new Random().nextInt(3) + 1);

        p.dropItem(rawPlayerStack, true, false);

    }

}
