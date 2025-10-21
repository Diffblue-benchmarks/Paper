package com.destroystokyo.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.destroystokyo.paper.VersionHistoryManager.VersionData;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionHistoryManagerDiffblueTest {
  /**
   * Test VersionData {@link VersionData#equals(Object)}, and {@link VersionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionData#equals(Object)}
   *   <li>{@link VersionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test VersionData equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("1.0.2");
    versionData.setOldVersion("1.0.1");

    VersionData versionData2 = new VersionData();
    versionData2.setCurrentVersion("1.0.2");
    versionData2.setOldVersion("1.0.1");

    // Act and Assert
    assertEquals(versionData, versionData2);
    assertEquals(versionData.hashCode(), versionData2.hashCode());
  }

  /**
   * Test VersionData {@link VersionData#equals(Object)}, and {@link VersionData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionData#equals(Object)}
   *   <li>{@link VersionData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test VersionData equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("1.0.2");
    versionData.setOldVersion("1.0.1");

    // Act and Assert
    assertEquals(versionData, versionData);
    int expectedHashCodeResult = versionData.hashCode();
    assertEquals(expectedHashCodeResult, versionData.hashCode());
  }

  /**
   * Test VersionData {@link VersionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionData#equals(Object)}
   */
  @Test
  @DisplayName("Test VersionData equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("Current Version");
    versionData.setOldVersion("1.0.1");

    VersionData versionData2 = new VersionData();
    versionData2.setCurrentVersion("1.0.2");
    versionData2.setOldVersion("1.0.1");

    // Act and Assert
    assertNotEquals(versionData, versionData2);
  }

  /**
   * Test VersionData {@link VersionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionData#equals(Object)}
   */
  @Test
  @DisplayName("Test VersionData equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("1.0.2");
    versionData.setOldVersion("1.0.2");

    VersionData versionData2 = new VersionData();
    versionData2.setCurrentVersion("1.0.2");
    versionData2.setOldVersion("1.0.1");

    // Act and Assert
    assertNotEquals(versionData, versionData2);
  }

  /**
   * Test VersionData {@link VersionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionData#equals(Object)}
   */
  @Test
  @DisplayName("Test VersionData equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("1.0.2");
    versionData.setOldVersion("1.0.1");

    // Act and Assert
    assertNotEquals(versionData, null);
  }

  /**
   * Test VersionData {@link VersionData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionData#equals(Object)}
   */
  @Test
  @DisplayName("Test VersionData equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VersionData.equals(Object)", "int VersionData.hashCode()"})
  void testVersionDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionData versionData = new VersionData();
    versionData.setCurrentVersion("1.0.2");
    versionData.setOldVersion("1.0.1");

    // Act and Assert
    assertNotEquals(versionData, "Different type to VersionData");
  }

  /**
   * Test VersionData getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionData}
   *   <li>{@link VersionData#setCurrentVersion(String)}
   *   <li>{@link VersionData#setOldVersion(String)}
   *   <li>{@link VersionData#toString()}
   *   <li>{@link VersionData#getCurrentVersion()}
   *   <li>{@link VersionData#getOldVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test VersionData getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VersionData.<init>()",
    "String VersionData.getCurrentVersion()",
    "String VersionData.getOldVersion()",
    "void VersionData.setCurrentVersion(String)",
    "void VersionData.setOldVersion(String)",
    "String VersionData.toString()"
  })
  void testVersionDataGettersAndSetters() {
    // Arrange and Act
    VersionData actualVersionData = new VersionData();
    actualVersionData.setCurrentVersion("1.0.2");
    actualVersionData.setOldVersion("1.0.1");
    String actualToStringResult = actualVersionData.toString();
    String actualCurrentVersion = actualVersionData.getCurrentVersion();

    // Assert
    assertEquals("1.0.1", actualVersionData.getOldVersion());
    assertEquals("1.0.2", actualCurrentVersion);
    assertEquals("VersionData{oldVersion=1.0.1, currentVersion=1.0.2}", actualToStringResult);
  }
}
