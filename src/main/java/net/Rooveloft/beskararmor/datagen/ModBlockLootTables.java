package net.Rooveloft.beskararmor.datagen;

import net.Rooveloft.beskararmor.block.Modblocks;
import net.Rooveloft.beskararmor.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(Modblocks.BESKAR_BLOCK.get());

        add(Modblocks.BESKAR_ORE.get(), (block -> createOreDrop(Modblocks.BESKAR_ORE.get(),
                ModItems.RAW_BESKAR_ORE.get())));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Modblocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
