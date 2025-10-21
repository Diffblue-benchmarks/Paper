package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerPickupExperienceEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerPickupExperienceEvent#PlayerPickupExperienceEvent(Player, ExperienceOrb)}
   *   <li>{@link PlayerPickupExperienceEvent#setCancelled(boolean)}
   *   <li>{@link PlayerPickupExperienceEvent#getHandlerList()}
   *   <li>{@link PlayerPickupExperienceEvent#getExperienceOrb()}
   *   <li>{@link PlayerPickupExperienceEvent#getHandlers()}
   *   <li>{@link PlayerPickupExperienceEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerPickupExperienceEvent.<init>(Player, ExperienceOrb)",
    "ExperienceOrb PlayerPickupExperienceEvent.getExperienceOrb()",
    "HandlerList PlayerPickupExperienceEvent.getHandlerList()",
    "HandlerList PlayerPickupExperienceEvent.getHandlers()",
    "boolean PlayerPickupExperienceEvent.isCancelled()",
    "void PlayerPickupExperienceEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    Player player = mock(Player.class);
    ExperienceOrb experienceOrb = mock(ExperienceOrb.class);

    // Act
    PlayerPickupExperienceEvent actualPlayerPickupExperienceEvent =
        new PlayerPickupExperienceEvent(player, experienceOrb);
    actualPlayerPickupExperienceEvent.setCancelled(true);
    HandlerList actualHandlerList = actualPlayerPickupExperienceEvent.getHandlerList();
    ExperienceOrb actualExperienceOrb = actualPlayerPickupExperienceEvent.getExperienceOrb();
    HandlerList actualHandlers = actualPlayerPickupExperienceEvent.getHandlers();
    boolean actualIsCancelledResult = actualPlayerPickupExperienceEvent.isCancelled();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerPickupExperienceEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(experienceOrb, actualExperienceOrb);
    assertSame(player, actualPlayerPickupExperienceEvent.getPlayer());
  }
}
