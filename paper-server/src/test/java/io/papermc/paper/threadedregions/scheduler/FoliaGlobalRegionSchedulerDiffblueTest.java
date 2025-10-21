package io.papermc.paper.threadedregions.scheduler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.PaperTestPlugin;
import java.util.function.Consumer;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FoliaGlobalRegionSchedulerDiffblueTest {
  /**
   * Test {@link FoliaGlobalRegionScheduler#run(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#run(Plugin, Consumer)}
   */
  @Test
  @DisplayName("Test run(Plugin, Consumer); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.run(Plugin, Consumer)"
  })
  void testRun_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () -> foliaGlobalRegionScheduler.run(plugin, mock(Consumer.class)));
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#run(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#run(Plugin, Consumer)}
   */
  @Test
  @DisplayName(
      "Test run(Plugin, Consumer); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.run(Plugin, Consumer)"
  })
  void testRun_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertFalse(
        foliaGlobalRegionScheduler
            .run(new PaperTestPlugin("Plugin Name"), mock(Consumer.class))
            .isCancelled());
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runDelayed(Plugin, Consumer, long)"
  })
  void testRunDelayed_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () -> foliaGlobalRegionScheduler.runDelayed(plugin, mock(Consumer.class), 1L));
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runDelayed(Plugin, Consumer, long)"
  })
  void testRunDelayed_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaGlobalRegionScheduler.runDelayed(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), -1L));
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runDelayed(Plugin, Consumer, long)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runDelayed(Plugin, Consumer, long)"
  })
  void testRunDelayed_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertFalse(
        foliaGlobalRegionScheduler
            .runDelayed(new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 1L)
            .isCancelled());
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runAtFixedRate(Plugin, Consumer, long, long)"
  })
  void testRunAtFixedRate_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () -> foliaGlobalRegionScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 1L));
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long, long)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runAtFixedRate(Plugin, Consumer, long, long)"
  })
  void testRunAtFixedRate_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertFalse(
        foliaGlobalRegionScheduler
            .runAtFixedRate(new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 1L, 1L)
            .isCancelled());
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runAtFixedRate(Plugin, Consumer, long, long)"
  })
  void testRunAtFixedRate_whenZero_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaGlobalRegionScheduler.runAtFixedRate(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 0L, 1L));
  }

  /**
   * Test {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaGlobalRegionScheduler#runAtFixedRate(Plugin, Consumer, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaGlobalRegionScheduler.runAtFixedRate(Plugin, Consumer, long, long)"
  })
  void testRunAtFixedRate_whenZero_thenThrowIllegalArgumentException2() {
    // Arrange
    FoliaGlobalRegionScheduler foliaGlobalRegionScheduler = new FoliaGlobalRegionScheduler();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaGlobalRegionScheduler.runAtFixedRate(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 1L, 0L));
  }
}
