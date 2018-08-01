
package top.afrymask.spigotplugin;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;


import java.io.IOException;


/**
 * Sample block listener
 * @author Dinnerbone
 */
public class SampleBlockListener implements Listener {
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {




        Block block = event.getBlock();
        if (block.getType() == Material.REDSTONE_LAMP_OFF || block.getType() == Material.REDSTONE_LAMP_ON){
//            System.out.println("插件被卸载了");
        }

        if ((block.getType() == Material.SAND) || (block.getType() == Material.GRAVEL)) {
            Block above = block.getRelative(BlockFace.UP);
            if (above.getType() == Material.IRON_BLOCK) {
                event.setCancelled(true);
            }else if (above.getType() == Material.REDSTONE_LAMP_OFF){
                above.setType(Material.REDSTONE_LAMP_ON);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockRedstoneChange(BlockRedstoneEvent event){
//        event.setNewCurrent(event.getOldCurrent());
        Block block = event.getBlock();
        if (block.getBiome() == Biome.MESA){
            event.setNewCurrent(15);
        }


    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

//        Material mat = event.getMaterial();

//        if (mat.equals(Material.CACTUS)) {
//            event.setBuildable(true);
//        }
        Block block = event.getBlock();
        if (block.getType() == Material.REDSTONE_LAMP_OFF) {

//            event.setBuildable(false);
        }
        block.setType(Material.REDSTONE_LAMP_ON);
        block.setBiome(Biome.MESA);



    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();


        if (block.getType() == Material.REDSTONE_LAMP_OFF) {

            block.setBiome(Biome.MESA);
            event.setCancelled(true);
        }


    }


}
