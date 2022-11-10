package CaveExplorer;

import java.io.*;

public class Main {
    static Game game;

    private static void saveGame() {
        try {
            FileOutputStream fos = new FileOutputStream("CaveExplorer.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game); // game
            oos.flush(); // write out any buffered bytes
            oos.close();
            System.out.print("Game saved\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't save data.\n"
                    + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }
    private static void loadGame() {
        try {
            FileInputStream fis = new FileInputStream("CaveExplorer.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            ois.close();
            System.out.print("\n---Game loaded---\n");
        } catch (Exception e) {
            System.out.print("Serialization Error! Can't load data.\n");
            System.out.print(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        BufferedReader inputReader  = new BufferedReader(new InputStreamReader(System.in));
        boolean continueGame = true;

        game = new Game();
        //game.showIntro();

        do {
            System.out.print("> ");
            input = inputReader.readLine();
            switch (input) {
                case "save":
                    saveGame();
                    break;
                case "load":
                    loadGame();
                    break;
                default:
                    output = game.runCommand(input);
                    break;
            }
            if (!output.trim().isEmpty()) {
                game.showStr(output);
            }
        } while (continueGame);
    }
}
