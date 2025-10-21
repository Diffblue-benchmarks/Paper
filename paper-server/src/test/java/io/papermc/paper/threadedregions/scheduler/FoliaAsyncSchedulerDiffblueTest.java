package io.papermc.paper.threadedregions.scheduler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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
  void testRunDelayed_whenOne_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 1L, TimeUnit.MICROSECONDS)
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
            .runDelayed(new PaperTestPlugin("42"), mock(Consumer.class), 6L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When {@link PaperTestPlugin#PaperTestPlugin(String)} with pluginName is {@code Plugin may
   *       not be null}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when PaperTestPlugin(String) with pluginName is 'Plugin may not be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenPaperTestPluginWithPluginNameIsPluginMayNotBeNull() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin may not be null"),
                mock(Consumer.class),
                6L,
                TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when six; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenSix_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin Name"), mock(Consumer.class), 6L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}.
   *
   * <ul>
   *   <li>When thirty.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runDelayed(Plugin, Consumer, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runDelayed(Plugin, Consumer, long, TimeUnit); when thirty; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runDelayed(Plugin, Consumer, long, TimeUnit)"
  })
  void testRunDelayed_whenThirty_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runDelayed(
                new PaperTestPlugin("Plugin Name"),
                mock(Consumer.class),
                30L,
                TimeUnit.MICROSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName("Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin may not be null");
    plugin.setEnabled(true);

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, mock(Consumer.class), 1L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName("Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin("Plugin may not be null");
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.NANOSECONDS));
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'false'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenFalse_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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
   *   <li>When {@code MILLISECONDS}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException(); when 'MILLISECONDS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException_whenMilliseconds() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 0L, 1L, TimeUnit.MILLISECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When thirty.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException(); when thirty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException_whenThirty() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 30L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException(); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException_whenThree() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 3L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When two.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException(); when two; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException_whenTwo_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 2L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When two.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalArgumentException(); when two; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalArgumentException_whenTwo_thenReturnNotCancelled2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 0L, 2L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

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
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   *   <li>When {@code SECONDS}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'; when 'SECONDS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg_whenSeconds() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler.runAtFixedRate(plugin, task, 0L, 1L, TimeUnit.SECONDS).isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg_whenThree() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 3L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'; when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg_whenThree2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 0L, 3L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg_whenTwo() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 2L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link IllegalPluginAccessException#IllegalPluginAccessException(String)} with
   *       {@code Msg}.
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given IllegalPluginAccessException(String) with 'Msg'; when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenIllegalPluginAccessExceptionWithMsg_whenTwo2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalPluginAccessException("Msg"))
        .when(task)
        .accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 0L, 2L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code Plugin may not be null}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'Plugin may not be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenPluginMayNotBeNull() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperPluginMeta configuration = new PaperPluginMeta();
    configuration.setName("Plugin may not be null");

    PaperTestPlugin plugin = new PaperTestPlugin(configuration);
    plugin.setEnabled(true);

    Consumer<ScheduledTask> task = mock(Consumer.class);
    doThrow(new IllegalArgumentException()).when(task).accept(Mockito.<ScheduledTask>any());

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, task, 0L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Consumer}.
   *   <li>Then return not Cancelled.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when Consumer; then return not Cancelled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenConsumer_thenReturnNotCancelled() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, mock(Consumer.class), 1L, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, mock(Consumer.class), Long.MAX_VALUE, 1L, TimeUnit.NANOSECONDS)
            .isCancelled());
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, mock(Consumer.class), 0L, Long.MAX_VALUE, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); given 'true'; when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_givenTrue_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), -1L, 1L, TimeUnit.NANOSECONDS));
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

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(true);

    // Act and Assert
    assertFalse(
        foliaAsyncScheduler
            .runAtFixedRate(plugin, mock(Consumer.class), 0L, 30L, TimeUnit.NANOSECONDS)
            .isCancelled());
  }

  /**
   * Test {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_thenThrowIllegalArgumentException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_thenThrowIllegalPluginAccessException() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
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
   *   <li>Then throw {@link IllegalPluginAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link FoliaAsyncScheduler#runAtFixedRate(Plugin, Consumer, long, long,
   * TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test runAtFixedRate(Plugin, Consumer, long, long, TimeUnit); then throw IllegalPluginAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledTask FoliaAsyncScheduler.runAtFixedRate(Plugin, Consumer, long, long, TimeUnit)"
  })
  void testRunAtFixedRate_thenThrowIllegalPluginAccessException2() {
    // Arrange
    FoliaAsyncScheduler foliaAsyncScheduler = new FoliaAsyncScheduler();

    PaperTestPlugin plugin = new PaperTestPlugin(new PaperPluginMeta());
    plugin.setEnabled(false);

    // Act and Assert
    assertThrows(
        IllegalPluginAccessException.class,
        () ->
            foliaAsyncScheduler.runAtFixedRate(
                plugin, mock(Consumer.class), 1L, 1L, TimeUnit.NANOSECONDS));
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
                1L,
                1L,
                TimeUnit.NANOSECONDS)
            .isCancelled());
  }
}
