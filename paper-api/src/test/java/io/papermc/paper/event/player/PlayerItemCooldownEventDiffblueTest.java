package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerItemCooldownEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerItemCooldownEvent#PlayerItemCooldownEvent(Player, Material, NamespacedKey,
   *       int)}
   *   <li>{@link PlayerItemCooldownEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerItemCooldownEvent.<init>(Player, Material, NamespacedKey, int)",
    "Material PlayerItemCooldownEvent.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    NamespacedKey cooldownGroup = NamespacedKey.randomKey();

    // Act
    PlayerItemCooldownEvent actualPlayerItemCooldownEvent =
        new PlayerItemCooldownEvent(player, Material.ACACIA_BOAT, cooldownGroup, 1);
    Material actualType = actualPlayerItemCooldownEvent.getType();

    // Assert
    assertEquals(1, actualPlayerItemCooldownEvent.getCooldown());
    assertEquals(Material.ACACIA_BOAT, actualType);
    assertFalse(actualPlayerItemCooldownEvent.isCancelled());
    assertFalse(actualPlayerItemCooldownEvent.isAsynchronous());
    assertSame(cooldownGroup, actualPlayerItemCooldownEvent.getCooldownGroup());
    assertSame(player, actualPlayerItemCooldownEvent.getPlayer());
  }
}
