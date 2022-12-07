package CaveExplorerApp.globals;

import CaveExplorerApp.items.*;

/**
 * An item that can be used on another item
 * (use [UsableOn] on [item])
 */
public interface UsableOn {
    String useOn(Item itemToUseOn);
}
