package org.bukkit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DyeColorDiffblueTest {
  /**
   * Test {@link DyeColor#getByWoolData(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByWoolData(byte)}
   */
  @Test
  @DisplayName("Test getByWoolData(byte); when 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByWoolData(byte)"})
  void testGetByWoolData_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DyeColor.getByWoolData((byte) 'A'));
  }

  /**
   * Test {@link DyeColor#getByWoolData(byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code WHITE}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByWoolData(byte)}
   */
  @Test
  @DisplayName("Test getByWoolData(byte); when zero; then return 'WHITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByWoolData(byte)"})
  void testGetByWoolData_whenZero_thenReturnWhite() {
    // Arrange, Act and Assert
    assertEquals(DyeColor.WHITE, DyeColor.getByWoolData((byte) 0));
  }

  /**
   * Test {@link DyeColor#getByDyeData(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByDyeData(byte)}
   */
  @Test
  @DisplayName("Test getByDyeData(byte); when 'A'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByDyeData(byte)"})
  void testGetByDyeData_whenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DyeColor.getByDyeData((byte) 'A'));
  }

  /**
   * Test {@link DyeColor#getByDyeData(byte)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code BLACK}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByDyeData(byte)}
   */
  @Test
  @DisplayName("Test getByDyeData(byte); when zero; then return 'BLACK'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByDyeData(byte)"})
  void testGetByDyeData_whenZero_thenReturnBlack() {
    // Arrange, Act and Assert
    assertEquals(DyeColor.BLACK, DyeColor.getByDyeData((byte) 0));
  }

  /**
   * Test {@link DyeColor#getByColor(Color)}.
   *
   * <p>Method under test: {@link DyeColor#getByColor(Color)}
   */
  @Test
  @DisplayName("Test getByColor(Color)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByColor(Color)"})
  void testGetByColor() throws IllegalArgumentException {
    // Arrange
    Color color = Color.fromARGB(1, 255, 255, 255);

    // Act and Assert
    assertNull(DyeColor.getByColor(color));
  }

  /**
   * Test {@link DyeColor#getByColor(Color)}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByColor(Color)}
   */
  @Test
  @DisplayName("Test getByColor(Color); when AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByColor(Color)"})
  void testGetByColor_whenAqua() {
    // Arrange, Act and Assert
    assertNull(DyeColor.getByColor(Color.AQUA));
  }

  /**
   * Test {@link DyeColor#getByFireworkColor(Color)}.
   *
   * <p>Method under test: {@link DyeColor#getByFireworkColor(Color)}
   */
  @Test
  @DisplayName("Test getByFireworkColor(Color)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByFireworkColor(Color)"})
  void testGetByFireworkColor() throws IllegalArgumentException {
    // Arrange
    Color color = Color.fromARGB(1, 255, 255, 255);

    // Act and Assert
    assertNull(DyeColor.getByFireworkColor(color));
  }

  /**
   * Test {@link DyeColor#getByFireworkColor(Color)}.
   *
   * <ul>
   *   <li>When {@link Color#AQUA}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByFireworkColor(Color)}
   */
  @Test
  @DisplayName("Test getByFireworkColor(Color); when AQUA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByFireworkColor(Color)"})
  void testGetByFireworkColor_whenAqua() {
    // Arrange, Act and Assert
    assertNull(DyeColor.getByFireworkColor(Color.AQUA));
  }

  /**
   * Test {@link DyeColor#getByFireworkColor(Color)}.
   *
   * <ul>
   *   <li>When {@link Color#BLACK}.
   * </ul>
   *
   * <p>Method under test: {@link DyeColor#getByFireworkColor(Color)}
   */
  @Test
  @DisplayName("Test getByFireworkColor(Color); when BLACK")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DyeColor DyeColor.getByFireworkColor(Color)"})
  void testGetByFireworkColor_whenBlack() {
    // Arrange, Act and Assert
    assertNull(DyeColor.getByFireworkColor(Color.BLACK));
  }
}
