package net.examplemod.kenza

import dev.architectury.networking.NetworkManager
import net.minecraft.network.PacketByteBuf
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier
import java.lang.ref.WeakReference
import java.util.WeakHashMap

internal interface KPacketSender {

    fun sendPacket(identifier: Identifier, buf: PacketByteBuf)


}

internal class KServerPacketSender(val player: WeakReference<ServerPlayerEntity>) : KPacketSender {

    companion object {
        val map = WeakHashMap<ServerPlayerEntity,KServerPacketSender >()

        @JvmStatic
        fun pool(player: ServerPlayerEntity): KPacketSender {
            return  map[player] ?: KServerPacketSender(WeakReference(player)).apply {
                map[player] = this
            }
        }
    }

    override fun sendPacket(identifier: Identifier, buf: PacketByteBuf) {
        player.get()?.let {
            NetworkManager.sendToPlayer(it, identifier, buf);
        }
    }
}

internal class KPlayerPacketSender : KPacketSender {

    companion object {
        @JvmStatic
        val sender = KPlayerPacketSender()
    }

    override fun sendPacket(identifier: Identifier, buf: PacketByteBuf) {
        NetworkManager.sendToServer(identifier, buf);
    }
}