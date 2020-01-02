package plugin

import hazae41.minecraft.kutils.bungee.BungeePlugin
import plugin.services.Config

import plugin.services.Instance

class Main : BungeePlugin() {
    override fun onLoad() {
        Instance(this)
        Config().load()
        Commands().register()
    }
}
