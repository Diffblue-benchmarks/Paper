package org.bukkit.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BroadcastMessageEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Component}.
   *   <li>Then return not Asynchronous.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadcastMessageEvent#BroadcastMessageEvent(Component, Set)}
   *   <li>{@link BroadcastMessageEvent#message(Component)}
   *   <li>{@link BroadcastMessageEvent#setCancelled(boolean)}
   *   <li>{@link BroadcastMessageEvent#getHandlerList()}
   *   <li>{@link BroadcastMessageEvent#getHandlers()}
   *   <li>{@link BroadcastMessageEvent#getRecipients()}
   *   <li>{@link BroadcastMessageEvent#isCancelled()}
   *   <li>{@link BroadcastMessageEvent#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Component; then return not Asynchronous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadcastMessageEvent.<init>(Component, Set)",
    "void BroadcastMessageEvent.<init>(boolean, Component, Set)",
    "HandlerList BroadcastMessageEvent.getHandlerList()",
    "HandlerList BroadcastMessageEvent.getHandlers()",
    "Set BroadcastMessageEvent.getRecipients()",
    "boolean BroadcastMessageEvent.isCancelled()",
    "Component BroadcastMessageEvent.message()",
    "void BroadcastMessageEvent.message(Component)",
    "void BroadcastMessageEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenComponent_thenReturnNotAsynchronous() {
    // Arrange
    Component message = mock(Component.class);
    HashSet<CommandSender> recipients = new HashSet<>();

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent(message, recipients);
    Component message2 = mock(Component.class);
    actualBroadcastMessageEvent.message(message2);
    actualBroadcastMessageEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBroadcastMessageEvent.getHandlerList();
    HandlerList actualHandlers = actualBroadcastMessageEvent.getHandlers();
    Set<CommandSender> actualRecipients = actualBroadcastMessageEvent.getRecipients();
    boolean actualIsCancelledResult = actualBroadcastMessageEvent.isCancelled();
    Component actualMessageResult = actualBroadcastMessageEvent.message();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(actualBroadcastMessageEvent.isAsynchronous());
    assertTrue(actualRecipients.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(recipients, actualRecipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message2, actualMessageResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Asynchronous.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, Component, Set)}
   *   <li>{@link BroadcastMessageEvent#message(Component)}
   *   <li>{@link BroadcastMessageEvent#setCancelled(boolean)}
   *   <li>{@link BroadcastMessageEvent#getHandlerList()}
   *   <li>{@link BroadcastMessageEvent#getHandlers()}
   *   <li>{@link BroadcastMessageEvent#getRecipients()}
   *   <li>{@link BroadcastMessageEvent#isCancelled()}
   *   <li>{@link BroadcastMessageEvent#message()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return Asynchronous")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadcastMessageEvent.<init>(Component, Set)",
    "void BroadcastMessageEvent.<init>(boolean, Component, Set)",
    "HandlerList BroadcastMessageEvent.getHandlerList()",
    "HandlerList BroadcastMessageEvent.getHandlers()",
    "Set BroadcastMessageEvent.getRecipients()",
    "boolean BroadcastMessageEvent.isCancelled()",
    "Component BroadcastMessageEvent.message()",
    "void BroadcastMessageEvent.message(Component)",
    "void BroadcastMessageEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters_whenTrue_thenReturnAsynchronous() {
    // Arrange
    Component message = mock(Component.class);
    HashSet<CommandSender> recipients = new HashSet<>();

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent(true, message, recipients);
    Component message2 = mock(Component.class);
    actualBroadcastMessageEvent.message(message2);
    actualBroadcastMessageEvent.setCancelled(true);
    HandlerList actualHandlerList = actualBroadcastMessageEvent.getHandlerList();
    HandlerList actualHandlers = actualBroadcastMessageEvent.getHandlers();
    Set<CommandSender> actualRecipients = actualBroadcastMessageEvent.getRecipients();
    boolean actualIsCancelledResult = actualBroadcastMessageEvent.isCancelled();
    Component actualMessageResult = actualBroadcastMessageEvent.message();

    // Assert
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualRecipients.isEmpty());
    assertTrue(actualBroadcastMessageEvent.isAsynchronous());
    assertTrue(actualIsCancelledResult);
    assertSame(recipients, actualRecipients);
    assertSame(actualHandlerList, actualHandlers);
    assertSame(message2, actualMessageResult);
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}.
   *
   * <ul>
   *   <li>Then return Recipients is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}
   */
  @Test
  @DisplayName("Test new BroadcastMessageEvent(String, Set); then return Recipients is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(String, Set)"})
  void testNewBroadcastMessageEvent_thenReturnRecipientsIsHashSet() {
    // Arrange
    HashSet<CommandSender> recipients = new HashSet<>();
    recipients.add(new BufferedCommandSender());

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent("Not all who wander are lost", recipients);

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isAsynchronous());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
    assertSame(recipients, actualBroadcastMessageEvent.getRecipients());
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}.
   *
   * <ul>
   *   <li>Then return Recipients is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}
   */
  @Test
  @DisplayName("Test new BroadcastMessageEvent(String, Set); then return Recipients is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(String, Set)"})
  void testNewBroadcastMessageEvent_thenReturnRecipientsIsHashSet2() {
    // Arrange
    HashSet<CommandSender> recipients = new HashSet<>();
    recipients.add(new BufferedCommandSender());
    recipients.add(new BufferedCommandSender());

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent("Not all who wander are lost", recipients);

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isAsynchronous());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
    assertSame(recipients, actualBroadcastMessageEvent.getRecipients());
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}.
   *
   * <ul>
   *   <li>Then return Recipients is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}
   */
  @Test
  @DisplayName(
      "Test new BroadcastMessageEvent(boolean, String, Set); then return Recipients is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(boolean, String, Set)"})
  void testNewBroadcastMessageEvent_thenReturnRecipientsIsHashSet3() {
    // Arrange
    HashSet<CommandSender> recipients = new HashSet<>();
    recipients.add(new BufferedCommandSender());

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent(true, "Not all who wander are lost", recipients);

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualBroadcastMessageEvent.isAsynchronous());
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
    assertSame(recipients, actualBroadcastMessageEvent.getRecipients());
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}.
   *
   * <ul>
   *   <li>Then return Recipients is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}
   */
  @Test
  @DisplayName(
      "Test new BroadcastMessageEvent(boolean, String, Set); then return Recipients is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(boolean, String, Set)"})
  void testNewBroadcastMessageEvent_thenReturnRecipientsIsHashSet4() {
    // Arrange
    HashSet<CommandSender> recipients = new HashSet<>();
    recipients.add(new BufferedCommandSender());
    recipients.add(new BufferedCommandSender());

    // Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent(true, "Not all who wander are lost", recipients);

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualBroadcastMessageEvent.isAsynchronous());
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
    assertSame(recipients, actualBroadcastMessageEvent.getRecipients());
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Recipients Empty.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(String, Set)}
   */
  @Test
  @DisplayName(
      "Test new BroadcastMessageEvent(String, Set); when HashSet(); then return Recipients Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(String, Set)"})
  void testNewBroadcastMessageEvent_whenHashSet_thenReturnRecipientsEmpty() {
    // Arrange and Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent("Not all who wander are lost", new HashSet<>());

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isAsynchronous());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualBroadcastMessageEvent.getRecipients().isEmpty());
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
  }

  /**
   * Test {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Recipients Empty.
   * </ul>
   *
   * <p>Method under test: {@link BroadcastMessageEvent#BroadcastMessageEvent(boolean, String, Set)}
   */
  @Test
  @DisplayName(
      "Test new BroadcastMessageEvent(boolean, String, Set); when HashSet(); then return Recipients Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadcastMessageEvent.<init>(boolean, String, Set)"})
  void testNewBroadcastMessageEvent_whenHashSet_thenReturnRecipientsEmpty2() {
    // Arrange and Act
    BroadcastMessageEvent actualBroadcastMessageEvent =
        new BroadcastMessageEvent(true, "Not all who wander are lost", new HashSet<>());

    // Assert
    assertEquals("BroadcastMessageEvent", actualBroadcastMessageEvent.getEventName());
    assertEquals("Not all who wander are lost", actualBroadcastMessageEvent.getMessage());
    Component messageResult = actualBroadcastMessageEvent.message();
    assertNull(messageResult.insertion());
    assertNull(messageResult.font());
    assertNull(messageResult.color());
    assertEquals(0, actualBroadcastMessageEvent.getHandlers().getRegisteredListeners().length);
    Map<TextDecoration, State> decorationsResult = messageResult.decorations();
    assertEquals(5, decorationsResult.size());
    assertFalse(messageResult.hasStyling());
    assertFalse(actualBroadcastMessageEvent.isCancelled());
    assertTrue(decorationsResult.containsKey(TextDecoration.BOLD));
    assertTrue(decorationsResult.containsKey(TextDecoration.OBFUSCATED));
    assertTrue(decorationsResult.containsKey(TextDecoration.STRIKETHROUGH));
    assertTrue(decorationsResult.containsKey(TextDecoration.UNDERLINED));
    assertTrue(actualBroadcastMessageEvent.getRecipients().isEmpty());
    assertTrue(actualBroadcastMessageEvent.isAsynchronous());
    Component actualCompactResult = messageResult.compact();
    assertEquals(messageResult, actualCompactResult);
  }

  /**
   * Test {@link BroadcastMessageEvent#getMessage()}.
   *
   * <p>Method under test: {@link BroadcastMessageEvent#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadcastMessageEvent.getMessage()"})
  void testGetMessage() {
    // Arrange
    BroadcastMessageEvent broadcastMessageEvent =
        new BroadcastMessageEvent("Not all who wander are lost", new HashSet<>());

    // Act and Assert
    assertEquals("Not all who wander are lost", broadcastMessageEvent.getMessage());
  }
}
