package net.Rooveloft.beskararmor;

import com.mojang.logging.LogUtils;
import net.Rooveloft.beskararmor.block.Modblocks;
import net.Rooveloft.beskararmor.item.ModCreativeModeTabs;
import net.Rooveloft.beskararmor.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        Modblocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(ModItems.BESKAR_INGOT);
            event.accept(ModItems.RAW_BESKAR_ORE);

            event.accept(Modblocks.BESKAR_ORE);
            event.accept(Modblocks.DEEPSLATE_BESKAR_ORE);
            event.accept(Modblocks.BESKAR_BLOCK);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.BESKAR_HELMET);
            event.accept(ModItems.BESKAR_CHESTPIECE);
            event.accept(ModItems.BESKAR_LEGGINGS);
            event.accept(ModItems.BESKAR_BOOTS);
        }
        if(event.getTab() == ModCreativeModeTabs.BESKAR_TAB.get())
        {
            event.accept(ModItems.BESKAR_INGOT);
            event.accept(ModItems.RAW_BESKAR_ORE);
            event.accept(ModItems.BESKAR_HELMET);
            event.accept(ModItems.BESKAR_CHESTPIECE);
            event.accept(ModItems.BESKAR_LEGGINGS);
            event.accept(ModItems.BESKAR_BOOTS);

            event.accept(Modblocks.BESKAR_ORE);
            event.accept(Modblocks.DEEPSLATE_BESKAR_ORE);
            event.accept(Modblocks.BESKAR_BLOCK);
        }
    }
    public void commonSetup(final FMLCommonSetupEvent event) {}
}
