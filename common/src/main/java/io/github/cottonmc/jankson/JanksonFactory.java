package io.github.cottonmc.jankson;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.command.argument.serialize.ArgumentSerializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.Schedule;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.passive.CatVariant;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.entry.LootPoolEntryType;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.nbt.LootNbtProviderType;
import net.minecraft.loot.provider.number.LootNumberProviderType;
import net.minecraft.loot.provider.score.LootScoreProviderType;
import net.minecraft.particle.ParticleType;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.StatType;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.pool.StructurePoolElementType;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.structure.rule.PosRuleTestType;
import net.minecraft.structure.rule.RuleTestType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.floatprovider.FloatProviderType;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.VillagerType;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.PositionSourceType;
import net.minecraft.world.gen.blockpredicate.BlockPredicateType;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.chunk.placement.StructurePlacementType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.size.FeatureSizeType;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.heightprovider.HeightProviderType;
import net.minecraft.world.gen.placementmodifier.PlacementModifierType;
import net.minecraft.world.gen.root.RootPlacerType;
import net.minecraft.world.gen.stateprovider.BlockStateProviderType;
import net.minecraft.world.gen.structure.StructureType;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.minecraft.world.poi.PointOfInterestType;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonNull;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;

import static net.minecraft.util.registry.Registry.*;

