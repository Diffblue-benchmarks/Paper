package io.papermc.paper.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BrewingSimpleContainerDataDiffblueTest {
  /**
   * Test new {@link BrewingSimpleContainerData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BrewingSimpleContainerData}
   */
  @Test
  @DisplayName("Test new BrewingSimpleContainerData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BrewingSimpleContainerData.<init>()"})
  void testNewBrewingSimpleContainerData() {
    // Arrange, Act and Assert
    assertEquals(3, new BrewingSimpleContainerData().getCount());
  }
}
