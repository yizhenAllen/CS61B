public class FirstJavaProgram {
    public static void main(String[] args) {
        int size = 27;
        String name = "Fido";
        Dog myDog = new Dog(name, size);
        Dog yourDog = new Dog("Scruffy", 1000);
        Dog[] dogList = new Dog[3];
        dogList[0] = myDog;
        dogList[1] = yourDog;
//        dogList[2] = null;
        dogList[2] = new Dog("Cutie", 8);
        int x;
        x = size - 15;
        if (x < 15) {
            myDog.bark(8);
        }
    }
}
