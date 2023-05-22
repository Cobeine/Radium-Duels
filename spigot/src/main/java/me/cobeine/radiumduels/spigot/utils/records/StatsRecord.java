package me.cobeine.radiumduels.spigot.utils.records;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public enum StatsRecord {

    KILLS,DEATHS, LOSES, MATCHES, WINS,ELO;


    public static String[] asStringArray() {
        String[] arr = new String[StatsRecord.values().length];
        int i =0;
        for (StatsRecord record : StatsRecord.values()) {
            arr[i] = record.name().toLowerCase();
            i++;
        }
        return arr;
    }
}
