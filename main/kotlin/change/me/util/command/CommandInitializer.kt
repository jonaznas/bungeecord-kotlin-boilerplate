package change.me.util.command

import change.me.controller.Commands
import hazae41.minecraft.kutils.bungee.command
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import change.me.util.plugin.Instance
import hazae41.minecraft.kutils.bungee.BungeeSender
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.reflect.Method

class CommandInitializer {

    fun defineCommands() {
        val reflections = Reflections(Commands::class.java, MethodAnnotationsScanner())
        val annotated = reflections.getMethodsAnnotatedWith(CommandMapping::class.java)

        for (method in annotated) {
            val instance = method.declaringClass.getDeclaredConstructor().newInstance()
            val cmd = method.getAnnotation(CommandMapping::class.java).cmd

            Instance.plugin.command(cmd) { sender, args ->
                executeCommand(method, instance, sender, args)
            }
        }
    }

    private fun executeCommand(
        method: Method,
        instance: Any,
        sender: BungeeSender,
        args: Array<String>
    ) = GlobalScope.launch {
        method.invoke(instance, sender, args)
    }
}
