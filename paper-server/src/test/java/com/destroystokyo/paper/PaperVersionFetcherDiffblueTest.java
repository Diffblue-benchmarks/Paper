package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperVersionFetcherDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PaperVersionFetcher}
   *   <li>{@link PaperVersionFetcher#getCacheTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaperVersionFetcher.<init>()",
    "long PaperVersionFetcher.getCacheTime()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(720000L, new PaperVersionFetcher().getCacheTime());
  }
}
