package by.gsu.pms;

public class Word{

    private String word;
    private int copies;
    private boolean searched;

    public Word(String word){
        this.word = word;
        this.copies = -1;
        this.searched = false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public boolean isSearched() {
        return searched;
    }

    public void setSearched(boolean searched) {
        this.searched = searched;
    }

    public void addCopies(){
        this.copies++;
    }

    @Override
    public String toString() {
        return word+";"+copies;
    }
}
