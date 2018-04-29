package assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("In which directory are the files you would like to compare?");
        String directory = sc.next();
        System.out.println("How many words per sequence?");
        int n = Integer.valueOf(sc.next());

        File folder = null;
        File infile = null;
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
                infile = new File(directory + "\\" + i);
                BufferedReader br = new BufferedReader(new FileReader(infile));
                ArrayList<String> docWords = new ArrayList<String>();
                String line = br.readLine();
                while(line != null){
                    Pattern p = Pattern.compile("[\\w':\\-]+");
                    Matcher m = p.matcher(line);
                    while(m.find()){
                        docWords.add(m.group());
                    }
                    line = br.readLine();
                    int pppp = 234;
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
            catch(Exception e){
                System.out.println(e);
            }
        }
        for (int i=0; i<allSeqs.size(); i++){
            System.out.println(allSeqs.get(i).getWords());
        }
    }
}
