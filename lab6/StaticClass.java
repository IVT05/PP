package lab6;

public abstract class StaticClass {
    private static MainInterfaceFactory factory;
    static MainIterface unmodifableMainInterface(MainIterface o)
    {
        return new InterfaceDecorator(o);
    }
    public static void setMainInterfaceFactory(MainInterfaceFactory o)
    {
        factory = o;
    }
    public static void createInstance()
    {
        factory.createInstance();
    }
}
