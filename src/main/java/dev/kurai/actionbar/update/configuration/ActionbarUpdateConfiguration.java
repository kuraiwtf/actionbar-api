package dev.kurai.actionbar.update.configuration;

import static java.lang.Long.MAX_VALUE;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Range;

public sealed interface ActionbarUpdateConfiguration permits ActionbarUpdateConfigurationImpl {

  ActionbarUpdateConfiguration EVERY_TICK = actionbarUpdateConfiguration(0L, 1L);

  @Contract(value = "_, _ -> new", pure = true)
  static ActionbarUpdateConfiguration actionbarUpdateConfiguration(
      final @Range(from = 0L, to = MAX_VALUE) long initialDelay,
      final @Range(from = 1L, to = MAX_VALUE) long period) {
    return new ActionbarUpdateConfigurationImpl(initialDelay, period);
  }

  long initialDelay();

  long period();
}
