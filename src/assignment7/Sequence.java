package assignment7;

import java.util.ArrayList;

public class Sequence {
    private ArrayList<String> words;
    private String doc;

    public Sequence(ArrayList<String> words, String doc){
        this.words = words;
        this.doc = doc;
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public String getDoc(){ return doc;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Sequence)) return false;
        Sequence s = (Sequence) o;
        if (words.equals(s.getWords())) return true;
        else return false;
    }
}
