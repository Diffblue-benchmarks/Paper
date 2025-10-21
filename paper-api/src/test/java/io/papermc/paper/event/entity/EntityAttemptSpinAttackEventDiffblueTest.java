package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityAttemptSpinAttackEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAttemptSpinAttackEvent#EntityAttemptSpinAttackEvent(LivingEntity,
   *       LivingEntity)}
   *   <li>{@link EntityAttemptSpinAttackEvent#setCancelled(boolean)}
   *   <li>{@link EntityAttemptSpinAttackEvent#getHandlerList()}
   *   <li>{@link EntityAttemptSpinAttackEvent#getHandlers()}
   *   <li>{@link EntityAttemptSpinAttackEvent#getTarget()}
   *   <li>{@link EntityAttemptSpinAttackEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAttemptSpinAttackEvent.<init>(LivingEntity, LivingEntity)",
    "HandlerList EntityAttemptSpinAttackEvent.getHandlerList()",
    "HandlerList EntityAttemptSpinAttackEvent.getHandlers()",
    "LivingEntity EntityAttemptSpinAttackEvent.getTarget()",
    "boolean EntityAttemptSpinAttackEvent.isCancelled()",
    "void EntityAttemptSpinAttackEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);
    LivingEntity target = mock(LivingEntity.class);

    // Act
    EntityAttemptSpinAttackEvent actualEntityAttemptSpinAttackEvent =
        new EntityAttemptSpinAttackEvent(entity, target);
    actualEntityAttemptSpinAttackEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityAttemptSpinAttackEvent.getHandlerList();
    HandlerList actualHandlers = actualEntityAttemptSpinAttackEvent.getHandlers();
    LivingEntity actualTarget = actualEntityAttemptSpinAttackEvent.getTarget();
    boolean actualIsCancelledResult = actualEntityAttemptSpinAttackEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEntityAttemptSpinAttackEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityAttemptSpinAttackEvent.getEntity());
    assertSame(target, actualTarget);
  }
}
