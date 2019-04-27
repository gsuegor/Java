import by.gsu.pms.Lexeme;
import by.gsu.pms.Sentence;
import by.gsu.pms.Text;
import by.gsu.pms.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final String FILE_PATH= "src/in.txt";
    public static void main(String[] args) {

        Text text = new Text(new File(FILE_PATH));
        System.out.println(text);

        Sentence firstSentence = text.getSentences().get(0);
        List<Lexeme> firstSenteceWords = new ArrayList<>(getOnlyWords(firstSentence));
        System.out.println("\tFirst sentence:"+getOnlyWords(firstSentence));

        List<Lexeme> repetedList = getNotUniqueWords(text, firstSenteceWords);
        firstSenteceWords.removeAll(repetedList);
        System.out.println("\tUnique words:"+firstSenteceWords);
        System.out.println("\tRepeated words:"+repetedList);
    }
    private static List<Lexeme> getOnlyWords(Sentence sentence){
        List<Lexeme> words = new ArrayList<>();
        for (Lexeme lexeme : sentence.getLexemes()){
            if (lexeme instanceof Word){
                words.add(lexeme);
            }
        }
        return words;
    }

    private static List<Lexeme> getNotUniqueWords(Text text, List<Lexeme> sentence){
        List<Lexeme> notUniqueList = new ArrayList<>();
        for (int i = 1; i < text.getSentences().size()-1; i++){
            List<Lexeme> otherSentences = new ArrayList<>(getOnlyWords(text.getSentences().get(i)));
            for (Lexeme mainWord : sentence){
                for (Lexeme word : otherSentences){
                    if (mainWord.equals(word)){
                        notUniqueList.add(mainWord);
                    }
                }
            }
        }
        return notUniqueList;
    }
}
