package User;
//简单工厂模式：勇者基本属性+判断用户角色：普通orVIP
public abstract class Brave {
	public String bName;
	public String bSex;
	public String bCustume;
	public String bWeapon;
	public int bHP=100;
	public int bMP=100;
	public int bAttack=80;
	public int bDefence=60;
	public int bMoney=0;
	
	public abstract boolean different();
}
