package net.Rooveloft.beskararmor.block.custom;

import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.item.custom.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Modblocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> BESKAR_BLOCK = registerBlock("beskar_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4.8f)
                    .requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    public static final RegistryObject<Block> BESKAR_ORE = registerBlock("beskar_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.0f).requiresCorrectToolForDrops())
            , CreativeModeTab.TAB_MISC);
    public static final RegistryObject<Block> DEEPSLATE_BESKAR_ORE = registerBlock("deepslate_beskar_ore",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.0f).requiresCorrectToolForDrops())
            , CreativeModeTab.TAB_MISC);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
