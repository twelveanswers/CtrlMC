package escapemc.Gui.TabGui;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import escapemc.Event.Event;
import escapemc.Event.HookManager;
import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class CtrlMCTabGui extends Event {

	private static Section sec = Section.CATS;
	private static int maxCat;
	private static int maxModule;
	private static int currCat;
	private static int currModule;
	private static Category currC;

	public static void onRender2D() {
		if (!Minecraft.getMinecraft().gameSettings.showDebugInfo) {
				int yC = 24;
				currC = Category.values()[0];
				for (int i = 0; i < Category.values().length; i++) {
					Gui.drawRect(2, yC, maxCat, (yC + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2),
							Integer.MIN_VALUE);
					Gui.drawRect(2, yC, maxCat, (yC + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2),
							(i == currCat) ? Integer.MIN_VALUE : 1);
					Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(Category.values()[i].name(), 4, yC + 2,
							-1);
					currC = Category.values()[currCat];
					yC += 12;
				}
				int yCM = 24;
				if (sec == Section.Modules) {
					for (int i = 0; i < CtrlMCTabGui.getModulesInCat(currC).size(); i++) {
						Gui.drawRect(maxCat + 2, yCM, maxCat + maxModule,
								(yCM + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2), Integer.MIN_VALUE);
						Gui.drawRect(maxCat + 2, yCM, maxCat + maxModule,
								(yCM + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 2),
								(i == currModule) ? Integer.MIN_VALUE : 1);
						Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(
								CtrlMCTabGui.getModulesInCat(currC).get(i).getName(), maxCat + 4, yCM + 2,
								CtrlMCTabGui.getModulesInCat(currC).get(i).isToggled() ? 0x888888 : -1);
						
						//Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text, x, y, color)
						//Gui.drawRect(left, top, right, bottom, color);
						
						yCM += 12;
					}
				}
			}
		}

	public static void onKeyPress(int key) {
						switch (key) {
				case Keyboard.KEY_DOWN:
					if (CtrlMCTabGui.sec == Section.CATS) {
						if (CtrlMCTabGui.currCat < Category.values().length - 1) {
							CtrlMCTabGui.currCat++;
						} else {
							CtrlMCTabGui.currCat = 0;
						}
					}
					if (CtrlMCTabGui.sec == Section.Modules) {
						if (CtrlMCTabGui.currModule < CtrlMCTabGui.getModulesInCat(currC).size() - 1) {
							CtrlMCTabGui.currModule++;
						} else {
							CtrlMCTabGui.currModule = 0;
						}
					}
					break;
				case Keyboard.KEY_UP:
					if (CtrlMCTabGui.sec == Section.CATS) {
						if (CtrlMCTabGui.currCat > 0) {
							CtrlMCTabGui.currCat--;
						} else {
							CtrlMCTabGui.currCat = Category.values().length - 1;
						}
					}
					if (CtrlMCTabGui.sec == Section.Modules) {
						if (CtrlMCTabGui.currModule > 0) {
							CtrlMCTabGui.currModule--;
						} else {
							CtrlMCTabGui.currModule = CtrlMCTabGui.getModulesInCat(currC).size() - 1;
						}
					}
					break;
				case Keyboard.KEY_LEFT:
					if (sec == Section.Modules) {
						sec = Section.CATS;
					}
					break;
				case Keyboard.KEY_RIGHT:
					if (sec == Section.Modules) {
						Module m = CtrlMCTabGui.getModulesInCat(currC).get(currModule);
						if (m != null) {
							m.toggle();
						}else if(m == null) {
							
							break;						
						}
					}
					if (sec == Section.CATS) {
						sec = Section.Modules;
						CtrlMCTabGui.currModule = 0;
					}
					break;
				}
	}

	public static ArrayList<Module> getModulesInCat(Category category) {
		ArrayList<Module> arr = new ArrayList<Module>();
		for (Module m : ModuleManager.getModules()) {
			if (m.getCategory() == category) {
				arr.add(m);
			}
		}
		return arr;
	}

	private enum Section {
		CATS, Modules;
	}

}