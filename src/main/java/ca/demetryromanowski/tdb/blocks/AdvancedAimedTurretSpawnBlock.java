package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.AdvancedAimedTurret;

public class AdvancedAimedTurretSpawnBlock extends SpawnBlock{
    public AdvancedAimedTurretSpawnBlock(){
        super(new AdvancedAimedTurret(), AdvancedAimedTurret.BOTTOM, "Rotary Aimed Turret");
    }
}
