package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;

@SuppressWarnings("deprecation")
public class BasicTurret implements ITurret {
    static Material TOP = Material.DISPENSER;
    static Material BOT = Material.WOOD;

    public void addTurret(World world, int facing, int x, int y, int z){
        world.getBlockAt(x, y + 1, z).setType(TOP);
        world.getBlockAt(x, y + 1, z).setData((byte)facing);
        world.getBlockAt(x, y, z).setType(BOT);
    }
}
