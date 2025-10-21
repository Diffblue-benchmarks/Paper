package org.bukkit.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.KeybindComponent;
import org.bukkit.command.CommandSender.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommandSenderDiffblueTest {
  /**
   * Test {@link CommandSender#sendMessage(BaseComponent[])} with {@code BaseComponent[]}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code §f}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendMessage(BaseComponent[])}
   */
  @Test
  @DisplayName(
      "Test sendMessage(BaseComponent[]) with 'BaseComponent[]'; then BufferedCommandSender (default constructor) Buffer is '§f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendMessage(BaseComponent[])"})
  void testSendMessageWithBaseComponent_thenBufferedCommandSenderBufferIsF() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendMessage(new BaseComponent[] {});

    // Assert
    assertEquals("§f\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendMessage(BaseComponent)} with {@code BaseComponent}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code Legacy Text}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendMessage(BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test sendMessage(BaseComponent) with 'BaseComponent'; then BufferedCommandSender (default constructor) Buffer is 'Legacy Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendMessage(BaseComponent)"})
  void testSendMessageWithBaseComponent_thenBufferedCommandSenderBufferIsLegacyText() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    KeybindComponent component = mock(KeybindComponent.class);
    when(component.toLegacyText()).thenReturn("Legacy Text");

    // Act
    bufferedCommandSender.sendMessage(component);

    // Assert
    verify(component).toLegacyText();
    assertEquals("Legacy Text\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendMessage(Identity, Component, MessageType)} with {@code Identity},
   * {@code Component}, {@code MessageType}.
   *
   * <p>Method under test: {@link CommandSender#sendMessage(Identity, Component, MessageType)}
   */
  @Test
  @DisplayName(
      "Test sendMessage(Identity, Component, MessageType) with 'Identity', 'Component', 'MessageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendMessage(Identity, Component, MessageType)"})
  void testSendMessageWithIdentityComponentMessageType() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    Identity identity = mock(Identity.class);

    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component message = mock(Component.class);
    when(message.children()).thenReturn(new ArrayList<>());
    when(message.style()).thenReturn(style);

    // Act
    bufferedCommandSender.sendMessage(identity, message, MessageType.CHAT);

    // Assert
    verify(message).children();
    verify(message).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    assertEquals("\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendRichMessage(String)} with {@code message}.
   *
   * <p>Method under test: {@link CommandSender#sendRichMessage(String)}
   */
  @Test
  @DisplayName("Test sendRichMessage(String) with 'message'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendRichMessage(String)"})
  void testSendRichMessageWithMessage() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendRichMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendRichMessage(String, TagResolver[])} with {@code message}, {@code
   * resolvers}.
   *
   * <p>Method under test: {@link CommandSender#sendRichMessage(String, TagResolver[])}
   */
  @Test
  @DisplayName("Test sendRichMessage(String, TagResolver[]) with 'message', 'resolvers'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendRichMessage(String, TagResolver[])"})
  void testSendRichMessageWithMessageResolvers() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendRichMessage("Not all who wander are lost", mock(TagResolver.class));

    // Assert
    assertEquals("Not all who wander are lost\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendRichMessage(String, TagResolver[])} with {@code message}, {@code
   * resolvers}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is lf.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendRichMessage(String, TagResolver[])}
   */
  @Test
  @DisplayName(
      "Test sendRichMessage(String, TagResolver[]) with 'message', 'resolvers'; then BufferedCommandSender (default constructor) Buffer is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendRichMessage(String, TagResolver[])"})
  void testSendRichMessageWithMessageResolvers_thenBufferedCommandSenderBufferIsLf() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendRichMessage("", mock(TagResolver.class));

    // Assert
    assertEquals("\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendRichMessage(String)} with {@code message}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is lf.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendRichMessage(String)}
   */
  @Test
  @DisplayName(
      "Test sendRichMessage(String) with 'message'; then BufferedCommandSender (default constructor) Buffer is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendRichMessage(String)"})
  void testSendRichMessageWithMessage_thenBufferedCommandSenderBufferIsLf() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendRichMessage("");

    // Assert
    assertEquals("\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendRichMessage(String)} with {@code message}.
   *
   * <ul>
   *   <li>When {@code l}.
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code l}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendRichMessage(String)}
   */
  @Test
  @DisplayName(
      "Test sendRichMessage(String) with 'message'; when 'l'; then BufferedCommandSender (default constructor) Buffer is 'l'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendRichMessage(String)"})
  void testSendRichMessageWithMessage_whenL_thenBufferedCommandSenderBufferIsL() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendRichMessage("l");

    // Assert
    assertEquals("l\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendPlainMessage(String)}.
   *
   * <ul>
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is {@code Not all who
   *       wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendPlainMessage(String)}
   */
  @Test
  @DisplayName(
      "Test sendPlainMessage(String); then BufferedCommandSender (default constructor) Buffer is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendPlainMessage(String)"})
  void testSendPlainMessage_thenBufferedCommandSenderBufferIsNotAllWhoWanderAreLost() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendPlainMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test {@link CommandSender#sendPlainMessage(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then {@link BufferedCommandSender} (default constructor) Buffer is lf.
   * </ul>
   *
   * <p>Method under test: {@link CommandSender#sendPlainMessage(String)}
   */
  @Test
  @DisplayName(
      "Test sendPlainMessage(String); when empty string; then BufferedCommandSender (default constructor) Buffer is lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandSender.sendPlainMessage(String)"})
  void testSendPlainMessage_whenEmptyString_thenBufferedCommandSenderBufferIsLf() {
    // Arrange
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();

    // Act
    bufferedCommandSender.sendPlainMessage("");

    // Assert
    assertEquals("\n", bufferedCommandSender.getBuffer());
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(BaseComponent)} with {@code component}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(BaseComponent)}
   */
  @Test
  @DisplayName("Test Spigot sendMessage(BaseComponent) with 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(BaseComponent)"})
  void testSpigotSendMessageWithComponent() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> spigot.sendMessage(new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(BaseComponent[])} with {@code components}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(BaseComponent[])}
   */
  @Test
  @DisplayName("Test Spigot sendMessage(BaseComponent[]) with 'components'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(BaseComponent[])"})
  void testSpigotSendMessageWithComponents() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> spigot.sendMessage(new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(UUID, BaseComponent)} with {@code sender}, {@code
   * component}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(UUID, BaseComponent)}
   */
  @Test
  @DisplayName("Test Spigot sendMessage(UUID, BaseComponent) with 'sender', 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(UUID, BaseComponent)"})
  void testSpigotSendMessageWithSenderComponent() {
    // Arrange
    Spigot spigot = new Spigot();
    UUID sender = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(sender, new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(UUID, BaseComponent[])} with {@code sender}, {@code
   * components}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(UUID, BaseComponent[])}
   */
  @Test
  @DisplayName("Test Spigot sendMessage(UUID, BaseComponent[]) with 'sender', 'components'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(UUID, BaseComponent[])"})
  void testSpigotSendMessageWithSenderComponents() {
    // Arrange
    Spigot spigot = new Spigot();
    UUID sender = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(sender, new KeybindComponent()));
  }
}
