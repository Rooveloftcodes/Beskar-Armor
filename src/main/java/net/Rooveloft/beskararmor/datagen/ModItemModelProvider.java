package net.Rooveloft.beskararmor.datagen;

import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Main.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BESKAR_INGOT);
        simpleItem(ModItems.RAW_BESKAR_ORE);
        simpleItem(ModItems.BESKAR_HELMET);
        simpleItem(ModItems.BESKAR_CHESTPIECE);
        simpleItem(ModItems.BESKAR_LEGGINGS);
        simpleItem(ModItems.BESKAR_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Main.MODID, "item/" + item.getId().getPath()));
    }
}
