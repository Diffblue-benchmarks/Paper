package com.destroystokyo.paper.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import net.minecraft.gametest.framework.GameTestServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RAMDetailsDiffblueTest {
  /**
   * Test {@link RAMDetails#getPreferredSize()}.
   *
   * <p>Method under test: {@link RAMDetails#getPreferredSize()}
   */
  @Test
  @DisplayName("Test getPreferredSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dimension RAMDetails.getPreferredSize()"})
  void testGetPreferredSize() {
    // Arrange and Act
    Dimension actualPreferredSize = new RAMDetails(mock(GameTestServer.class)).getPreferredSize();

    // Assert
    assertEquals(100, actualPreferredSize.height);
    assertEquals(100.0d, actualPreferredSize.getHeight());
    assertEquals(350, actualPreferredSize.width);
    assertEquals(350.0d, actualPreferredSize.getWidth());
    Dimension actualSize = actualPreferredSize.getSize();
    assertEquals(actualPreferredSize, actualSize);
  }

  /**
   * Test {@link RAMDetails#getAverage(long[])}.
   *
   * <p>Method under test: {@link RAMDetails#getAverage(long[])}
   */
  @Test
  @DisplayName("Test getAverage(long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double RAMDetails.getAverage(long[])"})
  void testGetAverage() {
    // Arrange and Act
    double actualAverage =
        new RAMDetails(mock(GameTestServer.class)).getAverage(new long[] {1L, 100L, 1L, 100L});

    // Assert
    assertEquals(0.050499999999999996d, actualAverage);
  }
}
