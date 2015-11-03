package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.AimedTurret;

public class AimedTurretSpawnBlock extends SpawnBlock{
    public AimedTurretSpawnBlock(){
        super(new AimedTurret(), AimedTurret.BOTTOM, "Aimed Turret");
    }
}