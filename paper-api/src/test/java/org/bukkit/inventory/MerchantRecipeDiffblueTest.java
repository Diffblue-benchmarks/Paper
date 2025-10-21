package org.bukkit.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MerchantRecipeDiffblueTest {
  /**
   * Test {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int, float)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return AdjustedIngredient1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test new MerchantRecipe(ItemStack, int, int, boolean, int, float); given 'false'; then return AdjustedIngredient1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.<init>(ItemStack, int, int, boolean, int, float)"})
  void testNewMerchantRecipe_givenFalse_thenReturnAdjustedIngredient1IsNull() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    MerchantRecipe actualMerchantRecipe = new MerchantRecipe(result, 1, 3, true, 1, 10.0f);

    // Assert
    verify(result).isEmpty();
    assertNull(actualMerchantRecipe.getAdjustedIngredient1());
    assertNull(actualMerchantRecipe.getResult());
    assertEquals(0, actualMerchantRecipe.getDemand());
    assertEquals(0, actualMerchantRecipe.getSpecialPrice());
    assertEquals(1, actualMerchantRecipe.getUses());
    assertEquals(1, actualMerchantRecipe.getVillagerExperience());
    assertEquals(10.0f, actualMerchantRecipe.getPriceMultiplier());
    assertEquals(3, actualMerchantRecipe.getMaxUses());
    assertTrue(actualMerchantRecipe.getIngredients().isEmpty());
    assertTrue(actualMerchantRecipe.hasExperienceReward());
  }

  /**
   * Test {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int, float, int, int)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return AdjustedIngredient1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int,
   * float, int, int)}
   */
  @Test
  @DisplayName(
      "Test new MerchantRecipe(ItemStack, int, int, boolean, int, float, int, int); given 'false'; then return AdjustedIngredient1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerchantRecipe.<init>(ItemStack, int, int, boolean, int, float, int, int)"
  })
  void testNewMerchantRecipe_givenFalse_thenReturnAdjustedIngredient1IsNull2() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    MerchantRecipe actualMerchantRecipe = new MerchantRecipe(result, 1, 3, true, 1, 10.0f, 1, 1);

    // Assert
    verify(result).isEmpty();
    assertNull(actualMerchantRecipe.getAdjustedIngredient1());
    assertNull(actualMerchantRecipe.getResult());
    assertEquals(1, actualMerchantRecipe.getDemand());
    assertEquals(1, actualMerchantRecipe.getSpecialPrice());
    assertEquals(1, actualMerchantRecipe.getUses());
    assertEquals(1, actualMerchantRecipe.getVillagerExperience());
    assertEquals(10.0f, actualMerchantRecipe.getPriceMultiplier());
    assertEquals(3, actualMerchantRecipe.getMaxUses());
    assertTrue(actualMerchantRecipe.getIngredients().isEmpty());
    assertTrue(actualMerchantRecipe.hasExperienceReward());
  }

  /**
   * Test {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int, float, int, int,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return AdjustedIngredient1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int,
   * float, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MerchantRecipe(ItemStack, int, int, boolean, int, float, int, int, boolean); given 'false'; then return AdjustedIngredient1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerchantRecipe.<init>(ItemStack, int, int, boolean, int, float, int, int, boolean)"
  })
  void testNewMerchantRecipe_givenFalse_thenReturnAdjustedIngredient1IsNull3() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    MerchantRecipe actualMerchantRecipe =
        new MerchantRecipe(result, 1, 3, true, 1, 10.0f, 1, 1, true);

    // Assert
    verify(result).isEmpty();
    assertNull(actualMerchantRecipe.getAdjustedIngredient1());
    assertNull(actualMerchantRecipe.getResult());
    assertEquals(1, actualMerchantRecipe.getDemand());
    assertEquals(1, actualMerchantRecipe.getSpecialPrice());
    assertEquals(1, actualMerchantRecipe.getUses());
    assertEquals(1, actualMerchantRecipe.getVillagerExperience());
    assertEquals(10.0f, actualMerchantRecipe.getPriceMultiplier());
    assertEquals(3, actualMerchantRecipe.getMaxUses());
    assertTrue(actualMerchantRecipe.getIngredients().isEmpty());
    assertTrue(actualMerchantRecipe.hasExperienceReward());
  }

  /**
   * Test {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int, float, boolean)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return AdjustedIngredient1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#MerchantRecipe(ItemStack, int, int, boolean, int,
   * float, boolean)}
   */
  @Test
  @DisplayName(
      "Test new MerchantRecipe(ItemStack, int, int, boolean, int, float, boolean); given 'false'; then return AdjustedIngredient1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MerchantRecipe.<init>(ItemStack, int, int, boolean, int, float, boolean)"
  })
  void testNewMerchantRecipe_givenFalse_thenReturnAdjustedIngredient1IsNull4() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    MerchantRecipe actualMerchantRecipe = new MerchantRecipe(result, 1, 3, true, 1, 10.0f, true);

    // Assert
    verify(result).isEmpty();
    assertNull(actualMerchantRecipe.getAdjustedIngredient1());
    assertNull(actualMerchantRecipe.getResult());
    assertEquals(0, actualMerchantRecipe.getDemand());
    assertEquals(0, actualMerchantRecipe.getSpecialPrice());
    assertEquals(1, actualMerchantRecipe.getUses());
    assertEquals(1, actualMerchantRecipe.getVillagerExperience());
    assertEquals(10.0f, actualMerchantRecipe.getPriceMultiplier());
    assertEquals(3, actualMerchantRecipe.getMaxUses());
    assertTrue(actualMerchantRecipe.getIngredients().isEmpty());
    assertTrue(actualMerchantRecipe.hasExperienceReward());
  }

  /**
   * Test {@link MerchantRecipe#setIngredients(List)}.
   *
   * <p>Method under test: {@link MerchantRecipe#setIngredients(List)}
   */
  @Test
  @DisplayName("Test setIngredients(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.setIngredients(List)"})
  void testSetIngredients() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);

    // Act
    merchantRecipe.setIngredients(new ArrayList<>());

    // Assert
    verify(result).isEmpty();
  }

  /**
   * Test {@link MerchantRecipe#getIngredients()}.
   *
   * <ul>
   *   <li>Given {@link ItemStack} {@link ItemStack#isEmpty()} return {@code false}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#getIngredients()}
   */
  @Test
  @DisplayName("Test getIngredients(); given ItemStack isEmpty() return 'false'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MerchantRecipe.getIngredients()"})
  void testGetIngredients_givenItemStackIsEmptyReturnFalse_thenReturnEmpty() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    List<ItemStack> actualIngredients = new MerchantRecipe(result, 3).getIngredients();

    // Assert
    verify(result).isEmpty();
    assertTrue(actualIngredients.isEmpty());
  }

  /**
   * Test {@link MerchantRecipe#getAdjustedIngredient1()}.
   *
   * <ul>
   *   <li>Given {@link ItemStack} {@link ItemStack#isEmpty()} return {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#getAdjustedIngredient1()}
   */
  @Test
  @DisplayName(
      "Test getAdjustedIngredient1(); given ItemStack isEmpty() return 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemStack MerchantRecipe.getAdjustedIngredient1()"})
  void testGetAdjustedIngredient1_givenItemStackIsEmptyReturnFalse_thenReturnNull() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    ItemStack actualAdjustedIngredient1 = new MerchantRecipe(result, 3).getAdjustedIngredient1();

    // Assert
    verify(result).isEmpty();
    assertNull(actualAdjustedIngredient1);
  }

  /**
   * Test {@link MerchantRecipe#adjust(ItemStack)}.
   *
   * <p>Method under test: {@link MerchantRecipe#adjust(ItemStack)}
   */
  @Test
  @DisplayName("Test adjust(ItemStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.adjust(ItemStack)"})
  void testAdjust() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);
    merchantRecipe.setPriceMultiplier(Float.NaN);

    ItemStack itemStack = mock(ItemStack.class);
    when(itemStack.getMaxStackSize()).thenReturn(3);
    doNothing().when(itemStack).setAmount(anyInt());
    when(itemStack.getAmount()).thenReturn(10);
    when(itemStack.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    merchantRecipe.adjust(itemStack);

    // Assert
    verify(itemStack, atLeast(1)).getAmount();
    verify(itemStack).getMaxStackSize();
    verify(itemStack).getType();
    verify(result).isEmpty();
    verify(itemStack).setAmount(3);
  }

  /**
   * Test {@link MerchantRecipe#adjust(ItemStack)}.
   *
   * <ul>
   *   <li>Given {@link Material#AIR}.
   *   <li>When {@link ItemStack} {@link ItemStack#getType()} return {@link Material#AIR}.
   *   <li>Then calls {@link ItemStack#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#adjust(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test adjust(ItemStack); given AIR; when ItemStack getType() return AIR; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.adjust(ItemStack)"})
  void testAdjust_givenAir_whenItemStackGetTypeReturnAir_thenCallsGetType() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);

    ItemStack itemStack = mock(ItemStack.class);
    when(itemStack.getType()).thenReturn(Material.AIR);

    // Act
    merchantRecipe.adjust(itemStack);

    // Assert
    verify(itemStack).getType();
    verify(result).isEmpty();
  }

  /**
   * Test {@link MerchantRecipe#adjust(ItemStack)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link ItemStack#getMaxStackSize()}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#adjust(ItemStack)}
   */
  @Test
  @DisplayName("Test adjust(ItemStack); given three; then calls getMaxStackSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.adjust(ItemStack)"})
  void testAdjust_givenThree_thenCallsGetMaxStackSize() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);

    ItemStack itemStack = mock(ItemStack.class);
    when(itemStack.getMaxStackSize()).thenReturn(3);
    doNothing().when(itemStack).setAmount(anyInt());
    when(itemStack.getAmount()).thenReturn(10);
    when(itemStack.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    merchantRecipe.adjust(itemStack);

    // Assert
    verify(itemStack, atLeast(1)).getAmount();
    verify(itemStack).getMaxStackSize();
    verify(itemStack).getType();
    verify(result).isEmpty();
    verify(itemStack).setAmount(3);
  }

  /**
   * Test {@link MerchantRecipe#adjust(ItemStack)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ItemStack} {@link ItemStack#getAmount()} return zero.
   *   <li>Then calls {@link ItemStack#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#adjust(ItemStack)}
   */
  @Test
  @DisplayName(
      "Test adjust(ItemStack); given zero; when ItemStack getAmount() return zero; then calls getAmount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.adjust(ItemStack)"})
  void testAdjust_givenZero_whenItemStackGetAmountReturnZero_thenCallsGetAmount() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);
    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);

    ItemStack itemStack = mock(ItemStack.class);
    when(itemStack.getAmount()).thenReturn(0);
    when(itemStack.getType()).thenReturn(Material.ACACIA_BOAT);

    // Act
    merchantRecipe.adjust(itemStack);

    // Assert
    verify(itemStack).getAmount();
    verify(itemStack).getType();
    verify(result).isEmpty();
  }

  /**
   * Test {@link MerchantRecipe#adjust(ItemStack)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ItemStack#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#adjust(ItemStack)}
   */
  @Test
  @DisplayName("Test adjust(ItemStack); when 'null'; then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MerchantRecipe.adjust(ItemStack)"})
  void testAdjust_whenNull_thenCallsIsEmpty() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    new MerchantRecipe(result, 3).adjust(null);

    // Assert
    verify(result).isEmpty();
  }

  /**
   * Test {@link MerchantRecipe#shouldIgnoreDiscounts()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#shouldIgnoreDiscounts()}
   */
  @Test
  @DisplayName("Test shouldIgnoreDiscounts(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MerchantRecipe.shouldIgnoreDiscounts()"})
  void testShouldIgnoreDiscounts_thenReturnFalse() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    // Act
    boolean actualShouldIgnoreDiscountsResult =
        new MerchantRecipe(result, 3).shouldIgnoreDiscounts();

    // Assert
    verify(result).isEmpty();
    assertFalse(actualShouldIgnoreDiscountsResult);
  }

  /**
   * Test {@link MerchantRecipe#shouldIgnoreDiscounts()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MerchantRecipe#shouldIgnoreDiscounts()}
   */
  @Test
  @DisplayName("Test shouldIgnoreDiscounts(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MerchantRecipe.shouldIgnoreDiscounts()"})
  void testShouldIgnoreDiscounts_thenReturnTrue() {
    // Arrange
    ItemStack result = mock(ItemStack.class);
    when(result.isEmpty()).thenReturn(false);

    MerchantRecipe merchantRecipe = new MerchantRecipe(result, 3);
    merchantRecipe.setIgnoreDiscounts(true);

    // Act
    boolean actualShouldIgnoreDiscountsResult = merchantRecipe.shouldIgnoreDiscounts();

    // Assert
    verify(result).isEmpty();
    assertTrue(actualShouldIgnoreDiscountsResult);
  }
}
