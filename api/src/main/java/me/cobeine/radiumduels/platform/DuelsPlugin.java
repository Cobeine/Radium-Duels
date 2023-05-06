package me.cobeine.radiumduels.platform;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface DuelsPlugin {

    void init();



    void registerCommands();

    void registerListeners();

    void fini();

}
