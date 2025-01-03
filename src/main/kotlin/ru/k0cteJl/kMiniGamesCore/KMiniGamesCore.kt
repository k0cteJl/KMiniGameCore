package ru.k0cteJl.kMiniGamesCore

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class KMiniGamesCore : JavaPlugin(){

    override fun onEnable() {
        instance = this

        object : BukkitRunnable() {
            override fun run() {
                KMiniGameQueue.queuesTimeStep(1.0)
            }
        }.runTaskTimer(this, 20L, 20L)

        server.pluginManager.registerEvents(KMiniGameListener(), this)
    }

    companion object{
        lateinit var instance: KMiniGamesCore
            private set
    }

}