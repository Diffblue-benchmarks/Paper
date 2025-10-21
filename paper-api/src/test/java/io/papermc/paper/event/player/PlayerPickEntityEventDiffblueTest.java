package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPickEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPickEntityEvent#PlayerPickEntityEvent(Player, Entity, boolean, int, int)}
   *   <li>{@link PlayerPickEntityEvent#getEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPickEntityEvent.<init>(Player, Entity, boolean, int, int)",
    "Entity PlayerPickEntityEvent.getEntity()"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    Entity entity = mock(Entity.class);

    // Act
    PlayerPickEntityEvent actualPlayerPickEntityEvent =
        new PlayerPickEntityEvent(player, entity, true, 1, 1);
    Entity actualEntity = actualPlayerPickEntityEvent.getEntity();

    // Assert
    assertEquals(1, actualPlayerPickEntityEvent.getSourceSlot());
    assertEquals(1, actualPlayerPickEntityEvent.getTargetSlot());
    assertFalse(actualPlayerPickEntityEvent.isCancelled());
    assertFalse(actualPlayerPickEntityEvent.isAsynchronous());
    assertTrue(actualPlayerPickEntityEvent.isIncludeData());
    assertSame(entity, actualEntity);
    assertSame(player, actualPlayerPickEntityEvent.getPlayer());
  }
}
