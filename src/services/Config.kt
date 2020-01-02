package plugin.services

import net.md_5.bungee.config.Configuration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.YamlConfiguration
import java.io.File
import java.io.IOException


class Config {
    private val plugin = Instance.plugin

    fun load() {
        create()
    }

    private fun save(config: Configuration, file: File) {
        ConfigurationProvider.getProvider(YamlConfiguration::class.java).save(config, file)
    }

    private fun create(): File {
        val file = File(plugin.dataFolder.path, "config.yml")
        try {
            if (!plugin.dataFolder.exists()) {
                plugin.dataFolder.mkdir()
            }
            if (!file.exists()) {
                file.createNewFile()
                val config = getConfig(file)
                config.set("database.host", "127.0.0.1")
                config.set("database.user", "root")
                config.set("database.pass", "mypassword")
                config.set("database.name", "databasename")
                save(config, file)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return file
    }

    private fun getConfig(file: File): Configuration {
        return ConfigurationProvider.getProvider(YamlConfiguration::class.java).load(file)
    }
}
