package Scene;
//抽象工厂模式：搭配不同天气和场景
public interface SceneFactory {
	public Map buildScene();
	public Weather buildWeather();
}
