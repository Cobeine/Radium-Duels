package me.cobeine.radiumduels.storage.mysql.queries;

public interface Callback<V , T extends Throwable>  {

    void call(V result, T throwable);

}
