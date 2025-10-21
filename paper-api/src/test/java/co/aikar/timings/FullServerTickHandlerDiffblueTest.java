package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FullServerTickHandlerDiffblueTest {
  /**
   * Test {@link FullServerTickHandler#FullServerTickHandler()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link FullServerTickHandler}
   */
  @Test
  @DisplayName("Test new FullServerTickHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FullServerTickHandler.<init>()"})
  void testNewFullServerTickHandler() {
    // Arrange and Act
    FullServerTickHandler actualFullServerTickHandler = new FullServerTickHandler();

    // Assert
    TimingIdentifier timingIdentifier = actualFullServerTickHandler.identifier;
    assertEquals("Full Server Tick", timingIdentifier.name);
    assertEquals("Minecraft", timingIdentifier.group);
    assertNull(timingIdentifier.groupHandler);
    assertEquals(-1.0d, actualFullServerTickHandler.avgFreeMemory);
    assertEquals(-1.0d, actualFullServerTickHandler.avgUsedMemory);
    TimingData timingData = actualFullServerTickHandler.minuteData;
    assertEquals(0, timingData.getCurTickCount());
    TimingData timingData2 = actualFullServerTickHandler.record;
    assertEquals(0, timingData2.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(0L, timingData2.getCurTickTotal());
    assertEquals(0L, timingData.getTotalTime());
    assertEquals(0L, timingData2.getTotalTime());
    assertFalse(actualFullServerTickHandler.isEnabled());
    assertFalse(actualFullServerTickHandler.isSpecial());
    assertFalse(actualFullServerTickHandler.isViolated());
    assertFalse(timingData.hasData());
    assertFalse(timingData2.hasData());
    assertFalse(actualFullServerTickHandler.isTimed());
  }

  /**
   * Test {@link FullServerTickHandler#startTiming()}.
   *
   * <p>Method under test: {@link FullServerTickHandler#startTiming()}
   */
  @Test
  @DisplayName("Test startTiming()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timing FullServerTickHandler.startTiming()"})
  void testStartTiming() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act
    Timing actualStartTimingResult = fullServerTickHandler.startTiming();

    // Assert
    assertSame(fullServerTickHandler, actualStartTimingResult);
  }

  /**
   * Test {@link FullServerTickHandler#isViolated()}.
   *
   * <p>Method under test: {@link FullServerTickHandler#isViolated()}
   */
  @Test
  @DisplayName("Test isViolated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FullServerTickHandler.isViolated()"})
  void testIsViolated() {
    // Arrange, Act and Assert
    assertFalse(TimingsManager.FULL_SERVER_TICK.isViolated());
  }
}
