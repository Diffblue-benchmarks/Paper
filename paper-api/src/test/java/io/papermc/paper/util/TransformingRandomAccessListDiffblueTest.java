package io.papermc.paper.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.util.TransformingRandomAccessList.TransformedListIterator;
import it.unimi.dsi.fastutil.objects.ObjectIterators;
import it.unimi.dsi.fastutil.objects.ObjectIterators.UnmodifiableListIterator;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransformingRandomAccessListDiffblueTest {
  /**
   * Test {@link TransformingRandomAccessList#TransformingRandomAccessList(List, Function,
   * Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TransformingRandomAccessList#TransformingRandomAccessList(List,
   * Function, Function)}
   */
  @Test
  @DisplayName(
      "Test new TransformingRandomAccessList(List, Function, Function); given '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformingRandomAccessList.<init>(List, Function, Function)"})
  void testNewTransformingRandomAccessList_given42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> fromList = new ArrayList<>();
    fromList.add("42");

    // Act
    TransformingRandomAccessList<Object, Object> actualObjectList =
        new TransformingRandomAccessList<>(fromList, mock(Function.class), mock(Function.class));

    // Assert
    assertEquals(1, actualObjectList.size());
    assertNull(actualObjectList.get(0));
  }

  /**
   * Test {@link TransformingRandomAccessList#TransformingRandomAccessList(List, Function,
   * Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TransformingRandomAccessList#TransformingRandomAccessList(List,
   * Function, Function)}
   */
  @Test
  @DisplayName(
      "Test new TransformingRandomAccessList(List, Function, Function); given '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformingRandomAccessList.<init>(List, Function, Function)"})
  void testNewTransformingRandomAccessList_given42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Object> fromList = new ArrayList<>();
    fromList.add("42");
    fromList.add("42");

    // Act
    TransformingRandomAccessList<Object, Object> actualObjectList =
        new TransformingRandomAccessList<>(fromList, mock(Function.class), mock(Function.class));

    // Assert
    assertEquals(2, actualObjectList.size());
    assertNull(actualObjectList.get(0));
    assertNull(actualObjectList.get(1));
  }

  /**
   * Test {@link TransformingRandomAccessList#TransformingRandomAccessList(List, Function,
   * Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link TransformingRandomAccessList#fromList}.
   * </ul>
   *
   * <p>Method under test: {@link TransformingRandomAccessList#TransformingRandomAccessList(List,
   * Function, Function)}
   */
  @Test
  @DisplayName(
      "Test new TransformingRandomAccessList(List, Function, Function); when ArrayList(); then return fromList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TransformingRandomAccessList.<init>(List, Function, Function)"})
  void testNewTransformingRandomAccessList_whenArrayList_thenReturnFromList() {
    // Arrange and Act
    TransformingRandomAccessList<Object, Object> actualObjectList =
        new TransformingRandomAccessList<>(
            new ArrayList<>(), mock(Function.class), mock(Function.class));

    // Assert
    List<Object> expectedObjectList = actualObjectList.fromList;
    assertEquals(expectedObjectList, actualObjectList);
  }

  /**
   * Test TransformedListIterator {@link TransformedListIterator#cast(Iterator)}.
   *
   * <p>Method under test: {@link TransformedListIterator#cast(Iterator)}
   */
  @Test
  @DisplayName("Test TransformedListIterator cast(Iterator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListIterator TransformedListIterator.cast(Iterator)"})
  void testTransformedListIteratorCast() {
    // Arrange and Act
    ListIterator<Object> actualCastResult =
        TransformedListIterator.cast(
            new UnmodifiableListIterator<>(mock(ObjectListIterator.class)));

    // Assert
    assertTrue(actualCastResult instanceof UnmodifiableListIterator);
    assertFalse(actualCastResult.hasNext());
  }
}
