package io.github.cottonmc.fabric;

import io.github.cottonmc.cotton.gui.impl.LibGuiCommon;
import io.github.cottonmc.cotton.gui.impl.client.LibGuiClient;
import net.fabricmc.api.ModInitializer;

public class LibGuiFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        LibGuiCommon.onInitialize();
//        LibGuiClient.onInitializeClient();
    }
}
