package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class AdvancedFireTurret extends Turret {
    public AdvancedFireTurret(World world, int facing, int x, int y, int z) {
        super(world, facing, x, y, z, Material.NETHER_BRICK);
    }
}
