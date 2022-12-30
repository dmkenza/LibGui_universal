//package net.examplemod.forge;
//
//import dev.architectury.platform.forge.EventBuses;
//import dev.architectury.registry.registries.DeferredRegister;
//import juuxel.libninepatch.NinePatch;
//import net.examplemod.ExampleMod;
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.entity.SpawnGroup;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.screen.ScreenHandlerType;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.eventbus.api.Event;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//
//import java.util.function.Supplier;
//
//import static net.examplemod.ExampleMod.MOD_ID;
//import static net.minecraft.util.registry.Registry.SCREEN_HANDLER;
//
//@Mod(ExampleMod.MOD_ID)
//public class ExampleModForge {
//
//    //    public static GuiBlock GUI_BLOCK;
////    public static Block NO_BLOCK_INVENTORY_BLOCK;
//    public static BlockItem GUI_BLOCK_ITEM;
//    //    public static BlockEntityType<GuiBlockEntity> GUI_BLOCKENTITY_TYPE;
//    public static ScreenHandlerType<ReallySimpleDescription> REALLY_SIMPLE_SCREEN_HANDLER_TYPE;
//
////    public static ScreenHandlerType<ReallySimpleDescription> REALLY_SIMPLE_SCREEN_HANDLER_TYPE;
//
//    public ExampleModForge() {
//        // Submit our event bus to let architectury register our content on the right time
//        EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
//        ExampleMod.init();
//
//        NinePatch.class.arrayType();
//
//        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
//
//        CommonPlatformHelperImpl.BLOCKS.register(bus);
//        CommonPlatformHelperImpl.ITEMS.register(bus);
//
//
//        registerBlock("no_block_inventory", ()-> new NoBlockInventoryBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
//        bus.addListener(this::setup);
//
//        MinecraftForge.EVENT_BUS.register(this);
//
////        NO_BLOCK_INVENTORY_BLOCK = new NoBlockInventoryBlock(AbstractBlock.Settings.copy(Blocks.STONE));
////        CommonPlatformHelperImpl.registerItem("no_block_inventory", () -> new BlockItem(NO_BLOCK_INVENTORY_BLOCK, new Item.Settings()));
////        CommonPlatformHelperImpl.registerBlock("no_block_inventory", () -> NO_BLOCK_INVENTORY_BLOCK);
//    }
//
//    private void setup(final FMLCommonSetupEvent event) {
//        event.enqueueWork(() -> {
//            REALLY_SIMPLE_SCREEN_HANDLER_TYPE = new ScreenHandlerType<>(ReallySimpleDescription::new);
//            Registry.register(SCREEN_HANDLER, new Identifier(MOD_ID, "really_simple"), REALLY_SIMPLE_SCREEN_HANDLER_TYPE);
//        });
//    }
//
//    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
//        Supplier<T> supplier = CommonPlatformHelperImpl.registerBlock(name, block);
//        CommonPlatformHelperImpl.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Settings().group(ItemGroup.MISC)));
//        return supplier;
//    }
//}
