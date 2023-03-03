package io.github.cottonmc.cotton.gui.impl;

import juuxel.libninepatch.NinePatch;
import kenza.Ref;

import net.fabricmc.api.ModInitializer;

import org.joml.Matrix4f;

public final class LibGuiCommon {
	public static final String MOD_ID = Ref.MOD_ID;

	public static void onInitialize() {
		ScreenNetworkingImpl.init();

		NinePatch.class.arrayType();
		Matrix4f.class.arrayType();

	}
}
