package net.Rooveloft.beskararmor.worldgen.feature;

import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.block.Modblocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.List;

public class ModConfiguredFeatures{
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BESKAR_ORE_KEY = registerKey("beskar_ore");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldBeskarOres = List.of(OreConfiguration.target(stoneReplaceables,
                    Modblocks.BESKAR_ORE.get().defaultBlockState()),
            OreConfiguration.target(deepslateReplaceables, Modblocks.DEEPSLATE_BESKAR_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_BESKAR_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBeskarOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Main.MODID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    public static void register(IEventBus modEventBus) {
        register(modEventBus);
    }
}