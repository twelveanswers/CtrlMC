package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.Event.Event;
import escapemc.Event.events.EventPreMotion;
import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class Killaura extends Module {

	public Killaura() {

		super("Killaura", Keyboard.KEY_K, Category.COMBAT);
	
	}

	public static int Range = (int) 50;
	
	public Entity ClosestEntity() {
		Entity closest = null;
		for(Object o : mc.theWorld.loadedEntityList) {			
			Entity e = (Entity) o;
			if((! (o instanceof EntityPlayerSP) &&o instanceof EntityLivingBase && (!e.isDead) && e.getEntityId()< 1000000000 && mc.thePlayer.canEntityBeSeen(e))) {				
				if((!e.getName().equals(mc.thePlayer.getName())) && (closest == null) || mc.thePlayer.getDistanceToEntity(e) < mc.thePlayer.getDistanceToEntity(closest)) {					
					closest = e;
					
				}
				
			}
			
		}
			return closest;
		
	}
	
	public Entity entity;
	public void Tick() {
		entity = ClosestEntity();
		if(entity != null) {						
				if(entity.getDistanceToEntity(mc.thePlayer) <= Range) {				
					if(mc.thePlayer.getCooledAttackStrength(0.0F) >= 1.0F) {
						if(ModuleManager.criticals.isToggled()) {							
							ModuleManager.criticals.doCrits();							
						}						
						mc.thePlayer.swingArm(EnumHand.MAIN_HAND);				
						mc.playerController.attackEntity(mc.thePlayer, entity);;
				}
			
			}
		
		}
	
	}

	public void Event(Event e) {
		if(e instanceof EventPreMotion) {
			if(entity != null) {
				if(entity.getDistanceToEntity(mc.thePlayer) <= Range) {
					((EventPreMotion) e).rotationYaw = getYaw(entity);
					((EventPreMotion) e).rotationPitch = getPitch(entity);
			
				}
					
			}
		
		}
	
	}
	
	  public static float getYaw(Entity e)
	  {
	    double x = e.posX - Minecraft.getMinecraft().thePlayer.posX;
	    double z = e.posZ - Minecraft.getMinecraft().thePlayer.posZ;
	    
	    float yaw = (float)(Math.atan2(z, x) * 180.0D / 3.141592653589793D) - 90.0F;
	    if (yaw < 0.0F) {
	      yaw += 360.0F;
	    }
	    return yaw;
	  }
	  
	  public static float getPitch(Entity e)
	  {
	    double x = e.posX - Minecraft.getMinecraft().thePlayer.posX;
	    double z = e.posZ - Minecraft.getMinecraft().thePlayer.posZ;
	    
	    double d1 = Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight() - (
	      e.posY + e.getEyeHeight());
	    double d3 = MathHelper.sqrt_double(x * x + z * z);
	    float f1 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
	    
	    return -f1;
	  }
	
	
}