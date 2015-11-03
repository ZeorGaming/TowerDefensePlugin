package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.AdvancedFireTurret;

public class AdvancedFireTurretSpawnBlock extends SpawnBlock{
    public AdvancedFireTurretSpawnBlock(){
        super(new AdvancedFireTurret(), AdvancedFireTurret.BOTTOM, "Advanced Fire Turret");
    }
}
