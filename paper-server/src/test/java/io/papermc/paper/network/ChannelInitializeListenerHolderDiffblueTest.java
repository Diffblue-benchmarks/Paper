package io.papermc.paper.network;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.key.Key;
import org.bukkit.NamespacedKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChannelInitializeListenerHolderDiffblueTest {
  /**
   * Test {@link ChannelInitializeListenerHolder#hasListener(Key)}.
   *
   * <ul>
   *   <li>When randomKey.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelInitializeListenerHolder#hasListener(Key)}
   */
  @Test
  @DisplayName("Test hasListener(Key); when randomKey; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ChannelInitializeListenerHolder.hasListener(Key)"})
  void testHasListener_whenRandomKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ChannelInitializeListenerHolder.hasListener(NamespacedKey.randomKey()));
  }
}
