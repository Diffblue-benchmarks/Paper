package org.bukkit.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapCursorCollectionDiffblueTest {
  /**
   * Test {@link MapCursorCollection#size()}.
   *
   * <p>Method under test: {@link MapCursorCollection#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapCursorCollection.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new MapCursorCollection().size());
  }

  /**
   * Test {@link MapCursorCollection#removeCursor(MapCursor)}.
   *
   * <ul>
   *   <li>When {@link MapCursor}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapCursorCollection#removeCursor(MapCursor)}
   */
  @Test
  @DisplayName("Test removeCursor(MapCursor); when MapCursor; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapCursorCollection.removeCursor(MapCursor)"})
  void testRemoveCursor_whenMapCursor_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MapCursorCollection().removeCursor(mock(MapCursor.class)));
  }

  /**
   * Test {@link MapCursorCollection#addCursor(MapCursor)} with {@code MapCursor}.
   *
   * <ul>
   *   <li>When {@link MapCursor}.
   *   <li>Then {@link MapCursorCollection} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapCursorCollection#addCursor(MapCursor)}
   */
  @Test
  @DisplayName(
      "Test addCursor(MapCursor) with 'MapCursor'; when MapCursor; then MapCursorCollection (default constructor) size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapCursor MapCursorCollection.addCursor(MapCursor)"})
  void testAddCursorWithMapCursor_whenMapCursor_thenMapCursorCollectionSizeIsOne() {
    // Arrange
    MapCursorCollection mapCursorCollection = new MapCursorCollection();
    MapCursor cursor = mock(MapCursor.class);

    // Act
    MapCursor actualAddCursorResult = mapCursorCollection.addCursor(cursor);

    // Assert
    assertEquals(1, mapCursorCollection.size());
    assertSame(cursor, actualAddCursorResult);
  }

  /**
   * Test new {@link MapCursorCollection} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MapCursorCollection}
   */
  @Test
  @DisplayName("Test new MapCursorCollection (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapCursorCollection.<init>()"})
  void testNewMapCursorCollection() {
    // Arrange, Act and Assert
    assertEquals(0, new MapCursorCollection().size());
  }
}
