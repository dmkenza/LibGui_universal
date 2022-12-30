//package net.examplemod.forge;
//
//import io.github.cottonmc.cotton.gui.client.CottonHud;
//import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
//import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
//import io.github.cottonmc.cotton.gui.widget.WLabel;
//import net.minecraft.client.gui.screen.ingame.HandledScreens;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//
//import static net.examplemod.ExampleMod.MOD_ID;
//import static net.examplemod.forge.ExampleModForge.REALLY_SIMPLE_SCREEN_HANDLER_TYPE;
//import static net.minecraft.util.registry.Registry.SCREEN_HANDLER;
//
//@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class ExampleForgeClient {
//    @SubscribeEvent
//    public static void init(FMLClientSetupEvent event) {
//
//        LibGuiClient.onInitializeClient();
//
////        CottonHud.add(new WHudTest(), 10, -20, 10, 10);
////        CottonHud.add(new WLabel(Text.literal("Test label")), 10, -30, 10, 10);
////
////        HandledScreens.<ReallySimpleDescription, CottonInventoryScreen<ReallySimpleDescription>>register(
////                REALLY_SIMPLE_SCREEN_HANDLER_TYPE,
////                CottonInventoryScreen::new
////        );
////        Registry.register(SCREEN_HANDLER, new Identifier(MOD_ID, "really_simple"), REALLY_SIMPLE_SCREEN_HANDLER_TYPE);
////        ScreenRegistry.register(ClickMachine.GUI_SCREEN_HANDLER_TYPE) { controller, inv, _ -> IRInventoryScreen(controller, inv.player) }
//    }
//
////    @SubscribeEvent
////    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
////        event.registerLayerDefinition(ZebraRenderer.LAYER_LOCATION, ZebraModel::createBodyLayer);
////    }
//}
