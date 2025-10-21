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
import org.bukkit.event.HandlerList;
import org.bukkit.potion.PotionEffectType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityEffectTickEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityEffectTickEvent#EntityEffectTickEvent(LivingEntity, PotionEffectType, int)}
   *   <li>{@link EntityEffectTickEvent#setCancelled(boolean)}
   *   <li>{@link EntityEffectTickEvent#getHandlerList()}
   *   <li>{@link EntityEffectTickEvent#getAmplifier()}
   *   <li>{@link EntityEffectTickEvent#getHandlers()}
   *   <li>{@link EntityEffectTickEvent#getType()}
   *   <li>{@link EntityEffectTickEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityEffectTickEvent.<init>(LivingEntity, PotionEffectType, int)",
    "int EntityEffectTickEvent.getAmplifier()",
    "HandlerList EntityEffectTickEvent.getHandlerList()",
    "HandlerList EntityEffectTickEvent.getHandlers()",
    "PotionEffectType EntityEffectTickEvent.getType()",
    "boolean EntityEffectTickEvent.isCancelled()",
    "void EntityEffectTickEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    LivingEntity entity = mock(LivingEntity.class);

    // Act
    EntityEffectTickEvent actualEntityEffectTickEvent = new EntityEffectTickEvent(entity, null, 1);
    actualEntityEffectTickEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEntityEffectTickEvent.getHandlerList();
    int actualAmplifier = actualEntityEffectTickEvent.getAmplifier();
    HandlerList actualHandlers = actualEntityEffectTickEvent.getHandlers();
    PotionEffectType actualType = actualEntityEffectTickEvent.getType();
    boolean actualIsCancelledResult = actualEntityEffectTickEvent.isCancelled();

    // Assert
    assertNull(actualType);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertEquals(1, actualAmplifier);
    assertFalse(actualEntityEffectTickEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(entity, actualEntityEffectTickEvent.getEntity());
  }
}
