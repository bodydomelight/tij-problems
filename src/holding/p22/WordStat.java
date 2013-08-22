package holding.p22;

class WordStat {

    private String word;
    private int count;

    WordStat(String word) {
        if (word != null) {
            this.word = word;
            this.count = 0;
        } else {
            throw new NullPointerException();
        }
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public boolean addWord(String word) {
        if (this.word.equals(word)) {
            count++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof String){
            String word = (String) obj;
            return this.getWord().equals(word);
        } return false;
    }
    @Override
    public String toString() {
        return word + ": " + count;
    }
}