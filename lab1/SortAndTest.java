public class SortAndTest {
    /**
     * test the sorted string right or not
     */
    public static void test() {
        String[] input = {"i", "have", "an", "egg"};
        String[] output = {"an", "egg", "have", "i"};
        sort(input);
        org.junit.Assert.assertArrayEquals(output, input);
    }

    /**
     * Selection sort, find the minimum then swap it with the first item who has not been swaped
     *
     * @param input an Array of String
     */
    public static void sort(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < input.length; j++) {
                if (input[minIndex].compareTo(input[j]) > 0) {
                    minIndex = j;
                }
            }
            // swap input[i] and input[j]
            String tmp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        test();
    }

}
