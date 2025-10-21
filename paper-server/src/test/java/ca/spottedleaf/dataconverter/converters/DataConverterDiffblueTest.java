package ca.spottedleaf.dataconverter.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ca.spottedleaf.dataconverter.minecraft.converters.chunk.ConverterFlattenChunk;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataConverterDiffblueTest {
  /**
   * Test {@link DataConverter#getToVersion()}.
   *
   * <p>Method under test: {@link DataConverter#getToVersion()}
   */
  @Test
  @DisplayName("Test getToVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataConverter.getToVersion()"})
  void testGetToVersion() {
    // Arrange, Act and Assert
    assertEquals(1451, new ConverterFlattenChunk().getToVersion());
  }

  /**
   * Test {@link DataConverter#getVersionStep()}.
   *
   * <p>Method under test: {@link DataConverter#getVersionStep()}
   */
  @Test
  @DisplayName("Test getVersionStep()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataConverter.getVersionStep()"})
  void testGetVersionStep() {
    // Arrange, Act and Assert
    assertEquals(1, new ConverterFlattenChunk().getVersionStep());
  }

  /**
   * Test {@link DataConverter#getEncodedVersion()}.
   *
   * <p>Method under test: {@link DataConverter#getEncodedVersion()}
   */
  @Test
  @DisplayName("Test getEncodedVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataConverter.getEncodedVersion()"})
  void testGetEncodedVersion() {
    // Arrange, Act and Assert
    assertEquals(6231997546497L, new ConverterFlattenChunk().getEncodedVersion());
  }

  /**
   * Test {@link DataConverter#encodeVersions(int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code -4294967293}.
   * </ul>
   *
   * <p>Method under test: {@link DataConverter#encodeVersions(int, int)}
   */
  @Test
  @DisplayName("Test encodeVersions(int, int); when minus one; then return '-4294967293'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataConverter.encodeVersions(int, int)"})
  void testEncodeVersions_whenMinusOne_thenReturn4294967293() {
    // Arrange, Act and Assert
    assertEquals(-4294967293L, DataConverter.encodeVersions(-1, 3));
  }

  /**
   * Test {@link DataConverter#encodeVersions(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 4294967299}.
   * </ul>
   *
   * <p>Method under test: {@link DataConverter#encodeVersions(int, int)}
   */
  @Test
  @DisplayName("Test encodeVersions(int, int); when one; then return '4294967299'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataConverter.encodeVersions(int, int)"})
  void testEncodeVersions_whenOne_thenReturn4294967299() {
    // Arrange, Act and Assert
    assertEquals(4294967299L, DataConverter.encodeVersions(1, 3));
  }

  /**
   * Test {@link DataConverter#encodeVersions(int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return {@code 137438953475}.
   * </ul>
   *
   * <p>Method under test: {@link DataConverter#encodeVersions(int, int)}
   */
  @Test
  @DisplayName("Test encodeVersions(int, int); when SIZE; then return '137438953475'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataConverter.encodeVersions(int, int)"})
  void testEncodeVersions_whenSize_thenReturn137438953475() {
    // Arrange, Act and Assert
    assertEquals(137438953475L, DataConverter.encodeVersions(Integer.SIZE, 3));
  }

  /**
   * Test {@link DataConverter#encodeVersions(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 12884901891}.
   * </ul>
   *
   * <p>Method under test: {@link DataConverter#encodeVersions(int, int)}
   */
  @Test
  @DisplayName("Test encodeVersions(int, int); when three; then return '12884901891'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataConverter.encodeVersions(int, int)"})
  void testEncodeVersions_whenThree_thenReturn12884901891() {
    // Arrange, Act and Assert
    assertEquals(12884901891L, DataConverter.encodeVersions(3, 3));
  }

  /**
   * Test {@link DataConverter#getVersion(long)}.
   *
   * <p>Method under test: {@link DataConverter#getVersion(long)}
   */
  @Test
  @DisplayName("Test getVersion(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataConverter.getVersion(long)"})
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals(0, DataConverter.getVersion(1L));
  }

  /**
   * Test {@link DataConverter#getStep(long)}.
   *
   * <p>Method under test: {@link DataConverter#getStep(long)}
   */
  @Test
  @DisplayName("Test getStep(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataConverter.getStep(long)"})
  void testGetStep() {
    // Arrange, Act and Assert
    assertEquals(1, DataConverter.getStep(1L));
  }

  /**
   * Test {@link DataConverter#encodedToString(long)}.
   *
   * <p>Method under test: {@link DataConverter#encodedToString(long)}
   */
  @Test
  @DisplayName("Test encodedToString(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DataConverter.encodedToString(long)"})
  void testEncodedToString() {
    // Arrange, Act and Assert
    assertEquals("0.1", DataConverter.encodedToString(1L));
  }
}
