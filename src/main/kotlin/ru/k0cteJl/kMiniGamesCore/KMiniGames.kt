package ru.k0cteJl.kMiniGamesCore

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

object KMiniGames {

    private val plugins = mutableListOf<JavaPlugin>()

    var allowInteractions = true

    fun connect(plugin: JavaPlugin){
        plugins.add(plugin)
    }

    fun enableQueues(){
        object : BukkitRunnable() {
            override fun run() {
                KMiniGameQueue.queuesTimeStep(1.0)
            }
        }.runTaskTimer(KMiniGamesCore.instance, 20L, 20L)
    }

}