package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTameEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityTameEvent#EntityTameEvent(LivingEntity, AnimalTamer)}
   *   <li>{@link EntityTameEvent#setCancelled(boolean)}
   *   <li>{@link EntityTameEvent#getHandlerList()}
   *   <li>{@link EntityTameEvent#getHandlers()}
   *   <li>{@link EntityTameEvent#getOwner()}
   *   <li>{@link EntityTameEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityTameEvent.<init>(LivingEntity, AnimalTamer)",
    "HandlerList EntityTameEvent.getHandlerList()",
    "HandlerList EntityTameEvent.getHandlers()",
    "AnimalTamer EntityTameEvent.getOwner()",
    "boolean EntityTameEvent.isCancelled()",
    "void EntityTameEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    AnimalTamer owner = mock(AnimalTamer.class);

    // Act
    EntityTameEvent actualEntityTameEvent = new EntityTameEvent(entity, owner);
    actualEntityTameEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityTameEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityTameEvent.getHandlers();
    AnimalTamer actualOwner = actualEntityTameEvent.getOwner();
    boolean actualIsCancelledResult = actualEntityTameEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityTameEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(owner, actualOwner);
    assertSame(entity, actualEntityTameEvent.getEntity());
  }

  /**
   * Test {@link EntityTameEvent#getEntity()}.
   *
   * <p>Method under test: {@link EntityTameEvent#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LivingEntity EntityTameEvent.getEntity()"})
  void testGetEntity() {
    // Arrange
    EntityTameEvent entityTameEvent =
        new EntityTameEvent(mock(LivingEntity.class), mock(AnimalTamer.class));

    // Act
    LivingEntity actualEntity = entityTameEvent.getEntity();

    // Assert
    assertSame(entityTameEvent.entity, actualEntity);
  }
}
