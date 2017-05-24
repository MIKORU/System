package Scene;

import javax.swing.ImageIcon;

import GUI.MainGUI;
//µØÍ¼B
public class MapB implements Map {
	private static MapB mapb =null;
	public static MapB getMapB(){
		if(mapb==null){
			mapb=new MapB();
		}
		return mapb;
	}

	@Override
	public void showm() {
		// TODO Auto-generated method stub
		MainGUI.la.setIcon(new ImageIcon(MainGUI.class.getResource("/image/mapb.jpg")));
	}

}
