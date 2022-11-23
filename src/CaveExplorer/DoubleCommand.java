package CaveExplorer;

import java.util.ArrayList;

public class DoubleCommand extends Command{
    private String parameter;

    public DoubleCommand(String name, String helpMessage) {
        super(name, helpMessage);

        this.parameter = "";
    }

    public DoubleCommand(String name, ArrayList<String> synonyms, String helpMessage) {
        super(name,synonyms, helpMessage);

        this.parameter = "";
    }

    public void setParameter(String parameter) {this.parameter = parameter;}
    public String getParameter(){return this.parameter;}
}
