package net.Rooveloft.beskararmor.world.feature;

import com.google.common.base.Suppliers;
import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.block.Modblocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures{
    /*public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Main.MODID);*/
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_BESKAR_ORE_KEY = registerKey("overworld_beskar_ore");
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BESKAR_ORES =
            Suppliers.memoize(() -> List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),Modblocks.BESKAR_ORE.get().defaultBlockState()),
                    OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            Modblocks.DEEPSLATE_BESKAR_ORE.get().defaultBlockState())));
    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context)
    {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, OVERWORLD_BESKAR_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_BESKAR_ORES.get(),30));
    }
    /*public static final RegistryObject<ConfiguredFeature<?,?>> BESKAR_ORE = CONFIGURED_FEATURES.register("beskar_ore"
            , ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BESKAR_ORES.get(), 40)));*/
    public static ResourceKey<ConfiguredFeature<?,?>>registerKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Main.MODID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    /*public static void register(IEventBus eventBus)
    {
        CONFIGURED_FEATURES.register(eventBus);
    }*/
}