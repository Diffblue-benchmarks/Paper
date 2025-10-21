package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import co.aikar.timings.TimingIdentifier.TimingGroup;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimingIdentifierDiffblueTest {
  /**
   * Test {@link TimingIdentifier#TimingIdentifier(String, String, Timing)}.
   *
   * <ul>
   *   <li>When {@code Group}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#TimingIdentifier(String, String, Timing)}
   */
  @Test
  @DisplayName(
      "Test new TimingIdentifier(String, String, Timing); when 'Group'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingIdentifier.<init>(String, String, Timing)"})
  void testNewTimingIdentifier_whenGroup_thenReturnGroup() {
    // Arrange and Act
    TimingIdentifier actualTimingIdentifier =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Assert
    assertEquals("Group", actualTimingIdentifier.group);
    assertEquals("Name", actualTimingIdentifier.name);
    assertNull(actualTimingIdentifier.groupHandler);
  }

  /**
   * Test {@link TimingIdentifier#TimingIdentifier(String, String, Timing)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link TimingIdentifier#group} is {@code Minecraft}.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#TimingIdentifier(String, String, Timing)}
   */
  @Test
  @DisplayName(
      "Test new TimingIdentifier(String, String, Timing); when 'null'; then return group is 'Minecraft'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingIdentifier.<init>(String, String, Timing)"})
  void testNewTimingIdentifier_whenNull_thenReturnGroupIsMinecraft() {
    // Arrange and Act
    TimingIdentifier actualTimingIdentifier = new TimingIdentifier(null, "Name", null);

    // Assert
    assertEquals("Minecraft", actualTimingIdentifier.group);
    assertEquals("Name", actualTimingIdentifier.name);
    assertNull(actualTimingIdentifier.groupHandler);
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}, and {@link TimingIdentifier#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingIdentifier#equals(Object)}
   *   <li>{@link TimingIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimingIdentifier timingIdentifier =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);
    TimingIdentifier timingIdentifier2 =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act and Assert
    assertEquals(timingIdentifier, timingIdentifier2);
    assertEquals(timingIdentifier.hashCode(), timingIdentifier2.hashCode());
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}, and {@link TimingIdentifier#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingIdentifier#equals(Object)}
   *   <li>{@link TimingIdentifier#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimingIdentifier timingIdentifier =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act and Assert
    assertEquals(timingIdentifier, timingIdentifier);
    int expectedHashCodeResult = timingIdentifier.hashCode();
    assertEquals(expectedHashCodeResult, timingIdentifier.hashCode());
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TimingIdentifier timingIdentifier =
        new TimingIdentifier("Group", "Minecraft", NullTimingHandler.NULL);

    // Act and Assert
    assertNotEquals(
        timingIdentifier, new TimingIdentifier("Group", "Name", NullTimingHandler.NULL));
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TimingIdentifier timingIdentifier = new TimingIdentifier(null, "Name", NullTimingHandler.NULL);

    // Act and Assert
    assertNotEquals(
        timingIdentifier, new TimingIdentifier("Group", "Name", NullTimingHandler.NULL));
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TimingIdentifier("Group", "Name", NullTimingHandler.NULL), null);
  }

  /**
   * Test {@link TimingIdentifier#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link TimingIdentifier#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingIdentifier.equals(Object)", "int TimingIdentifier.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenThrowException() {
    // Arrange
    TimingIdentifier timingIdentifier =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act and Assert
    assertThrows(
        ClassCastException.class,
        () -> timingIdentifier.equals("Different type to TimingIdentifier"));
  }

  /**
   * Test TimingGroup {@link TimingGroup#equals(Object)}, and {@link TimingGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingGroup#equals(Object)}
   *   <li>{@link TimingGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TimingGroup equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingGroup.equals(Object)", "int TimingGroup.hashCode()"})
  void testTimingGroupEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TimingGroup group = TimingIdentifier.getGroup("Group Name");
    TimingGroup group2 = TimingIdentifier.getGroup("Group Name");

    // Act and Assert
    assertEquals(group, group2);
    assertEquals(group.hashCode(), group2.hashCode());
  }

  /**
   * Test TimingGroup {@link TimingGroup#equals(Object)}, and {@link TimingGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimingGroup#equals(Object)}
   *   <li>{@link TimingGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TimingGroup equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingGroup.equals(Object)", "int TimingGroup.hashCode()"})
  void testTimingGroupEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TimingGroup group = TimingIdentifier.getGroup("Group Name");

    // Act and Assert
    assertEquals(group, group);
    int expectedHashCodeResult = group.hashCode();
    assertEquals(expectedHashCodeResult, group.hashCode());
  }

  /**
   * Test TimingGroup {@link TimingGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test TimingGroup equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingGroup.equals(Object)", "int TimingGroup.hashCode()"})
  void testTimingGroupEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TimingIdentifier.getGroup("Minecraft"), TimingIdentifier.getGroup("Group Name"));
  }

  /**
   * Test TimingGroup {@link TimingGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test TimingGroup equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingGroup.equals(Object)", "int TimingGroup.hashCode()"})
  void testTimingGroupEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimingIdentifier.getGroup("Group Name"), null);
  }

  /**
   * Test TimingGroup {@link TimingGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TimingGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test TimingGroup equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TimingGroup.equals(Object)", "int TimingGroup.hashCode()"})
  void testTimingGroupEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TimingIdentifier.getGroup("Group Name"), "Different type to TimingGroup");
  }

  /**
   * Test {@link TimingIdentifier#toString()}.
   *
   * <p>Method under test: {@link TimingIdentifier#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TimingIdentifier.toString()"})
  void testToString() {
    // Arrange
    TimingIdentifier timingIdentifier =
        new TimingIdentifier("Group", "Name", NullTimingHandler.NULL);

    // Act and Assert
    assertEquals("TimingIdentifier{id=Group:Name}", timingIdentifier.toString());
  }
}
