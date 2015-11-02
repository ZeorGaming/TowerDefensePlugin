package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.Turret;
import org.bukkit.Material;

public class BasicTurretSpawnBlock extends SpawnBlock{
    public BasicTurretSpawnBlock(){
        super(Material.WOOD, "Basic Turret");
    }

    public Turret getTurret(){
        return turret;
    }
}
