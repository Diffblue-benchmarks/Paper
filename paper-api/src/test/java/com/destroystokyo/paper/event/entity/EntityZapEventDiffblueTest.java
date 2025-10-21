package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.event.entity.EntityTransformEvent.TransformReason;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityZapEventDiffblueTest {
  /**
   * Test {@link EntityZapEvent#EntityZapEvent(Entity, LightningStrike, Entity)}.
   *
   * <p>Method under test: {@link EntityZapEvent#EntityZapEvent(Entity, LightningStrike, Entity)}
   */
  @Test
  @DisplayName("Test new EntityZapEvent(Entity, LightningStrike, Entity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityZapEvent.<init>(Entity, LightningStrike, Entity)"})
  void testNewEntityZapEvent() {
    // Arrange
    Entity entity = mock(Entity.class);
    LightningStrike bolt = mock(LightningStrike.class);
    Entity replacementEntity = mock(Entity.class);

    // Act
    EntityZapEvent actualEntityZapEvent = new EntityZapEvent(entity, bolt, replacementEntity);

    // Assert
    assertEquals("EntityZapEvent", actualEntityZapEvent.getEventName());
    assertNull(actualEntityZapEvent.getEntityType());
    assertEquals(0, actualEntityZapEvent.getHandlers().getRegisteredListeners().length);
    List<Entity> transformedEntities = actualEntityZapEvent.getTransformedEntities();
    assertEquals(1, transformedEntities.size());
    assertEquals(TransformReason.LIGHTNING, actualEntityZapEvent.getTransformReason());
    assertFalse(actualEntityZapEvent.isCancelled());
    assertFalse(actualEntityZapEvent.isAsynchronous());
    assertSame(replacementEntity, actualEntityZapEvent.getReplacementEntity());
    assertSame(replacementEntity, transformedEntities.get(0));
    assertSame(entity, actualEntityZapEvent.getEntity());
    assertSame(replacementEntity, actualEntityZapEvent.getTransformedEntity());
    assertSame(bolt, actualEntityZapEvent.getBolt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityZapEvent#setCancelled(boolean)}
   *   <li>{@link EntityZapEvent#getHandlerList()}
   *   <li>{@link EntityZapEvent#getBolt()}
   *   <li>{@link EntityZapEvent#getHandlers()}
   *   <li>{@link EntityZapEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LightningStrike EntityZapEvent.getBolt()",
    "HandlerList EntityZapEvent.getHandlerList()",
    "HandlerList EntityZapEvent.getHandlers()",
    "boolean EntityZapEvent.isCancelled()",
    "void EntityZapEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityZapEvent entityZapEvent =
        new EntityZapEvent(mock(Entity.class), mock(LightningStrike.class), mock(Entity.class));

    // Act
    entityZapEvent.setCancelled(true);
    HandlerList actualHandlerList = entityZapEvent.getHandlerList();
    entityZapEvent.getBolt();
    HandlerList actualHandlers = entityZapEvent.getHandlers();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(entityZapEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
  }
}
