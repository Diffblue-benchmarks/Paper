package ca.spottedleaf.dataconverter.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import ca.spottedleaf.dataconverter.types.nbt.NBTListType;
import ca.spottedleaf.dataconverter.types.nbt.NBTMapType;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import net.minecraft.server.Bootstrap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.transformation.ConfigurationTransformation;

class ObjectTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#getObjectClass()}
   *   <li>{@link ObjectType#isNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ObjectType.getObjectClass()", "boolean ObjectType.isNumber()"})
  void testGettersAndSetters() {
    // Arrange
    ObjectType valueOfResult = ObjectType.valueOf("NONE");

    // Act
    Class<?> actualObjectClass = valueOfResult.getObjectClass();

    // Assert
    assertNull(actualObjectClass);
    assertFalse(valueOfResult.isNumber());
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when 'A'; then return 'BYTE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenA_thenReturnByte() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.BYTE, ObjectType.getType((byte) 'A'));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@link Bootstrap#bootstrapDuration}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when bootstrapDuration; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenBootstrapDuration_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectType.getType(Bootstrap.bootstrapDuration));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@link NBTListType#NBTListType()}.
   *   <li>Then return {@code LIST}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when NBTListType(); then return 'LIST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenNBTListType_thenReturnList() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.LIST, ObjectType.getType(new NBTListType()));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@link NBTMapType#NBTMapType()}.
   *   <li>Then return {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when NBTMapType(); then return 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenNBTMapType_thenReturnMap() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.MAP, ObjectType.getType(new NBTMapType()));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when 'Object'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenObject_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.STRING, ObjectType.getType("Object"));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code INT}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when one; then return 'INT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenOne_thenReturnInt() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.INT, ObjectType.getType(1));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code LONG}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when one; then return 'LONG'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenOne_thenReturnLong() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.LONG, ObjectType.getType(1L));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code SHORT}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when one; then return 'SHORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenOne_thenReturnShort() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.SHORT, ObjectType.getType((short) 1));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when ten; then return 'DOUBLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenTen_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.DOUBLE, ObjectType.getType(10.0d));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when ten; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenTen_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(ObjectType.FLOAT, ObjectType.getType(10.0f));
  }

  /**
   * Test {@link ObjectType#getType(Object)}.
   *
   * <ul>
   *   <li>When {@link ConfigurationTransformation#WILDCARD_OBJECT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#getType(Object)}
   */
  @Test
  @DisplayName("Test getType(Object); when WILDCARD_OBJECT; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectType ObjectType.getType(Object)"})
  void testGetType_whenWildcard_object_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ObjectType.getType(ConfigurationTransformation.WILDCARD_OBJECT));
  }
}
