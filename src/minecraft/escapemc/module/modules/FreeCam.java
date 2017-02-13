package escapemc.module.modules;

import escapemc.Event.Event;
import escapemc.Event.events.EventSendPacket;
import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class FreeCam extends Module {

	public FreeCam() {
	
		super("FreeCam", 0, Category.Player);

	}

	private EntityOtherPlayerMP fakePlayer = null;
	private double oldX;
	private double oldY;
	private double oldZ;
	
	@Override
	public void onEnable()
	{
		oldX = mc.thePlayer.posX;
		oldY = mc.thePlayer.posY;
		oldZ = mc.thePlayer.posZ;
		fakePlayer = new EntityOtherPlayerMP(mc.theWorld, mc.thePlayer.getGameProfile());
		fakePlayer.clonePlayer(mc.thePlayer, true);
		fakePlayer.copyLocationAndAnglesFrom(mc.thePlayer);
		fakePlayer.rotationYawHead = mc.thePlayer.rotationYawHead;
		mc.theWorld.addEntityToWorld(-69, fakePlayer);
	}
	
	@Override
	public void Tick()
	{
		mc.thePlayer.capabilities.isFlying = true;
		if(mc.gameSettings.keyBindJump.pressed) {
			mc.thePlayer.motionY = 0.5F;	
		}else if(mc.gameSettings.keyBindSneak.pressed) {
			mc.thePlayer.motionY = -0.5F;
		}else{
			mc.thePlayer.motionY = 0F;
		}
		if(!mc.gameSettings.keyBindForward.pressed && !mc.gameSettings.keyBindRight.pressed && !mc.gameSettings.keyBindLeft.pressed && !mc.gameSettings.keyBindBack.pressed) {
			
			mc.thePlayer.motionX = 0;
			mc.thePlayer.motionZ = 0;
			
		}
		
	}
	
	@Override
	public void onDisable()
	{
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.setPositionAndRotation(oldX, oldY, oldZ,
		mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
		mc.theWorld.removeEntityFromWorld(-69);
		fakePlayer = null;
		mc.renderGlobal.loadRenderers();
	}
	
	public void Event(Event ev) {

		if(ev instanceof EventSendPacket) {

			EventSendPacket e = (EventSendPacket) ev;
			e.cancel = true;
			
		}
	
	}

	
}
