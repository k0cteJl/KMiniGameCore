package ru.k0cteJl.kMiniGamesCore

import org.bukkit.inventory.ItemStack

object KItemStackBase {

    val items = mutableMapOf<String,ItemStack>()

    fun put(id: String, item: ItemStack){
        items[id] = item
    }

}