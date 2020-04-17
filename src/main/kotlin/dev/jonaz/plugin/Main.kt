@file:Suppress("unused")

package dev.jonaz.plugin

import dev.jonaz.plugin.model.DatabaseModelInitializer
import dev.jonaz.plugin.util.command.CommandInitializer
import dev.jonaz.plugin.util.exposed.DatabaseInitializer
import dev.jonaz.plugin.util.plugin.PluginConfig
import dev.jonaz.plugin.util.plugin.Instance
import hazae41.minecraft.kutils.bungee.BungeePlugin
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
        cmdInitializer.defineCommands()
        info("Plugin enabled")
    }
}
