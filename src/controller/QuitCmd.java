package controller;

import DataBaseManager.DataBaseController;
import model.Player;

/**
 * Implementation of *Quit* Command.
 */
public class QuitCmd extends Command {

    public QuitCmd() {
    }

    /**
     * "Quit" was entered. If no words is entered as the second word, returns
     * true and exists the game Otherwise, returns false and prints an error
     * message
     */
    public boolean execute(Player player) {
        clearOutputString();
        if (getSecondWord() == null) {
            appendToOutputString("Thanks for playing! Good bye...");
            return true;
        } else {
            appendToOutputString("I cannot quit something...");
            return false;
        }
    }
}
