package com.destroystokyo.paper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.destroystokyo.paper.util.VersionFetcher.DummyVersionFetcher;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionFetcherDiffblueTest {
  /**
   * Test DummyVersionFetcher getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DummyVersionFetcher}
   *   <li>{@link DummyVersionFetcher#getCacheTime()}
   * </ul>
   */
  @Test
  @DisplayName("Test DummyVersionFetcher getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DummyVersionFetcher.<init>()",
    "long DummyVersionFetcher.getCacheTime()"
  })
  void testDummyVersionFetcherGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(-1L, new DummyVersionFetcher().getCacheTime());
  }
}
