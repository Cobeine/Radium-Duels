package me.cobeine.radiumduels.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cooldown {
    int sex() ;
    TimeUnit timeUnit()  default TimeUnit.SECONDS;
}
