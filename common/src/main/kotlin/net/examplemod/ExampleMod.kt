//package net.examplemod
//
//import com.google.common.base.Suppliers
//import dev.architectury.registry.registries.Registrar
//import dev.architectury.registry.registries.Registries
//import net.minecraft.item.Item
//import net.minecraft.util.registry.Registry
//import java.util.function.Supplier
//
//object ExampleMod {
//    const val MOD_ID = "examplemod"
//
//    // We can use this if we don't want to use DeferredRegister
//
//    val REGISTRIES: Supplier<Registries> = Suppliers.memoize {
//        Registries.get(MOD_ID)
//    }
//
//    @JvmStatic
//    fun init() {
//
//        Registries.get(MOD_ID)
//
//        val items: Registrar<Item> = REGISTRIES.get().get(Registry.ITEM_KEY)
//
//
////        val REGISTRIES: Supplier<Registries> = Suppliers.memoize { get(MOD_ID) }
//
////        val EXAMPLE_TAB =
////            CreativeTabRegistry.create(ResourceLocation(MOD_ID, "example_tab")) {
////                ItemStack(EXAMPLE_ITEM.get())
////            }
////
////        val ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY)
////        val EXAMPLE_ITEM = ITEMS.register("example_item") { Item(Item.Properties().tab(ExampleMod.EXAMPLE_TAB)) }
//
//
////        ITEMS.register()
//
//
//
//        println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString())
//    }
//}