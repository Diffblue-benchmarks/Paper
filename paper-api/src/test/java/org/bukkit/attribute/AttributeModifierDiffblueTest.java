package org.bukkit.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeModifierDiffblueTest {
  /**
   * Test {@link AttributeModifier#AttributeModifier(String, double, Operation)}.
   *
   * <ul>
   *   <li>When {@code ADD_NUMBER}.
   *   <li>Then return SlotGroup toString is {@code any}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(String, double, Operation)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(String, double, Operation); when 'ADD_NUMBER'; then return SlotGroup toString is 'any'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributeModifier.<init>(String, double, Operation)"})
  void testNewAttributeModifier_whenAddNumber_thenReturnSlotGroupToStringIsAny() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("any", slotGroup.toString());
    NamespacedKey key = actualAttributeModifier.getKey();
    assertEquals("minecraft", key.getNamespace());
    assertEquals("minecraft", key.namespace());
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(10.0d, actualAttributeModifier.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualAttributeModifier.getOperation());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
    assertSame(key, actualAttributeModifier.key());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation)}.
   *
   * <ul>
   *   <li>When {@code ADD_NUMBER}.
   *   <li>Then return SlotGroup toString is {@code any}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation); when 'ADD_NUMBER'; then return SlotGroup toString is 'any'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributeModifier.<init>(UUID, String, double, Operation)"})
  void testNewAttributeModifier_whenAddNumber_thenReturnSlotGroupToStringIsAny2() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("any", slotGroup.toString());
    NamespacedKey key = actualAttributeModifier.getKey();
    assertEquals("minecraft", key.getNamespace());
    assertEquals("minecraft", key.namespace());
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(10.0d, actualAttributeModifier.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualAttributeModifier.getOperation());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
    assertSame(key, actualAttributeModifier.key());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(NamespacedKey, double, Operation)}.
   *
   * <ul>
   *   <li>When {@code ADD_NUMBER}.
   *   <li>Then return SlotGroup toString is {@code any}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(NamespacedKey, double,
   * Operation)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(NamespacedKey, double, Operation); when 'ADD_NUMBER'; then return SlotGroup toString is 'any'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributeModifier.<init>(NamespacedKey, double, Operation)"})
  void testNewAttributeModifier_whenAddNumber_thenReturnSlotGroupToStringIsAny3() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(key, 10.0d, Operation.ADD_NUMBER);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("any", slotGroup.toString());
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(10.0d, actualAttributeModifier.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualAttributeModifier.getOperation());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
    assertSame(key, actualAttributeModifier.key());
    assertSame(key, actualAttributeModifier.getKey());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlotGroup)}.
   *
   * <ul>
   *   <li>When {@link EquipmentSlotGroup#ANY}.
   *   <li>Then return Key Namespace is {@code minecraft}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlotGroup)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlotGroup); when ANY; then return Key Namespace is 'minecraft'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlotGroup)"
  })
  void testNewAttributeModifier_whenAny_thenReturnKeyNamespaceIsMinecraft() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlotGroup.ANY);

    // Assert
    NamespacedKey key = actualAttributeModifier.getKey();
    assertEquals("minecraft", key.getNamespace());
    assertEquals("minecraft", key.namespace());
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(10.0d, actualAttributeModifier.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualAttributeModifier.getOperation());
    assertSame(key, actualAttributeModifier.key());
    assertSame(EquipmentSlotGroup.ANY, actualAttributeModifier.getSlotGroup());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(NamespacedKey, double, Operation,
   * EquipmentSlotGroup)}.
   *
   * <ul>
   *   <li>When {@link EquipmentSlotGroup#ANY}.
   *   <li>Then return Slot is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(NamespacedKey, double,
   * Operation, EquipmentSlotGroup)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(NamespacedKey, double, Operation, EquipmentSlotGroup); when ANY; then return Slot is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(NamespacedKey, double, Operation, EquipmentSlotGroup)"
  })
  void testNewAttributeModifier_whenAny_thenReturnSlotIsNull() {
    // Arrange
    NamespacedKey key = NamespacedKey.randomKey();

    // Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(key, 10.0d, Operation.ADD_NUMBER, EquipmentSlotGroup.ANY);

    // Assert
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(10.0d, actualAttributeModifier.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualAttributeModifier.getOperation());
    assertSame(key, actualAttributeModifier.key());
    assertSame(key, actualAttributeModifier.getKey());
    assertSame(EquipmentSlotGroup.ANY, actualAttributeModifier.getSlotGroup());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code BODY}.
   *   <li>Then return SlotGroup toString is {@code body}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'BODY'; then return SlotGroup toString is 'body'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenBody_thenReturnSlotGroupToStringIsBody() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.BODY);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("body", slotGroup.toString());
    assertEquals(EquipmentSlot.BODY, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.BODY, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code CHEST}.
   *   <li>Then return SlotGroup toString is {@code chest}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'CHEST'; then return SlotGroup toString is 'chest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenChest_thenReturnSlotGroupToStringIsChest() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("chest", slotGroup.toString());
    assertEquals(EquipmentSlot.CHEST, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.CHEST, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code FEET}.
   *   <li>Then return SlotGroup toString is {@code feet}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'FEET'; then return SlotGroup toString is 'feet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenFeet_thenReturnSlotGroupToStringIsFeet() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.FEET);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("feet", slotGroup.toString());
    assertEquals(EquipmentSlot.FEET, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.FEET, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code HAND}.
   *   <li>Then return SlotGroup toString is {@code mainhand}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'HAND'; then return SlotGroup toString is 'mainhand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenHand_thenReturnSlotGroupToStringIsMainhand() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.HAND);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("mainhand", slotGroup.toString());
    assertEquals(EquipmentSlot.HAND, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code HEAD}.
   *   <li>Then return SlotGroup toString is {@code head}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'HEAD'; then return SlotGroup toString is 'head'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenHead_thenReturnSlotGroupToStringIsHead() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.HEAD);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("head", slotGroup.toString());
    assertEquals(EquipmentSlot.HEAD, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.HEAD, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code LEGS}.
   *   <li>Then return SlotGroup toString is {@code legs}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'LEGS'; then return SlotGroup toString is 'legs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenLegs_thenReturnSlotGroupToStringIsLegs() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.LEGS);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("legs", slotGroup.toString());
    assertEquals(EquipmentSlot.LEGS, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.LEGS, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SlotGroup toString is {@code any}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'null'; then return SlotGroup toString is 'any'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenNull_thenReturnSlotGroupToStringIsAny() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, (EquipmentSlot) null);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("any", slotGroup.toString());
    assertNull(actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code OFF_HAND}.
   *   <li>Then return SlotGroup toString is {@code offhand}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'OFF_HAND'; then return SlotGroup toString is 'offhand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenOffHand_thenReturnSlotGroupToStringIsOffhand() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("offhand", slotGroup.toString());
    assertEquals(EquipmentSlot.OFF_HAND, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.OFF_HAND, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#AttributeModifier(UUID, String, double, Operation,
   * EquipmentSlot)}.
   *
   * <ul>
   *   <li>When {@code SADDLE}.
   *   <li>Then return SlotGroup toString is {@code saddle}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#AttributeModifier(UUID, String, double,
   * Operation, EquipmentSlot)}
   */
  @Test
  @DisplayName(
      "Test new AttributeModifier(UUID, String, double, Operation, EquipmentSlot); when 'SADDLE'; then return SlotGroup toString is 'saddle'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeModifier.<init>(UUID, String, double, Operation, EquipmentSlot)"
  })
  void testNewAttributeModifier_whenSaddle_thenReturnSlotGroupToStringIsSaddle() {
    // Arrange and Act
    AttributeModifier actualAttributeModifier =
        new AttributeModifier(
            UUID.randomUUID(), "Name", 10.0d, Operation.ADD_NUMBER, EquipmentSlot.SADDLE);

    // Assert
    EquipmentSlotGroup slotGroup = actualAttributeModifier.getSlotGroup();
    assertEquals("saddle", slotGroup.toString());
    assertEquals(EquipmentSlot.SADDLE, actualAttributeModifier.getSlot());
    assertEquals(EquipmentSlot.SADDLE, slotGroup.getExample());
  }

  /**
   * Test {@link AttributeModifier#getUniqueId()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 47c53d8d-d632-3230-badb-00fb3a156a97}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#getUniqueId()}
   */
  @Test
  @DisplayName("Test getUniqueId(); then return toString is '47c53d8d-d632-3230-badb-00fb3a156a97'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AttributeModifier.getUniqueId()"})
  void testGetUniqueId_thenReturnToStringIs47c53d8dD6323230Badb00fb3a156a97() {
    // Arrange, Act and Assert
    assertEquals(
        "47c53d8d-d632-3230-badb-00fb3a156a97",
        new AttributeModifier(
                NamespacedKey.minecraft(NamespacedKey.MINECRAFT), 10.0d, Operation.ADD_NUMBER)
            .getUniqueId()
            .toString());
  }

  /**
   * Test {@link AttributeModifier#getName()}.
   *
   * <ul>
   *   <li>Given {@link NamespacedKey} {@link NamespacedKey#getKey()} return {@code Key}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#getName()}
   */
  @Test
  @DisplayName("Test getName(); given NamespacedKey getKey() return 'Key'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AttributeModifier.getName()"})
  void testGetName_givenNamespacedKeyGetKeyReturnKey_thenReturnKey() {
    // Arrange
    NamespacedKey key = mock(NamespacedKey.class);
    when(key.getKey()).thenReturn("Key");

    // Act
    String actualName = new AttributeModifier(key, 10.0d, Operation.ADD_NUMBER).getName();

    // Assert
    verify(key).getKey();
    assertEquals("Key", actualName);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeModifier#getAmount()}
   *   <li>{@link AttributeModifier#getKey()}
   *   <li>{@link AttributeModifier#getOperation()}
   *   <li>{@link AttributeModifier#getSlotGroup()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double AttributeModifier.getAmount()",
    "NamespacedKey AttributeModifier.getKey()",
    "Operation AttributeModifier.getOperation()",
    "EquipmentSlotGroup AttributeModifier.getSlotGroup()"
  })
  void testGettersAndSetters() {
    // Arrange
    AttributeModifier attributeModifier =
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER);

    // Act
    double actualAmount = attributeModifier.getAmount();
    NamespacedKey actualKey = attributeModifier.getKey();
    Operation actualOperation = attributeModifier.getOperation();
    EquipmentSlotGroup actualSlotGroup = attributeModifier.getSlotGroup();

    // Assert
    assertEquals("minecraft", actualKey.getNamespace());
    assertEquals("minecraft", actualKey.namespace());
    assertEquals(10.0d, actualAmount);
    assertEquals(Operation.ADD_NUMBER, actualOperation);
    assertSame(EquipmentSlotGroup.ANY, actualSlotGroup);
  }

  /**
   * Test {@link AttributeModifier#getSlot()}.
   *
   * <p>Method under test: {@link AttributeModifier#getSlot()}
   */
  @Test
  @DisplayName("Test getSlot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EquipmentSlot AttributeModifier.getSlot()"})
  void testGetSlot() {
    // Arrange, Act and Assert
    assertNull(new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER).getSlot());
  }

  /**
   * Test {@link AttributeModifier#serialize()}.
   *
   * <p>Method under test: {@link AttributeModifier#serialize()}
   */
  @Test
  @DisplayName("Test serialize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AttributeModifier.serialize()"})
  void testSerialize() {
    // Arrange and Act
    Map<String, Object> actualSerializeResult =
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER).serialize();

    // Assert
    assertEquals(3, actualSerializeResult.size());
    assertEquals(0, ((Integer) actualSerializeResult.get("operation")).intValue());
    assertEquals(10.0d, ((Double) actualSerializeResult.get("amount")).doubleValue());
    assertTrue(actualSerializeResult.containsKey("key"));
  }

  /**
   * Test {@link AttributeModifier#equals(Object)}, and {@link AttributeModifier#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeModifier#equals(Object)}
   *   <li>{@link AttributeModifier#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeModifier.equals(Object)",
    "int AttributeModifier.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeModifier attributeModifier =
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER);

    // Act and Assert
    assertEquals(attributeModifier, attributeModifier);
    int expectedHashCodeResult = attributeModifier.hashCode();
    assertEquals(expectedHashCodeResult, attributeModifier.hashCode());
  }

  /**
   * Test {@link AttributeModifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeModifier.equals(Object)",
    "int AttributeModifier.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeModifier attributeModifier =
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER);

    // Act and Assert
    assertNotEquals(attributeModifier, new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER));
  }

  /**
   * Test {@link AttributeModifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeModifier.equals(Object)",
    "int AttributeModifier.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER), null);
  }

  /**
   * Test {@link AttributeModifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttributeModifier.equals(Object)",
    "int AttributeModifier.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AttributeModifier("Name", 10.0d, Operation.ADD_NUMBER),
        "Different type to AttributeModifier");
  }

  /**
   * Test {@link AttributeModifier#deserialize(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code uuid} is {@code 42}.
   *   <li>Then return Key Key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeModifier#deserialize(Map)}
   */
  @Test
  @DisplayName(
      "Test deserialize(Map); given '42'; when HashMap() 'uuid' is '42'; then return Key Key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributeModifier AttributeModifier.deserialize(Map)"})
  void testDeserialize_given42_whenHashMapUuidIs42_thenReturnKeyKeyIs42() {
    // Arrange
    HashMap<String, Object> args = new HashMap<>();
    args.put("uuid", "42");

    // Act
    AttributeModifier actualDeserializeResult = AttributeModifier.deserialize(args);

    // Assert
    NamespacedKey key = actualDeserializeResult.getKey();
    assertEquals("42", key.getKey());
    assertEquals("42", actualDeserializeResult.getName());
    EquipmentSlotGroup slotGroup = actualDeserializeResult.getSlotGroup();
    assertEquals("any", slotGroup.toString());
    assertEquals(
        "eb4c3dc4-d3ac-3eb8-8d39-f08335840e93", actualDeserializeResult.getUniqueId().toString());
    assertEquals("minecraft", key.getNamespace());
    assertEquals("minecraft", key.namespace());
    assertNull(actualDeserializeResult.getSlot());
    assertEquals(0.0d, actualDeserializeResult.getAmount());
    assertEquals(Operation.ADD_NUMBER, actualDeserializeResult.getOperation());
    assertEquals(EquipmentSlot.HAND, slotGroup.getExample());
    assertSame(key, actualDeserializeResult.key());
  }
}
