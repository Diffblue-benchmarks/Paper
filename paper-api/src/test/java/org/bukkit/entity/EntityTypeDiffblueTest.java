package org.bukkit.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.boat.AcaciaBoat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityTypeDiffblueTest {
  /**
   * Test {@link EntityType#getKey()}.
   *
   * <p>Method under test: {@link EntityType#getKey()}
   */
  @Test
  @DisplayName("Test getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamespacedKey EntityType.getKey()"})
  void testGetKey() {
    // Arrange and Act
    NamespacedKey actualKey = EntityType.ACACIA_BOAT.getKey();

    // Assert
    assertEquals("acacia_boat", actualKey.getKey());
    assertEquals("minecraft", actualKey.getNamespace());
    assertEquals("minecraft", actualKey.namespace());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityType#getEntityClass()}
   *   <li>{@link EntityType#getName()}
   *   <li>{@link EntityType#getTypeId()}
   *   <li>{@link EntityType#isAlive()}
   *   <li>{@link EntityType#isSpawnable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class EntityType.getEntityClass()",
    "String EntityType.getName()",
    "short EntityType.getTypeId()",
    "boolean EntityType.isAlive()",
    "boolean EntityType.isSpawnable()"
  })
  void testGettersAndSetters() {
    // Arrange
    EntityType valueOfResult = EntityType.valueOf("ACACIA_BOAT");

    // Act
    Class<? extends Entity> actualEntityClass = valueOfResult.getEntityClass();
    String actualName = valueOfResult.getName();
    short actualTypeId = valueOfResult.getTypeId();
    boolean actualIsAliveResult = valueOfResult.isAlive();

    // Assert
    assertEquals("acacia_boat", actualName);
    assertEquals((short) -1, actualTypeId);
    assertFalse(actualIsAliveResult);
    assertTrue(valueOfResult.isSpawnable());
    Class<AcaciaBoat> expectedEntityClass = AcaciaBoat.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link EntityType#fromName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link EntityType#fromName(String)}
   */
  @Test
  @DisplayName("Test fromName(String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityType.fromName(String)"})
  void testFromName_whenName() {
    // Arrange, Act and Assert
    assertNull(EntityType.fromName("Name"));
  }

  /**
   * Test {@link EntityType#fromName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityType#fromName(String)}
   */
  @Test
  @DisplayName("Test fromName(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityType.fromName(String)"})
  void testFromName_whenNull() {
    // Arrange, Act and Assert
    assertNull(EntityType.fromName(null));
  }

  /**
   * Test {@link EntityType#fromId(int)}.
   *
   * <ul>
   *   <li>When {@code 32768}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityType#fromId(int)}
   */
  @Test
  @DisplayName("Test fromId(int); when '32768'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityType.fromId(int)"})
  void testFromId_when32768_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(EntityType.fromId(32768));
  }

  /**
   * Test {@link EntityType#fromId(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code ITEM}.
   * </ul>
   *
   * <p>Method under test: {@link EntityType#fromId(int)}
   */
  @Test
  @DisplayName("Test fromId(int); when one; then return 'ITEM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType EntityType.fromId(int)"})
  void testFromId_whenOne_thenReturnItem() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ITEM, EntityType.fromId(1));
  }
}
