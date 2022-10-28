package net.Rooveloft.beskararmor;

import com.mojang.logging.LogUtils;
import net.Rooveloft.beskararmor.block.custom.Modblocks;
import net.Rooveloft.beskararmor.item.custom.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        //modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    /*private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }*/
}
