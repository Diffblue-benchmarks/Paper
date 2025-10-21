package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingHistoryEntryDiffblueTest {
  /**
   * Test {@link TimingHistoryEntry#TimingHistoryEntry(TimingHandler)}.
   *
   * <ul>
   *   <li>When {@link TimingsManager#TIMINGS_TICK}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHistoryEntry#TimingHistoryEntry(TimingHandler)}
   */
  @Test
  @DisplayName("Test new TimingHistoryEntry(TimingHandler); when TIMINGS_TICK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHistoryEntry.<init>(TimingHandler)"})
  void testNewTimingHistoryEntry_whenTimings_tick() {
    // Arrange, Act and Assert
    TimingData timingData = new TimingHistoryEntry(TimingsManager.TIMINGS_TICK).data;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(0L, timingData.getTotalTime());
    assertFalse(timingData.hasData());
  }

  /**
   * Test {@link TimingHistoryEntry#export()}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link TimingHistoryEntry#export()}
   */
  @Test
  @DisplayName("Test export(); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TimingHistoryEntry.export()"})
  void testExport_thenReturnSizeIsThree() {
    // Arrange
    TimingIdentifier id = new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act
    List<Object> actualExportResult = new TimingHistoryEntry(new TimingHandler(id)).export();

    // Assert
    assertEquals(3, actualExportResult.size());
    assertEquals(0, ((Integer) actualExportResult.get(1)).intValue());
    assertEquals(0L, ((Long) actualExportResult.get(2)).longValue());
  }
}
