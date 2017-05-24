package Scene;
//ÌìÆøA
import javax.swing.ImageIcon;

import GUI.MainGUI;

public class WeatherA implements Weather {
	private static WeatherA wa =null;
	public static WeatherA getWeatherA(){
		if(wa==null){
			wa=new WeatherA();
		}
		return wa;
	}
	@Override
	public void showw() {
		// TODO Auto-generated method stub
		MainGUI.lb.setIcon(new ImageIcon(MainGUI.class.getResource("/image/sun72.png")));
	}
}
