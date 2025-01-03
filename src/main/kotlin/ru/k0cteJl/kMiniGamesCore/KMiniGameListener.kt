package ru.k0cteJl.kMiniGamesCore

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryInteractEvent
import org.bukkit.event.player.PlayerInteractEvent

class KMiniGameListener: Listener {

    @EventHandler
    private fun playerInteraction(e: PlayerInteractEvent){
        e.isCancelled = !KMiniGames.allowInteractions
    }

    @EventHandler
    private fun playerInventoryInteraction(e: InventoryInteractEvent){
        e.isCancelled = !KMiniGames.allowInteractions
    }

}