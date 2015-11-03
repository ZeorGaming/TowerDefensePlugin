package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.Turret;
import org.bukkit.inventory.ItemStack;

public enum SpawnBlocks {
    BASIC_TURRET_SPAWN_BLOCK (new BasicTurretSpawnBlock()),
    AIMED_TURRET_SPAWN_BLOCK (new AimedTurretSpawnBlock()),
    ADVANCED_AIMED_TURRET_SPAWN_BLOCK (new AdvancedAimedTurretSpawnBlock()),
    SPIN_TURRET_SPAWN_BLOCK (new SpinTurretSpawnBlock()),
    FIRE_TURRET_SPAWN_BLOCK (new FireTurretSpawnBlock()),
    ADVANCED_FIRE_TURRET_SPAWN_BLOCK (new AdvancedFireTurretSpawnBlock()),
    COW_CANNON_SPAWN_BLOCK (new CowCannonSpawnBlock());

    private ItemStack item;
    private Turret turret;

    SpawnBlocks(SpawnBlock spawnBlock){
        this.item = spawnBlock.getBlock();
        this.turret = spawnBlock.getType();
    }

    public ItemStack getItem(){
        return item;
    }
    public Turret getTurret(){
        return turret;
    }
}