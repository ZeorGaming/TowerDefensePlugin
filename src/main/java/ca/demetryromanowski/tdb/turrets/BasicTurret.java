package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class BasicTurret extends Turret{
    public BasicTurret(World world, int face, int x, int y, int z) {
        super(world, face, x, y, z, Material.WOOD);
    }
}
