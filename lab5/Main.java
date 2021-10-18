package lab5;

public class Main {
    public static void main(String[] args) {
        Clothes c1 = new Clothes();
        InterfaceClothes object1 = c1;

        Thread thread1 = new Thread1(object1); //записывает
        thread1.setPriority(10);
        Thread thread2 = new Thread2(object1); //читает
        thread2.setPriority(1);
        //10 - высокий    1 - низкий
        thread1.start();
        thread2.start();

        Thread thread3 = new Thread3(object1);
        thread3.start();
        Thread thread4 = new Thread4(object1);
        thread4.start();

        StaticClass.synchronizedInterfaceClothes(object1);
    }
}
