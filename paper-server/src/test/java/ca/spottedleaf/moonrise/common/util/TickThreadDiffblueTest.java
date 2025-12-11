package ca.spottedleaf.moonrise.common.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.phys.AABB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TickThreadDiffblueTest {
  /**
   * Test {@link TickThread#ensureTickThread(Level, AABB, String)} with {@code Level}, {@code AABB},
   * {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(Level, AABB, String)}
   */
  @Test
  @DisplayName("Test ensureTickThread(Level, AABB, String) with 'Level', 'AABB', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(Level, AABB, String)"})
  void testEnsureTickThreadWithLevelAabbString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TickThread.ensureTickThread(null, Hopper.SUCK_AABB, "Just cause"));
  }

  /**
   * Test {@link TickThread#ensureTickThread(Level, BlockPos, int, String)} with {@code Level},
   * {@code BlockPos}, {@code int}, {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(Level, BlockPos, int, String)}
   */
  @Test
  @DisplayName(
      "Test ensureTickThread(Level, BlockPos, int, String) with 'Level', 'BlockPos', 'int', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(Level, BlockPos, int, String)"})
  void testEnsureTickThreadWithLevelBlockPosIntString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TickThread.ensureTickThread(null, BlockPos.of(1L), 1, "Just cause"));
  }

  /**
   * Test {@link TickThread#ensureTickThread(Level, BlockPos, String)} with {@code Level}, {@code
   * BlockPos}, {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(Level, BlockPos, String)}
   */
  @Test
  @DisplayName("Test ensureTickThread(Level, BlockPos, String) with 'Level', 'BlockPos', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(Level, BlockPos, String)"})
  void testEnsureTickThreadWithLevelBlockPosString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TickThread.ensureTickThread(null, BlockPos.of(1L), "Just cause"));
  }

  /**
   * Test {@link TickThread#ensureTickThread(Level, double, double, String)} with {@code Level},
   * {@code double}, {@code double}, {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(Level, double, double, String)}
   */
  @Test
  @DisplayName(
      "Test ensureTickThread(Level, double, double, String) with 'Level', 'double', 'double', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(Level, double, double, String)"})
  void testEnsureTickThreadWithLevelDoubleDoubleString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> TickThread.ensureTickThread(null, 10.0d, 10.0d, "Just cause"));
  }

  /**
   * Test {@link TickThread#ensureTickThread(String)} with {@code String}.
   *
   * <p>Method under test: {@link TickThread#ensureTickThread(String)}
   */
  @Test
  @DisplayName("Test ensureTickThread(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TickThread.ensureTickThread(String)"})
  void testEnsureTickThreadWithString() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> TickThread.ensureTickThread("Just cause"));
  }

  /**
   * Test {@link TickThread#isTickThread()}.
   *
   * <p>Method under test: {@link TickThread#isTickThread()}
   */
  @Test
  @DisplayName("Test isTickThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TickThread.isTickThread()"})
  void testIsTickThread() {
    // Arrange, Act and Assert
    assertFalse(TickThread.isTickThread());
  }

  /**
   * Test {@link TickThread#isShutdownThread()}.
   *
   * <p>Method under test: {@link TickThread#isShutdownThread()}
   */
  @Test
  @DisplayName("Test isShutdownThread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TickThread.isShutdownThread()"})
  void testIsShutdownThread() {
    // Arrange, Act and Assert
    assertFalse(new TickThread("Name").isShutdownThread());
  }
}
