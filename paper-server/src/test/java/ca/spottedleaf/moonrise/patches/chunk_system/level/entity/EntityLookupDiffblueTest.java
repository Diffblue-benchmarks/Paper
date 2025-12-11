package ca.spottedleaf.moonrise.patches.chunk_system.level.entity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ArrayIterable;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ArrayIterable.ArrayIterator;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ChunkSlicesRegion;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class EntityLookupDiffblueTest {
  /**
   * Test ArrayIterable_ArrayIterator {@link ArrayIterable.ArrayIterator#hasNext()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayIterable.ArrayIterator#hasNext()}
   */
  @Test
  @DisplayName("Test ArrayIterable_ArrayIterator hasNext(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayIterable.ArrayIterator.hasNext()"})
  void testArrayIterable_ArrayIteratorHasNext_thenReturnFalse() {
    // Arrange
    Object[] array = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ArrayIterator<Object> arrayIterator = new ArrayIterator<>(array, 3, 3);

    // Act and Assert
    assertFalse(arrayIterator.hasNext());
  }

  /**
   * Test ArrayIterable_ArrayIterator {@link ArrayIterable.ArrayIterator#hasNext()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayIterable.ArrayIterator#hasNext()}
   */
  @Test
  @DisplayName("Test ArrayIterable_ArrayIterator hasNext(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ArrayIterable.ArrayIterator.hasNext()"})
  void testArrayIterable_ArrayIteratorHasNext_thenReturnTrue() {
    // Arrange
    Object[] array = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ArrayIterator<Object> arrayIterator = new ArrayIterator<>(array, 1, 3);

    // Act and Assert
    assertTrue(arrayIterator.hasNext());
  }

  /**
   * Test ArrayIterable_ArrayIterator {@link ArrayIterable.ArrayIterator#next()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ArrayIterable.ArrayIterator#next()}
   */
  @Test
  @DisplayName("Test ArrayIterable_ArrayIterator next(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ArrayIterable.ArrayIterator.next()"})
  void testArrayIterable_ArrayIteratorNext_thenDoesNotThrow() {
    // Arrange
    ArrayIterator<Object> arrayIterator =
        new ArrayIterator<>(
            new Object[] {
              ConfigurationTransformation.WILDCARD_OBJECT,
              ConfigurationTransformation.WILDCARD_OBJECT
            },
            1,
            3);

    // Act
    assertDoesNotThrow(() -> arrayIterator.next());
  }

  /**
   * Test ArrayIterable_ArrayIterator {@link ArrayIterable.ArrayIterator#next()}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayIterable.ArrayIterator#next()}
   */
  @Test
  @DisplayName("Test ArrayIterable_ArrayIterator next(); then throw NoSuchElementException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ArrayIterable.ArrayIterator.next()"})
  void testArrayIterable_ArrayIteratorNext_thenThrowNoSuchElementException() {
    // Arrange
    Object[] array = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ArrayIterator<Object> arrayIterator = new ArrayIterator<>(array, 3, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> arrayIterator.next());
  }

  /**
   * Test ArrayIterable_ArrayIterator {@link ArrayIterable.ArrayIterator#remove()}.
   *
   * <p>Method under test: {@link ArrayIterable.ArrayIterator#remove()}
   */
  @Test
  @DisplayName("Test ArrayIterable_ArrayIterator remove()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayIterable.ArrayIterator.remove()"})
  void testArrayIterable_ArrayIteratorRemove() {
    // Arrange
    Object[] array = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ArrayIterator<Object> arrayIterator = new ArrayIterator<>(array, 1, 3);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> arrayIterator.remove());
  }

  /**
   * Test ChunkSlicesRegion {@link ChunkSlicesRegion#get(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkSlicesRegion#get(int)}
   */
  @Test
  @DisplayName("Test ChunkSlicesRegion get(int); when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ca.spottedleaf.moonrise.patches.chunk_system.level.entity.ChunkEntitySlices ChunkSlicesRegion.get(int)"
  })
  void testChunkSlicesRegionGet_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ChunkSlicesRegion().get(1));
  }

  /**
   * Test ChunkSlicesRegion new {@link ChunkSlicesRegion} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ChunkSlicesRegion}
   */
  @Test
  @DisplayName("Test ChunkSlicesRegion new ChunkSlicesRegion (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChunkSlicesRegion.<init>()"})
  void testChunkSlicesRegionNewChunkSlicesRegion() {
    // Arrange, Act and Assert
    assertNull(new ChunkSlicesRegion().get(1));
  }

  /**
   * Test ChunkSlicesRegion {@link ChunkSlicesRegion#remove(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link ChunkSlicesRegion#remove(int)}
   */
  @Test
  @DisplayName("Test ChunkSlicesRegion remove(int); when one; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChunkSlicesRegion.remove(int)"})
  void testChunkSlicesRegionRemove_whenOne_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new ChunkSlicesRegion().remove(1));
  }
}
