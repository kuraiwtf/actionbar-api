package dev.kurai.actionbar.update.configuration;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
record ActionbarUpdateConfigurationImpl(long initialDelay, long period)
    implements ActionbarUpdateConfiguration {}
