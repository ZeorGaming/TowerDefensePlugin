package ca.demetryromanowski.tdb.turrets;

import org.bukkit.World;

public interface ITurret {
    void addTurret(World world, int facing, int x, int y, int z);
}
