package DebugExercise;

public class Tmp {
    public int tmp1;
    public Tmp tmp2;
    public Tmp[] tmp3;

    public static void main(String[] args) {
        Tmp tmpObjects = new Tmp(); //实例的字段都会默认初始化
        System.out.println(tmpObjects.tmp1); //0
        System.out.println(tmpObjects.tmp2); //null
        System.out.println(tmpObjects.tmp3); //null
        System.out.println(tmpObjects.tmp3[0]); //run time error: NullPointerException

        int[] array; // 单纯的声明不会初始化
        int integer; // 单纯的声明不会初始化
//        System.out.println(integer); //Compile error
//        System.out.println(array); //Compile error

        array = new int[5]; //用new创建数组的时候，数组元素会像字段一样初始化
        System.out.println(array); //an address
        System.out.println(array[0]); //0

        Tmp[] tmpArray = new Tmp[5]; //数组元素会像字段一样初始化
        System.out.println(tmpArray); //an address
        System.out.println(tmpArray[0]); //null
    }
}
