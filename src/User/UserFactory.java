package User;

public class UserFactory {
	public static Brave getUser(String mod,String name){
		if(mod.equals("VIP")){
			return new VIPBrave(name);
		}else return new NormalBrave(name);
	}
}
