package co.aikar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import co.aikar.util.JSONUtil.JSONPair;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JSONUtilDiffblueTest {
  /**
   * Test JSONPair {@link JSONPair#JSONPair(String, Object)}.
   *
   * <p>Method under test: {@link JSONPair#JSONPair(String, Object)}
   */
  @Test
  @DisplayName("Test JSONPair new JSONPair(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JSONPair.<init>(String, Object)"})
  void testJSONPairNewJSONPair() {
    // Arrange and Act
    JSONPair actualJsonPair = new JSONPair("Key", "Val");

    // Assert
    assertEquals("Key", actualJsonPair.key);
    assertEquals("Val", actualJsonPair.val);
  }

  /**
   * Test {@link JSONUtil#pair(long, Object)} with {@code long}, {@code Object}.
   *
   * <p>Method under test: {@link JSONUtil#pair(long, Object)}
   */
  @Test
  @DisplayName("Test pair(long, Object) with 'long', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONPair JSONUtil.pair(long, Object)"})
  void testPairWithLongObject() {
    // Arrange and Act
    JSONPair actualPairResult = JSONUtil.pair(1L, "Obj");

    // Assert
    assertEquals("1", actualPairResult.key);
    assertEquals("Obj", actualPairResult.val);
  }

  /**
   * Test {@link JSONUtil#pair(String, Object)} with {@code String}, {@code Object}.
   *
   * <p>Method under test: {@link JSONUtil#pair(String, Object)}
   */
  @Test
  @DisplayName("Test pair(String, Object) with 'String', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONPair JSONUtil.pair(String, Object)"})
  void testPairWithStringObject() {
    // Arrange and Act
    JSONPair actualPairResult = JSONUtil.pair("Key", "Obj");

    // Assert
    assertEquals("Key", actualPairResult.key);
    assertEquals("Obj", actualPairResult.val);
  }

  /**
   * Test {@link JSONUtil#createObject(JSONPair[])}.
   *
   * <p>Method under test: {@link JSONUtil#createObject(JSONPair[])}
   */
  @Test
  @DisplayName("Test createObject(JSONPair[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.createObject(JSONPair[])"})
  void testCreateObject() {
    // Arrange
    JSONPair pairResult = JSONUtil.pair(1L, "Obj");

    // Act
    Map<String, Object> actualCreateObjectResult = JSONUtil.createObject(pairResult);

    // Assert
    assertEquals(1, actualCreateObjectResult.size());
    Object getResult = actualCreateObjectResult.get("1");
    assertEquals("Obj", getResult);
    assertSame(pairResult.val, getResult);
  }

  /**
   * Test {@link JSONUtil#appendObjectData(Map, JSONPair[])}.
   *
   * <p>Method under test: {@link JSONUtil#appendObjectData(Map, JSONPair[])}
   */
  @Test
  @DisplayName("Test appendObjectData(Map, JSONPair[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.appendObjectData(Map, JSONPair[])"})
  void testAppendObjectData() {
    // Arrange
    HashMap<Object, Object> parent = new HashMap<>();
    JSONPair pairResult = JSONUtil.pair(1L, "Obj");

    // Act
    Map<String, Object> actualAppendObjectDataResult =
        JSONUtil.appendObjectData(parent, pairResult);

    // Assert
    assertEquals(1, parent.size());
    assertEquals(1, actualAppendObjectDataResult.size());
    Object getResult = actualAppendObjectDataResult.get("1");
    assertEquals("Obj", getResult);
    Object object = pairResult.val;
    assertSame(object, parent.get("1"));
    assertSame(object, getResult);
  }

  /**
   * Test {@link JSONUtil#toArray(Object[])}.
   *
   * <ul>
   *   <li>When {@code Data}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArray(Object[])}
   */
  @Test
  @DisplayName("Test toArray(Object[]); when 'Data'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArray(Object[])"})
  void testToArray_whenData_thenReturnSizeIsOne() {
    // Arrange and Act
    List actualToArrayResult = JSONUtil.toArray("Data");

    // Assert
    assertEquals(1, actualToArrayResult.size());
    assertEquals("Data", actualToArrayResult.get(0));
  }

  /**
   * Test {@link JSONUtil#toArrayMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArrayMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toArrayMapper(Iterable, Function) with 'Iterable', 'Function'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArrayMapper(Iterable, Function)"})
  void testToArrayMapperWithIterableFunction_givenApply_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List actualToArrayMapperResult = JSONUtil.toArrayMapper(collection, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualToArrayMapperResult.size());
    assertEquals("Apply", actualToArrayMapperResult.get(0));
  }

  /**
   * Test {@link JSONUtil#toArrayMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArrayMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toArrayMapper(Iterable, Function) with 'Iterable', 'Function'; given 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArrayMapper(Iterable, Function)"})
  void testToArrayMapperWithIterableFunction_givenNull_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    List actualToArrayMapperResult = JSONUtil.toArrayMapper(collection, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertTrue(actualToArrayMapperResult.isEmpty());
  }

  /**
   * Test {@link JSONUtil#toArrayMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArrayMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toArrayMapper(Iterable, Function) with 'Iterable', 'Function'; when ArrayList(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArrayMapper(Iterable, Function)"})
  void testToArrayMapperWithIterableFunction_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();

    // Act
    List actualToArrayMapperResult = JSONUtil.toArrayMapper(collection, mock(Function.class));

    // Assert
    assertEquals(collection, actualToArrayMapperResult);
  }

  /**
   * Test {@link JSONUtil#toArrayMapper(Object[], Function)} with {@code Object[]}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArrayMapper(Object[], Function)}
   */
  @Test
  @DisplayName(
      "Test toArrayMapper(Object[], Function) with 'Object[]', 'Function'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArrayMapper(Object[], Function)"})
  void testToArrayMapperWithObjectFunction_givenApply_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    List actualToArrayMapperResult = JSONUtil.toArrayMapper(new Object[] {"Collection"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualToArrayMapperResult.size());
    assertEquals("Apply", actualToArrayMapperResult.get(0));
  }

  /**
   * Test {@link JSONUtil#toArrayMapper(Object[], Function)} with {@code Object[]}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toArrayMapper(Object[], Function)}
   */
  @Test
  @DisplayName(
      "Test toArrayMapper(Object[], Function) with 'Object[]', 'Function'; given 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JSONUtil.toArrayMapper(Object[], Function)"})
  void testToArrayMapperWithObjectFunction_givenNull_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    List actualToArrayMapperResult = JSONUtil.toArrayMapper(new Object[] {"Collection"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertTrue(actualToArrayMapperResult.isEmpty());
  }

  /**
   * Test {@link JSONUtil#toObjectMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toObjectMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toObjectMapper(Iterable, Function) with 'Iterable', 'Function'; given 'null'; when Function apply(Object) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.toObjectMapper(Iterable, Function)"})
  void testToObjectMapperWithIterableFunction_givenNull_whenFunctionApplyReturnNull() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    Function<Object, JSONPair> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    Map actualToObjectMapperResult = JSONUtil.toObjectMapper(collection, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertTrue(actualToObjectMapperResult.isEmpty());
  }

  /**
   * Test {@link JSONUtil#toObjectMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given pair one and {@code Obj}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toObjectMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toObjectMapper(Iterable, Function) with 'Iterable', 'Function'; given pair one and 'Obj'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.toObjectMapper(Iterable, Function)"})
  void testToObjectMapperWithIterableFunction_givenPairOneAndObj_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    Function<Object, JSONPair> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(JSONUtil.pair(1L, "Obj"));

    // Act
    Map actualToObjectMapperResult = JSONUtil.toObjectMapper(collection, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualToObjectMapperResult.size());
    assertEquals("Obj", actualToObjectMapperResult.get("1"));
  }

  /**
   * Test {@link JSONUtil#toObjectMapper(Iterable, Function)} with {@code Iterable}, {@code
   * Function}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toObjectMapper(Iterable, Function)}
   */
  @Test
  @DisplayName(
      "Test toObjectMapper(Iterable, Function) with 'Iterable', 'Function'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.toObjectMapper(Iterable, Function)"})
  void testToObjectMapperWithIterableFunction_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(JSONUtil.toObjectMapper(new ArrayList<>(), mock(Function.class)).isEmpty());
  }

  /**
   * Test {@link JSONUtil#toObjectMapper(Object[], Function)} with {@code Object[]}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toObjectMapper(Object[], Function)}
   */
  @Test
  @DisplayName(
      "Test toObjectMapper(Object[], Function) with 'Object[]', 'Function'; given 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.toObjectMapper(Object[], Function)"})
  void testToObjectMapperWithObjectFunction_givenNull_thenReturnEmpty() {
    // Arrange
    Function<Object, JSONPair> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    Map actualToObjectMapperResult = JSONUtil.toObjectMapper(new Object[] {"Collection"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertTrue(actualToObjectMapperResult.isEmpty());
  }

  /**
   * Test {@link JSONUtil#toObjectMapper(Object[], Function)} with {@code Object[]}, {@code
   * Function}.
   *
   * <ul>
   *   <li>Given pair one and {@code Obj}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JSONUtil#toObjectMapper(Object[], Function)}
   */
  @Test
  @DisplayName(
      "Test toObjectMapper(Object[], Function) with 'Object[]', 'Function'; given pair one and 'Obj'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JSONUtil.toObjectMapper(Object[], Function)"})
  void testToObjectMapperWithObjectFunction_givenPairOneAndObj_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, JSONPair> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<Object>any())).thenReturn(JSONUtil.pair(1L, "Obj"));

    // Act
    Map actualToObjectMapperResult = JSONUtil.toObjectMapper(new Object[] {"Collection"}, mapper);

    // Assert
    verify(mapper).apply(isA(Object.class));
    assertEquals(1, actualToObjectMapperResult.size());
    assertEquals("Obj", actualToObjectMapperResult.get("1"));
  }
}
