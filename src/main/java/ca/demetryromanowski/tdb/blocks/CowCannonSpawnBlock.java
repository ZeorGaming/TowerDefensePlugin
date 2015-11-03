package ca.demetryromanowski.tdb.blocks;

import ca.demetryromanowski.tdb.turrets.CowCannon;

public class CowCannonSpawnBlock extends SpawnBlock{
    public CowCannonSpawnBlock(){
        super(new CowCannon(), CowCannon.BOTTOM, "Cow Cannon");
    }
}
