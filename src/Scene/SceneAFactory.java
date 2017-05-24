package Scene;
//����A�������䣺��ͼA+����A
public class SceneAFactory implements SceneFactory {
	private static SceneAFactory sea= null;
	public static SceneAFactory getSAF(){
		if(sea==null){
			sea = new SceneAFactory();
		}
		return sea;
	}
	@Override
	public Map buildScene() {
		// TODO Auto-generated method stub
		return MapA.getMapA();
	}
	@Override
	public Weather buildWeather() {
		// TODO Auto-generated method stub
		return WeatherA.getWeatherA();
	}

}
