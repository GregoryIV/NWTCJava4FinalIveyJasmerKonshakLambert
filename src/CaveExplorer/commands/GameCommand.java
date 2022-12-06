package CaveExplorer.commands;

import CaveExplorer.exceptions.GameCommandErrorException;

/**
 *
 * 4.3 Creation and use of a custom functional interface
 * 4.4 Use of optional type
 */
@FunctionalInterface
public interface GameCommand {
    String execute(String... parameters) throws GameCommandErrorException;
}
