package ca.demetryromanowski.tdb.turrets;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public class Turret {
    World world;
    int x, y, z;

    static final Material TOP = Material.DISPENSER;
    Material BOT = Material.ANVIL; //Default Material that will show

    private Block _top_block;
    private Block _bot_block;

    public Turret(Material mat){
        BOT = mat;
    }

    public Turret(World world, int facing, int x, int y, int z){
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;

        _top_block = world.getBlockAt(x, y + 1, z);
        _top_block.setType(TOP);
        _top_block.setData((byte)facing);
        _bot_block = world.getBlockAt(x, y, z);
        _bot_block.setType(BOT);
    }

    public Turret(World world, int facing, int x, int y, int z, Material BOT){
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;

        this.BOT = BOT;

        _top_block = world.getBlockAt(x, y + 1, z);
        _top_block.setType(TOP);
        _top_block.setData((byte)facing);
        _bot_block = world.getBlockAt(x, y, z);
        _bot_block.setType(BOT);
    }

    public Turret addTurret(World world, int facing, int x, int y, int z){
        Turret _ret = new Turret(world, facing, x, y, z);

        Block _top_block;
        Block _bot_block;

        _top_block = world.getBlockAt(x, y + 1, z);
        _top_block.setType(TOP);
        _top_block.setData((byte)facing);
        _bot_block = world.getBlockAt(x, y, z);
        _bot_block.setType(BOT);

        _ret.setBotBlock(_top_block);
        _ret.setBotBlock(_bot_block);

        return _ret;
    }

    public void removeTurret(){
        world.getBlockAt(x, y + 1, z).setType(Material.AIR);
        world.getBlockAt(x, y, z).setType(Material.AIR);
    }

    //TODO(Demetry return correct object):
    public ItemStack getSpawnBlock(){
        return null;
    }

    public Block getTopBlock(){
        return _top_block;
    }
    public Block getBotBlock(){
        return _bot_block;
    }

    public void setTopBlock(Block b){
        _top_block = b;
    }
    public void setBotBlock(Block b){
        _bot_block = b;
    }
}
