import java.util.Arrays;

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int k=0; k < this.length(); k++) {
            sb.append(this.wordAt(k));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length()) {
            return false;
        }
        for(int k=0; k<other.length(); k++) {
            if(!this.wordAt(k).equals(other.wordAt(k))) {
                return false;
            }
        }

        return true;
    }

    public WordGram shiftAdd(String word) {
        String[] words = new String[myWords.length];
        System.arraycopy(myWords, 1, words, 0, myWords.length-1);
        words[words.length-1] = word;
        WordGram out = new WordGram(words, 0, words.length);
        return out;
    }
    
    public int hashCode() {
        return this.toString().hashCode();
    }

}