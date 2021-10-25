package lab6;

public class MaterialsFactory implements MainInterfaceFactory{

    @Override
    public MainIterface createInstance() {
        return new Materials();
    }
}
