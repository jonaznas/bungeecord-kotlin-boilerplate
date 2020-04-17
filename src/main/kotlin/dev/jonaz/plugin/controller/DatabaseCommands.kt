@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.plugin.controller

import dev.jonaz.plugin.component.user.NewUser
import dev.jonaz.plugin.util.command.CommandMapping
import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.msg

// Example name
class DatabaseCommands {

    @CommandMapping("bungeetest")
    fun bungeeTestCommand(sender: BungeeSender, args: Array<String>) {
        val newUser = NewUser(sender.name)
        val insertId = newUser.insertByName()
        sender.msg("Your insert id is $insertId")
    }
}
