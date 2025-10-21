package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragon.Phase;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnderDragonChangePhaseEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnderDragonChangePhaseEvent#EnderDragonChangePhaseEvent(EnderDragon, Phase,
   *       Phase)}
   *   <li>{@link EnderDragonChangePhaseEvent#setCancelled(boolean)}
   *   <li>{@link EnderDragonChangePhaseEvent#getHandlerList()}
   *   <li>{@link EnderDragonChangePhaseEvent#getCurrentPhase()}
   *   <li>{@link EnderDragonChangePhaseEvent#getHandlers()}
   *   <li>{@link EnderDragonChangePhaseEvent#getNewPhase()}
   *   <li>{@link EnderDragonChangePhaseEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnderDragonChangePhaseEvent.<init>(EnderDragon, Phase, Phase)",
    "Phase EnderDragonChangePhaseEvent.getCurrentPhase()",
    "HandlerList EnderDragonChangePhaseEvent.getHandlerList()",
    "HandlerList EnderDragonChangePhaseEvent.getHandlers()",
    "Phase EnderDragonChangePhaseEvent.getNewPhase()",
    "boolean EnderDragonChangePhaseEvent.isCancelled()",
    "void EnderDragonChangePhaseEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EnderDragon enderDragon = mock(EnderDragon.class);

    // Act
    EnderDragonChangePhaseEvent actualEnderDragonChangePhaseEvent =
        new EnderDragonChangePhaseEvent(enderDragon, Phase.CIRCLING, Phase.CIRCLING);
    actualEnderDragonChangePhaseEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEnderDragonChangePhaseEvent.getHandlerList();
    Phase actualCurrentPhase = actualEnderDragonChangePhaseEvent.getCurrentPhase();
    HandlerList actualHandlers = actualEnderDragonChangePhaseEvent.getHandlers();
    Phase actualNewPhase = actualEnderDragonChangePhaseEvent.getNewPhase();
    boolean actualIsCancelledResult = actualEnderDragonChangePhaseEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(Phase.CIRCLING, actualCurrentPhase);
    assertEquals(Phase.CIRCLING, actualNewPhase);
    assertFalse(actualEnderDragonChangePhaseEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(enderDragon, actualEnderDragonChangePhaseEvent.getEntity());
  }

  /**
   * Test {@link EnderDragonChangePhaseEvent#getEntity()}.
   *
   * <p>Method under test: {@link EnderDragonChangePhaseEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EnderDragon EnderDragonChangePhaseEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EnderDragonChangePhaseEvent enderDragonChangePhaseEvent =
        new EnderDragonChangePhaseEvent(mock(EnderDragon.class), Phase.CIRCLING, Phase.CIRCLING);

    // Act
    EnderDragon actualEntity = enderDragonChangePhaseEvent.getEntity();

    // Assert
    assertSame(enderDragonChangePhaseEvent.entity, actualEntity);
  }
}
