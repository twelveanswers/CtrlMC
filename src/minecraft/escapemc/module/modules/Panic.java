package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class Panic extends Module {

	public Panic() {
	
		super("Panic", Keyboard.KEY_P, Category.Other);

	}
	
	@Override
	public void Tick()
	{
		for(Module mod : ModuleManager.getModules())
			if(mod.isToggled() && mod != this)
				mod.setToggled(false);
		setToggled(false);
	}

}
