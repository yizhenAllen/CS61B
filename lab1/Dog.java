public class Dog {
    public String name;
    public int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark(int size) {
        if (this.size > size) {
            System.out.println("bark!");
        }

    }

}
