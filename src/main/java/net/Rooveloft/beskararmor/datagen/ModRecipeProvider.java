package net.Rooveloft.beskararmor.datagen;

import net.Rooveloft.beskararmor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        oreSmelting(consumer, List.of(ModItems.RAW_BESKAR_ORE.get()), RecipeCategory.MISC,
                ModItems.BESKAR_INGOT.get(), 0.7f, 200, "beskar_ingot");
    }
}
