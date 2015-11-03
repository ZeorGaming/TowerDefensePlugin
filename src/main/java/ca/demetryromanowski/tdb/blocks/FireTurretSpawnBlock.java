package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.FireTurret;

public class FireTurretSpawnBlock extends SpawnBlock{
    public FireTurretSpawnBlock(){
        super(new FireTurret(), FireTurret.BOTTOM, "Spin Turret");
    }
}
