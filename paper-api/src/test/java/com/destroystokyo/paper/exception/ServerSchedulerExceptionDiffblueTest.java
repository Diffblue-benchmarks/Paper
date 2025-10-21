package com.destroystokyo.paper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.plugin.TestPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerSchedulerExceptionDiffblueTest {
  /**
   * Test {@link ServerSchedulerException#ServerSchedulerException(String, Throwable, BukkitTask)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerSchedulerException#ServerSchedulerException(String,
   * Throwable, BukkitTask)}
   */
  @Test
  @DisplayName(
      "Test new ServerSchedulerException(String, Throwable, BukkitTask); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerSchedulerException.<init>(String, Throwable, BukkitTask)"})
  void testNewServerSchedulerException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    BukkitTask task = mock(BukkitTask.class);
    TestPlugin testPlugin = new TestPlugin("Plugin Name");
    when(task.getOwner()).thenReturn(testPlugin);

    // Act
    ServerSchedulerException actualServerSchedulerException =
        new ServerSchedulerException("An error occurred", cause, task);

    // Assert
    verify(task).getOwner();
    assertEquals("An error occurred", actualServerSchedulerException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerSchedulerException.getMessage());
    assertEquals(0, actualServerSchedulerException.getSuppressed().length);
    assertSame(cause, actualServerSchedulerException.getCause());
    assertSame(testPlugin, actualServerSchedulerException.getResponsiblePlugin());
    assertSame(task, actualServerSchedulerException.getTask());
  }

  /**
   * Test {@link ServerSchedulerException#ServerSchedulerException(String, Throwable, boolean,
   * boolean, BukkitTask)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ServerSchedulerException#ServerSchedulerException(String,
   * Throwable, boolean, boolean, BukkitTask)}
   */
  @Test
  @DisplayName(
      "Test new ServerSchedulerException(String, Throwable, boolean, boolean, BukkitTask); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerSchedulerException.<init>(String, Throwable, boolean, boolean, BukkitTask)"
  })
  void testNewServerSchedulerException_thenReturnLocalizedMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    BukkitTask task = mock(BukkitTask.class);
    TestPlugin testPlugin = new TestPlugin("Plugin Name");
    when(task.getOwner()).thenReturn(testPlugin);

    // Act
    ServerSchedulerException actualServerSchedulerException =
        new ServerSchedulerException("An error occurred", cause, true, true, task);

    // Assert
    verify(task).getOwner();
    assertEquals("An error occurred", actualServerSchedulerException.getLocalizedMessage());
    assertEquals("An error occurred", actualServerSchedulerException.getMessage());
    assertEquals(0, actualServerSchedulerException.getSuppressed().length);
    assertSame(cause, actualServerSchedulerException.getCause());
    assertSame(testPlugin, actualServerSchedulerException.getResponsiblePlugin());
    assertSame(task, actualServerSchedulerException.getTask());
  }

  /**
   * Test {@link ServerSchedulerException#ServerSchedulerException(Throwable, BukkitTask)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ServerSchedulerException#ServerSchedulerException(Throwable,
   * BukkitTask)}
   */
  @Test
  @DisplayName(
      "Test new ServerSchedulerException(Throwable, BukkitTask); then return LocalizedMessage is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerSchedulerException.<init>(Throwable, BukkitTask)"})
  void testNewServerSchedulerException_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    BukkitTask task = mock(BukkitTask.class);
    TestPlugin testPlugin = new TestPlugin("Plugin Name");
    when(task.getOwner()).thenReturn(testPlugin);

    // Act
    ServerSchedulerException actualServerSchedulerException =
        new ServerSchedulerException(cause, task);

    // Assert
    verify(task).getOwner();
    assertEquals("java.lang.Throwable", actualServerSchedulerException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualServerSchedulerException.getMessage());
    assertEquals(0, actualServerSchedulerException.getSuppressed().length);
    assertSame(cause, actualServerSchedulerException.getCause());
    assertSame(testPlugin, actualServerSchedulerException.getResponsiblePlugin());
    assertSame(task, actualServerSchedulerException.getTask());
  }
}
