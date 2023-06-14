package net.Rooveloft.beskararmor;

import com.mojang.logging.LogUtils;
import net.Rooveloft.beskararmor.block.Modblocks;
import net.Rooveloft.beskararmor.item.custom.ModItems;
import net.Rooveloft.beskararmor.worldgen.feature.ModConfiguredFeatures;
import net.Rooveloft.beskararmor.worldgen.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod(Main.MODID)
public class Main
{
    public static final String MODID = "beskararmor";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Main()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        Modblocks.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public void commonSetup(final FMLCommonSetupEvent event) {}
}
