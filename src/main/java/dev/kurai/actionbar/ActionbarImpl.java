package dev.kurai.actionbar;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.Maps;
import dev.kurai.actionbar.entry.ActionbarEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.UnmodifiableView;

/**
 * Default {@link Actionbar} implementation backed by a {@link java.util.HashMap}. Entries are
 * stored and retrieved by their {@link Key}.
 */
final class ActionbarImpl implements Actionbar {

  private static final String KEY_CANNOT_BE_NULL = "Key cannot be null";

  private final Map<Key, ActionbarEntry> actionbarEntries = Maps.newConcurrentMap();
  private final Collection<ActionbarEntry> actionbarEntriesView =
      Collections.unmodifiableCollection(this.actionbarEntries.values());

  /** {@inheritDoc} */
  @Override
  @UnmodifiableView
  public Collection<ActionbarEntry> actionbarEntries() {
    return this.actionbarEntriesView;
  }

  /** {@inheritDoc} */
  @Override
  public void registerActionbarEntry(final ActionbarEntry actionbarEntry) {
    requireNonNull(actionbarEntry, "Actionbar entry cannot be null");

    this.actionbarEntries.put(actionbarEntry.key(), actionbarEntry);
  }

  /** {@inheritDoc} */
  @Override
  public void unregisterActionbarEntry(final Key key) {
    this.actionbarEntries.remove(requireNonNull(key, KEY_CANNOT_BE_NULL));
  }

  @Override
  public void unregisterActionbarEntriesIf(final Predicate<ActionbarEntry> actionbarEntryFilter) {
    this.actionbarEntries
        .values()
        .removeIf(requireNonNull(actionbarEntryFilter, "Actionbar entry filter cannot be null"));
  }

  /** {@inheritDoc} */
  @Override
  public ActionbarEntry actionbarEntry(final Key key) {
    return this.actionbarEntries.get(requireNonNull(key, KEY_CANNOT_BE_NULL));
  }
}
