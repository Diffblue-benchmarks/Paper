package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityDismountEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Entity}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDismountEvent#EntityDismountEvent(Entity, Entity)}
   *   <li>{@link EntityDismountEvent#getHandlerList()}
   *   <li>{@link EntityDismountEvent#getDismounted()}
   *   <li>{@link EntityDismountEvent#getHandlers()}
   *   <li>{@link EntityDismountEvent#isCancellable()}
   *   <li>{@link EntityDismountEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDismountEvent.<init>(Entity, Entity)",
    "void EntityDismountEvent.<init>(Entity, Entity, boolean)",
    "Entity EntityDismountEvent.getDismounted()",
    "HandlerList EntityDismountEvent.getHandlerList()",
    "HandlerList EntityDismountEvent.getHandlers()",
    "boolean EntityDismountEvent.isCancellable()",
    "boolean EntityDismountEvent.isCancelled()"
  })
  void testGettersAndSetters_whenEntity() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity dismounted = mock(Entity.class);

    // Act
    EntityDismountEvent actualEntityDismountEvent = new EntityDismountEvent(entity, dismounted);
    HandlerList actualHandlerList = actualEntityDismountEvent.getHandlerList();
    Entity actualDismounted = actualEntityDismountEvent.getDismounted();
    HandlerList actualHandlers = actualEntityDismountEvent.getHandlers();
    boolean actualIsCancellableResult = actualEntityDismountEvent.isCancellable();
    boolean actualIsCancelledResult = actualEntityDismountEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityDismountEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualIsCancellableResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(dismounted, actualDismounted);
    assertSame(entity, actualEntityDismountEvent.getEntity());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDismountEvent#EntityDismountEvent(Entity, Entity, boolean)}
   *   <li>{@link EntityDismountEvent#getHandlerList()}
   *   <li>{@link EntityDismountEvent#getDismounted()}
   *   <li>{@link EntityDismountEvent#getHandlers()}
   *   <li>{@link EntityDismountEvent#isCancellable()}
   *   <li>{@link EntityDismountEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDismountEvent.<init>(Entity, Entity)",
    "void EntityDismountEvent.<init>(Entity, Entity, boolean)",
    "Entity EntityDismountEvent.getDismounted()",
    "HandlerList EntityDismountEvent.getHandlerList()",
    "HandlerList EntityDismountEvent.getHandlers()",
    "boolean EntityDismountEvent.isCancellable()",
    "boolean EntityDismountEvent.isCancelled()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange
    Entity entity = mock(Entity.class);
    Entity dismounted = mock(Entity.class);

    // Act
    EntityDismountEvent actualEntityDismountEvent =
        new EntityDismountEvent(entity, dismounted, true);
    HandlerList actualHandlerList = actualEntityDismountEvent.getHandlerList();
    Entity actualDismounted = actualEntityDismountEvent.getDismounted();
    HandlerList actualHandlers = actualEntityDismountEvent.getHandlers();
    boolean actualIsCancellableResult = actualEntityDismountEvent.isCancellable();
    boolean actualIsCancelledResult = actualEntityDismountEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityDismountEvent.isAsynchronous());
    assertFalse(actualIsCancelledResult);
    assertTrue(actualIsCancellableResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(dismounted, actualDismounted);
    assertSame(entity, actualEntityDismountEvent.getEntity());
  }

  /**
   * Test {@link EntityDismountEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link EntityDismountEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDismountEvent.setCancelled(boolean)"})
  void testSetCancelled() {
    // Arrange
    EntityDismountEvent entityDismountEvent =
        new EntityDismountEvent(mock(Entity.class), mock(Entity.class));

    // Act
    entityDismountEvent.setCancelled(false);

    // Assert that nothing has changed
    assertFalse(entityDismountEvent.isCancelled());
  }

  /**
   * Test {@link EntityDismountEvent#setCancelled(boolean)}.
   *
   * <p>Method under test: {@link EntityDismountEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName("Test setCancelled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDismountEvent.setCancelled(boolean)"})
  void testSetCancelled2() {
    // Arrange
    EntityDismountEvent entityDismountEvent =
        new EntityDismountEvent(mock(Entity.class), mock(Entity.class), false);

    // Act
    entityDismountEvent.setCancelled(true);

    // Assert that nothing has changed
    assertFalse(entityDismountEvent.isCancelled());
  }

  /**
   * Test {@link EntityDismountEvent#setCancelled(boolean)}.
   *
   * <ul>
   *   <li>Then {@link EntityDismountEvent#EntityDismountEvent(Entity, Entity)} with {@link Entity}
   *       and dismounted is {@link Entity} Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link EntityDismountEvent#setCancelled(boolean)}
   */
  @Test
  @DisplayName(
      "Test setCancelled(boolean); then EntityDismountEvent(Entity, Entity) with Entity and dismounted is Entity Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDismountEvent.setCancelled(boolean)"})
  void testSetCancelled_thenEntityDismountEventWithEntityAndDismountedIsEntityCancelled() {
    // Arrange
    EntityDismountEvent entityDismountEvent =
        new EntityDismountEvent(mock(Entity.class), mock(Entity.class));

    // Act
    entityDismountEvent.setCancelled(true);

    // Assert
    assertTrue(entityDismountEvent.isCancelled());
  }
}
