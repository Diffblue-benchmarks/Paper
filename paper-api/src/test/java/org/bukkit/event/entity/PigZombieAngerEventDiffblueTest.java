package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PigZombieAngerEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PigZombieAngerEvent#PigZombieAngerEvent(PigZombie, Entity, int)}
   *   <li>{@link PigZombieAngerEvent#setCancelled(boolean)}
   *   <li>{@link PigZombieAngerEvent#setNewAnger(int)}
   *   <li>{@link PigZombieAngerEvent#getHandlerList()}
   *   <li>{@link PigZombieAngerEvent#getHandlers()}
   *   <li>{@link PigZombieAngerEvent#getNewAnger()}
   *   <li>{@link PigZombieAngerEvent#getTarget()}
   *   <li>{@link PigZombieAngerEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PigZombieAngerEvent.<init>(PigZombie, Entity, int)",
    "HandlerList PigZombieAngerEvent.getHandlerList()",
    "HandlerList PigZombieAngerEvent.getHandlers()",
    "int PigZombieAngerEvent.getNewAnger()",
    "Entity PigZombieAngerEvent.getTarget()",
    "boolean PigZombieAngerEvent.isCancelled()",
    "void PigZombieAngerEvent.setCancelled(boolean)",
    "void PigZombieAngerEvent.setNewAnger(int)"
  })
  void testGettersAndSetters() {
    // Arrange
    PigZombie zombifiedPiglin = mock(PigZombie.class);
    Entity target = mock(Entity.class);

    // Act
    PigZombieAngerEvent actualPigZombieAngerEvent =
        new PigZombieAngerEvent(zombifiedPiglin, target, 1);
    actualPigZombieAngerEvent.setCancelled(true);
    actualPigZombieAngerEvent.setNewAnger(1);
    HandlerList actualHandlerList = actualPigZombieAngerEvent.getHandlerList();
    HandlerList actualHandlers = actualPigZombieAngerEvent.getHandlers();
    int actualNewAnger = actualPigZombieAngerEvent.getNewAnger();
    Entity actualTarget = actualPigZombieAngerEvent.getTarget();
    boolean actualIsCancelledResult = actualPigZombieAngerEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualNewAnger);
    assertFalse(actualPigZombieAngerEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(target, actualTarget);
    assertSame(zombifiedPiglin, actualPigZombieAngerEvent.getEntity());
  }

  /**
   * Test {@link PigZombieAngerEvent#getEntity()}.
   *
   * <p>Method under test: {@link PigZombieAngerEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PigZombie PigZombieAngerEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    PigZombieAngerEvent pigZombieAngerEvent =
        new PigZombieAngerEvent(mock(PigZombie.class), mock(Entity.class), 1);

    // Act
    PigZombie actualEntity = pigZombieAngerEvent.getEntity();

    // Assert
    assertSame(pigZombieAngerEvent.entity, actualEntity);
  }
}
