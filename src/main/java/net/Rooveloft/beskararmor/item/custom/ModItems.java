package net.Rooveloft.beskararmor.item.custom;

import net.Rooveloft.beskararmor.Main;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    public static final RegistryObject<Item> BESKAR_INGOT = ITEMS.register("beskar_ingot",
            ()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BESKAR_HELMET = ITEMS.register("beskar_helmet",
            () -> new ArmorItem(ModArmorMaterials.BESKAR, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BESKAR_CHESTPIECE = ITEMS.register("beskar_chestpiece",
            () -> new ArmorItem(ModArmorMaterials.BESKAR, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BESKAR_LEGGINGS = ITEMS.register("beskar_leggings",
            () -> new ArmorItem(ModArmorMaterials.BESKAR, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BESKAR_BOOTS = ITEMS.register("beskar_boots",
            () -> new ArmorItem(ModArmorMaterials.BESKAR, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
