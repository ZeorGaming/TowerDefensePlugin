package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

public class AimedTurret implements ITurret{
    static Material TOP = Material.DISPENSER;
    static Material BOT = Material.IRON_BLOCK;

    @Override
    public void addTurret(World world, int facing, int x, int y, int z) {
        world.getBlockAt(x, y+1, z).setType(TOP);
        world.getBlockAt(x, y+1, z).setData((byte)facing);
        world.getBlockAt(x, y, z).setType(BOT);
    }
}
