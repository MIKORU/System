package Scene;
//ÌìÆøB
import javax.swing.ImageIcon;

import GUI.MainGUI;

public class WeatherB implements Weather {
	private static WeatherB wb =null;
	public static WeatherB getWeatherB(){
		if(wb==null){
			wb=new WeatherB();
		}
		return wb;
	}
	@Override
	public void showw() {
		// TODO Auto-generated method stub
		MainGUI.lb.setIcon(new ImageIcon(MainGUI.class.getResource("/image/shadow.png")));
	}
}
