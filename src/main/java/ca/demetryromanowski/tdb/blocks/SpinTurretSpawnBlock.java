package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.SpinTurret;

public class SpinTurretSpawnBlock extends SpawnBlock{
    public SpinTurretSpawnBlock(){
        super(new SpinTurret(), SpinTurret.BOTTOM, "Spin Turret");
    }
}
