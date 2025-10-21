package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingDataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingData#TimingData(int)}
   *   <li>{@link TimingData#setCurTickCount(int)}
   *   <li>{@link TimingData#setCurTickTotal(long)}
   *   <li>{@link TimingData#getCurTickCount()}
   *   <li>{@link TimingData#getCurTickTotal()}
   *   <li>{@link TimingData#getTotalTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimingData.<init>(int)",
    "int TimingData.getCurTickCount()",
    "long TimingData.getCurTickTotal()",
    "long TimingData.getTotalTime()",
    "void TimingData.setCurTickCount(int)",
    "void TimingData.setCurTickTotal(long)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TimingData actualTimingData = new TimingData(1);
    actualTimingData.setCurTickCount(3);
    actualTimingData.setCurTickTotal(1L);
    int actualCurTickCount = actualTimingData.getCurTickCount();
    long actualCurTickTotal = actualTimingData.getCurTickTotal();

    // Assert
    assertEquals(0L, actualTimingData.getTotalTime());
    assertEquals(1L, actualCurTickTotal);
    assertEquals(3, actualCurTickCount);
  }

  /**
   * Test {@link TimingData#add(long)}.
   *
   * <p>Method under test: {@link TimingData#add(long)}
   */
  @Test
  @DisplayName("Test add(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingData.add(long)"})
  void testAdd() {
    // Arrange
    TimingData timingData = new TimingData(1);

    // Act
    timingData.add(1L);

    // Assert
    assertEquals(1, timingData.getCurTickCount());
    assertEquals(1L, timingData.getCurTickTotal());
  }

  /**
   * Test {@link TimingData#clone()}.
   *
   * <p>Method under test: {@link TimingData#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimingData TimingData.clone()"})
  void testClone() {
    // Arrange and Act
    TimingData actualCloneResult = new TimingData(1).clone();

    // Assert
    assertEquals(0, actualCloneResult.getCurTickCount());
    assertEquals(0L, actualCloneResult.getCurTickTotal());
    assertEquals(0L, actualCloneResult.getTotalTime());
    assertFalse(actualCloneResult.hasData());
  }

  /**
   * Test {@link TimingData#export()}.
   *
   * <p>Method under test: {@link TimingData#export()}
   */
  @Test
  @DisplayName("Test export()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TimingData.export()"})
  void testExport() {
    // Arrange and Act
    List<Object> actualExportResult = new TimingData(1).export();

    // Assert
    assertEquals(3, actualExportResult.size());
    assertEquals(0, ((Integer) actualExportResult.get(1)).intValue());
    assertEquals(0L, ((Long) actualExportResult.get(2)).longValue());
    assertEquals(1, ((Integer) actualExportResult.get(0)).intValue());
  }

  /**
   * Test {@link TimingData#hasData()}.
   *
   * <p>Method under test: {@link TimingData#hasData()}
   */
  @Test
  @DisplayName("Test hasData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingData.hasData()"})
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse(new TimingData(1).hasData());
  }
}
