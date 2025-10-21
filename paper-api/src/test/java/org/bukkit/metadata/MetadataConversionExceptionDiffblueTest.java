package org.bukkit.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MetadataConversionExceptionDiffblueTest {
  /**
   * Test {@link MetadataConversionException#MetadataConversionException(String)}.
   *
   * <p>Method under test: {@link MetadataConversionException#MetadataConversionException(String)}
   */
  @Test
  @DisplayName("Test new MetadataConversionException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetadataConversionException.<init>(String)"})
  void testNewMetadataConversionException() {
    // Arrange and Act
    MetadataConversionException actualMetadataConversionException =
        new MetadataConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualMetadataConversionException.getMessage());
    assertNull(actualMetadataConversionException.getCause());
    assertEquals(0, actualMetadataConversionException.getSuppressed().length);
  }
}
