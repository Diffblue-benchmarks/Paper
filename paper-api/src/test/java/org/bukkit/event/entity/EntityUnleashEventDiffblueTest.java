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
import org.bukkit.event.entity.EntityUnleashEvent.UnleashReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityUnleashEventDiffblueTest {
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
   *   <li>{@link EntityUnleashEvent#EntityUnleashEvent(Entity, UnleashReason)}
   *   <li>{@link EntityUnleashEvent#setCancelled(boolean)}
   *   <li>{@link EntityUnleashEvent#setDropLeash(boolean)}
   *   <li>{@link EntityUnleashEvent#getHandlerList()}
   *   <li>{@link EntityUnleashEvent#getHandlers()}
   *   <li>{@link EntityUnleashEvent#getReason()}
   *   <li>{@link EntityUnleashEvent#isCancelled()}
   *   <li>{@link EntityUnleashEvent#isDropLeash()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityUnleashEvent.<init>(Entity, UnleashReason)",
    "void EntityUnleashEvent.<init>(Entity, UnleashReason, boolean)",
    "HandlerList EntityUnleashEvent.getHandlerList()",
    "HandlerList EntityUnleashEvent.getHandlers()",
    "UnleashReason EntityUnleashEvent.getReason()",
    "boolean EntityUnleashEvent.isCancelled()",
    "boolean EntityUnleashEvent.isDropLeash()",
    "void EntityUnleashEvent.setCancelled(boolean)",
    "void EntityUnleashEvent.setDropLeash(boolean)"
  })
  void testGettersAndSetters_whenEntity() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityUnleashEvent actualEntityUnleashEvent =
        new EntityUnleashEvent(entity, UnleashReason.HOLDER_GONE);
    actualEntityUnleashEvent.setCancelled(true);
    actualEntityUnleashEvent.setDropLeash(true);
    HandlerList actualHandlerList = actualEntityUnleashEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityUnleashEvent.getHandlers();
    UnleashReason actualReason = actualEntityUnleashEvent.getReason();
    boolean actualIsCancelledResult = actualEntityUnleashEvent.isCancelled();
    boolean actualIsDropLeashResult = actualEntityUnleashEvent.isDropLeash();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(UnleashReason.HOLDER_GONE, actualReason);
    assertFalse(actualEntityUnleashEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsDropLeashResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityUnleashEvent.getEntity());
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
   *   <li>{@link EntityUnleashEvent#EntityUnleashEvent(Entity, UnleashReason, boolean)}
   *   <li>{@link EntityUnleashEvent#setCancelled(boolean)}
   *   <li>{@link EntityUnleashEvent#setDropLeash(boolean)}
   *   <li>{@link EntityUnleashEvent#getHandlerList()}
   *   <li>{@link EntityUnleashEvent#getHandlers()}
   *   <li>{@link EntityUnleashEvent#getReason()}
   *   <li>{@link EntityUnleashEvent#isCancelled()}
   *   <li>{@link EntityUnleashEvent#isDropLeash()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityUnleashEvent.<init>(Entity, UnleashReason)",
    "void EntityUnleashEvent.<init>(Entity, UnleashReason, boolean)",
    "HandlerList EntityUnleashEvent.getHandlerList()",
    "HandlerList EntityUnleashEvent.getHandlers()",
    "UnleashReason EntityUnleashEvent.getReason()",
    "boolean EntityUnleashEvent.isCancelled()",
    "boolean EntityUnleashEvent.isDropLeash()",
    "void EntityUnleashEvent.setCancelled(boolean)",
    "void EntityUnleashEvent.setDropLeash(boolean)"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange
    Entity entity = mock(Entity.class);

    // Act
    EntityUnleashEvent actualEntityUnleashEvent =
        new EntityUnleashEvent(entity, UnleashReason.HOLDER_GONE, true);
    actualEntityUnleashEvent.setCancelled(true);
    actualEntityUnleashEvent.setDropLeash(true);
    HandlerList actualHandlerList = actualEntityUnleashEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityUnleashEvent.getHandlers();
    UnleashReason actualReason = actualEntityUnleashEvent.getReason();
    boolean actualIsCancelledResult = actualEntityUnleashEvent.isCancelled();
    boolean actualIsDropLeashResult = actualEntityUnleashEvent.isDropLeash();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(UnleashReason.HOLDER_GONE, actualReason);
    assertFalse(actualEntityUnleashEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertTrue(actualIsDropLeashResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityUnleashEvent.getEntity());
  }
}
