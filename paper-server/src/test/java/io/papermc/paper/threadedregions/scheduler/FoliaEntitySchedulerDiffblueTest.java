package io.papermc.paper.threadedregions.scheduler;

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

class FoliaEntitySchedulerDiffblueTest {
  /**
   * Test {@link FoliaEntityScheduler#run(Plugin, Consumer, Runnable)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#run(Plugin, Consumer, Runnable)}
   */
  @Test
  @DisplayName(
      "Test run(Plugin, Consumer, Runnable); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.run(Plugin, Consumer, Runnable)"
  })
  void testRun_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () -> foliaEntityScheduler.run(plugin, mock(Consumer.class), mock(Runnable.class)));
  }

  /**
   * Test {@link FoliaEntityScheduler#runDelayed(Plugin, Consumer, Runnable, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#runDelayed(Plugin, Consumer, Runnable, long)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, Runnable, long); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.runDelayed(Plugin, Consumer, Runnable, long)"
  })
  void testRunDelayed_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaEntityScheduler.runDelayed(
                plugin, mock(Consumer.class), mock(Runnable.class), 1L));
  }

  /**
   * Test {@link FoliaEntityScheduler#runDelayed(Plugin, Consumer, Runnable, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#runDelayed(Plugin, Consumer, Runnable, long)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, Runnable, long); given 'false'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.runDelayed(Plugin, Consumer, Runnable, long)"
  })
  void testRunDelayed_givenFalse_whenZero_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaEntityScheduler.runDelayed(
                plugin, mock(Consumer.class), mock(Runnable.class), 0L));
  }

  /**
   * Test {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable, long, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, Runnable, long, long); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.runAtFixedRate(Plugin, Consumer, Runnable, long, long)"
  })
  void testRunAtFixedRate_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaEntityScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), mock(Runnable.class), 1L, 1L));
  }

  /**
   * Test {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable, long, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, Runnable, long, long); given 'false'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.runAtFixedRate(Plugin, Consumer, Runnable, long, long)"
  })
  void testRunAtFixedRate_givenFalse_whenZero_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaEntityScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), mock(Runnable.class), 0L, 1L));
  }

  /**
   * Test {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable, long, long)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaEntityScheduler#runAtFixedRate(Plugin, Consumer, Runnable,
   * long, long)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, Runnable, long, long); given 'false'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.threadedregions.scheduler.ScheduledTask FoliaEntityScheduler.runAtFixedRate(Plugin, Consumer, Runnable, long, long)"
  })
  void testRunAtFixedRate_givenFalse_whenZero_thenThrowIllegalArgumentException2() {
    // Arrange
    FoliaEntityScheduler foliaEntityScheduler = new FoliaEntityScheduler(null);

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaEntityScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), mock(Runnable.class), 1L, 0L));
  }
}
