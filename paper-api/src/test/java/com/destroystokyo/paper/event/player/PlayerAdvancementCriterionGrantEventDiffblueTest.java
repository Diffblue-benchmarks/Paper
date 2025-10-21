package com.destroystokyo.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerAdvancementCriterionGrantEventDiffblueTest {
  /**
   * Test {@link PlayerAdvancementCriterionGrantEvent#PlayerAdvancementCriterionGrantEvent(Player,
   * Advancement, String)}.
   *
   * <p>Method under test: {@link
   * PlayerAdvancementCriterionGrantEvent#PlayerAdvancementCriterionGrantEvent(Player, Advancement,
   * String)}
   */
  @Test
  @DisplayName("Test new PlayerAdvancementCriterionGrantEvent(Player, Advancement, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAdvancementCriterionGrantEvent.<init>(Player, Advancement, String)"
  })
  void testNewPlayerAdvancementCriterionGrantEvent() {
    // Arrange
    Player player = mock(Player.class);
    when(player.getAdvancementProgress(Mockito.<Advancement>any()))
        .thenReturn(mock(AdvancementProgress.class));
    Advancement advancement = mock(Advancement.class);

    // Act
    PlayerAdvancementCriterionGrantEvent actualPlayerAdvancementCriterionGrantEvent =
        new PlayerAdvancementCriterionGrantEvent(player, advancement, "Criterion");

    // Assert
    verify(player).getAdvancementProgress(isA(Advancement.class));
    assertEquals("Criterion", actualPlayerAdvancementCriterionGrantEvent.getCriterion());
    assertEquals(
        "PlayerAdvancementCriterionGrantEvent",
        actualPlayerAdvancementCriterionGrantEvent.getEventName());
    assertEquals(
        0,
        actualPlayerAdvancementCriterionGrantEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerAdvancementCriterionGrantEvent.isCancelled());
    assertFalse(actualPlayerAdvancementCriterionGrantEvent.isAsynchronous());
    assertSame(advancement, actualPlayerAdvancementCriterionGrantEvent.getAdvancement());
    assertSame(player, actualPlayerAdvancementCriterionGrantEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#setCancelled(boolean)}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#getHandlerList()}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#getAdvancement()}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#getAdvancementProgress()}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#getCriterion()}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#getHandlers()}
   *   <li>{@link PlayerAdvancementCriterionGrantEvent#isCancelled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Advancement PlayerAdvancementCriterionGrantEvent.getAdvancement()",
    "AdvancementProgress PlayerAdvancementCriterionGrantEvent.getAdvancementProgress()",
    "String PlayerAdvancementCriterionGrantEvent.getCriterion()",
    "HandlerList PlayerAdvancementCriterionGrantEvent.getHandlerList()",
    "HandlerList PlayerAdvancementCriterionGrantEvent.getHandlers()",
    "boolean PlayerAdvancementCriterionGrantEvent.isCancelled()",
    "void PlayerAdvancementCriterionGrantEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerAdvancementCriterionGrantEvent playerAdvancementCriterionGrantEvent =
        new PlayerAdvancementCriterionGrantEvent(
            mock(Player.class), mock(Advancement.class), "Criterion");

    // Act
    playerAdvancementCriterionGrantEvent.setCancelled(true);
    HandlerList actualHandlerList = playerAdvancementCriterionGrantEvent.getHandlerList();
    playerAdvancementCriterionGrantEvent.getAdvancement();
    AdvancementProgress actualAdvancementProgress =
        playerAdvancementCriterionGrantEvent.getAdvancementProgress();
    String actualCriterion = playerAdvancementCriterionGrantEvent.getCriterion();
    HandlerList actualHandlers = playerAdvancementCriterionGrantEvent.getHandlers();

    // Assert
    assertEquals("Criterion", actualCriterion);
    assertNull(actualAdvancementProgress);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(playerAdvancementCriterionGrantEvent.isCancelled());
    assertSame(actualHandlerList, actualHandlers);
  }
}
