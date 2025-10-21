package com.destroystokyo.paper.event.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnderDragonShootFireballEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnderDragonShootFireballEvent#EnderDragonShootFireballEvent(EnderDragon,
   *       DragonFireball)}
   *   <li>{@link EnderDragonShootFireballEvent#setCancelled(boolean)}
   *   <li>{@link EnderDragonShootFireballEvent#getHandlerList()}
   *   <li>{@link EnderDragonShootFireballEvent#getFireball()}
   *   <li>{@link EnderDragonShootFireballEvent#getHandlers()}
   *   <li>{@link EnderDragonShootFireballEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnderDragonShootFireballEvent.<init>(EnderDragon, DragonFireball)",
    "DragonFireball EnderDragonShootFireballEvent.getFireball()",
    "HandlerList EnderDragonShootFireballEvent.getHandlerList()",
    "HandlerList EnderDragonShootFireballEvent.getHandlers()",
    "boolean EnderDragonShootFireballEvent.isCancelled()",
    "void EnderDragonShootFireballEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    EnderDragon entity = mock(EnderDragon.class);
    DragonFireball fireball = mock(DragonFireball.class);

    // Act
    EnderDragonShootFireballEvent actualEnderDragonShootFireballEvent =
        new EnderDragonShootFireballEvent(entity, fireball);
    actualEnderDragonShootFireballEvent.setCancelled(true);
    HandlerList actualHandlerList = actualEnderDragonShootFireballEvent.getHandlerList();
    DragonFireball actualFireball = actualEnderDragonShootFireballEvent.getFireball();
    HandlerList actualHandlers = actualEnderDragonShootFireballEvent.getHandlers();
    boolean actualIsCancelledResult = actualEnderDragonShootFireballEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualEnderDragonShootFireballEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(fireball, actualFireball);
    assertSame(entity, actualEnderDragonShootFireballEvent.getEntity());
  }
}
