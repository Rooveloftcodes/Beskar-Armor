package net.Rooveloft.beskararmor.datagen;

import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.block.Modblocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Main.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(Modblocks.BESKAR_BLOCK);
        blockWithItem(Modblocks.BESKAR_ORE);
        blockWithItem(Modblocks.DEEPSLATE_BESKAR_ORE);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
