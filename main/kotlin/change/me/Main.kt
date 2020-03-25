@file:Suppress("unused")

package change.me

import change.me.model.DatabaseModelInitializer
import change.me.util.command.CommandInitializer
import change.me.util.exposed.DatabaseInitializer
import hazae41.minecraft.kutils.bungee.BungeePlugin
import change.me.util.plugin.PluginConfig
import change.me.util.plugin.Instance
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
