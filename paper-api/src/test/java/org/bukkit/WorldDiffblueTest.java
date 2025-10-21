package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.bukkit.World.Environment;
import org.bukkit.World.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldDiffblueTest {
  /**
   * Test Environment {@link Environment#getEnvironment(int)}.
   *
   * <p>Method under test: {@link Environment#getEnvironment(int)}
   */
  @Test
  @DisplayName("Test Environment getEnvironment(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Environment Environment.getEnvironment(int)"})
  void testEnvironmentGetEnvironment() {
    // Arrange, Act and Assert
    assertEquals(Environment.THE_END, Environment.getEnvironment(1));
  }

  /**
   * Test Spigot {@link Spigot#strikeLightning(Location, boolean)}.
   *
   * <p>Method under test: {@link Spigot#strikeLightning(Location, boolean)}
   */
  @Test
  @DisplayName("Test Spigot strikeLightning(Location, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.bukkit.entity.LightningStrike Spigot.strikeLightning(Location, boolean)"})
  void testSpigotStrikeLightning() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.strikeLightning(Location.deserialize(new HashMap<>()), true));
  }

  /**
   * Test Spigot {@link Spigot#strikeLightningEffect(Location, boolean)}.
   *
   * <p>Method under test: {@link Spigot#strikeLightningEffect(Location, boolean)}
   */
  @Test
  @DisplayName("Test Spigot strikeLightningEffect(Location, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.bukkit.entity.LightningStrike Spigot.strikeLightningEffect(Location, boolean)"
  })
  void testSpigotStrikeLightningEffect() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.strikeLightningEffect(Location.deserialize(new HashMap<>()), true));
  }
}