public class JanksonFactory {
	public static Jankson.Builder builder() {
		Jankson.Builder builder = Jankson.builder();

		builder
			.registerDeserializer(String.class, ItemStack.class, BlockAndItemSerializers::getItemStackPrimitive)
			.registerDeserializer(JsonObject.class, ItemStack.class, BlockAndItemSerializers::getItemStack)
			.registerSerializer(ItemStack.class, BlockAndItemSerializers::saveItemStack);

		builder
			.registerDeserializer(String.class, BlockState.class, BlockAndItemSerializers::getBlockStatePrimitive)
			.registerDeserializer(JsonObject.class, BlockState.class, BlockAndItemSerializers::getBlockState)
			.registerSerializer(BlockState.class, BlockAndItemSerializers::saveBlockState);

		builder
			.registerDeserializer(String.class, Identifier.class,         (s,m)->new Identifier(s))
			.registerSerializer(Identifier.class, (i,m)->new JsonPrimitive(i.toString()))
			;

		//All the things you could potentially specify with just a registry ID
		//Note: specifically excludes dynamic registries since we can't have static access to them.
		register(builder, Activity.class,                   ACTIVITY);
		register(builder, ArgumentSerializer.class,         COMMAND_ARGUMENT_TYPE);
		register(builder, BannerPattern.class,              BANNER_PATTERN);
		register(builder, Block.class,                      BLOCK);
		register(builder, BlockEntityType.class,            BLOCK_ENTITY_TYPE);
		register(builder, BlockPredicateType.class,         BLOCK_PREDICATE_TYPE);
		register(builder, BlockStateProviderType.class,     BLOCK_STATE_PROVIDER_TYPE);
		register(builder, Carver.class,                     CARVER);
		register(builder, CatVariant.class,                 CAT_VARIANT);
		register(builder, ChunkStatus.class,                CHUNK_STATUS);
		register(builder, Enchantment.class,                ENCHANTMENT);
		register(builder, EntityAttribute.class,            ATTRIBUTE);
		register(builder, EntityType.class,                 ENTITY_TYPE);
		register(builder, Feature.class,                    FEATURE);
		register(builder, FeatureSizeType.class,            FEATURE_SIZE_TYPE);
		register(builder, FloatProviderType.class,          FLOAT_PROVIDER_TYPE);
		register(builder, Fluid.class,                      FLUID);
		register(builder, FoliagePlacerType.class,          FOLIAGE_PLACER_TYPE);
		register(builder, FrogVariant.class,                FROG_VARIANT);
		register(builder, GameEvent.class,                  GAME_EVENT);
		register(builder, HeightProviderType.class,         HEIGHT_PROVIDER_TYPE);
		register(builder, Instrument.class,                 INSTRUMENT);
		register(builder, IntProviderType.class,            INT_PROVIDER_TYPE);
		register(builder, Item.class,                       ITEM);
		register(builder, LootConditionType.class,          LOOT_CONDITION_TYPE);
		register(builder, LootFunctionType.class,           LOOT_FUNCTION_TYPE);
		register(builder, LootNbtProviderType.class,        LOOT_NBT_PROVIDER_TYPE);
		register(builder, LootNumberProviderType.class,     LOOT_NUMBER_PROVIDER_TYPE);
		register(builder, LootPoolEntryType.class,          LOOT_POOL_ENTRY_TYPE);
		register(builder, LootScoreProviderType.class,      LOOT_SCORE_PROVIDER_TYPE);
		register(builder, MemoryModuleType.class,           MEMORY_MODULE_TYPE);
		register(builder, PaintingVariant.class,            PAINTING_VARIANT);
		register(builder, ParticleType.class,               PARTICLE_TYPE);
		register(builder, PlacementModifierType.class,      PLACEMENT_MODIFIER_TYPE);
		register(builder, PointOfInterestType.class,        POINT_OF_INTEREST_TYPE);
		register(builder, PositionSourceType.class,         POSITION_SOURCE_TYPE);
		register(builder, PosRuleTestType.class,            POS_RULE_TEST);
		register(builder, Potion.class,                     POTION);
		register(builder, RecipeSerializer.class,           RECIPE_SERIALIZER);
		register(builder, RecipeType.class,                 RECIPE_TYPE);
		register(builder, RootPlacerType.class,             ROOT_PLACER_TYPE);
		register(builder, RuleTestType.class,               RULE_TEST);
		register(builder, Schedule.class,                   SCHEDULE);
		register(builder, ScreenHandlerType.class,          SCREEN_HANDLER);
		register(builder, SensorType.class,                 SENSOR_TYPE);
		register(builder, SoundEvent.class,                 SOUND_EVENT);
		register(builder, StatType.class,                   STAT_TYPE);
		register(builder, StatusEffect.class,               STATUS_EFFECT);
		register(builder, StructurePlacementType.class,     STRUCTURE_PLACEMENT);
		register(builder, StructurePieceType.class,         STRUCTURE_PIECE);
		register(builder, StructurePoolElementType.class,   STRUCTURE_POOL_ELEMENT);
		register(builder, StructureProcessorType.class,     STRUCTURE_PROCESSOR);
		register(builder, StructureType.class,              STRUCTURE_TYPE);
		register(builder, TreeDecoratorType.class,          TREE_DECORATOR_TYPE);
		register(builder, TrunkPlacerType.class,            TRUNK_PLACER_TYPE);
		register(builder, VillagerProfession.class,         VILLAGER_PROFESSION);
		register(builder, VillagerType.class,               VILLAGER_TYPE);
		register(builder, Registry.class,                   REGISTRIES);

		return builder;
	}

	private static <T> void register(Jankson.Builder builder, Class<T> clazz, Registry<? extends T> registry) {
		builder.registerDeserializer(String.class, clazz, (s,m)->lookupDeserialize(s, registry));
		builder.registerSerializer(clazz, (o,m)->lookupSerialize(o, registry));
	}

	private static <T> T lookupDeserialize(String s, Registry<T> registry) {
		return registry.get(new Identifier(s));
	}

	private static <T, U extends T> JsonElement lookupSerialize(T t, Registry<U> registry) {
		@SuppressWarnings("unchecked") //Widening cast happening because of generic type parameters in the registry class
		Identifier id = registry.getId((U)t);
		if (id==null) return JsonNull.INSTANCE;
		return new JsonPrimitive(id.toString());
	}


	public static Jankson createJankson() {
		return builder().build();
	}

}
