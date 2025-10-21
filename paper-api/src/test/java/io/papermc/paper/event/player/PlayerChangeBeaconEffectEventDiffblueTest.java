package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.potion.PotionEffectType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerChangeBeaconEffectEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerChangeBeaconEffectEvent#PlayerChangeBeaconEffectEvent(Player,
   *       PotionEffectType, PotionEffectType, Block)}
   *   <li>{@link PlayerChangeBeaconEffectEvent#setCancelled(boolean)}
   *   <li>{@link PlayerChangeBeaconEffectEvent#setConsumeItem(boolean)}
   *   <li>{@link PlayerChangeBeaconEffectEvent#setPrimary(PotionEffectType)}
   *   <li>{@link PlayerChangeBeaconEffectEvent#setSecondary(PotionEffectType)}
   *   <li>{@link PlayerChangeBeaconEffectEvent#getHandlerList()}
   *   <li>{@link PlayerChangeBeaconEffectEvent#getBeacon()}
   *   <li>{@link PlayerChangeBeaconEffectEvent#getHandlers()}
   *   <li>{@link PlayerChangeBeaconEffectEvent#getPrimary()}
   *   <li>{@link PlayerChangeBeaconEffectEvent#getSecondary()}
   *   <li>{@link PlayerChangeBeaconEffectEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerChangeBeaconEffectEvent.<init>(Player, PotionEffectType, PotionEffectType, Block)",
    "Block PlayerChangeBeaconEffectEvent.getBeacon()",
    "HandlerList PlayerChangeBeaconEffectEvent.getHandlerList()",
    "HandlerList PlayerChangeBeaconEffectEvent.getHandlers()",
    "PotionEffectType PlayerChangeBeaconEffectEvent.getPrimary()",
    "PotionEffectType PlayerChangeBeaconEffectEvent.getSecondary()",
    "boolean PlayerChangeBeaconEffectEvent.isCancelled()",
    "void PlayerChangeBeaconEffectEvent.setCancelled(boolean)",
    "void PlayerChangeBeaconEffectEvent.setConsumeItem(boolean)",
    "void PlayerChangeBeaconEffectEvent.setPrimary(PotionEffectType)",
    "void PlayerChangeBeaconEffectEvent.setSecondary(PotionEffectType)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Block beacon = mock(Block.class);

    // Act
    PlayerChangeBeaconEffectEvent actualPlayerChangeBeaconEffectEvent =
        new PlayerChangeBeaconEffectEvent(player, null, null, beacon);
    actualPlayerChangeBeaconEffectEvent.setCancelled(true);
    actualPlayerChangeBeaconEffectEvent.setConsumeItem(true);
    actualPlayerChangeBeaconEffectEvent.setPrimary(null);
    actualPlayerChangeBeaconEffectEvent.setSecondary(null);
    HandlerList actualHandlerList = actualPlayerChangeBeaconEffectEvent.getHandlerList();
    Block actualBeacon = actualPlayerChangeBeaconEffectEvent.getBeacon();
    HandlerList actualHandlers = actualPlayerChangeBeaconEffectEvent.getHandlers();
    PotionEffectType actualPrimary = actualPlayerChangeBeaconEffectEvent.getPrimary();
    PotionEffectType actualSecondary = actualPlayerChangeBeaconEffectEvent.getSecondary();
    boolean actualIsCancelledResult = actualPlayerChangeBeaconEffectEvent.isCancelled();

    // Assert
    assertNull(actualPrimary);
    assertNull(actualSecondary);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerChangeBeaconEffectEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(beacon, actualBeacon);
    assertSame(player, actualPlayerChangeBeaconEffectEvent.getPlayer());
  }
}
