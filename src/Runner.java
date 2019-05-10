import by.gsu.pms.Sentence;
import by.gsu.pms.Text;
import by.gsu.pms.Word;

import java.io.File;
import java.util.HashMap;

public class Runner {

    private static final String FILE_PATH = "src/in.txt";

    public static void main(String[] args) {
        Text text = new Text(new File(FILE_PATH));

        for (Sentence sentence : text.getSentences()){
            for (Word word : sentence.getWords()){
                if (!word.isSearched()){
                    for (Sentence innerSentece : text.getSentences()){
                        for (Word innerWord : innerSentece.getWords()){
                            if (word.getWord().equals(innerWord.getWord())){
                                word.addCopies();
                            }
                        }
                    }
                }
            }
        }
        HashMap<String, Integer> answerMap = new HashMap<>();
        for (Sentence sentence : text.getSentences()){
            for (Word word : sentence.getWords()){
                answerMap.put(word.getWord(),word.getCopies());
                }
            }
        System.out.println(answerMap);
    }
}
