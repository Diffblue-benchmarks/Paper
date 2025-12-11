package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.world.level.Level;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WorldUtilDiffblueTest {
  /**
   * Test {@link WorldUtil#getWorldName(Level)}.
   *
   * <p>Method under test: {@link WorldUtil#getWorldName(Level)}
   */
  @Test
  @DisplayName("Test getWorldName(Level)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String WorldUtil.getWorldName(Level)"})
  void testGetWorldName() {
    // Arrange, Act and Assert
    assertEquals("null world", WorldUtil.getWorldName(null));
  }
}
