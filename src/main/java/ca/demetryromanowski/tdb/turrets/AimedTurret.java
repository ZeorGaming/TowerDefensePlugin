package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class AimedTurret extends Turret {
    public AimedTurret(World world, int facing, int x, int y, int z) {
        super(world, facing, x, y, z, Material.IRON_BLOCK);
    }
}
