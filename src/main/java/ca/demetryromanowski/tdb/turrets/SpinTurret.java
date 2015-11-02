package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class SpinTurret extends Turret {
    public SpinTurret(World world, int facing, int x, int y, int z) {
        super(world, facing, x, y, z, Material.GLASS);
    }
}
