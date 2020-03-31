@file:Suppress("unused")

package dev.jonaz

import dev.jonaz.model.DatabaseModelInitializer
import dev.jonaz.util.command.CommandInitializer
import dev.jonaz.util.exposed.DatabaseInitializer
import hazae41.minecraft.kutils.bungee.BungeePlugin
import dev.jonaz.util.plugin.PluginConfig
import dev.jonaz.util.plugin.Instance
import hazae41.minecraft.kutils.bungee.info

class Main : BungeePlugin() {
    private val instance = Instance(this)
    private val config = PluginConfig()
    private val database = DatabaseInitializer()
    private val databaseModel = DatabaseModelInitializer()
    private val cmdInitializer = CommandInitializer()

    override fun onLoad() {
        database.connect()
        databaseModel.createSchema()
        config.createIfNotExist()
        cmdInitializer.defineCommands()
        info("Plugin enabled")
    }
}
