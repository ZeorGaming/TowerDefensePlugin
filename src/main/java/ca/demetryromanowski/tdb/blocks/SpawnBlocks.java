package ca.demetryromanowski.tdb.blocks;

import org.bukkit.inventory.ItemStack;

public enum SpawnBlocks {
    BASIC_TURRET_SPAWN_BLOCK (new BasicTurretSpawnBlock()),
    AIMED_TURRET_SPAWN_BLOCK (new AimedTurretSpawnBlock()),
    ADVANCED_AIMED_TURRET_SPAWN_BLOCK (new AdvancedAimedTurretSpawnBlock()),
    SPIN_TURRET_SPAWN_BLOCK (new SpinTurretSpawnBlock()),
    FIRE_TURRET_SPAWN_BLOCK (new FireTurretSpawnBlock()),
    ADVANCED_FIRE_TURRET_SPAWN_BLOCK (new AdvancedFireTurretSpawnBlock()),
    COW_CANNON_SPAWN_BLOCK (new CowCannonSpawnBlock());

    private ItemStack value;

    SpawnBlocks(SpawnBlock value){
        this.value = value.getBlock();
    }

    public ItemStack getItem(){
        return value;
    }
}