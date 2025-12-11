package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.destroystokyo.paper.Metrics.AdvancedBarChart;
import com.destroystokyo.paper.Metrics.AdvancedPie;
import com.destroystokyo.paper.Metrics.CustomChart;
import com.destroystokyo.paper.Metrics.DrilldownPie;
import com.destroystokyo.paper.Metrics.MultiLineChart;
import com.destroystokyo.paper.Metrics.SimpleBarChart;
import com.destroystokyo.paper.Metrics.SimplePie;
import com.destroystokyo.paper.Metrics.SingleLineChart;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetricsDiffblueTest {
  /**
   * Test {@link Metrics#addCustomChart(CustomChart)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Metrics#addCustomChart(CustomChart)}
   */
  @Test
  @DisplayName("Test addCustomChart(CustomChart); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Metrics.addCustomChart(CustomChart)"})
  void testAddCustomChart_thenDoesNotThrow() {
    // Arrange
    Metrics metrics =
        new Metrics("Name", "01234567-89AB-CDEF-FEDC-BA9876543210", true, Logger.getGlobal());
    AdvancedBarChart chart = new AdvancedBarChart("42", mock(Callable.class));

    // Act and Assert
    assertDoesNotThrow(() -> metrics.addCustomChart(chart));
  }

  /**
   * Test {@link Metrics#addCustomChart(CustomChart)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Metrics#addCustomChart(CustomChart)}
   */
  @Test
  @DisplayName("Test addCustomChart(CustomChart); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Metrics.addCustomChart(CustomChart)"})
  void testAddCustomChart_whenNull_thenThrowIllegalArgumentException() {
    // Arrange
    Metrics metrics =
        new Metrics("Name", "01234567-89AB-CDEF-FEDC-BA9876543210", true, Logger.getGlobal());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> metrics.addCustomChart(null));
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test AdvancedBarChart getChartData(); given Callable call() return HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedBarChart.getChartData()"})
  void testAdvancedBarChartGetChartData_givenCallableCallReturnHashMap_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Map<String, int[]>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(new HashMap<>());
    AdvancedBarChart advancedBarChart = new AdvancedBarChart("42", callable);

    // Act
    JSONObject actualChartData = advancedBarChart.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is empty array of {@code int}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test AdvancedBarChart getChartData(); given HashMap() 'Key' is empty array of int; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedBarChart.getChartData()"})
  void testAdvancedBarChartGetChartData_givenHashMapKeyIsEmptyArrayOfInt_thenReturnNull()
      throws Exception {
    // Arrange
    HashMap<String, int[]> stringIntArrayMap = new HashMap<>();
    stringIntArrayMap.put("Key", new int[] {});

    Callable<Map<String, int[]>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntArrayMap);
    AdvancedBarChart advancedBarChart = new AdvancedBarChart("42", callable);

    // Act
    JSONObject actualChartData = advancedBarChart.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#getChartData()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#getChartData()}
   */
  @Test
  @DisplayName("Test AdvancedBarChart getChartData(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedBarChart.getChartData()"})
  void testAdvancedBarChartGetChartData_thenReturnSizeIsOne() throws Exception {
    // Arrange
    HashMap<String, int[]> stringIntArrayMap = new HashMap<>();
    stringIntArrayMap.put("Key", new int[] {42, 1, 42, 1});

    Callable<Map<String, int[]>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntArrayMap);
    AdvancedBarChart advancedBarChart = new AdvancedBarChart("42", callable);

    // Act
    JSONObject actualChartData = advancedBarChart.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    JSONArray getResult2 = ((Map<String, JSONArray>) getResult).get("Key");
    assertEquals(4, getResult2.size());
    assertEquals(1, ((Integer) getResult2.get(1)).intValue());
    assertEquals(1, ((Integer) getResult2.get(3)).intValue());
    assertEquals(1, ((Map<String, JSONArray>) getResult).size());
    assertEquals(42, ((Integer) getResult2.get(0)).intValue());
    assertEquals(42, ((Integer) getResult2.get(2)).intValue());
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test AdvancedBarChart new AdvancedBarChart(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedBarChart.<init>(String, Callable)"})
  void testAdvancedBarChartNewAdvancedBarChart_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    AdvancedBarChart actualAdvancedBarChart = new AdvancedBarChart("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualAdvancedBarChart.chartId);
    assertNull(actualAdvancedBarChart.getChartData());
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}
   */
  @Test
  @DisplayName("Test AdvancedBarChart new AdvancedBarChart(String, Callable); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedBarChart.<init>(String, Callable)"})
  void testAdvancedBarChartNewAdvancedBarChart_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new AdvancedBarChart("", mock(Callable.class)));
  }

  /**
   * Test AdvancedBarChart {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedBarChart#AdvancedBarChart(String, Callable)}
   */
  @Test
  @DisplayName("Test AdvancedBarChart new AdvancedBarChart(String, Callable); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedBarChart.<init>(String, Callable)"})
  void testAdvancedBarChartNewAdvancedBarChart_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new AdvancedBarChart(null, mock(Callable.class)));
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie getChartData(); given Callable call() return HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedPie.getChartData()"})
  void testAdvancedPieGetChartData_givenCallableCallReturnHashMap_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(new HashMap<>());
    AdvancedPie advancedPie = new AdvancedPie("42", callable);

    // Act
    JSONObject actualChartData = advancedPie.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedPie.getChartData()"})
  void testAdvancedPieGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("Key", 42);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    AdvancedPie advancedPie = new AdvancedPie("42", callable);

    // Act
    JSONObject actualChartData = advancedPie.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(42, ((Map<String, Integer>) getResult).get("Key").intValue());
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedPie.getChartData()"})
  void testAdvancedPieGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne2()
      throws Exception {
    // Arrange
    BiFunction<String, Integer, Integer> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<Integer>any())).thenReturn(0);

    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("42", 1);
    stringIntegerMap.replaceAll(biFunction);
    stringIntegerMap.put("Key", 42);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    AdvancedPie advancedPie = new AdvancedPie("42", callable);

    // Act
    JSONObject actualChartData = advancedPie.getChartData();

    // Assert
    verify(callable).call();
    verify(biFunction).apply("42", 1);
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(42, ((Map<String, Integer>) getResult).get("Key").intValue());
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#getChartData()}
   */
  @Test
  @DisplayName("Test AdvancedPie getChartData(); given HashMap() 'Key' is zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject AdvancedPie.getChartData()"})
  void testAdvancedPieGetChartData_givenHashMapKeyIsZero_thenReturnNull() throws Exception {
    // Arrange
    BiFunction<String, Integer, Integer> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<Integer>any())).thenReturn(0);

    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("42", 1);
    stringIntegerMap.replaceAll(biFunction);
    stringIntegerMap.put("Key", 0);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    AdvancedPie advancedPie = new AdvancedPie("42", callable);

    // Act
    JSONObject actualChartData = advancedPie.getChartData();

    // Assert
    verify(callable).call();
    verify(biFunction).apply("42", 1);
    assertNull(actualChartData);
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#AdvancedPie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#AdvancedPie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie new AdvancedPie(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedPie.<init>(String, Callable)"})
  void testAdvancedPieNewAdvancedPie_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    AdvancedPie actualAdvancedPie = new AdvancedPie("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualAdvancedPie.chartId);
    assertNull(actualAdvancedPie.getChartData());
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#AdvancedPie(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#AdvancedPie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie new AdvancedPie(String, Callable); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedPie.<init>(String, Callable)"})
  void testAdvancedPieNewAdvancedPie_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AdvancedPie("", mock(Callable.class)));
  }

  /**
   * Test AdvancedPie {@link AdvancedPie#AdvancedPie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AdvancedPie#AdvancedPie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test AdvancedPie new AdvancedPie(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedPie.<init>(String, Callable)"})
  void testAdvancedPieNewAdvancedPie_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AdvancedPie(null, mock(Callable.class)));
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test DrilldownPie getChartData(); given Callable call() return HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject DrilldownPie.getChartData()"})
  void testDrilldownPieGetChartData_givenCallableCallReturnHashMap_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Map<String, Map<String, Integer>>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(new HashMap<>());
    DrilldownPie drilldownPie = new DrilldownPie("42", callable);

    // Act
    JSONObject actualChartData = drilldownPie.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test DrilldownPie getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject DrilldownPie.getChartData()"})
  void testDrilldownPieGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("Key", 42);

    HashMap<String, Map<String, Integer>> stringMapMap = new HashMap<>();
    stringMapMap.put("Key", stringIntegerMap);

    Callable<Map<String, Map<String, Integer>>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringMapMap);
    DrilldownPie drilldownPie = new DrilldownPie("42", callable);

    // Act
    JSONObject actualChartData = drilldownPie.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    assertEquals(stringMapMap, actualChartData.get("values"));
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test DrilldownPie getChartData(); given HashMap() 'Key' is HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject DrilldownPie.getChartData()"})
  void testDrilldownPieGetChartData_givenHashMapKeyIsHashMap_thenReturnNull() throws Exception {
    // Arrange
    HashMap<String, Map<String, Integer>> stringMapMap = new HashMap<>();
    stringMapMap.put("Key", new HashMap<>());

    Callable<Map<String, Map<String, Integer>>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringMapMap);
    DrilldownPie drilldownPie = new DrilldownPie("42", callable);

    // Act
    JSONObject actualChartData = drilldownPie.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#DrilldownPie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#DrilldownPie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test DrilldownPie new DrilldownPie(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DrilldownPie.<init>(String, Callable)"})
  void testDrilldownPieNewDrilldownPie_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    DrilldownPie actualDrilldownPie = new DrilldownPie("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualDrilldownPie.chartId);
    assertNull(actualDrilldownPie.getChartData());
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#DrilldownPie(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#DrilldownPie(String, Callable)}
   */
  @Test
  @DisplayName("Test DrilldownPie new DrilldownPie(String, Callable); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DrilldownPie.<init>(String, Callable)"})
  void testDrilldownPieNewDrilldownPie_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new DrilldownPie("", mock(Callable.class)));
  }

  /**
   * Test DrilldownPie {@link DrilldownPie#DrilldownPie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DrilldownPie#DrilldownPie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test DrilldownPie new DrilldownPie(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DrilldownPie.<init>(String, Callable)"})
  void testDrilldownPieNewDrilldownPie_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new DrilldownPie(null, mock(Callable.class)));
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart getChartData(); given Callable call() return HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject MultiLineChart.getChartData()"})
  void testMultiLineChartGetChartData_givenCallableCallReturnHashMap_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(new HashMap<>());
    MultiLineChart multiLineChart = new MultiLineChart("42", callable);

    // Act
    JSONObject actualChartData = multiLineChart.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject MultiLineChart.getChartData()"})
  void testMultiLineChartGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("Key", 42);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    MultiLineChart multiLineChart = new MultiLineChart("42", callable);

    // Act
    JSONObject actualChartData = multiLineChart.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(42, ((Map<String, Integer>) getResult).get("Key").intValue());
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject MultiLineChart.getChartData()"})
  void testMultiLineChartGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne2()
      throws Exception {
    // Arrange
    BiFunction<String, Integer, Integer> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<Integer>any())).thenReturn(0);

    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("42", 1);
    stringIntegerMap.replaceAll(biFunction);
    stringIntegerMap.put("Key", 42);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    MultiLineChart multiLineChart = new MultiLineChart("42", callable);

    // Act
    JSONObject actualChartData = multiLineChart.getChartData();

    // Assert
    verify(callable).call();
    verify(biFunction).apply("42", 1);
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(42, ((Map<String, Integer>) getResult).get("Key").intValue());
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart getChartData(); given HashMap() 'Key' is zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject MultiLineChart.getChartData()"})
  void testMultiLineChartGetChartData_givenHashMapKeyIsZero_thenReturnNull() throws Exception {
    // Arrange
    BiFunction<String, Integer, Integer> biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<String>any(), Mockito.<Integer>any())).thenReturn(0);

    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("42", 1);
    stringIntegerMap.replaceAll(biFunction);
    stringIntegerMap.put("Key", 0);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    MultiLineChart multiLineChart = new MultiLineChart("42", callable);

    // Act
    JSONObject actualChartData = multiLineChart.getChartData();

    // Assert
    verify(callable).call();
    verify(biFunction).apply("42", 1);
    assertNull(actualChartData);
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#MultiLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#MultiLineChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart new MultiLineChart(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiLineChart.<init>(String, Callable)"})
  void testMultiLineChartNewMultiLineChart_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    MultiLineChart actualMultiLineChart = new MultiLineChart("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualMultiLineChart.chartId);
    assertNull(actualMultiLineChart.getChartData());
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#MultiLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#MultiLineChart(String, Callable)}
   */
  @Test
  @DisplayName("Test MultiLineChart new MultiLineChart(String, Callable); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiLineChart.<init>(String, Callable)"})
  void testMultiLineChartNewMultiLineChart_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MultiLineChart("", mock(Callable.class)));
  }

  /**
   * Test MultiLineChart {@link MultiLineChart#MultiLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MultiLineChart#MultiLineChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test MultiLineChart new MultiLineChart(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiLineChart.<init>(String, Callable)"})
  void testMultiLineChartNewMultiLineChart_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new MultiLineChart(null, mock(Callable.class)));
  }

  /**
   * Test SimpleBarChart {@link SimpleBarChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleBarChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SimpleBarChart getChartData(); given Callable call() return HashMap(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SimpleBarChart.getChartData()"})
  void testSimpleBarChartGetChartData_givenCallableCallReturnHashMap_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(new HashMap<>());
    SimpleBarChart simpleBarChart = new SimpleBarChart("42", callable);

    // Act
    JSONObject actualChartData = simpleBarChart.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test SimpleBarChart {@link SimpleBarChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is forty-two.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleBarChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SimpleBarChart getChartData(); given HashMap() 'Key' is forty-two; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SimpleBarChart.getChartData()"})
  void testSimpleBarChartGetChartData_givenHashMapKeyIsFortyTwo_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    HashMap<String, Integer> stringIntegerMap = new HashMap<>();
    stringIntegerMap.put("Key", 42);

    Callable<Map<String, Integer>> callable = mock(Callable.class);
    when(callable.call()).thenReturn(stringIntegerMap);
    SimpleBarChart simpleBarChart = new SimpleBarChart("42", callable);

    // Act
    JSONObject actualChartData = simpleBarChart.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    Object getResult = actualChartData.get("values");
    JSONArray getResult2 = ((Map<String, JSONArray>) getResult).get("Key");
    assertEquals(1, getResult2.size());
    assertEquals(1, ((Map<String, JSONArray>) getResult).size());
    assertEquals(42, ((Integer) getResult2.get(0)).intValue());
  }

  /**
   * Test SimpleBarChart {@link SimpleBarChart#SimpleBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleBarChart#SimpleBarChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SimpleBarChart new SimpleBarChart(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleBarChart.<init>(String, Callable)"})
  void testSimpleBarChartNewSimpleBarChart_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    SimpleBarChart actualSimpleBarChart = new SimpleBarChart("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualSimpleBarChart.chartId);
    assertNull(actualSimpleBarChart.getChartData());
  }

  /**
   * Test SimpleBarChart {@link SimpleBarChart#SimpleBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SimpleBarChart#SimpleBarChart(String, Callable)}
   */
  @Test
  @DisplayName("Test SimpleBarChart new SimpleBarChart(String, Callable); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleBarChart.<init>(String, Callable)"})
  void testSimpleBarChartNewSimpleBarChart_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SimpleBarChart("", mock(Callable.class)));
  }

  /**
   * Test SimpleBarChart {@link SimpleBarChart#SimpleBarChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleBarChart#SimpleBarChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SimpleBarChart new SimpleBarChart(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleBarChart.<init>(String, Callable)"})
  void testSimpleBarChartNewSimpleBarChart_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SimpleBarChart(null, mock(Callable.class)));
  }

  /**
   * Test SimplePie {@link SimplePie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code Call}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SimplePie getChartData(); given Callable call() return 'Call'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SimplePie.getChartData()"})
  void testSimplePieGetChartData_givenCallableCallReturnCall_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    Callable<String> callable = mock(Callable.class);
    when(callable.call()).thenReturn("Call");
    SimplePie simplePie = new SimplePie("42", callable);

    // Act
    JSONObject actualChartData = simplePie.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    assertEquals("Call", actualChartData.get("value"));
  }

  /**
   * Test SimplePie {@link SimplePie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SimplePie getChartData(); given Callable call() return empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SimplePie.getChartData()"})
  void testSimplePieGetChartData_givenCallableCallReturnEmptyString_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<String> callable = mock(Callable.class);
    when(callable.call()).thenReturn("");
    SimplePie simplePie = new SimplePie("42", callable);

    // Act
    JSONObject actualChartData = simplePie.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test SimplePie {@link SimplePie#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SimplePie getChartData(); given Callable call() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SimplePie.getChartData()"})
  void testSimplePieGetChartData_givenCallableCallReturnNull_thenReturnNull() throws Exception {
    // Arrange
    Callable<String> callable = mock(Callable.class);
    when(callable.call()).thenReturn(null);
    SimplePie simplePie = new SimplePie("42", callable);

    // Act
    JSONObject actualChartData = simplePie.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test SimplePie {@link SimplePie#SimplePie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#SimplePie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SimplePie new SimplePie(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePie.<init>(String, Callable)"})
  void testSimplePieNewSimplePie_when42_thenReturnChartIdIs42() throws Exception {
    // Arrange and Act
    SimplePie actualSimplePie = new SimplePie("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualSimplePie.chartId);
    assertNull(actualSimplePie.getChartData());
  }

  /**
   * Test SimplePie {@link SimplePie#SimplePie(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#SimplePie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SimplePie new SimplePie(String, Callable); when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePie.<init>(String, Callable)"})
  void testSimplePieNewSimplePie_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SimplePie("", mock(Callable.class)));
  }

  /**
   * Test SimplePie {@link SimplePie#SimplePie(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SimplePie#SimplePie(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SimplePie new SimplePie(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimplePie.<init>(String, Callable)"})
  void testSimplePieNewSimplePie_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new SimplePie(null, mock(Callable.class)));
  }

  /**
   * Test SingleLineChart {@link SingleLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SingleLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SingleLineChart getChartData(); given Callable call() return one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SingleLineChart.getChartData()"})
  void testSingleLineChartGetChartData_givenCallableCallReturnOne_thenReturnSizeIsOne()
      throws Exception {
    // Arrange
    Callable<Integer> callable = mock(Callable.class);
    when(callable.call()).thenReturn(1);
    SingleLineChart singleLineChart = new SingleLineChart("42", callable);

    // Act
    JSONObject actualChartData = singleLineChart.getChartData();

    // Assert
    verify(callable).call();
    assertEquals(1, actualChartData.size());
    assertEquals(1, ((Integer) actualChartData.get("value")).intValue());
  }

  /**
   * Test SingleLineChart {@link SingleLineChart#getChartData()}.
   *
   * <ul>
   *   <li>Given {@link Callable} {@link Callable#call()} return zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SingleLineChart#getChartData()}
   */
  @Test
  @DisplayName(
      "Test SingleLineChart getChartData(); given Callable call() return zero; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JSONObject SingleLineChart.getChartData()"})
  void testSingleLineChartGetChartData_givenCallableCallReturnZero_thenReturnNull()
      throws Exception {
    // Arrange
    Callable<Integer> callable = mock(Callable.class);
    when(callable.call()).thenReturn(0);
    SingleLineChart singleLineChart = new SingleLineChart("42", callable);

    // Act
    JSONObject actualChartData = singleLineChart.getChartData();

    // Assert
    verify(callable).call();
    assertNull(actualChartData);
  }

  /**
   * Test SingleLineChart {@link SingleLineChart#SingleLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link CustomChart#chartId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SingleLineChart#SingleLineChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SingleLineChart new SingleLineChart(String, Callable); when '42'; then return chartId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleLineChart.<init>(String, Callable)"})
  void testSingleLineChartNewSingleLineChart_when42_thenReturnChartIdIs42() {
    // Arrange and Act
    SingleLineChart actualSingleLineChart = new SingleLineChart("42", mock(Callable.class));

    // Assert
    assertEquals("42", actualSingleLineChart.chartId);
  }

  /**
   * Test SingleLineChart {@link SingleLineChart#SingleLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link SingleLineChart#SingleLineChart(String, Callable)}
   */
  @Test
  @DisplayName("Test SingleLineChart new SingleLineChart(String, Callable); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleLineChart.<init>(String, Callable)"})
  void testSingleLineChartNewSingleLineChart_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SingleLineChart("", mock(Callable.class)));
  }

  /**
   * Test SingleLineChart {@link SingleLineChart#SingleLineChart(String, Callable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SingleLineChart#SingleLineChart(String, Callable)}
   */
  @Test
  @DisplayName(
      "Test SingleLineChart new SingleLineChart(String, Callable); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SingleLineChart.<init>(String, Callable)"})
  void testSingleLineChartNewSingleLineChart_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new SingleLineChart(null, mock(Callable.class)));
  }
}
