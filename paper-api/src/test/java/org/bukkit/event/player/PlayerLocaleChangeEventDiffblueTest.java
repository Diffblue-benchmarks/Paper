package org.bukkit.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerLocaleChangeEventDiffblueTest {
  /**
   * Test {@link PlayerLocaleChangeEvent#PlayerLocaleChangeEvent(Player, String)}.
   *
   * <p>Method under test: {@link PlayerLocaleChangeEvent#PlayerLocaleChangeEvent(Player, String)}
   */
  @Test
  @DisplayName("Test new PlayerLocaleChangeEvent(Player, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerLocaleChangeEvent.<init>(Player, String)"})
  void testNewPlayerLocaleChangeEvent() {
    // Arrange
    Player player = mock(Player.class);

    // Act
    PlayerLocaleChangeEvent actualPlayerLocaleChangeEvent =
        new PlayerLocaleChangeEvent(player, "en");

    // Assert
    assertEquals("PlayerLocaleChangeEvent", actualPlayerLocaleChangeEvent.getEventName());
    assertEquals("en", actualPlayerLocaleChangeEvent.getLocale());
    assertFalse(actualPlayerLocaleChangeEvent.isAsynchronous());
    assertSame(player, actualPlayerLocaleChangeEvent.getPlayer());
  }

  /**
   * Test {@link PlayerLocaleChangeEvent#locale()}.
   *
   * <p>Method under test: {@link PlayerLocaleChangeEvent#locale()}
   */
  @Test
  @DisplayName("Test locale()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale PlayerLocaleChangeEvent.locale()"})
  void testLocale() {
    // Arrange, Act and Assert
    assertEquals(Locale.ENGLISH, new PlayerLocaleChangeEvent(mock(Player.class), "en").locale());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerLocaleChangeEvent#getHandlerList()}
   *   <li>{@link PlayerLocaleChangeEvent#getHandlers()}
   *   <li>{@link PlayerLocaleChangeEvent#getLocale()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HandlerList PlayerLocaleChangeEvent.getHandlerList()",
    "HandlerList PlayerLocaleChangeEvent.getHandlers()",
    "String PlayerLocaleChangeEvent.getLocale()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerLocaleChangeEvent playerLocaleChangeEvent =
        new PlayerLocaleChangeEvent(mock(Player.class), "en");

    // Act
    HandlerList actualHandlerList = playerLocaleChangeEvent.getHandlerList();
    HandlerList actualHandlers = playerLocaleChangeEvent.getHandlers();

    // Assert
    assertEquals("en", playerLocaleChangeEvent.getLocale());
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertSame(actualHandlerList, actualHandlers);
  }
}
