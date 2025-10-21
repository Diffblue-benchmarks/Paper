package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnsafeTimingHandlerDiffblueTest {
  /**
   * Test {@link UnsafeTimingHandler#UnsafeTimingHandler(TimingIdentifier)}.
   *
   * <p>Method under test: {@link UnsafeTimingHandler#UnsafeTimingHandler(TimingIdentifier)}
   */
  @Test
  @DisplayName("Test new UnsafeTimingHandler(TimingIdentifier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnsafeTimingHandler.<init>(TimingIdentifier)"})
  void testNewUnsafeTimingHandler() {
    // Arrange
    TimingIdentifier id = new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act
    UnsafeTimingHandler actualUnsafeTimingHandler = new UnsafeTimingHandler(id);

    // Assert
    TimingIdentifier timingIdentifier = actualUnsafeTimingHandler.identifier;
    assertEquals("Group", timingIdentifier.group);
    assertEquals("Name", timingIdentifier.name);
    assertNull(timingIdentifier.groupHandler);
    TimingData timingData = actualUnsafeTimingHandler.record;
    assertEquals(0, timingData.getCurTickCount());
    assertEquals(0L, timingData.getCurTickTotal());
    assertEquals(0L, timingData.getTotalTime());
    assertFalse(timingData.hasData());
    assertFalse(actualUnsafeTimingHandler.isEnabled());
    assertFalse(actualUnsafeTimingHandler.isSpecial());
    assertFalse(actualUnsafeTimingHandler.isTimed());
  }
}
