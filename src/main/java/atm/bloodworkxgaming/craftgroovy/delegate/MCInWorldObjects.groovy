package atm.bloodworkxgaming.craftgroovy.delegate

import atm.bloodworkxgaming.craftgroovy.wrappers.PBlock
import atm.bloodworkxgaming.craftgroovy.wrappers.PBlockState
import atm.bloodworkxgaming.craftgroovy.wrappers.PItem
import atm.bloodworkxgaming.craftgroovy.wrappers.PItemStack
import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember
import net.minecraft.item.Item

trait MCInWorldObjects {
    /**
     * Gets the Item from the given name
     */
    @GSLWhitelistMember
    static PItem item(String name) {
        return new PItem(Item.getByNameOrId(name))
    }

    /**
     * Makes a ItemStack from the given name
     * @param name item to used
     * @param meta meta of item
     * @param count amount of the stack
     * @return the stack
     */
    @GSLWhitelistMember
    static PItemStack itemStack(String name, int meta = 0, int count = 1) {
        def item = new PItemStack(name, meta)
        item.count = count
        return item
    }

    /**
     * Makes a ItemStack from the given Item
     * @param Item to make the stack from
     * @param meta meta of item
     * @param count amount of the stack
     * @return the stack
     */
    @GSLWhitelistMember
    static PItemStack itemStack(PItem item, int meta = 0, int count = 1) {
        def itemStack = new PItemStack(item.internal, meta)
        itemStack.count = count
        return itemStack
    }

    /**
     * Gets the block with the given name
     * @param name name of the block
     * @return the Block
     */
    @GSLWhitelistMember
    static PBlock block(String name) {
        return PBlock.getBlockFromName(name)
    }

    /**
     * Creates a blockstate which can be 'placed' in the world
     * @param name name of the block
     * @param meta meta of the state
     * @return the BlockState
     */
    @GSLWhitelistMember
    static PBlockState blockState(String name, int meta = 0) {
        return PBlock.getBlockFromName(name).getStateFromMeta(meta)
    }

    /**
     * Creates a blockstate which can be 'placed' in the world
     * @param block the block
     * @param meta meta of the state
     * @return the BlockState
     */
    @GSLWhitelistMember
    static PBlockState blockState(PBlock block, int meta = 0) {
        return block.getStateFromMeta(meta)
    }
}