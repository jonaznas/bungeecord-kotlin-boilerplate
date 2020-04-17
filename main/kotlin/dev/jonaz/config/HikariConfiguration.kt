package dev.jonaz.config

import dev.jonaz.util.exposed.DatabaseValidator
import dev.jonaz.util.plugin.PluginConfig
import com.zaxxer.hikari.HikariConfig
import net.md_5.bungee.config.Configuration

class HikariConfiguration {
    private val config = HikariConfig()
    private val pluginConfig: Configuration = PluginConfig().getConfig()

    private val dbHost: String? = pluginConfig.getString("database_host")
    private val dbPort: String? = pluginConfig.getString("database_port") ?: "5432"
    private val dbName: String? = pluginConfig.getString("database_name")
    private val dbUser: String? = pluginConfig.getString("database_user")
    private val dbPass: String? = pluginConfig.getString("database_pass")

    init {
        println(dbHost)

        DatabaseValidator(
            dbHost, dbName, dbUser, dbPass
        ).validateConfigValues()

        val url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
        Class.forName("org.postgresql.Driver")

        config.jdbcUrl = url
        config.username = dbUser
        config.password = dbPass
    }

    fun get(): HikariConfig = config
}
