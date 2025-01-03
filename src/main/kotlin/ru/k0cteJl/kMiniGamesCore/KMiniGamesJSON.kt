package ru.k0cteJl.kMiniGamesCore

import com.google.gson.Gson
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

object KMiniGamesJSON {

    private val gson = Gson()

    //name - Name of JSON file
    //dataType - Type of return value
    fun getJSON(plugin: JavaPlugin, name: String, dataType: Any): Any? {
        val file = File(plugin.dataFolder, name)
        if(file.exists()){
            return gson.fromJson(file.readText(), dataType::class.java)
        }
        return null
    }

    // saveData - Any data for save
    fun saveToJSON(plugin: JavaPlugin, name: String, saveData: Any){
        val json = gson.toJson(saveData)
        val file = File(plugin.dataFolder, name).writeText(json)
    }

}