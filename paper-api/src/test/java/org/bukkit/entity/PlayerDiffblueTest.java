package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.KeybindComponent;
import org.bukkit.entity.Player.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlayerDiffblueTest {
  /**
   * Test Spigot {@link Spigot#getHiddenPlayers()}.
   *
   * <p>Method under test: {@link Spigot#getHiddenPlayers()}
   */
  @Test
  @DisplayName("Test Spigot getHiddenPlayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Spigot.getHiddenPlayers()"})
  void testSpigotGetHiddenPlayers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getHiddenPlayers());
  }

  /**
   * Test Spigot {@link Spigot#getPing()}.
   *
   * <p>Method under test: {@link Spigot#getPing()}
   */
  @Test
  @DisplayName("Test Spigot getPing()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Spigot.getPing()"})
  void testSpigotGetPing() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getPing());
  }

  /**
   * Test Spigot {@link Spigot#getRawAddress()}.
   *
   * <p>Method under test: {@link Spigot#getRawAddress()}
   */
  @Test
  @DisplayName("Test Spigot getRawAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.net.InetSocketAddress Spigot.getRawAddress()"})
  void testSpigotGetRawAddress() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getRawAddress());
  }

  /**
   * Test Spigot {@link Spigot#respawn()}.
   *
   * <p>Method under test: {@link Spigot#respawn()}
   */
  @Test
  @DisplayName("Test Spigot respawn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.respawn()"})
  void testSpigotRespawn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().respawn());
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
   * Test Spigot {@link Spigot#sendMessage(ChatMessageType, BaseComponent)} with {@code position},
   * {@code component}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(ChatMessageType, BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test Spigot sendMessage(ChatMessageType, BaseComponent) with 'position', 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(ChatMessageType, BaseComponent)"})
  void testSpigotSendMessageWithPositionComponent() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(ChatMessageType.CHAT, new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(ChatMessageType, BaseComponent[])} with {@code position},
   * {@code components}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(ChatMessageType, BaseComponent[])}
   */
  @Test
  @DisplayName(
      "Test Spigot sendMessage(ChatMessageType, BaseComponent[]) with 'position', 'components'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(ChatMessageType, BaseComponent[])"})
  void testSpigotSendMessageWithPositionComponents() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(ChatMessageType.CHAT, new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(ChatMessageType, UUID, BaseComponent)} with {@code
   * position}, {@code sender}, {@code component}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(ChatMessageType, UUID, BaseComponent)}
   */
  @Test
  @DisplayName(
      "Test Spigot sendMessage(ChatMessageType, UUID, BaseComponent) with 'position', 'sender', 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(ChatMessageType, UUID, BaseComponent)"})
  void testSpigotSendMessageWithPositionSenderComponent() {
    // Arrange
    Spigot spigot = new Spigot();
    UUID sender = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(ChatMessageType.CHAT, sender, new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#sendMessage(ChatMessageType, UUID, BaseComponent[])} with {@code
   * position}, {@code sender}, {@code components}.
   *
   * <p>Method under test: {@link Spigot#sendMessage(ChatMessageType, UUID, BaseComponent[])}
   */
  @Test
  @DisplayName(
      "Test Spigot sendMessage(ChatMessageType, UUID, BaseComponent[]) with 'position', 'sender', 'components'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.sendMessage(ChatMessageType, UUID, BaseComponent[])"})
  void testSpigotSendMessageWithPositionSenderComponents() {
    // Arrange
    Spigot spigot = new Spigot();
    UUID sender = UUID.randomUUID();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.sendMessage(ChatMessageType.CHAT, sender, new KeybindComponent()));
  }
}
