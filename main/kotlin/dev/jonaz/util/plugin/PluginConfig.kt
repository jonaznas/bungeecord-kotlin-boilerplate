package dev.jonaz.util.plugin

import net.md_5.bungee.config.Configuration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.YamlConfiguration
import java.io.File
import java.io.IOException

class PluginConfig {
    private val plugin = Instance.plugin
    private val file = File(plugin.dataFolder.path, "config.yml")

    fun createIfNotExist(): File {
        val file = file
        try {
            if (!plugin.dataFolder.exists()) {
                plugin.dataFolder.mkdir()
            }
            if (!file.exists()) {
                file.createNewFile()
                val config = getConfig()
                // Do NOT type any sensitive data here! Use the created config.yml
                config.set("database.host", "127.0.0.1")
                config.set("database.port", "5432")
                config.set("database.user", "username")
                config.set("database.pass", "password")
                config.set("database.name", "database")
                save(config, file)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return file
    }

    fun getConfig(): Configuration = ConfigurationProvider.getProvider(YamlConfiguration::class.java).load(file)

    private fun save(config: Configuration, file: File) = ConfigurationProvider.getProvider(YamlConfiguration::class.java).save(config, file)
}
