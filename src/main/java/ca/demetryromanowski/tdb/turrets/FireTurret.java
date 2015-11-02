package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class FireTurret extends Turret {
    public FireTurret(World world, int facing, int x, int y, int z) {
        super(world, facing, x, y, z, Material.NETHERRACK);
    }
}
