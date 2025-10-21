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
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrePlayerAttackEntityEventDiffblueTest {
  /**
   * Test {@link PrePlayerAttackEntityEvent#PrePlayerAttackEntityEvent(Player, Entity, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return not willAttack.
   * </ul>
   *
   * <p>Method under test: {@link PrePlayerAttackEntityEvent#PrePlayerAttackEntityEvent(Player,
   * Entity, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PrePlayerAttackEntityEvent(Player, Entity, boolean); when 'false'; then return not willAttack")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrePlayerAttackEntityEvent.<init>(Player, Entity, boolean)"})
  void testNewPrePlayerAttackEntityEvent_whenFalse_thenReturnNotWillAttack() {
    // Arrange
    Player player = mock(Player.class);
    Entity attacked = mock(Entity.class);

    // Act
    PrePlayerAttackEntityEvent actualPrePlayerAttackEntityEvent =
        new PrePlayerAttackEntityEvent(player, attacked, false);

    // Assert
    assertEquals("PrePlayerAttackEntityEvent", actualPrePlayerAttackEntityEvent.getEventName());
    assertEquals(0, actualPrePlayerAttackEntityEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPrePlayerAttackEntityEvent.willAttack());
    assertFalse(actualPrePlayerAttackEntityEvent.isAsynchronous());
    assertTrue(actualPrePlayerAttackEntityEvent.isCancelled());
    assertSame(attacked, actualPrePlayerAttackEntityEvent.getAttacked());
    assertSame(player, actualPrePlayerAttackEntityEvent.getPlayer());
  }

  /**
   * Test {@link PrePlayerAttackEntityEvent#PrePlayerAttackEntityEvent(Player, Entity, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link PrePlayerAttackEntityEvent#PrePlayerAttackEntityEvent(Player,
   * Entity, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PrePlayerAttackEntityEvent(Player, Entity, boolean); when 'true'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrePlayerAttackEntityEvent.<init>(Player, Entity, boolean)"})
  void testNewPrePlayerAttackEntityEvent_whenTrue_thenReturnNotCancelled() {
    // Arrange
    Player player = mock(Player.class);
    Entity attacked = mock(Entity.class);

    // Act
    PrePlayerAttackEntityEvent actualPrePlayerAttackEntityEvent =
        new PrePlayerAttackEntityEvent(player, attacked, true);

    // Assert
    assertEquals("PrePlayerAttackEntityEvent", actualPrePlayerAttackEntityEvent.getEventName());
    assertEquals(0, actualPrePlayerAttackEntityEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPrePlayerAttackEntityEvent.isCancelled());
    assertFalse(actualPrePlayerAttackEntityEvent.isAsynchronous());
    assertTrue(actualPrePlayerAttackEntityEvent.willAttack());
    assertSame(attacked, actualPrePlayerAttackEntityEvent.getAttacked());
    assertSame(player, actualPrePlayerAttackEntityEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PrePlayerAttackEntityEvent#getHandlerList()}
   *   <li>{@link PrePlayerAttackEntityEvent#getAttacked()}
   *   <li>{@link PrePlayerAttackEntityEvent#getHandlers()}
   *   <li>{@link PrePlayerAttackEntityEvent#isCancelled()}
   *   <li>{@link PrePlayerAttackEntityEvent#willAttack()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PrePlayerAttackEntityEvent.getAttacked()",
    "HandlerList PrePlayerAttackEntityEvent.getHandlerList()",
    "HandlerList PrePlayerAttackEntityEvent.getHandlers()",
    "boolean PrePlayerAttackEntityEvent.isCancelled()",
    "boolean PrePlayerAttackEntityEvent.willAttack()"
  })
  void testGettersAndSetters() {
    // Arrange
    PrePlayerAttackEntityEvent prePlayerAttackEntityEvent =
        new PrePlayerAttackEntityEvent(mock(Player.class), mock(Entity.class), true);

    // Act
    HandlerList actualHandlerList = prePlayerAttackEntityEvent.getHandlerList();
    prePlayerAttackEntityEvent.getAttacked();
    HandlerList actualHandlers = prePlayerAttackEntityEvent.getHandlers();
    boolean actualIsCancelledResult = prePlayerAttackEntityEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualIsCancelledResult);
    assertTrue(prePlayerAttackEntityEvent.willAttack());
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link PrePlayerAttackEntityEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PrePlayerAttackEntityEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrePlayerAttackEntityEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    PrePlayerAttackEntityEvent prePlayerAttackEntityEvent =
        new PrePlayerAttackEntityEvent(mock(Player.class), mock(Entity.class), true);

    // Act
    prePlayerAttackEntityEvent.setCancelled(true);

    // Assert
    assertTrue(prePlayerAttackEntityEvent.isCancelled());
  }

  /**
   * Test {@link PrePlayerAttackEntityEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link PrePlayerAttackEntityEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrePlayerAttackEntityEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    PrePlayerAttackEntityEvent prePlayerAttackEntityEvent =
        new PrePlayerAttackEntityEvent(mock(Player.class), mock(Entity.class), false);

    // Act
    prePlayerAttackEntityEvent.setCancelled(true);

    // Assert that nothing has changed
    assertTrue(prePlayerAttackEntityEvent.isCancelled());
  }
}
