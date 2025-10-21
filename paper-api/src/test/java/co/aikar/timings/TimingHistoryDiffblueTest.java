package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import co.aikar.timings.TimingHistory.RegionData;
import co.aikar.timings.TimingHistory.RegionData.RegionId;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingHistoryDiffblueTest {
  /**
   * Test RegionData {@link RegionData#equals(Object)}, and {@link RegionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegionData#equals(Object)}
   *   <li>{@link RegionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test RegionData equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionData.equals(Object)", "int RegionData.hashCode()"})
  void testRegionDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RegionData regionData = new RegionData(new RegionId(2, 1));
    RegionData regionData2 = new RegionData(new RegionId(2, 1));

    // Act and Assert
    assertEquals(regionData, regionData2);
    assertEquals(regionData.hashCode(), regionData2.hashCode());
  }

  /**
   * Test RegionData {@link RegionData#equals(Object)}, and {@link RegionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegionData#equals(Object)}
   *   <li>{@link RegionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test RegionData equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionData.equals(Object)", "int RegionData.hashCode()"})
  void testRegionDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RegionData regionData = new RegionData(new RegionId(2, 1));

    // Act and Assert
    assertEquals(regionData, regionData);
    int expectedHashCodeResult = regionData.hashCode();
    assertEquals(expectedHashCodeResult, regionData.hashCode());
  }

  /**
   * Test RegionData {@link RegionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionData#equals(Object)}
   */
  @Test
  @DisplayName("Test RegionData equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionData.equals(Object)", "int RegionData.hashCode()"})
  void testRegionDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RegionData regionData = new RegionData(mock(RegionId.class));

    // Act and Assert
    assertNotEquals(regionData, new RegionData(new RegionId(2, 1)));
  }

  /**
   * Test RegionData {@link RegionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionData#equals(Object)}
   */
  @Test
  @DisplayName("Test RegionData equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionData.equals(Object)", "int RegionData.hashCode()"})
  void testRegionDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegionData(new RegionId(2, 1)), null);
  }

  /**
   * Test RegionData {@link RegionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionData#equals(Object)}
   */
  @Test
  @DisplayName("Test RegionData equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionData.equals(Object)", "int RegionData.hashCode()"})
  void testRegionDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegionData(new RegionId(2, 1)), "Different type to RegionData");
  }

  /**
   * Test RegionData {@link RegionData#RegionData(RegionId)}.
   *
   * <p>Method under test: {@link RegionData#RegionData(RegionId)}
   */
  @Test
  @DisplayName("Test RegionData new RegionData(RegionId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegionData.<init>(RegionId)"})
  void testRegionDataNewRegionData() {
    // Arrange and Act
    RegionData actualRegionData = new RegionData(new RegionId(2, 1));

    // Assert
    RegionId regionId = actualRegionData.regionId;
    assertEquals(0, regionId.x);
    assertEquals(0, regionId.z);
    assertEquals(2147483648L, regionId.regionId);
    assertTrue(actualRegionData.entityCounts.isEmpty());
    assertTrue(actualRegionData.tileEntityCounts.isEmpty());
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}, and {@link RegionId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegionId#equals(Object)}
   *   <li>{@link RegionId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RegionId regionId = new RegionId(2, 1);
    RegionId regionId2 = new RegionId(2, 1);

    // Act and Assert
    assertEquals(regionId, regionId2);
    assertEquals(regionId.hashCode(), regionId2.hashCode());
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}, and {@link RegionId#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RegionId#equals(Object)}
   *   <li>{@link RegionId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RegionId regionId = new RegionId(2, 1);

    // Act and Assert
    assertEquals(regionId, regionId);
    int expectedHashCodeResult = regionId.hashCode();
    assertEquals(expectedHashCodeResult, regionId.hashCode());
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionId#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegionId(2, 1), Integer.MIN_VALUE);
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionId#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RegionId regionId = new RegionId(Integer.MIN_VALUE, 1);

    // Act and Assert
    assertNotEquals(regionId, new RegionId(2, 1));
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionId#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegionId(2, 1), null);
  }

  /**
   * Test RegionData_RegionId {@link RegionId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RegionId#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test RegionData_RegionId equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RegionId.equals(Object)", "int RegionId.hashCode()"})
  void testRegionData_RegionIdEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegionId(2, 1), "Different type to RegionId");
  }

  /**
   * Test RegionData_RegionId {@link RegionId#RegionId(int, int)}.
   *
   * <p>Method under test: {@link RegionId#RegionId(int, int)}
   */
  @Test
  @DisplayName("Test RegionData_RegionId new RegionId(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegionId.<init>(int, int)"})
  void testRegionData_RegionIdNewRegionId() {
    // Arrange and Act
    RegionId actualRegionId = new RegionId(2, 1);

    // Assert
    assertEquals(0, actualRegionId.x);
    assertEquals(0, actualRegionId.z);
    assertEquals(2147483648L, actualRegionId.regionId);
  }
}
