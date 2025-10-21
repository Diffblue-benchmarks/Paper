package org.bukkit.util.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BukkitObjectInputStreamDiffblueTest {
  /**
   * Test {@link BukkitObjectInputStream#resolveObject(Object)}.
   *
   * <p>Method under test: {@link BukkitObjectInputStream#resolveObject(Object)}
   */
  @Test
  @DisplayName("Test resolveObject(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BukkitObjectInputStream.resolveObject(Object)"})
  void testResolveObject() throws IOException, SecurityException {
    // Arrange, Act and Assert
    assertEquals("Obj", new BukkitObjectInputStream().resolveObject("Obj"));
  }
}
