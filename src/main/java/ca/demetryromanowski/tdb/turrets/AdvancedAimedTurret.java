package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

@SuppressWarnings("deprecation")
public class AdvancedAimedTurret extends Turret {
    public AdvancedAimedTurret(World world, int facing, int x, int y, int z) {
        super(world, facing, x, y, z, Material.LAPIS_BLOCK);
    }
}
