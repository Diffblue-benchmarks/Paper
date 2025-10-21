package io.papermc.paper.event.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.kyori.adventure.text.Component;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerServerFullCheckEventDiffblueTest {
  /**
   * Test {@link PlayerServerFullCheckEvent#PlayerServerFullCheckEvent(PlayerProfile, Component,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return Allowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * PlayerServerFullCheckEvent#PlayerServerFullCheckEvent(PlayerProfile, Component, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerServerFullCheckEvent(PlayerProfile, Component, boolean); when 'false'; then return Allowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerServerFullCheckEvent.<init>(PlayerProfile, Component, boolean)"})
  void testNewPlayerServerFullCheckEvent_whenFalse_thenReturnAllowed() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);
    Component kickMessage = mock(Component.class);

    // Act
    PlayerServerFullCheckEvent actualPlayerServerFullCheckEvent =
        new PlayerServerFullCheckEvent(profile, kickMessage, false);

    // Assert
    assertEquals("PlayerServerFullCheckEvent", actualPlayerServerFullCheckEvent.getEventName());
    assertEquals(0, actualPlayerServerFullCheckEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerServerFullCheckEvent.isAsynchronous());
    assertTrue(actualPlayerServerFullCheckEvent.isAllowed());
    assertSame(profile, actualPlayerServerFullCheckEvent.getPlayerProfile());
    assertSame(kickMessage, actualPlayerServerFullCheckEvent.kickMessage());
  }

  /**
   * Test {@link PlayerServerFullCheckEvent#PlayerServerFullCheckEvent(PlayerProfile, Component,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return not Allowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * PlayerServerFullCheckEvent#PlayerServerFullCheckEvent(PlayerProfile, Component, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PlayerServerFullCheckEvent(PlayerProfile, Component, boolean); when 'true'; then return not Allowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlayerServerFullCheckEvent.<init>(PlayerProfile, Component, boolean)"})
  void testNewPlayerServerFullCheckEvent_whenTrue_thenReturnNotAllowed() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);
    Component kickMessage = mock(Component.class);

    // Act
    PlayerServerFullCheckEvent actualPlayerServerFullCheckEvent =
        new PlayerServerFullCheckEvent(profile, kickMessage, true);

    // Assert
    assertEquals("PlayerServerFullCheckEvent", actualPlayerServerFullCheckEvent.getEventName());
    assertEquals(0, actualPlayerServerFullCheckEvent.getHandlers().getRegisteredListeners().length);
    assertFalse(actualPlayerServerFullCheckEvent.isAllowed());
    assertFalse(actualPlayerServerFullCheckEvent.isAsynchronous());
    assertSame(profile, actualPlayerServerFullCheckEvent.getPlayerProfile());
    assertSame(kickMessage, actualPlayerServerFullCheckEvent.kickMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlayerServerFullCheckEvent#allow(boolean)}
   *   <li>{@link PlayerServerFullCheckEvent#deny(Component)}
   *   <li>{@link PlayerServerFullCheckEvent#getHandlerList()}
   *   <li>{@link PlayerServerFullCheckEvent#getHandlers()}
   *   <li>{@link PlayerServerFullCheckEvent#getPlayerProfile()}
   *   <li>{@link PlayerServerFullCheckEvent#isAllowed()}
   *   <li>{@link PlayerServerFullCheckEvent#kickMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PlayerServerFullCheckEvent.allow(boolean)",
    "void PlayerServerFullCheckEvent.deny(Component)",
    "HandlerList PlayerServerFullCheckEvent.getHandlerList()",
    "HandlerList PlayerServerFullCheckEvent.getHandlers()",
    "PlayerProfile PlayerServerFullCheckEvent.getPlayerProfile()",
    "boolean PlayerServerFullCheckEvent.isAllowed()",
    "Component PlayerServerFullCheckEvent.kickMessage()"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerServerFullCheckEvent playerServerFullCheckEvent =
        new PlayerServerFullCheckEvent(mock(PlayerProfile.class), mock(Component.class), true);

    // Act
    playerServerFullCheckEvent.allow(true);
    Component kickMessage = mock(Component.class);
    playerServerFullCheckEvent.deny(kickMessage);
    HandlerList actualHandlerList = playerServerFullCheckEvent.getHandlerList();
    HandlerList actualHandlers = playerServerFullCheckEvent.getHandlers();
    playerServerFullCheckEvent.getPlayerProfile();
    boolean actualIsAllowedResult = playerServerFullCheckEvent.isAllowed();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualIsAllowedResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(kickMessage, playerServerFullCheckEvent.kickMessage());
  }
}
