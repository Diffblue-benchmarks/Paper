package io.papermc.paper.antixray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BitStorageReaderDiffblueTest {
  /**
   * Test {@link BitStorageReader#read()}.
   *
   * <p>Method under test: {@link BitStorageReader#read()}
   */
  @Test
  @DisplayName("Test read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BitStorageReader.read()"})
  void testRead() {
    // Arrange, Act and Assert
    assertEquals(0, new BitStorageReader().read());
  }
}
