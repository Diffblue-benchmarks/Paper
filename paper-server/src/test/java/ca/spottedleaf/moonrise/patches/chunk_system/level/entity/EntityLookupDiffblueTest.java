package ca.spottedleaf.moonrise.patches.chunk_system.level.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ArrayIterable;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ArrayIterable.ArrayIterator;
import ca.spottedleaf.moonrise.patches.chunk_system.level.entity.EntityLookup.ChunkSlicesRegion;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class EntityLookupDiffblueTest {
  /**
   * Test ArrayIterable {@link ArrayIterable#iterator()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayIterable.ArrayIterator}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayIterable#iterator()}
   */
  @Test
  @DisplayName("Test ArrayIterable iterator(); then return ArrayIterator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator ArrayIterable.iterator()"})
  void testArrayIterableIterator_thenReturnArrayIterator() {
    // Arrange
    Object[] array = new Object[] {ConfigurationTransformation.WILDCARD_OBJECT};
    ArrayIterable<Object> arrayIterable = new ArrayIterable<>(array, 1, 1);

    // Act
    Iterator<Object> actualIteratorResult = arrayIterable.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof ArrayIterator);
    assertFalse(actualIteratorResult.hasNext());
  }

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
}
