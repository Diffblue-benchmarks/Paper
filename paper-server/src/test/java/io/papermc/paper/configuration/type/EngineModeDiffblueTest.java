package io.papermc.paper.configuration.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EngineModeDiffblueTest {
  /**
   * Test {@link EngineMode#valueOf(int)} with {@code id}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EngineMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'; when four; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineMode.valueOf(int)"})
  void testValueOfWithId_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EngineMode.valueOf(4));
  }

  /**
   * Test {@link EngineMode#valueOf(int)} with {@code id}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code HIDE}.
   * </ul>
   *
   * <p>Method under test: {@link EngineMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'; when one; then return 'HIDE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineMode.valueOf(int)"})
  void testValueOfWithId_whenOne_thenReturnHide() {
    // Arrange, Act and Assert
    assertEquals(EngineMode.HIDE, EngineMode.valueOf(1));
  }

  /**
   * Test {@link EngineMode#valueOf(int)} with {@code id}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code OBFUSCATE}.
   * </ul>
   *
   * <p>Method under test: {@link EngineMode#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'; when two; then return 'OBFUSCATE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EngineMode EngineMode.valueOf(int)"})
  void testValueOfWithId_whenTwo_thenReturnObfuscate() {
    // Arrange, Act and Assert
    assertEquals(EngineMode.OBFUSCATE, EngineMode.valueOf(2));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EngineMode#getDescription()}
   *   <li>{@link EngineMode#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EngineMode.getDescription()", "int EngineMode.getId()"})
  void testGettersAndSetters() {
    // Arrange
    EngineMode valueOfResult = EngineMode.valueOf("HIDE");

    // Act
    String actualDescription = valueOfResult.getDescription();

    // Assert
    assertEquals("hide ores", actualDescription);
    assertEquals(1, valueOfResult.getId());
  }
}
