package lab6;

public class ClothesFactory implements MainInterfaceFactory{

    @Override
    public MainIterface createInstance() {
        return new Clothes();
    }
}
