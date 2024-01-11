public class BiggestItemOfArray {
    public static int max(int[] m) {
        int l = m.length;
        int result = m[0];
//        int index = 0;
//        while(index < l) {
//            if (m[index] > result){
//                result = m[index];
//            }
//            index++;
//        }
        // use for loop
        for (int index = 0; index < l; index++) {
            if (m[index] > result){
                result = m[index];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(array));
    }
}