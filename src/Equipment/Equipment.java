package Equipment;
//桥接模式：锻造多种多样的兵器
public abstract class Equipment {
	protected SpeciallyAdd adds;
	public void setSpeciallyAdd(SpeciallyAdd adds){
		this.adds = adds;
	}
	public abstract void wear();
}
