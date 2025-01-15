package ru.k0cteJl.kMiniGamesCore

import org.bukkit.plugin.java.JavaPlugin

class KMiniGamesCore : JavaPlugin(){

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(KMiniGameListener(), this)
    }

    companion object{
        lateinit var instance: KMiniGamesCore
            private set
    }

}