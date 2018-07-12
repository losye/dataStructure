package offer;

/**
 * Created by losye
 * 实现单例模式
 */
public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonFactory.instance;
    }

    private static class SingletonFactory {
        private static Singleton instance = new Singleton();
    }

}
