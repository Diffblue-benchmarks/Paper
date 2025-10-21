package com.destroystokyo.paper.event.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfileWhitelistVerifyEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProfileWhitelistVerifyEvent#ProfileWhitelistVerifyEvent(PlayerProfile, boolean,
   *       boolean, boolean, Component)}
   *   <li>{@link ProfileWhitelistVerifyEvent#kickMessage(Component)}
   *   <li>{@link ProfileWhitelistVerifyEvent#setWhitelisted(boolean)}
   *   <li>{@link ProfileWhitelistVerifyEvent#getHandlerList()}
   *   <li>{@link ProfileWhitelistVerifyEvent#getHandlers()}
   *   <li>{@link ProfileWhitelistVerifyEvent#getPlayerProfile()}
   *   <li>{@link ProfileWhitelistVerifyEvent#isOp()}
   *   <li>{@link ProfileWhitelistVerifyEvent#isWhitelistEnabled()}
   *   <li>{@link ProfileWhitelistVerifyEvent#isWhitelisted()}
   *   <li>{@link ProfileWhitelistVerifyEvent#kickMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProfileWhitelistVerifyEvent.<init>(PlayerProfile, boolean, boolean, boolean, Component)",
    "HandlerList ProfileWhitelistVerifyEvent.getHandlerList()",
    "HandlerList ProfileWhitelistVerifyEvent.getHandlers()",
    "PlayerProfile ProfileWhitelistVerifyEvent.getPlayerProfile()",
    "boolean ProfileWhitelistVerifyEvent.isOp()",
    "boolean ProfileWhitelistVerifyEvent.isWhitelistEnabled()",
    "boolean ProfileWhitelistVerifyEvent.isWhitelisted()",
    "Component ProfileWhitelistVerifyEvent.kickMessage()",
    "void ProfileWhitelistVerifyEvent.kickMessage(Component)",
    "void ProfileWhitelistVerifyEvent.setWhitelisted(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PlayerProfile profile = mock(PlayerProfile.class);

    // Act
    ProfileWhitelistVerifyEvent actualProfileWhitelistVerifyEvent =
        new ProfileWhitelistVerifyEvent(profile, true, true, true, mock(Component.class));
    Component kickMessage = mock(Component.class);
    actualProfileWhitelistVerifyEvent.kickMessage(kickMessage);
    actualProfileWhitelistVerifyEvent.setWhitelisted(true);
    HandlerList actualHandlerList = actualProfileWhitelistVerifyEvent.getHandlerList();
    HandlerList actualHandlers = actualProfileWhitelistVerifyEvent.getHandlers();
    PlayerProfile actualPlayerProfile = actualProfileWhitelistVerifyEvent.getPlayerProfile();
    boolean actualIsOpResult = actualProfileWhitelistVerifyEvent.isOp();
    boolean actualIsWhitelistEnabledResult = actualProfileWhitelistVerifyEvent.isWhitelistEnabled();
    boolean actualIsWhitelistedResult = actualProfileWhitelistVerifyEvent.isWhitelisted();
    Component actualKickMessageResult = actualProfileWhitelistVerifyEvent.kickMessage();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualProfileWhitelistVerifyEvent.isAsynchronous());
    assertTrue(actualIsOpResult);
    assertTrue(actualIsWhitelistEnabledResult);
    assertTrue(actualIsWhitelistedResult);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(profile, actualPlayerProfile);
    assertSame(kickMessage, actualKickMessageResult);
  }

  /**
   * Test {@link ProfileWhitelistVerifyEvent#getKickMessage()}.
   *
   * <ul>
   *   <li>Given {@link Style} {@link Style#color()} return {@link TextColor}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProfileWhitelistVerifyEvent#getKickMessage()}
   */
  @Test
  @DisplayName(
      "Test getKickMessage(); given Style color() return TextColor; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProfileWhitelistVerifyEvent.getKickMessage()"})
  void testGetKickMessage_givenStyleColorReturnTextColor_thenReturnEmptyString() {
    // Arrange
    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component kickMessage = mock(Component.class);
    when(kickMessage.children()).thenReturn(new ArrayList<>());
    when(kickMessage.style()).thenReturn(style);
    ProfileWhitelistVerifyEvent profileWhitelistVerifyEvent =
        new ProfileWhitelistVerifyEvent(mock(PlayerProfile.class), true, true, true, kickMessage);

    // Act
    String actualKickMessage = profileWhitelistVerifyEvent.getKickMessage();

    // Assert
    verify(kickMessage).children();
    verify(kickMessage).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    assertEquals("", actualKickMessage);
  }

  /**
   * Test {@link ProfileWhitelistVerifyEvent#getKickMessage()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProfileWhitelistVerifyEvent#getKickMessage()}
   */
  @Test
  @DisplayName("Test getKickMessage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProfileWhitelistVerifyEvent.getKickMessage()"})
  void testGetKickMessage_thenReturnNull() {
    // Arrange
    ProfileWhitelistVerifyEvent profileWhitelistVerifyEvent =
        new ProfileWhitelistVerifyEvent(mock(PlayerProfile.class), true, true, true, null);

    // Act and Assert
    assertNull(profileWhitelistVerifyEvent.getKickMessage());
  }

  /**
   * Test {@link ProfileWhitelistVerifyEvent#setKickMessage(String)}.
   *
   * <p>Method under test: {@link ProfileWhitelistVerifyEvent#setKickMessage(String)}
   */
  @Test
  @DisplayName("Test setKickMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProfileWhitelistVerifyEvent.setKickMessage(String)"})
  void testSetKickMessage() {
    // Arrange
    ProfileWhitelistVerifyEvent profileWhitelistVerifyEvent =
        new ProfileWhitelistVerifyEvent(
            mock(PlayerProfile.class), true, true, true, mock(Component.class));

    // Act
    profileWhitelistVerifyEvent.setKickMessage("Kick Message");

    // Assert
    assertEquals("Kick Message", profileWhitelistVerifyEvent.getKickMessage());
    Component kickMessageResult = profileWhitelistVerifyEvent.kickMessage();
    assertNull(kickMessageResult.insertion());
    assertNull(kickMessageResult.font());
    assertNull(kickMessageResult.color());
    Map<TextDecoration, State> decorationsResult = kickMessageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(kickMessageResult.hasStyling());
    Component actualCompactResult = kickMessageResult.compact();
    assertEquals(kickMessageResult, actualCompactResult);
  }

  /**
   * Test {@link ProfileWhitelistVerifyEvent#setKickMessage(String)}.
   *
   * <p>Method under test: {@link ProfileWhitelistVerifyEvent#setKickMessage(String)}
   */
  @Test
  @DisplayName("Test setKickMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProfileWhitelistVerifyEvent.setKickMessage(String)"})
  void testSetKickMessage2() {
    // Arrange
    ProfileWhitelistVerifyEvent profileWhitelistVerifyEvent =
        new ProfileWhitelistVerifyEvent(
            mock(PlayerProfile.class), true, true, true, mock(Component.class));

    // Act
    profileWhitelistVerifyEvent.setKickMessage(null);

    // Assert
    assertNull(profileWhitelistVerifyEvent.getKickMessage());
    assertNull(profileWhitelistVerifyEvent.kickMessage());
  }
}
