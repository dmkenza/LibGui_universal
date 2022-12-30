//package net.examplemod.forge;
//
//import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
//import io.github.cottonmc.cotton.gui.widget.WGridPanel;
//import net.minecraft.entity.player.PlayerInventory;
//
//import static net.examplemod.forge.ExampleModForge.REALLY_SIMPLE_SCREEN_HANDLER_TYPE;
//
//// A really simple GUI description that only contains a player inventory panel.
//public class ReallySimpleDescription extends SyncedGuiDescription {
//	public ReallySimpleDescription(int syncId, PlayerInventory playerInventory) {
//		super(REALLY_SIMPLE_SCREEN_HANDLER_TYPE, syncId, playerInventory);
//		setTitleVisible(true);
//		((WGridPanel) getRootPanel()).add(createPlayerInventoryPanel(), 0, 0);
//		getRootPanel().validate(this);
//	}
//}
