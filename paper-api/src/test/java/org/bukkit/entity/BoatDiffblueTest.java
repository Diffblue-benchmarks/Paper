package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.Material;
import org.bukkit.entity.Boat.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BoatDiffblueTest {
  /**
   * Test Type {@link Type#getMaterial()}.
   *
   * <p>Method under test: {@link Type#getMaterial()}
   */
  @Test
  @DisplayName("Test Type getMaterial()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Material Type.getMaterial()"})
  void testTypeGetMaterial() {
    // Arrange, Act and Assert
    assertEquals(Material.OAK_PLANKS, Type.valueOf("OAK").getMaterial());
  }
}
