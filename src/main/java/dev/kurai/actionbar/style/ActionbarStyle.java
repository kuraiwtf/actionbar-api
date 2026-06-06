package dev.kurai.actionbar.style;

import lombok.Builder;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

@Builder
@Getter
public final class ActionbarStyle {

  public static final ActionbarStyle DEFAULT = ActionbarStyle.builder().build();

  @lombok.Builder.Default
  private final Component prefix = Component.text('»', NamedTextColor.DARK_GRAY);

  @lombok.Builder.Default
  private final Component separator = Component.text('❘', NamedTextColor.DARK_GRAY);

  @lombok.Builder.Default
  private final Component suffix = Component.text('«', NamedTextColor.DARK_GRAY);
}
