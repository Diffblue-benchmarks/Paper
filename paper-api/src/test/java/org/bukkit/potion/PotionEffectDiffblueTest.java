package org.bukkit.potion;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PotionEffectDiffblueTest {
  /**
   * Test {@link PotionEffect#PotionEffect(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link PotionEffect#PotionEffect(Map)}
   */
  @Test
  @DisplayName("Test new PotionEffect(Map); when HashMap(); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PotionEffect.<init>(Map)"})
  void testNewPotionEffect_whenHashMap_thenThrowNoSuchElementException() {
    // Arrange, Act and Assert
    assertThrows(NoSuchElementException.class, () -> new PotionEffect(new HashMap<>()));
  }
}
