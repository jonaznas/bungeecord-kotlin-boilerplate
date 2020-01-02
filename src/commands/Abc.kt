package plugin.commands

import hazae41.minecraft.kutils.bungee.BungeeSender
import hazae41.minecraft.kutils.bungee.msg
import plugin.services.Mysql

object Abc {
    operator fun invoke(sender: BungeeSender, args: Array<String>) {
        val mysql = Mysql()
        mysql.query("select * from mytable where id = ? limit 1", listOf(10))
        { result ->
            result.next()
            /** Get column by name **/
            // result.getString("columnname")

            /** Get last insert id **/
            // result.getInt(1).toString()
        }

        sender.msg("&bThis is the test command")
    }
}
