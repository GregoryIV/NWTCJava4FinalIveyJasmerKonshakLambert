package CaveExplorer;

public class Command {
    private String name;
    private int wordCountMinimum;
    private int wordCountMaximum;

    public Command(String name, int wordCountMinimum, int wordCountMaximum) {
        this.name = name;
        this.wordCountMinimum = wordCountMinimum;
        this.wordCountMaximum = wordCountMaximum;
    }

    public String getName() {
        return name;
    }

    public int getWordCountMinimum() {
        return wordCountMinimum;
    }

    public int getWordCountMaximum() {
        return wordCountMaximum;
    }

}
