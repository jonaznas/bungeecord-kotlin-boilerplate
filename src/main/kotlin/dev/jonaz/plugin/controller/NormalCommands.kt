@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.plugin.controller

import dev.jonaz.plugin.util.command.CommandMapping
import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.msg

// Example name
class NormalCommands {

    @CommandMapping("abc")
    fun bungeeAbcCommand(sender: BungeeSender, args: Array<String>) {
        sender.msg("yep thats a non-subcommand command")
        args.forEach { s: String ->
            sender.msg(s)
        }
    }

    @CommandMapping("abc", "test")
    fun bungeeAbcTestCommand(sender: BungeeSender, args: Array<String>) {
        sender.msg("Abc test sub-command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }

    @CommandMapping("abc", "yes", permission = "plugin.test")
    fun bungeeAbcYesCommand(sender: BungeeSender, args: Array<String>) {
        sender.msg("the second sub-command")
    }
}
