package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.BasicTurret;

public class BasicTurretSpawnBlock extends SpawnBlock{
    public BasicTurretSpawnBlock(){
        super(new BasicTurret(), BasicTurret.BOTTOM, "Basic Turret");
    }
}
