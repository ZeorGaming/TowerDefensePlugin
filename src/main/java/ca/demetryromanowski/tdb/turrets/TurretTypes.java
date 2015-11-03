package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;

public enum TurretTypes {
    BASIC_TURRET (new Turret(Material.WOOD)),
    AIMED_TURRET (new Turret(Material.IRON_BLOCK)),
    ADVANCED_AIMED_TURRET (new Turret(Material.LAPIS_BLOCK)),
    SPIN_TURRET (new Turret(Material.GLASS)),
    FIRE_TURRET (new Turret(Material.NETHERRACK)),
    ADVANCED_FIRE_TURRET (new Turret(Material.NETHER_BRICK)),
    COW_CANNON (new Turret(Material.GLOWSTONE));

    private Turret turret;

    TurretTypes(Turret turret){
        this.turret = turret;
    }
}
