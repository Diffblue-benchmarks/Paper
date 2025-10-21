package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.destroystokyo.paper.MaterialSetTag;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import net.kyori.adventure.key.Key;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyedDiffblueTest {
  /**
   * Test {@link Keyed#key()}.
   *
   * <p>Method under test: {@link Keyed#key()}
   */
  @Test
  @DisplayName("Test key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key Keyed.key()"})
  void testKey() {
    // Arrange and Act
    Key actualKeyResult = new MaterialSetTag(new ArrayList<>()).key();

    // Assert
    assertTrue(actualKeyResult instanceof NamespacedKey);
    assertEquals(NamespacedKey.BUKKIT, actualKeyResult.namespace());
    assertEquals(NamespacedKey.BUKKIT, ((NamespacedKey) actualKeyResult).getNamespace());
  }
}
