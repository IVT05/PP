package lab7;

public class Commands {
    static private int max;
    static private int currMax;
    static private int min;
    static private int currMin;
    static private int value;
    static private int random;
    static private boolean isGameOn = false;
    static public void setMinMax(int minNumber, int maxNumber) {
        if (!isGameOn) {
            max = maxNumber;
            currMax = max;
            min = minNumber;
            currMin = min;
            isGameOn = true;
            gameOn();
        }
        else
            MainWindow.resultSetText("Игра уже идет, менять нельзя");
    }
    static public void setBigger() {
        if (currMin == value) {
            MainWindow.resultSetText("Компьютер угадал число " + value + " - вы жульничали");
            isGameOn = false;
        }
        else {
            currMin = value;
            gameOn();
        }
    }
    static public void setSmaller() {
        if (currMax == value) {
            MainWindow.resultSetText("Компьютер угадал число " + value + " - вы жульничали");
            isGameOn = false;
        }
        else {
            currMax = value;
            gameOn();
        }
    }
    static public void win() {
        if (isGameOn) {
            isGameOn = false;
            max = min = currMin = currMax = value = random = 0;
            MainWindow.resultSetText("Компьютер угадал число!");
        }
    }
    static public void gameOn() {
        if (isGameOn) {
            random = getRandom(currMin, currMax);
            if (value != random) {
                value = random;
                MainWindow.returnedValue(value);
            }
        }
    }
    static public int getRandom(int minNumber, int maxNumber) {
        return (int) ((Math.random() * (maxNumber - minNumber)) + minNumber);
    }
}
