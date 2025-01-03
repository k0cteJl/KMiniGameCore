package ru.k0cteJl.kMiniGamesCore.events

import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import ru.k0cteJl.kMiniGamesCore.KMGGameQueue

class KQueueTimerStartedEvent(queue: KMGGameQueue): Event() {

    override fun getHandlers(): HandlerList {
        return HandlerList()
    }

}