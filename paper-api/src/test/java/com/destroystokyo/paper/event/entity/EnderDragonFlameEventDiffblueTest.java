package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnderDragonFlameEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnderDragonFlameEvent#EnderDragonFlameEvent(EnderDragon, AreaEffectCloud)}
   *   <li>{@link EnderDragonFlameEvent#setCancelled(boolean)}
   *   <li>{@link EnderDragonFlameEvent#getHandlerList()}
   *   <li>{@link EnderDragonFlameEvent#getAreaEffectCloud()}
   *   <li>{@link EnderDragonFlameEvent#getHandlers()}
   *   <li>{@link EnderDragonFlameEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnderDragonFlameEvent.<init>(EnderDragon, AreaEffectCloud)",
    "AreaEffectCloud EnderDragonFlameEvent.getAreaEffectCloud()",
    "HandlerList EnderDragonFlameEvent.getHandlerList()",
    "HandlerList EnderDragonFlameEvent.getHandlers()",
    "boolean EnderDragonFlameEvent.isCancelled()",
    "void EnderDragonFlameEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EnderDragon enderDragon = mock(EnderDragon.class);
    AreaEffectCloud areaEffectCloud = mock(AreaEffectCloud.class);

    // Act
    EnderDragonFlameEvent actualEnderDragonFlameEvent =
        new EnderDragonFlameEvent(enderDragon, areaEffectCloud);
    actualEnderDragonFlameEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEnderDragonFlameEvent.getHandlerList();
    AreaEffectCloud actualAreaEffectCloud = actualEnderDragonFlameEvent.getAreaEffectCloud();
    HandlerList actualHandlers = actualEnderDragonFlameEvent.getHandlers();
    boolean actualIsCancelledResult = actualEnderDragonFlameEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEnderDragonFlameEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(areaEffectCloud, actualAreaEffectCloud);
    assertSame(enderDragon, actualEnderDragonFlameEvent.getEntity());
  }
}
