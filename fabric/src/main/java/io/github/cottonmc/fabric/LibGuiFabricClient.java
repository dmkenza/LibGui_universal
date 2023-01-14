package io.github.cottonmc.fabric;

import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
import net.fabricmc.api.ClientModInitializer;

import static kenza.Ref.MOD_ID;

//
public class LibGuiFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LibGuiClient.onInitialize();
    }
}


