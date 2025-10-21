package org.bukkit.block.spawner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SpawnRuleDiffblueTest {
  /**
   * Test {@link SpawnRule#SpawnRule(int, int, int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return MinBlockLight is one.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#SpawnRule(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test new SpawnRule(int, int, int, int); when three; then return MinBlockLight is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SpawnRule.<init>(int, int, int, int)"})
  void testNewSpawnRule_whenThree_thenReturnMinBlockLightIsOne() {
    // Arrange and Act
    SpawnRule actualSpawnRule = new SpawnRule(1, 3, 1, 3);

    // Assert
    assertEquals(1, actualSpawnRule.getMinBlockLight());
    assertEquals(1, actualSpawnRule.getMinSkyLight());
    assertEquals(3, actualSpawnRule.getMaxBlockLight());
    assertEquals(3, actualSpawnRule.getMaxSkyLight());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnRule#getMaxBlockLight()}
   *   <li>{@link SpawnRule#getMaxSkyLight()}
   *   <li>{@link SpawnRule#getMinBlockLight()}
   *   <li>{@link SpawnRule#getMinSkyLight()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SpawnRule.getMaxBlockLight()",
    "int SpawnRule.getMaxSkyLight()",
    "int SpawnRule.getMinBlockLight()",
    "int SpawnRule.getMinSkyLight()"
  })
  void testGettersAndSetters() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act
    int actualMaxBlockLight = spawnRule.getMaxBlockLight();
    int actualMaxSkyLight = spawnRule.getMaxSkyLight();
    int actualMinBlockLight = spawnRule.getMinBlockLight();

    // Assert
    assertEquals(1, actualMinBlockLight);
    assertEquals(1, spawnRule.getMinSkyLight());
    assertEquals(3, actualMaxBlockLight);
    assertEquals(3, actualMaxSkyLight);
  }

  /**
   * Test {@link SpawnRule#equals(Object)}, and {@link SpawnRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnRule#equals(Object)}
   *   <li>{@link SpawnRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);
    SpawnRule spawnRule2 = new SpawnRule(1, 3, 1, 3);

    // Act and Assert
    assertEquals(spawnRule, spawnRule2);
    assertEquals(spawnRule.hashCode(), spawnRule2.hashCode());
  }

  /**
   * Test {@link SpawnRule#equals(Object)}, and {@link SpawnRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SpawnRule#equals(Object)}
   *   <li>{@link SpawnRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act and Assert
    assertEquals(spawnRule, spawnRule);
    int expectedHashCodeResult = spawnRule.hashCode();
    assertEquals(expectedHashCodeResult, spawnRule.hashCode());
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(3, 3, 1, 3);

    // Act and Assert
    assertNotEquals(spawnRule, new SpawnRule(1, 3, 1, 3));
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 1, 1, 3);

    // Act and Assert
    assertNotEquals(spawnRule, new SpawnRule(1, 3, 1, 3));
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 3, 3);

    // Act and Assert
    assertNotEquals(spawnRule, new SpawnRule(1, 3, 1, 3));
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 1);

    // Act and Assert
    assertNotEquals(spawnRule, new SpawnRule(1, 3, 1, 3));
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SpawnRule(1, 3, 1, 3), null);
  }

  /**
   * Test {@link SpawnRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpawnRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpawnRule.equals(Object)", "int SpawnRule.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SpawnRule(1, 3, 1, 3), "Different type to SpawnRule");
  }

  /**
   * Test {@link SpawnRule#clone()}.
   *
   * <p>Method under test: {@link SpawnRule#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SpawnRule SpawnRule.clone()"})
  void testClone() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act
    SpawnRule actualCloneResult = spawnRule.clone();

    // Assert
    assertEquals(spawnRule, actualCloneResult);
  }

  /**
   * Test {@link SpawnRule#serialize()}.
   *
   * <p>Method under test: {@link SpawnRule#serialize()}
   */
  @Test
  @DisplayName("Test serialize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SpawnRule.serialize()"})
  void testSerialize() {
    // Arrange
    SpawnRule spawnRule = new SpawnRule(1, 3, 1, 3);

    // Act
    Map<String, Object> actualSerializeResult = spawnRule.serialize();

    // Assert
    assertEquals(2, actualSerializeResult.size());
    Object getResult = actualSerializeResult.get("block-light");
    assertTrue(getResult instanceof Map);
    assertEquals(2, ((Map<String, Integer>) getResult).size());
    assertEquals(1, ((Map<String, Integer>) getResult).get("min").intValue());
    assertEquals(3, ((Map<String, Integer>) getResult).get("max").intValue());
    assertEquals(getResult, actualSerializeResult.get("sky-light"));
  }

  /**
   * Test {@link SpawnRule#deserialize(Map)}.
   *
   * <p>Method under test: {@link SpawnRule#deserialize(Map)}
   */
  @Test
  @DisplayName("Test deserialize(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SpawnRule SpawnRule.deserialize(Map)"})
  void testDeserialize() {
    // Arrange and Act
    SpawnRule actualDeserializeResult = SpawnRule.deserialize(new HashMap<>());

    // Assert
    assertEquals(0, actualDeserializeResult.getMaxBlockLight());
    assertEquals(0, actualDeserializeResult.getMaxSkyLight());
    assertEquals(0, actualDeserializeResult.getMinBlockLight());
    assertEquals(0, actualDeserializeResult.getMinSkyLight());
  }
}
