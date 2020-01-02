package plugin.services

import hazae41.minecraft.kutils.bungee.BungeePlugin

class Instance(javaPlugin: BungeePlugin) {
    companion object {
        lateinit var plugin: BungeePlugin
    }

    init {
        plugin = javaPlugin
    }
}
