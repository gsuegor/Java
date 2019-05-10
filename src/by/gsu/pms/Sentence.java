package by.gsu.pms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private List<Word> words;

    private static final String PUNCTUATION_REGEX = "[«»,.!?/\\-]";

    public Sentence(){
    }

    public Sentence(String sentence){
        words = new LinkedList<>();

        String[] wordLine = sentence.split(" ");
        for (String word : wordLine){

            Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);

            for (String item : word.split(PUNCTUATION_REGEX)){
                if (!word.equals("")){
                    words.add(new Word(item));
                }
            }

        }
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "\nSentence{" +
                "words=" + words +
                '}';
    }
}
