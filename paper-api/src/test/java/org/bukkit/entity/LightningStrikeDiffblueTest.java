package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.entity.LightningStrike.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LightningStrikeDiffblueTest {
  /**
   * Test Spigot {@link Spigot#isSilent()}.
   *
   * <p>Method under test: {@link Spigot#isSilent()}
   */
  @Test
  @DisplayName("Test Spigot isSilent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Spigot.isSilent()"})
  void testSpigotIsSilent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().isSilent());
  }
}
