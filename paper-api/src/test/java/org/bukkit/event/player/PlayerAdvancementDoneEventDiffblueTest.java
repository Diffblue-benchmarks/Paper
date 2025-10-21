package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerAdvancementDoneEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Advancement}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAdvancementDoneEvent#PlayerAdvancementDoneEvent(Player, Advancement)}
   *   <li>{@link PlayerAdvancementDoneEvent#message(Component)}
   *   <li>{@link PlayerAdvancementDoneEvent#getHandlerList()}
   *   <li>{@link PlayerAdvancementDoneEvent#getAdvancement()}
   *   <li>{@link PlayerAdvancementDoneEvent#getHandlers()}
   *   <li>{@link PlayerAdvancementDoneEvent#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Advancement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAdvancementDoneEvent.<init>(Player, Advancement)",
    "void PlayerAdvancementDoneEvent.<init>(Player, Advancement, Component)",
    "Advancement PlayerAdvancementDoneEvent.getAdvancement()",
    "HandlerList PlayerAdvancementDoneEvent.getHandlerList()",
    "HandlerList PlayerAdvancementDoneEvent.getHandlers()",
    "Component PlayerAdvancementDoneEvent.message()",
    "void PlayerAdvancementDoneEvent.message(Component)"
  })
  void testGettersAndSetters_whenAdvancement() {
    // Arrange
    Player player = mock(Player.class);
    Advancement advancement = mock(Advancement.class);

    // Act
    PlayerAdvancementDoneEvent actualPlayerAdvancementDoneEvent =
        new PlayerAdvancementDoneEvent(player, advancement);
    Component message = mock(Component.class);
    actualPlayerAdvancementDoneEvent.message(message);
    HandlerList actualHandlerList = actualPlayerAdvancementDoneEvent.getHandlerList();
    Advancement actualAdvancement = actualPlayerAdvancementDoneEvent.getAdvancement();
    HandlerList actualHandlers = actualPlayerAdvancementDoneEvent.getHandlers();
    Component actualMessageResult = actualPlayerAdvancementDoneEvent.message();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerAdvancementDoneEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message, actualMessageResult);
    assertSame(advancement, actualAdvancement);
    assertSame(player, actualPlayerAdvancementDoneEvent.getPlayer());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Component}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerAdvancementDoneEvent#PlayerAdvancementDoneEvent(Player, Advancement,
   *       Component)}
   *   <li>{@link PlayerAdvancementDoneEvent#message(Component)}
   *   <li>{@link PlayerAdvancementDoneEvent#getHandlerList()}
   *   <li>{@link PlayerAdvancementDoneEvent#getAdvancement()}
   *   <li>{@link PlayerAdvancementDoneEvent#getHandlers()}
   *   <li>{@link PlayerAdvancementDoneEvent#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Component")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerAdvancementDoneEvent.<init>(Player, Advancement)",
    "void PlayerAdvancementDoneEvent.<init>(Player, Advancement, Component)",
    "Advancement PlayerAdvancementDoneEvent.getAdvancement()",
    "HandlerList PlayerAdvancementDoneEvent.getHandlerList()",
    "HandlerList PlayerAdvancementDoneEvent.getHandlers()",
    "Component PlayerAdvancementDoneEvent.message()",
    "void PlayerAdvancementDoneEvent.message(Component)"
  })
  void testGettersAndSetters_whenComponent() {
    // Arrange
    Player player = mock(Player.class);
    Advancement advancement = mock(Advancement.class);

    // Act
    PlayerAdvancementDoneEvent actualPlayerAdvancementDoneEvent =
        new PlayerAdvancementDoneEvent(player, advancement, mock(Component.class));
    Component message = mock(Component.class);
    actualPlayerAdvancementDoneEvent.message(message);
    HandlerList actualHandlerList = actualPlayerAdvancementDoneEvent.getHandlerList();
    Advancement actualAdvancement = actualPlayerAdvancementDoneEvent.getAdvancement();
    HandlerList actualHandlers = actualPlayerAdvancementDoneEvent.getHandlers();
    Component actualMessageResult = actualPlayerAdvancementDoneEvent.message();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualPlayerAdvancementDoneEvent.isAsynchronous());
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message, actualMessageResult);
    assertSame(advancement, actualAdvancement);
    assertSame(player, actualPlayerAdvancementDoneEvent.getPlayer());
  }
}
