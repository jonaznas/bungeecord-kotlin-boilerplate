@file:Suppress("unused", "UNUSED_PARAMETER")

package change.me.controller

import change.me.component.user.NewUser
import change.me.util.command.CommandMapping
import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.msg

class Commands {

    @CommandMapping("bungeeabc")
    fun bungeeAbcCommand(sender: BungeeSender, args: Array<String>) {
        sender.msg("Abc command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }

    @CommandMapping("bungeetest")
    fun bungeeTestCommand(sender: BungeeSender, args: Array<String>) {
        val newUser = NewUser(sender.name)
        val insertId = newUser.insertByName()
        sender.msg("Your insert id is $insertId")
    }
}
