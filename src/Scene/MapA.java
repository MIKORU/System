package Scene;

import javax.swing.ImageIcon;

import GUI.MainGUI;
//µØÍ¼A
public class MapA implements Map {
	private static MapA mapa =null;
	public static MapA getMapA(){
		if(mapa==null){
			mapa=new MapA();
		}
		return mapa;
	}
	@Override
	public void showm() {
		// TODO Auto-generated method stub
		MainGUI.la.setIcon(new ImageIcon(MainGUI.class.getResource("/image/mapa.jpg")));
	}
}
