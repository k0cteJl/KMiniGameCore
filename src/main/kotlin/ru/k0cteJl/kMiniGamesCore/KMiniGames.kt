package ru.k0cteJl.kMiniGamesCore

import org.bukkit.plugin.java.JavaPlugin

object KMiniGames {

    private val plugins = mutableListOf<JavaPlugin>()

    var allowInteractions = true

    fun connect(plugin: JavaPlugin){
        plugins.add(plugin)
    }

}