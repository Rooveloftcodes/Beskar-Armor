package net.Rooveloft.beskararmor.world.feature;

import com.google.common.base.Suppliers;
import net.Rooveloft.beskararmor.Main;
import net.Rooveloft.beskararmor.block.custom.Modblocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures{
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Main.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BESKAR_ORES =
            Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
                    Modblocks.BESKAR_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                            Modblocks.DEEPSLATE_BESKAR_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?,?>> BESKAR_ORE = CONFIGURED_FEATURES.register("beskar_ore"
            , ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BESKAR_ORES.get(), 40)));
    public static void register(IEventBus eventBus)
    {
        CONFIGURED_FEATURES.register(eventBus);
    }
}