package Brave;

import Main.Client;
import User.Brave;

//建造模式：给勇者额外的个性化设置：服装，初始武器，头像等
public abstract class BraveBuilder {
	protected Brave brave = Client.brave;//brave基础由工厂生成
	
	public abstract void buildBody();
	public abstract void buildCustume();
	public abstract void buildWeapon();
	
	public Brave getBrave(){
		return brave;
	}
}
