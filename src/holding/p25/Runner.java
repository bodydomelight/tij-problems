package holding.p25;

public class Runner {
    
    
    public static void main(String[] args) {
        MyFileReader fileReader = new MyFileReader();
        TextCounter textCounter = new TextCounter();
        textCounter.getMapOfWords(fileReader.getListOfWords("C:\\Users\\aamelin\\Desktop\\wordsTest.txt"));
    }
}
