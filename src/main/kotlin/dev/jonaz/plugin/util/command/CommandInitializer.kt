package dev.jonaz.plugin.util.command

import dev.jonaz.plugin.Main
import hazae41.minecraft.kutils.bungee.command
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import dev.jonaz.plugin.util.plugin.Instance
import hazae41.minecraft.kutils.bungee.BungeeSender
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.reflect.Method

class CommandInitializer {

    fun defineCommands() {
        val commands: MutableMap<String, MutableMap<String, Method>> = mutableMapOf()
        val reflections = Reflections(Main::class.java, MethodAnnotationsScanner())
        val annotated = reflections.getMethodsAnnotatedWith(CommandMapping::class.java)

        for (method in annotated) {
            val cmd = method.getAnnotation(CommandMapping::class.java).cmd
            val sub = method.getAnnotation(CommandMapping::class.java).sub

            when (commands[cmd]) {
                null -> commands[cmd] = mutableMapOf(sub to method)
                else -> commands[cmd]?.set(sub, method)
            }
        }

        commands.forEach { (t, u) ->
            Instance.plugin.command(t) { sender, args ->
                val subCommand = when (args.size) {
                    in Int.MIN_VALUE..0 -> ""
                    else -> args[0]
                }

                val method = when (u.containsKey(subCommand)) {
                    true -> u[subCommand] as Method
                    else -> u[""]
                }

                val instance = method?.declaringClass?.getDeclaredConstructor()?.newInstance()
                executeCommand(method, instance, sender, args)
            }
        }
    }

    private fun executeCommand(
        method: Method?,
        instance: Any?,
        sender: BungeeSender,
        args: Array<String>
    ) = GlobalScope.launch {
        method?.invoke(instance, sender, args)
    }
}
