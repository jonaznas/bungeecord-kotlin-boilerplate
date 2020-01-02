package plugin

import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.command
import hazae41.minecraft.kutils.bungee.msg
import plugin.commands.Abc
import plugin.services.Instance

class Commands {
    private val plugin = Instance.plugin

    fun register() {
        plugin.command("bungeeabc") { sender: BungeeSender, args: Array<String> -> Abc(sender, args) }
    }
}
