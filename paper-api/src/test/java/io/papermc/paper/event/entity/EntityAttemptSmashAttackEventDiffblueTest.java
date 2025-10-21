package io.papermc.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Result;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityAttemptSmashAttackEventDiffblueTest {
  /**
   * Test {@link EntityAttemptSmashAttackEvent#EntityAttemptSmashAttackEvent(LivingEntity,
   * LivingEntity, ItemStack, boolean)}.
   *
   * <p>Method under test: {@link
   * EntityAttemptSmashAttackEvent#EntityAttemptSmashAttackEvent(LivingEntity, LivingEntity,
   * ItemStack, boolean)}
   */
  @Test
  @DisplayName(
      "Test new EntityAttemptSmashAttackEvent(LivingEntity, LivingEntity, ItemStack, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAttemptSmashAttackEvent.<init>(LivingEntity, LivingEntity, ItemStack, boolean)"
  })
  void testNewEntityAttemptSmashAttackEvent() {
    // Arrange
    LivingEntity attacker = mock(LivingEntity.class);
    LivingEntity target = mock(LivingEntity.class);

    // Act
    EntityAttemptSmashAttackEvent actualEntityAttemptSmashAttackEvent =
        new EntityAttemptSmashAttackEvent(attacker, target, null, true);

    // Assert
    assertEquals(
        "EntityAttemptSmashAttackEvent", actualEntityAttemptSmashAttackEvent.getEventName());
    assertNull(actualEntityAttemptSmashAttackEvent.getEntityType());
    assertEquals(
        0, actualEntityAttemptSmashAttackEvent.getHandlers().getRegisteredListeners().length);
    assertEquals(Result.DEFAULT, actualEntityAttemptSmashAttackEvent.getResult());
    assertFalse(actualEntityAttemptSmashAttackEvent.isAsynchronous());
    assertTrue(actualEntityAttemptSmashAttackEvent.getOriginalResult());
    assertSame(target, actualEntityAttemptSmashAttackEvent.getTarget());
    assertSame(attacker, actualEntityAttemptSmashAttackEvent.getEntity());
  }
}
