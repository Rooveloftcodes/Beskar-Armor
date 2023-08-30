package net.Rooveloft.beskararmor.item;

import net.Rooveloft.beskararmor.Main;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final ResourceKey<Registry<CreativeModeTab>> CREATIVE_MODE_TAB = Registries.f_279569_;
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(CREATIVE_MODE_TAB, Main.MODID);
    public static RegistryObject<CreativeModeTab> BESKAR_TAB = CREATIVE_MODE_TABS.register("beskar_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BESKAR_INGOT.get())).title(Component.translatable("creativemodetab.beskar_tab")).build());
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
