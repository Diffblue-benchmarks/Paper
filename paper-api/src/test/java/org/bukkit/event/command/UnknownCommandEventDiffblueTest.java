package org.bukkit.event.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UnknownCommandEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownCommandEvent#UnknownCommandEvent(CommandSender, String, Component)}
   *   <li>{@link UnknownCommandEvent#message(Component)}
   *   <li>{@link UnknownCommandEvent#getHandlerList()}
   *   <li>{@link UnknownCommandEvent#getCommandLine()}
   *   <li>{@link UnknownCommandEvent#getHandlers()}
   *   <li>{@link UnknownCommandEvent#getSender()}
   *   <li>{@link UnknownCommandEvent#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownCommandEvent.<init>(CommandSender, String, Component)",
    "String UnknownCommandEvent.getCommandLine()",
    "HandlerList UnknownCommandEvent.getHandlerList()",
    "HandlerList UnknownCommandEvent.getHandlers()",
    "CommandSender UnknownCommandEvent.getSender()",
    "Component UnknownCommandEvent.message()",
    "void UnknownCommandEvent.message(Component)"
  })
  void testGettersAndSetters() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    UnknownCommandEvent actualUnknownCommandEvent =
        new UnknownCommandEvent(sender, "Command Line", mock(Component.class));
    Component message = mock(Component.class);
    actualUnknownCommandEvent.message(message);
    HandlerList actualHandlerList = actualUnknownCommandEvent.getHandlerList();
    String actualCommandLine = actualUnknownCommandEvent.getCommandLine();
    HandlerList actualHandlers = actualUnknownCommandEvent.getHandlers();
    CommandSender actualSender = actualUnknownCommandEvent.getSender();
    Component actualMessageResult = actualUnknownCommandEvent.message();

    // Assert
    assertEquals("Command Line", actualCommandLine);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualUnknownCommandEvent.isAsynchronous());
    assertSame(sender, actualSender);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message, actualMessageResult);
  }

  /**
   * Test {@link UnknownCommandEvent#getMessage()}.
   *
   * <ul>
   *   <li>Given {@link Style} {@link Style#color()} return {@link TextColor}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UnknownCommandEvent#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage(); given Style color() return TextColor; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UnknownCommandEvent.getMessage()"})
  void testGetMessage_givenStyleColorReturnTextColor_thenReturnEmptyString() {
    // Arrange
    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component message = mock(Component.class);
    when(message.children()).thenReturn(new ArrayList<>());
    when(message.style()).thenReturn(style);
    UnknownCommandEvent unknownCommandEvent =
        new UnknownCommandEvent(new BufferedCommandSender(), "Command Line", message);

    // Act
    String actualMessage = unknownCommandEvent.getMessage();

    // Assert
    verify(message).children();
    verify(message).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    assertEquals("", actualMessage);
  }

  /**
   * Test {@link UnknownCommandEvent#getMessage()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnknownCommandEvent#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UnknownCommandEvent.getMessage()"})
  void testGetMessage_thenReturnNull() {
    // Arrange
    UnknownCommandEvent unknownCommandEvent =
        new UnknownCommandEvent(new BufferedCommandSender(), "Command Line", null);

    // Act and Assert
    assertNull(unknownCommandEvent.getMessage());
  }

  /**
   * Test {@link UnknownCommandEvent#setMessage(String)}.
   *
   * <p>Method under test: {@link UnknownCommandEvent#setMessage(String)}
   */
  @Test
  @DisplayName("Test setMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownCommandEvent.setMessage(String)"})
  void testSetMessage() {
    // Arrange
    UnknownCommandEvent unknownCommandEvent =
        new UnknownCommandEvent(new BufferedCommandSender(), "Command Line", mock(Component.class));

    // Act
    unknownCommandEvent.setMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", unknownCommandEvent.getMessage());
    Component messageResult = unknownCommandEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.BOLD));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.OBFUSCATED));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.STRIKETHROUGH));
    assertEquals(State.NOT_SET, decorationsResult.get(TextDecoration.UNDERLINED));
    assertFalse(messageResult.hasStyling());
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
  }

  /**
   * Test {@link UnknownCommandEvent#setMessage(String)}.
   *
   * <p>Method under test: {@link UnknownCommandEvent#setMessage(String)}
   */
  @Test
  @DisplayName("Test setMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownCommandEvent.setMessage(String)"})
  void testSetMessage2() {
    // Arrange
    UnknownCommandEvent unknownCommandEvent =
        new UnknownCommandEvent(new BufferedCommandSender(), "Command Line", mock(Component.class));

    // Act
    unknownCommandEvent.setMessage(null);

    // Assert
    assertNull(unknownCommandEvent.getMessage());
    assertNull(unknownCommandEvent.message());
  }
}
