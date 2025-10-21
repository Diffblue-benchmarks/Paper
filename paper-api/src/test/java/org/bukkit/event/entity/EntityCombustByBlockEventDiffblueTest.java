package org.bukkit.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityCombustByBlockEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCombustByBlockEvent#EntityCombustByBlockEvent(Block, Entity, float)}
   *   <li>{@link EntityCombustByBlockEvent#getCombuster()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCombustByBlockEvent.<init>(Block, Entity, float)",
    "Block EntityCombustByBlockEvent.getCombuster()"
  })
  void testGettersAndSetters() {
    // Arrange
    Block combuster = mock(Block.class);
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustByBlockEvent actualEntityCombustByBlockEvent =
        new EntityCombustByBlockEvent(combuster, combustee, 10.0f);
    Block actualCombuster = actualEntityCombustByBlockEvent.getCombuster();

    // Assert
    assertEquals(10.0f, actualEntityCombustByBlockEvent.getDuration());
    assertFalse(actualEntityCombustByBlockEvent.isAsynchronous());
    assertFalse(actualEntityCombustByBlockEvent.isCancelled());
    assertSame(combuster, actualCombuster);
    assertSame(combustee, actualEntityCombustByBlockEvent.getEntity());
  }

  /**
   * Test {@link EntityCombustByBlockEvent#EntityCombustByBlockEvent(Block, Entity, int)}.
   *
   * <p>Method under test: {@link EntityCombustByBlockEvent#EntityCombustByBlockEvent(Block, Entity,
   * int)}
   */
  @Test
  @DisplayName("Test new EntityCombustByBlockEvent(Block, Entity, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityCombustByBlockEvent.<init>(Block, Entity, int)"})
  void testNewEntityCombustByBlockEvent() {
    // Arrange
    Block combuster = mock(Block.class);
    Entity combustee = mock(Entity.class);

    // Act
    EntityCombustByBlockEvent actualEntityCombustByBlockEvent =
        new EntityCombustByBlockEvent(combuster, combustee, 1);

    // Assert
    assertEquals("EntityCombustByBlockEvent", actualEntityCombustByBlockEvent.getEventName());
    assertNull(actualEntityCombustByBlockEvent.getEntityType());
    assertEquals(0, actualEntityCombustByBlockEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(1.0f, actualEntityCombustByBlockEvent.getDuration());
    assertFalse(actualEntityCombustByBlockEvent.isAsynchronous());
    assertFalse(actualEntityCombustByBlockEvent.isCancelled());
    assertSame(combuster, actualEntityCombustByBlockEvent.getCombuster());
    assertSame(combustee, actualEntityCombustByBlockEvent.getEntity());
  }
}
