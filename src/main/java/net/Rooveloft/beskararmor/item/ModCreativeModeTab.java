package net.Rooveloft.beskararmor.item;
import net.Rooveloft.beskararmor.Main;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab BESKAR_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        BESKAR_TAB = event.registerCreativeModeTab(new ResourceLocation(Main.MODID, "extra_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BESKAR_HELMET.get())).title(Component.translatable("creativemodetab.beskar_tab")));
    }
}
