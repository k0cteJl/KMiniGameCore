package ru.k0cteJl.kMiniGamesCore

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import ru.k0cteJl.kMiniGamesCore.events.KQueueTimerEndedEvent
import ru.k0cteJl.kMiniGamesCore.events.KQueueTimeStepEvent
import ru.k0cteJl.kMiniGamesCore.events.KQueueTimerStartedEvent

enum class KMGGameQueueStatus {
    WAITING_PLAYERS,
    TIMER,
    ENDED
}

data class KMGGameQueue (
    val minPlayersCount: Int,
    val time: Double,
    var timePass: Double,
    val players: MutableList<Player> = mutableListOf(),
    var status: KMGGameQueueStatus = KMGGameQueueStatus.WAITING_PLAYERS
)

object KMiniGameQueue {

    private val queues = mutableMapOf<String,  KMGGameQueue>()

    fun create(uniqueId: String, minPlayersCount: Int, time: Double): KMGGameQueue {
        val queue = KMGGameQueue(minPlayersCount, time, 0.0)
        queues[uniqueId] = queue
        return queue
    }

    fun addPlayerToQueue(queueId: String, player: Player){
        if(queueId in queues.keys){
            val queue = queues[queueId]!!
            queue.players.addLast(player)
            if(queue.players.size >= queue.minPlayersCount){
                queue.status = KMGGameQueueStatus.TIMER
                Bukkit.getPluginManager().callEvent(KQueueTimerStartedEvent(queue))
            }
        }
    }

    fun queueTimeStep(queueId: String, value: Double){
        if(queueId in queues.keys){
            val queue = queues[queueId]!!
            queue.timePass += value
            Bukkit.getPluginManager().callEvent(KQueueTimeStepEvent(queue))
            if(queue.time >= queue.timePass && queue.status != KMGGameQueueStatus.ENDED){
                queue.status = KMGGameQueueStatus.ENDED
                Bukkit.getPluginManager().callEvent(KQueueTimerEndedEvent(queue))
            }
        }
    }

    fun queuesTimeStep(value: Double, ignoreStatus: Boolean = false){
        for(queueId in queues.keys){
            if(!ignoreStatus && queues[queueId]!!.status != KMGGameQueueStatus.TIMER) continue
            queueTimeStep(queueId, value)
        }
    }

}