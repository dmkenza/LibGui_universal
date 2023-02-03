# LibGui_universal
Forge port of Cotton's Fabric LibGui

# For developers

Place jar from releases into libs folder for Forge.

add
modImplementation fileTree(dir: 'libs', include: ['*.jar'])

into gradle file.

You have to call also

LibGuiCommon.onInitialize() in your mod init.

LibGuiClient.onInitialize() in client init

The library requires Koltin.

For fabric and common modules you can just use CottonMC's version from maven.
