package io.papermc.paper.adventure.providers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import net.kyori.adventure.text.event.DataComponentValueConverterRegistry;
import net.kyori.adventure.text.event.DataComponentValueConverterRegistry.Conversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataComponentValueConverterProviderImplDiffblueTest {
  /**
   * Test {@link DataComponentValueConverterProviderImpl#id()}.
   *
   * <p>Method under test: {@link DataComponentValueConverterProviderImpl#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.kyori.adventure.key.Key DataComponentValueConverterProviderImpl.id()"})
  void testId() {
    // Arrange, Act and Assert
    assertSame(
        DataComponentValueConverterProviderImpl.ID,
        new DataComponentValueConverterProviderImpl().id());
  }

  /**
   * Test {@link DataComponentValueConverterProviderImpl#conversions()}.
   *
   * <p>Method under test: {@link DataComponentValueConverterProviderImpl#conversions()}
   */
  @Test
  @DisplayName("Test conversions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable DataComponentValueConverterProviderImpl.conversions()"})
  void testConversions() {
    // Arrange and Act
    Iterable<Conversion<?, ?>> actualConversionsResult =
        new DataComponentValueConverterProviderImpl().conversions();
    Iterator<Conversion<?, ?>> actualIteratorResult = actualConversionsResult.iterator();

    // Assert
    assertTrue(actualConversionsResult instanceof List);
    assertEquals(5, ((List<Conversion<?, ?>>) actualConversionsResult).size());
    Conversion<?, ?> expectedNextResult = ((List<Conversion<?, ?>>) actualConversionsResult).get(0);
    Conversion<?, ?> expectedNextResult2 =
        ((List<Conversion<?, ?>>) actualConversionsResult).get(1);
    Conversion<?, ?> expectedNextResult3 =
        ((List<Conversion<?, ?>>) actualConversionsResult).get(2);
    Conversion<?, ?> expectedNextResult4 =
        ((List<Conversion<?, ?>>) actualConversionsResult).get(3);
    Conversion<?, ?> expectedNextResult5 =
        ((List<Conversion<?, ?>>) actualConversionsResult).get(4);
    Conversion<?, ?> actualNextResult = actualIteratorResult.next();
    Conversion<?, ?> actualNextResult2 = actualIteratorResult.next();
    Conversion<?, ?> actualNextResult3 = actualIteratorResult.next();
    Conversion<?, ?> actualNextResult4 = actualIteratorResult.next();
    Conversion<?, ?> actualNextResult5 = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertSame(expectedNextResult2, actualNextResult2);
    assertSame(expectedNextResult3, actualNextResult3);
    assertSame(expectedNextResult4, actualNextResult4);
    assertSame(expectedNextResult5, actualNextResult5);
  }

  /**
   * Test new {@link DataComponentValueConverterProviderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DataComponentValueConverterProviderImpl}
   */
  @Test
  @DisplayName("Test new DataComponentValueConverterProviderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataComponentValueConverterProviderImpl.<init>()"})
  void testNewDataComponentValueConverterProviderImpl() {
    // Arrange, Act and Assert
    assertSame(
        DataComponentValueConverterProviderImpl.ID,
        new DataComponentValueConverterProviderImpl().id());
  }
}
