package Scene;
//工厂A场景搭配：地图A+天气A
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
