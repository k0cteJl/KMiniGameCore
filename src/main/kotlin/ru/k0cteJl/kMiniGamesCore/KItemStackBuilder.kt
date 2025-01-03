package ru.k0cteJl.kMiniGamesCore

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class KItemStackBuilder(
    private val material: Material,
    private val amount: Int,
    private val name: String?,
    private val model: Int?,
    private val lore: List<String>?
)
{

    fun build(): ItemStack{
        val item = ItemStack(material, amount)
        val meta = item.itemMeta
        name?.let { meta.itemName(Component.text(name)) }
        lore?.let {
            val componentLore = mutableListOf<Component>()
            for(i in lore){
                componentLore.add(Component.text(i))
            }
            item.lore(componentLore)
        }
        meta.setCustomModelData(model)
        item.setItemMeta(meta)
        return item
    }

}