package holding.p30;

public class Pets {
    public static Pet[] createArray(int i) {
        Pet[] petsArray = new Pet[i];
        for (int j = 0; j < i; j++) {
            petsArray[j] = new Pet(j + "");
        }
        return petsArray;
    }
}
