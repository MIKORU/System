package Scene;
//����B�������䣺��ͼB+����B
public class SceneBFactory implements SceneFactory {
	private static SceneBFactory seb= null;
	public static SceneBFactory getSBF(){
		if(seb==null){
			seb = new SceneBFactory();
		}
		return seb;
	}
	@Override
	public Map buildScene() {
		// TODO Auto-generated method stub
		return MapB.getMapB();
	}
	@Override
	public Weather buildWeather() {
		// TODO Auto-generated method stub
		return WeatherB.getWeatherB();
	}

}
