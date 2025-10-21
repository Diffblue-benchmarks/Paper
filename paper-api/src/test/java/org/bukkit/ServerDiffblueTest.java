package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.KeybindComponent;
import org.bukkit.Server.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerDiffblueTest {
  /**
   * Test Spigot {@link Spigot#broadcast(BaseComponent)} with {@code component}.
   *
   * <p>Method under test: {@link Spigot#broadcast(BaseComponent)}
   */
  @Test
  @DisplayName("Test Spigot broadcast(BaseComponent) with 'component'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.broadcast(BaseComponent)"})
  void testSpigotBroadcastWithComponent() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> spigot.broadcast(new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#broadcast(BaseComponent[])} with {@code components}.
   *
   * <p>Method under test: {@link Spigot#broadcast(BaseComponent[])}
   */
  @Test
  @DisplayName("Test Spigot broadcast(BaseComponent[]) with 'components'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.broadcast(BaseComponent[])"})
  void testSpigotBroadcastWithComponents() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> spigot.broadcast(new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#getBukkitConfig()}.
   *
   * <p>Method under test: {@link Spigot#getBukkitConfig()}
   */
  @Test
  @DisplayName("Test Spigot getBukkitConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.configuration.file.YamlConfiguration Spigot.getBukkitConfig()"})
  void testSpigotGetBukkitConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getBukkitConfig());
  }

  /**
   * Test Spigot {@link Spigot#getConfig()}.
   *
   * <p>Method under test: {@link Spigot#getConfig()}
   */
  @Test
  @DisplayName("Test Spigot getConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.configuration.file.YamlConfiguration Spigot.getConfig()"})
  void testSpigotGetConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getConfig());
  }

  /**
   * Test Spigot {@link Spigot#getPaperConfig()}.
   *
   * <p>Method under test: {@link Spigot#getPaperConfig()}
   */
  @Test
  @DisplayName("Test Spigot getPaperConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.configuration.file.YamlConfiguration Spigot.getPaperConfig()"})
  void testSpigotGetPaperConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getPaperConfig());
  }

  /**
   * Test Spigot {@link Spigot#getSpigotConfig()}.
   *
   * <p>Method under test: {@link Spigot#getSpigotConfig()}
   */
  @Test
  @DisplayName("Test Spigot getSpigotConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.configuration.file.YamlConfiguration Spigot.getSpigotConfig()"})
  void testSpigotGetSpigotConfig() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getSpigotConfig());
  }

  /**
   * Test Spigot {@link Spigot#restart()}.
   *
   * <p>Method under test: {@link Spigot#restart()}
   */
  @Test
  @DisplayName("Test Spigot restart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.restart()"})
  void testSpigotRestart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().restart());
  }
}
