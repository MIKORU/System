package Equipment;
//ÎäÆ÷ÀàĞÍ£º½£
public class JEquip extends Equipment {

	@Override
	public void wear() {
		// TODO Auto-generated method stub
		String equiptype = "½£";
		this.adds.Wear(equiptype);
	}
}
