package net.Rooveloft.beskararmor.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier BESKAR = new ForgeTier(2,2500,2.5f,4f,
            30, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.BESKAR_INGOT.get()));

}
