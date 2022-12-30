package io.github.cottonmc.cotton.gui.impl;

import kenza.Ref;
import net.fabricmc.api.ModInitializer;

public final class LibGuiCommon  {
	public static final String MOD_ID = Ref.MOD_ID;
	public static void onInitialize() {
		ScreenNetworkingImpl.init();
	}
}
