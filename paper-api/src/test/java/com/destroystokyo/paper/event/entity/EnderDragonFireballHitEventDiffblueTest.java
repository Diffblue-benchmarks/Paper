package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnderDragonFireballHitEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnderDragonFireballHitEvent#EnderDragonFireballHitEvent(DragonFireball,
   *       Collection, AreaEffectCloud)}
   *   <li>{@link EnderDragonFireballHitEvent#setCancelled(boolean)}
   *   <li>{@link EnderDragonFireballHitEvent#getHandlerList()}
   *   <li>{@link EnderDragonFireballHitEvent#getAreaEffectCloud()}
   *   <li>{@link EnderDragonFireballHitEvent#getHandlers()}
   *   <li>{@link EnderDragonFireballHitEvent#getTargets()}
   *   <li>{@link EnderDragonFireballHitEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnderDragonFireballHitEvent.<init>(DragonFireball, Collection, AreaEffectCloud)",
    "AreaEffectCloud EnderDragonFireballHitEvent.getAreaEffectCloud()",
    "HandlerList EnderDragonFireballHitEvent.getHandlerList()",
    "HandlerList EnderDragonFireballHitEvent.getHandlers()",
    "Collection EnderDragonFireballHitEvent.getTargets()",
    "boolean EnderDragonFireballHitEvent.isCancelled()",
    "void EnderDragonFireballHitEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    DragonFireball fireball = mock(DragonFireball.class);
    ArrayList<LivingEntity> targets = new ArrayList<>();
    AreaEffectCloud areaEffectCloud = mock(AreaEffectCloud.class);

    // Act
    EnderDragonFireballHitEvent actualEnderDragonFireballHitEvent =
        new EnderDragonFireballHitEvent(fireball, targets, areaEffectCloud);
    actualEnderDragonFireballHitEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEnderDragonFireballHitEvent.getHandlerList();
    AreaEffectCloud actualAreaEffectCloud = actualEnderDragonFireballHitEvent.getAreaEffectCloud();
    HandlerList actualHandlers = actualEnderDragonFireballHitEvent.getHandlers();
    Collection<LivingEntity> actualTargets = actualEnderDragonFireballHitEvent.getTargets();
    boolean actualIsCancelledResult = actualEnderDragonFireballHitEvent.isCancelled();

    // Assert
    assertTrue(actualTargets instanceof List);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEnderDragonFireballHitEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(targets, actualTargets);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(areaEffectCloud, actualAreaEffectCloud);
    assertSame(fireball, actualEnderDragonFireballHitEvent.getEntity());
  }
}
