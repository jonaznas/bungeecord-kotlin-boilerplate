@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.controller

import dev.jonaz.util.command.CommandMapping
import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.msg

// Example name
class NormalCommands {

    @CommandMapping("bungeeabc")
    fun bungeeAbcCommand(sender: BungeeSender, args: Array<String>) {
        sender.msg("Abc command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }
}
