class Laba3{
    public static void main(String[] args)
    {
        int[] arg = {1, 2, 3,4}; //менять
        try {
            Clothes cl1 = new Clothes(1, "name", arg); //создание с ошибкой
        }
        catch (RuntimeException e) {
            System.out.println(e);
        }
        Clothes cl2 = new Clothes();
        cl2.getArgs();
        cl2.getName();
        cl2.getNumber();
        try{
            char charArg = '4'; //менять
            if (charArg == '+' || charArg == '-') cl2.changeSize(charArg,10);
            else throw new WrongChar("Wrong char - " + charArg); //Выброс объявленной ошибки
        }
        catch (WrongChar err) {
            System.out.println(err);
        }
        Materials mat1 = new Materials(1, "silk", 1, 2);
        System.out.println(mat1.obj_toString());
        Materials mat2 = new Materials();
        Materials mat3 = new Materials();
        System.out.println(mat1.equals(mat2));
        System.out.println(mat1.hachCode());
        System.out.println(mat2.hachCode());
        System.out.println(mat3.hachCode());
        Values[] dataBase = new Values[4]; //2 и 3 одинаковые
        dataBase[0] = mat1;
        dataBase[1] = mat2;
        dataBase[2] = mat3;
        dataBase[3] = cl2;
        for (int i = 0; i <= dataBase.length-1;i++){  //Вывод всех элементов интерфейса
            System.out.println(dataBase[i].obj_toString());
        }
        Values[] dataBaseEq = new Values[2];
        Values[] dataBaseNotEq = new Values[2];
        System.out.println("------------------------");
        if (dataBase[2].returnFunc() == dataBase[1].returnFunc()) { //возвращают одинаковые значения
            dataBaseEq[0] = dataBase[1];
            dataBaseEq[1] = dataBase[2];
            dataBaseNotEq[0] = dataBase[0];
            dataBaseNotEq[1] = dataBase[3];
        }
        for (int i = 0; i <= dataBaseEq.length-1;i++){  //Вывод всех элементов интерфейса с однотипными элементами
            System.out.println(dataBaseEq[i].obj_toString());
        }
        System.out.println("------------------------");
        for (int i = 0; i <= dataBaseNotEq.length-1;i++){  //Вывод всех элементов интерфейса без однотипных
            System.out.println(dataBaseNotEq[i].obj_toString());
        }
    }
}
interface Values{
    public void getName();
    public void getNumber();
    public void getArgs();
    public void changeSize(char op, int value);
    public String obj_toString();
    public boolean returnFunc();
}

class Clothes implements  Values{ //класс одежда
    int model; //порядковый номер
    String name; //название
    int[] size = new int[3]; //размеры
    String hCode; //хэшкод
    public Clothes(){ //пустой конструктор
        model = 0;
        name = "default";
        for (int i = 0; i <= size.length-1; i++){
            size[i] = 0;
        }
        System.out.println("created default");
    }
    public Clothes(int model, String name, int[] size){ //конструктор с параметрами
        if (size.length > 3) {throw new RuntimeException("Out of array");} //выброс исключения
        else {
            this.model = model;
            this.name = name;
            for (int i = 0; i <= size.length-1;i++)
                this.size[i] = size[i];
            System.out.println("created with params");
        }
    }
    public void getArgs(int number){ // вывод одного размера
        System.out.println(this.size[number]);
    }
    public void getName() { //вывод названия
    System.out.println(this.name);
    }
    public void getNumber(){ //вывод номера модели
        System.out.println(this.model);
    }
    public void getArgs(){ //вывод всех размеров
        for (int i = 0; i <= this.size.length-1;i++)
            System.out.print(this.size[i]+" ");
            System.out.println("");
    }
    public void changeSize(char op, int value){ //изменение размера
        if (op == '+') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]+=value; System.out.print(this.size[i] + " ");}
        if (op == '-') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]-=value; System.out.print(this.size[i] + " ");}
        System.out.println();
    }
    public String obj_toString(){
        return name + " " + model + " " + size[0] + ":" + size[1]+ ":" + size[2];
    }
    public boolean equals(Clothes obj){
        return (this.name == obj.name && this.size[0] == obj.size[0] && this.size[1] == obj.size[1] && this.size[2] == obj.size[2]&& this.model == obj.model);
    }
    public String hachCode(){
        String temp = this.obj_toString();
        byte[] byteArray = temp.getBytes();
        String temp1 = "";
        for (int i =0; i <= byteArray.length-1;i++) temp1 += byteArray[i];
        this.hCode = temp1;
        return temp1;
    }

    @java.lang.Override
    public boolean returnFunc() {
        if (this.name == "default") return true; else return false;
    }
}

class WrongChar extends Exception{ //объявленное исключение
    public WrongChar(String errMessage){
        super(errMessage);
    }
}

class Materials implements Values{
    int number;
    int[] size = new int[2];
    String name;
    String hCode;
    public Materials(){
        this.number = 0;
        this.size[0] = 0;
        this.size[1] = 0;
        this.name = "Default";
        System.out.println("Created default");
    }
    public Materials(int number, String name, int arg1, int arg2){
        this.number = number;
        this.name = name;
        this.size[0] = arg1;
        this.size[1] = arg2;
        System.out.println("Created with params");
    }
    public void getName(){
        System.out.println(name);
    }
    public void getNumber(){
        System.out.println(number);
    }
    public void getArgs(){
        System.out.println(size[0] + " " + size[1]);
    }
    public void changeSize(char op, int value){
        if (op == '+') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]+=value; System.out.print(this.size[i] + " ");}
        if (op == '-') for (int i = 0; i <= this.size.length-1;i++) {this.size[i]-=value; System.out.print(this.size[i] + " ");}
        System.out.println();
    }
    public String obj_toString(){
        return name + " " + number + " " + size[0] + ":" + size[1];
    }
    public boolean equals(Materials obj){
        return (this.name == obj.name && this.size[0] == obj.size[0] && this.size[1] == obj.size[1] && this.number == obj.number);
    }
    public String hachCode(){
        String temp = this.obj_toString();
        byte[] byteArray = temp.getBytes();
        String temp1 = "";
        for (int i =0; i <= byteArray.length-1;i++) temp1 += byteArray[i];
        this.hCode = temp1;
        return temp1;
    }

    @java.lang.Override
    public boolean returnFunc() {
        if (this.name == "Default") return true; else return false;
    }
}