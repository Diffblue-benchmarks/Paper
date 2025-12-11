package io.papermc.paper.threadedregions.scheduler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.plugin.PaperTestPlugin;
import io.papermc.paper.plugin.provider.configuration.PaperPluginMeta;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FoliaAsyncSchedulerDiffblueTest {
  /**
   * Test {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}
   */
  @Test
  @DisplayName(
      "Test runNow(Plugin, Consumer); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScheduledTask FoliaAsyncScheduler.runNow(Plugin, Consumer)"})
  void testRunNow_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () -> foliaAsyncScheduler.runNow(plugin, mock(Consumer.class)));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name} Enabled is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}
   */
  @Test
  @DisplayName(
      "Test runNow(Plugin, Consumer); given 'true'; when PaperTestPlugin(String) with 'Plugin Name' Enabled is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScheduledTask FoliaAsyncScheduler.runNow(Plugin, Consumer)"})
  void testRunNow_givenTrue_whenPaperTestPluginWithPluginNameEnabledIsTrue() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(foliaAsyncScheduler.runNow(plugin, task).isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with pluginName is {@code Task may
   *       not be null}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}
   */
  @Test
  @DisplayName(
      "Test runNow(Plugin, Consumer); when PaperTestPlugin(String) with pluginName is 'Task may not be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScheduledTask FoliaAsyncScheduler.runNow(Plugin, Consumer)"})
  void testRunNow_whenPaperTestPluginWithPluginNameIsTaskMayNotBeNull() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runNow(new PaperTestPlugin("Task may not be null"), mock(Consumer.class))
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runNow(Plugin, Consumer)}
   */
  @Test
  @DisplayName(
      "Test runNow(Plugin, Consumer); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ScheduledTask FoliaAsyncScheduler.runNow(Plugin, Consumer)"})
  void testRunNow_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runNow(new PaperTestPlugin("Plugin Name"), mock(Consumer.class))
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test runDelayed(Plugin, Consumer, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin may not be nullFolia Async Scheduler Thread Timer"),
                mock(Consumer.class),
                6L,
                TimeUnit.MILLISECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); given 'false'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_givenFalse_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runDelayed(plugin, mock(Consumer.class), 0L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); given 'false'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_givenFalse_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runDelayed(
                plugin, mock(Consumer.class), -1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when one; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenOne_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with pluginName is {@code 42}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when PaperTestPlugin(String) with pluginName is '42'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenPaperTestPluginWithPluginNameIs42_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(new PaperTestPlugin("42"), mock(Consumer.class), 0L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with pluginName is {@code 42}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when PaperTestPlugin(String) with pluginName is '42'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenPaperTestPluginWithPluginNameIs42_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(new PaperTestPlugin("42"), mock(Consumer.class), 6L, TimeUnit.MILLISECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 6L, TimeUnit.MILLISECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@code 3000}.
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when '3000'; then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_when3000_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 3000L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 2L, 1L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 3L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.MICROSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 4L, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 4L, 1L, TimeUnit.MICROSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse9() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 0L, 3L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse10() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 3L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse11() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse12() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.MICROSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse13() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse14() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 1L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin isEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginIsEnabledReturnFalse15() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 2L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name} Enabled is
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin(String) with 'Plugin Name' Enabled is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginWithPluginNameEnabledIsFalse() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 0L, 0L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name} Enabled is
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin(String) with 'Plugin Name' Enabled is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginWithPluginNameEnabledIsFalse2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 0L, 1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name} Enabled is
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when PaperTestPlugin(String) with 'Plugin Name' Enabled is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenPaperTestPluginWithPluginNameEnabledIsFalse3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), -1L, 0L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 30L, 1L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 2L, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 2L, 1L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 30L, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code DAYS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'DAYS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenDays_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 1L, TimeUnit.DAYS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code DAYS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'DAYS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenDays_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 2L, 1L, TimeUnit.DAYS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code DAYS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'DAYS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenDays_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 3L, 1L, TimeUnit.DAYS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code DAYS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'DAYS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenDays_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 3L, TimeUnit.DAYS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code DAYS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'DAYS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenDays_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.DAYS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 4L, 2L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 4L, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 4L, 3L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 4L, 3L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 4L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 4L, 4L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 4L, 4L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 4L, Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled9() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 2L, 4L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When four.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when four; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenFour_thenReturnNotCancelled10() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 4L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 3L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 2L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 2L, Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when MAX_VALUE; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMax_value_thenReturnNotCancelled8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 2L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MICROSECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MICROSECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMicroseconds_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 1L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MICROSECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MICROSECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMicroseconds_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, Long.MAX_VALUE, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MICROSECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MICROSECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMicroseconds_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 2L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 2L, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 3L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 2L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 2L, 2L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, 3L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'MILLISECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMilliseconds_thenReturnNotCancelled8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, 2L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1000L, 1L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 1000L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1000L, 1L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 1000L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1000L, 3L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1000L, Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, 1000L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When one thousand.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when one thousand; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenOneThousand_thenReturnNotCancelled8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, 1000L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 1L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 2L, 1L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), Long.MAX_VALUE, 1L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 2L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 1L, 3L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@code SECONDS}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when 'SECONDS'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenSeconds_thenReturnNotCancelled7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, mock(Consumer.class), 4L, 1L, TimeUnit.SECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When thirty.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when thirty; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenThirty_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 3L, 30L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When thirty.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when thirty; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenThirty_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 30L, 1L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When thirty.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when thirty; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenThirty_thenReturnNotCancelled3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(
            plugin, mock(Consumer.class), 3L, 30L, TimeUnit.MILLISECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When three.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when three; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenThree_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 1L, 3L, TimeUnit.NANOSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When zero.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when zero; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenZero_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenReturn(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act
    ScheduledTask actualRunAtFixedRateResult =
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 0L, 3L, TimeUnit.MICROSECONDS);

    // Assert
    verify(plugin, atLeast(1)).isEnabled();
    assertFalse(actualRunAtFixedRateResult.isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when Consumer accept(Object) throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenConsumerAcceptThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();
    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 1L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    Long.MIN_VALUE,
                    1L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    1L,
                    Long.MIN_VALUE,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    Long.MIN_VALUE,
                    1L,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    3L,
                    Long.MIN_VALUE,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException5() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    2L,
                    Long.MIN_VALUE,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when MIN_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMin_value_thenThrowIllegalArgumentException6() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    1L,
                    Long.MIN_VALUE,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    2L,
                    -1L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    -1L,
                    3L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    -1L,
                    Long.MAX_VALUE,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    1L,
                    -1L,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException5() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class), mock(Consumer.class), -1L, 1L, TimeUnit.SECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException6() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    -1L,
                    4L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException7() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    -1L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException8() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    3L,
                    -1L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException9() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    Long.MAX_VALUE,
                    -1L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException10() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    0L,
                    -1L,
                    TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException11() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    -1L,
                    Long.MAX_VALUE,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenMinusOne_thenThrowIllegalArgumentException12() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    1L,
                    -1L,
                    TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 1L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException3() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 3L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException4() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException5() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException6() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 3L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException7() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException8() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 3L, TimeUnit.MILLISECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException9() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 2L, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException10() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), Long.MAX_VALUE, 2L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException11() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 2L, TimeUnit.MICROSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException12() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), Long.MAX_VALUE, 1L, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException13() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 3L, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException14() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 2L, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException15() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, Long.MAX_VALUE, TimeUnit.SECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin} {@link PaperTestPlugin#isEnabled()} throw {@link
   *       IllegalPluginAccessException#IllegalPluginAccessException()}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin isEnabled() throw IllegalPluginAccessException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginIsEnabledThrowIllegalPluginAccessException16() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = mock(PaperTestPlugin.class);
    when(plugin.isEnabled()).thenThrow(new IllegalPluginAccessException());

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 3L, 30L, TimeUnit.NANOSECONDS));
    verify(plugin).isEnabled();
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(PluginMeta)} with configuration is {@link
   *       PaperPluginMeta} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin(PluginMeta) with configuration is PaperPluginMeta (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginWithConfigurationIsPaperPluginMeta() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();
    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 1L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginWithPluginName_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(
                new PaperTestPlugin("Plugin Name"),
                mock(Consumer.class),
                0L,
                1L,
                TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with {@code Plugin Name}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin(String) with 'Plugin Name'; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPluginWithPluginName_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();
    PaperTestPlugin plugin = new PaperTestPlugin("Plugin Name");

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doNothing().when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 1L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    4L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    2L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    0L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    1L,
                    0L,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException5() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    3L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException6() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    4L,
                    0L,
                    TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException7() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    4L,
                    0L,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException8() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    0L,
                    0L,
                    TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException9() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    0L,
                    0L,
                    TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when PaperTestPlugin; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenPaperTestPlugin_thenThrowIllegalArgumentException10() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    Long.MAX_VALUE,
                    0L,
                    TimeUnit.MICROSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When thirty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when thirty; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenThirty_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    30L,
                    0L,
                    TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When thirty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); when thirty; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_whenThirty_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new FoliaAsyncScheduler()
                .runAtFixedRate(
                    mock(PaperTestPlugin.class),
                    mock(Consumer.class),
                    30L,
                    0L,
                    TimeUnit.MILLISECONDS));
  }
}
