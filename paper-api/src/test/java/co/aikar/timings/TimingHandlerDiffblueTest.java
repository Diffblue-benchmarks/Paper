package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingHandlerDiffblueTest {
  /**
   * Test {@link TimingHandler#TimingHandler(TimingIdentifier)}.
   *
   * <ul>
   *   <li>Then return {@link TimingHandler#identifier} {@link TimingIdentifier#group} is {@code
   *       Group}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#TimingHandler(TimingIdentifier)}
   */
  @Test
  @DisplayName("Test new TimingHandler(TimingIdentifier); then return identifier group is 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.<init>(TimingIdentifier)"})
  void testNewTimingHandler_thenReturnIdentifierGroupIsGroup() {
    // Arrange
    TimingIdentifier id = new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act
    TimingHandler actualTimingHandler = new TimingHandler(id);

    // Assert
    TimingIdentifier timingIdentifier = actualTimingHandler.identifier;
    assertEquals("Group", timingIdentifier.group);
    assertEquals("Name", timingIdentifier.name);
    assertNull(timingIdentifier.groupHandler);
    TimingData timingData = actualTimingHandler.record;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(0L, timingData.getTotalTime());
    assertFalse(timingData.hasData());
    assertFalse(actualTimingHandler.isEnabled());
    assertFalse(actualTimingHandler.isSpecial());
    assertFalse(actualTimingHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#TimingHandler(TimingIdentifier)}.
   *
   * <ul>
   *   <li>Then return {@link TimingHandler#identifier} {@link TimingIdentifier#group} is {@code
   *       ##}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#TimingHandler(TimingIdentifier)}
   */
  @Test
  @DisplayName("Test new TimingHandler(TimingIdentifier); then return identifier group is '##'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.<init>(TimingIdentifier)"})
  void testNewTimingHandler_thenReturnIdentifierGroupIsNumberSignNumberSign() {
    // Arrange
    TimingIdentifier id = new TimingIdentifier("##", "Name", NullTimingHandler.NULL);

    // Act
    TimingHandler actualTimingHandler = new TimingHandler(id);

    // Assert
    TimingIdentifier timingIdentifier = actualTimingHandler.identifier;
    assertEquals("##", timingIdentifier.group);
    assertEquals("Name", timingIdentifier.name);
    assertNull(timingIdentifier.groupHandler);
    TimingData timingData = actualTimingHandler.record;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(0L, timingData.getTotalTime());
    assertFalse(timingData.hasData());
    assertFalse(actualTimingHandler.isEnabled());
    assertFalse(actualTimingHandler.isSpecial());
    assertFalse(actualTimingHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#processTick(boolean)}.
   *
   * <ul>
   *   <li>Then {@link FullServerTickHandler#FullServerTickHandler()} {@link TimingHandler#record}
   *       CurTickCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#processTick(boolean)}
   */
  @Test
  @DisplayName(
      "Test processTick(boolean); then FullServerTickHandler() record CurTickCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.processTick(boolean)"})
  void testProcessTick_thenFullServerTickHandlerRecordCurTickCountIsZero() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Act
    fullServerTickHandler.processTick(true);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(1L, timingData.getTotalTime());
    assertTrue(timingData.hasData());
  }

  /**
   * Test {@link TimingHandler#processTick(boolean)}.
   *
   * <ul>
   *   <li>Then {@link FullServerTickHandler#FullServerTickHandler()} {@link TimingHandler#record}
   *       CurTickCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#processTick(boolean)}
   */
  @Test
  @DisplayName(
      "Test processTick(boolean); then FullServerTickHandler() record CurTickCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.processTick(boolean)"})
  void testProcessTick_thenFullServerTickHandlerRecordCurTickCountIsZero2() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Act
    fullServerTickHandler.processTick(false);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(1L, timingData.getTotalTime());
    assertTrue(timingData.hasData());
  }

  /**
   * Test {@link TimingHandler#startTimingIfSync()}.
   *
   * <p>Method under test: {@link TimingHandler#startTimingIfSync()}
   */
  @Test
  @DisplayName("Test startTimingIfSync()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timing TimingHandler.startTimingIfSync()"})
  void testStartTimingIfSync() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act
    Timing actualStartTimingIfSyncResult = fullServerTickHandler.startTimingIfSync();

    // Assert
    assertSame(fullServerTickHandler, actualStartTimingIfSyncResult);
  }

  /**
   * Test {@link TimingHandler#startTiming()}.
   *
   * <p>Method under test: {@link TimingHandler#startTiming()}
   */
  @Test
  @DisplayName("Test startTiming()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timing TimingHandler.startTiming()"})
  void testStartTiming() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act
    Timing actualStartTimingResult = fullServerTickHandler.startTiming();

    // Assert
    assertSame(fullServerTickHandler, actualStartTimingResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingHandler#abort()}
   *   <li>{@link TimingHandler#isEnabled()}
   *   <li>{@link TimingHandler#isTimed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimingHandler.abort()",
    "boolean TimingHandler.isEnabled()",
    "boolean TimingHandler.isTimed()"
  })
  void testGettersAndSetters() {
    // Arrange
    TimingIdentifier id = new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);
    TimingHandler timingHandler = new TimingHandler(id);

    // Act
    timingHandler.abort();
    boolean actualIsEnabledResult = timingHandler.isEnabled();

    // Assert
    assertFalse(actualIsEnabledResult);
    assertFalse(timingHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Given {@link FullServerTickHandler#FullServerTickHandler()} addDiff {@link
   *       Long#MIN_VALUE} and {@link TimingsManager#TIMINGS_TICK}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); given FullServerTickHandler() addDiff MIN_VALUE and TIMINGS_TICK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_givenFullServerTickHandlerAddDiffMin_valueAndTimings_tick() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(Long.MIN_VALUE, TimingsManager.TIMINGS_TICK);

    // Act
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(-9223372036854775807L, timingData.getCurTickTotal());
    assertEquals(2, timingData.getCurTickCount());
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Given {@link FullServerTickHandler#FullServerTickHandler()} addDiff minus one and {@link
   *       TimingsManager#FULL_SERVER_TICK}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); given FullServerTickHandler() addDiff minus one and FULL_SERVER_TICK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_givenFullServerTickHandlerAddDiffMinusOneAndFull_server_tick() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(-1L, TimingsManager.FULL_SERVER_TICK);

    // Act
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(2, timingData.getCurTickCount());
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Given {@link FullServerTickHandler#FullServerTickHandler()} addDiff minus one and {@link
   *       TimingsManager#TIMINGS_TICK}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); given FullServerTickHandler() addDiff minus one and TIMINGS_TICK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_givenFullServerTickHandlerAddDiffMinusOneAndTimings_tick() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(-1L, TimingsManager.TIMINGS_TICK);

    // Act
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(2, timingData.getCurTickCount());
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Given {@link TimingsManager#FULL_SERVER_TICK}.
   *   <li>When {@link TimingsManager#FULL_SERVER_TICK}.
   *   <li>Then {@link TimingsManager#FULL_SERVER_TICK} Timed.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); given FULL_SERVER_TICK; when FULL_SERVER_TICK; then FULL_SERVER_TICK Timed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_givenFull_server_tick_whenFull_server_tick_thenFull_server_tickTimed() {
    // Arrange
    FullServerTickHandler parent = TimingsManager.FULL_SERVER_TICK;

    // Act
    TimingsManager.FULL_SERVER_TICK.addDiff(1L, parent);

    // Assert that nothing has changed
    assertTrue(parent.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Given {@link TimingsManager#FULL_SERVER_TICK}.
   *   <li>When {@code null}.
   *   <li>Then {@link TimingsManager#FULL_SERVER_TICK} Timed.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); given FULL_SERVER_TICK; when 'null'; then FULL_SERVER_TICK Timed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_givenFull_server_tick_whenNull_thenFull_server_tickTimed() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act
    fullServerTickHandler.addDiff(1L, null);

    // Assert that nothing has changed
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Then {@link FullServerTickHandler#FullServerTickHandler()} {@link TimingHandler#record}
   *       CurTickCount is one.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); then FullServerTickHandler() record CurTickCount is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_thenFullServerTickHandlerRecordCurTickCountIsOne() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();

    // Act
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(1, timingData.getCurTickCount());
    assertEquals(1L, timingData.getCurTickTotal());
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>Then {@link FullServerTickHandler#FullServerTickHandler()} {@link TimingHandler#record}
   *       CurTickTotal is {@code -9223372036854775807}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); then FullServerTickHandler() record CurTickTotal is '-9223372036854775807'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_thenFullServerTickHandlerRecordCurTickTotalIs9223372036854775807() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(Long.MIN_VALUE, TimingsManager.FULL_SERVER_TICK);

    // Act
    fullServerTickHandler.addDiff(1L, TimingsManager.FULL_SERVER_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(-9223372036854775807L, timingData.getCurTickTotal());
    assertEquals(2, timingData.getCurTickCount());
    assertTrue(fullServerTickHandler.isTimed());
  }

  /**
   * Test {@link TimingHandler#addDiff(long, TimingHandler)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link FullServerTickHandler#FullServerTickHandler()} {@link TimingHandler#record}
   *       CurTickTotal is {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#addDiff(long, TimingHandler)}
   */
  @Test
  @DisplayName(
      "Test addDiff(long, TimingHandler); when zero; then FullServerTickHandler() record CurTickTotal is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingHandler.addDiff(long, TimingHandler)"})
  void testAddDiff_whenZero_thenFullServerTickHandlerRecordCurTickTotalIsMin_value() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = new FullServerTickHandler();
    fullServerTickHandler.addDiff(Long.MIN_VALUE, TimingsManager.FULL_SERVER_TICK);

    // Act
    fullServerTickHandler.addDiff(0L, TimingsManager.TIMINGS_TICK);

    // Assert
    TimingData timingData = fullServerTickHandler.record;
    assertEquals(2, timingData.getCurTickCount());
    assertTrue(fullServerTickHandler.isTimed());
    assertEquals(Long.MIN_VALUE, timingData.getCurTickTotal());
  }

  /**
   * Test {@link TimingHandler#getTimingHandler()}.
   *
   * <p>Method under test: {@link TimingHandler#getTimingHandler()}
   */
  @Test
  @DisplayName("Test getTimingHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimingHandler TimingHandler.getTimingHandler()"})
  void testGetTimingHandler() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act
    TimingHandler actualTimingHandler = fullServerTickHandler.getTimingHandler();

    // Assert
    assertSame(fullServerTickHandler, actualTimingHandler);
  }

  /**
   * Test {@link TimingHandler#equals(Object)}, and {@link TimingHandler#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.equals(Object)", "int TimingHandler.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;
    FullServerTickHandler fullServerTickHandler2 = TimingsManager.FULL_SERVER_TICK;

    // Act and Assert
    assertEquals(fullServerTickHandler, fullServerTickHandler2);
    assertEquals(fullServerTickHandler.hashCode(), fullServerTickHandler2.hashCode());
  }

  /**
   * Test {@link TimingHandler#equals(Object)}, and {@link TimingHandler#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.equals(Object)", "int TimingHandler.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FullServerTickHandler fullServerTickHandler = TimingsManager.FULL_SERVER_TICK;

    // Act and Assert
    assertEquals(fullServerTickHandler, fullServerTickHandler);
    int expectedHashCodeResult = fullServerTickHandler.hashCode();
    assertEquals(expectedHashCodeResult, fullServerTickHandler.hashCode());
  }

  /**
   * Test {@link TimingHandler#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.equals(Object)", "int TimingHandler.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FullServerTickHandler(), TimingsManager.FULL_SERVER_TICK);
  }

  /**
   * Test {@link TimingHandler#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.equals(Object)", "int TimingHandler.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimingsManager.FULL_SERVER_TICK, null);
  }

  /**
   * Test {@link TimingHandler#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.equals(Object)", "int TimingHandler.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimingsManager.FULL_SERVER_TICK, "Different type to TimingHandler");
  }

  /**
   * Test {@link TimingHandler#isSpecial()}.
   *
   * <ul>
   *   <li>Given {@link FullServerTickHandler#FullServerTickHandler()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#isSpecial()}
   */
  @Test
  @DisplayName("Test isSpecial(); given FullServerTickHandler(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.isSpecial()"})
  void testIsSpecial_givenFullServerTickHandler_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FullServerTickHandler().isSpecial());
  }

  /**
   * Test {@link TimingHandler#isSpecial()}.
   *
   * <ul>
   *   <li>Given {@link TimingsManager#FULL_SERVER_TICK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#isSpecial()}
   */
  @Test
  @DisplayName("Test isSpecial(); given FULL_SERVER_TICK; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.isSpecial()"})
  void testIsSpecial_givenFull_server_tick_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TimingsManager.FULL_SERVER_TICK.isSpecial());
  }

  /**
   * Test {@link TimingHandler#isSpecial()}.
   *
   * <ul>
   *   <li>Given {@link TimingsManager#TIMINGS_TICK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TimingHandler#isSpecial()}
   */
  @Test
  @DisplayName("Test isSpecial(); given TIMINGS_TICK; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingHandler.isSpecial()"})
  void testIsSpecial_givenTimings_tick_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TimingsManager.TIMINGS_TICK.isSpecial());
  }
}
