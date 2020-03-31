@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.controller

import dev.jonaz.component.user.NewUser
import dev.jonaz.util.command.CommandMapping
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
