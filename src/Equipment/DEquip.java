package Equipment;
//ÎäÆ÷ÀàĞÍ£ºµ¶
public class DEquip extends Equipment {

	@Override
	public void wear() {
		// TODO Auto-generated method stub
		String equiptype = "µ¶";
		this.adds.Wear(equiptype);
	}
}
