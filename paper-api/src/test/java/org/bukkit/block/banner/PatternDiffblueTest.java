package org.bukkit.block.banner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PatternDiffblueTest {
  /**
   * Test {@link Pattern#Pattern(Map)}.
   *
   * <ul>
   *   <li>Given {@code SILVER}.
   *   <li>When {@link HashMap#HashMap()} {@code color} is {@code SILVER}.
   * </ul>
   *
   * <p>Method under test: {@link Pattern#Pattern(Map)}
   */
  @Test
  @DisplayName("Test new Pattern(Map); given 'SILVER'; when HashMap() 'color' is 'SILVER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pattern.<init>(Map)"})
  void testNewPattern_givenSilver_whenHashMapColorIsSilver() {
    // Arrange
    HashMap<String, Object> map = new HashMap<>();
    map.put("color", "SILVER");
    map.put("pattern", null);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> new Pattern(map));
  }

  /**
   * Test {@link Pattern#Pattern(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link Pattern#Pattern(Map)}
   */
  @Test
  @DisplayName("Test new Pattern(Map); when HashMap(); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Pattern.<init>(Map)"})
  void testNewPattern_whenHashMap_thenThrowNoSuchElementException() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> new Pattern(new HashMap<>()));
  }
}
