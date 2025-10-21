package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.craftbukkit.scheduler.CraftTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerSchedulerReportingWrapperDiffblueTest {
  /**
   * Test {@link ServerSchedulerReportingWrapper#ServerSchedulerReportingWrapper(CraftTask)}.
   *
   * <ul>
   *   <li>Then return InternalTask is {@link CraftTask}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServerSchedulerReportingWrapper#ServerSchedulerReportingWrapper(CraftTask)}
   */
  @Test
  @DisplayName(
      "Test new ServerSchedulerReportingWrapper(CraftTask); then return InternalTask is CraftTask")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerSchedulerReportingWrapper.<init>(CraftTask)"})
  void testNewServerSchedulerReportingWrapper_thenReturnInternalTaskIsCraftTask() {
    // Arrange
    CraftTask internalTask = mock(CraftTask.class);

    // Act and Assert
    assertSame(internalTask, new ServerSchedulerReportingWrapper(internalTask).getInternalTask());
  }

  /**
   * Test {@link ServerSchedulerReportingWrapper#run()}.
   *
   * <ul>
   *   <li>Given {@link CraftTask} {@link CraftTask#run()} does nothing.
   *   <li>Then calls {@link CraftTask#run()}.
   * </ul>
   *
   * <p>Method under test: {@link ServerSchedulerReportingWrapper#run()}
   */
  @Test
  @DisplayName("Test run(); given CraftTask run() does nothing; then calls run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServerSchedulerReportingWrapper.run()"})
  void testRun_givenCraftTaskRunDoesNothing_thenCallsRun() {
    // Arrange
    CraftTask internalTask = mock(CraftTask.class);
    doNothing().when(internalTask).run();

    // Act
    new ServerSchedulerReportingWrapper(internalTask).run();

    // Assert
    verify(internalTask).run();
  }
}
