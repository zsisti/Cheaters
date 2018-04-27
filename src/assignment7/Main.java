package assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("In which directory are the files you would like to compare?");
        String directory = sc.next();
        System.out.println("How many words per sequence?");
        int n = Integer.valueOf(sc.next());

        File folder = null;
        Scanner infile = null;
        try{
            folder = new File(directory);
        }
        catch (Exception e){
            System.out.println(e);
        }
        String[] essays = folder.list();
        ArrayList<Sequence> allSeqs = new ArrayList<Sequence>();
        for(String i : essays){
            try{
                infile = new Scanner(new File(folder+ "/" + i));
            }
            catch(FileNotFoundException e){
                System.out.println(e);
            }
            ArrayList<String> docWords = new ArrayList<String>();
            while(infile.hasNext()){
                docWords.add(infile.next());
            }
            int j=0;
            while(j+n <= docWords.size()){
                ArrayList<String> newArr = new ArrayList<String>();
                for(int k=0; k<n; k++){
                    newArr.add(docWords.get(j+k));
                }
                Sequence newSeq = new Sequence(newArr, i);
                allSeqs.add(newSeq);
                j++;
            }
        }
        for (Sequence s : allSeqs){
            System.out.println(s.getWords());
        }
    }
}
