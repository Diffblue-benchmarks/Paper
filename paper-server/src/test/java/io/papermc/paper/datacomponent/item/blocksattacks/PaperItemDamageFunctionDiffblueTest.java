package io.papermc.paper.datacomponent.item.blocksattacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.blocksattacks.ItemDamageFunction.Builder;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperItemDamageFunction.BuilderImpl;
import net.minecraft.world.item.component.BlocksAttacks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemDamageFunctionDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder BuilderImpl.base(float)",
    "ItemDamageFunction BuilderImpl.build()",
    "Builder BuilderImpl.factor(float)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    ItemDamageFunction actualItemDamageFunction = new BuilderImpl().build();

    // Assert
    assertTrue(actualItemDamageFunction instanceof PaperItemDamageFunction);
  }

  /**
   * Test BuilderImpl new {@link BuilderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BuilderImpl}
   */
  @Test
  @DisplayName("Test BuilderImpl new BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>()"})
  void testBuilderImplNewBuilderImpl() {
    // Arrange, Act and Assert
    ItemDamageFunction itemDamageFunction = new BuilderImpl().build();
    assertTrue(itemDamageFunction instanceof PaperItemDamageFunction);
    BlocksAttacks.ItemDamageFunction handle =
        ((PaperItemDamageFunction) itemDamageFunction).getHandle();
    assertEquals(0.0f, handle.base());
    assertEquals(1.0f, handle.factor());
    assertEquals(1.0f, handle.threshold());
    assertSame(handle, ((PaperItemDamageFunction) itemDamageFunction).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#threshold(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperItemDamageFunction}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#threshold(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl threshold(float); when ten; then BuilderImpl (default constructor) build PaperItemDamageFunction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.threshold(float)"})
  void testBuilderImplThreshold_whenTen_thenBuilderImplBuildPaperItemDamageFunction() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualThresholdResult = builderImpl.threshold(10.0f);

    // Assert
    ItemDamageFunction itemDamageFunction = builderImpl.build();
    assertTrue(itemDamageFunction instanceof PaperItemDamageFunction);
    assertEquals(10.0f, ((PaperItemDamageFunction) itemDamageFunction).getHandle().threshold());
    assertSame(builderImpl, actualThresholdResult);
  }

  /**
   * Test {@link PaperItemDamageFunction#getHandle()}.
   *
   * <p>Method under test: {@link PaperItemDamageFunction#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlocksAttacks.ItemDamageFunction PaperItemDamageFunction.getHandle()"})
  void testGetHandle() {
    // Arrange
    BlocksAttacks.ItemDamageFunction impl =
        new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f);

    // Act and Assert
    assertSame(impl, new PaperItemDamageFunction(impl).getHandle());
  }

  /**
   * Test {@link PaperItemDamageFunction#threshold()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#threshold()}
   */
  @Test
  @DisplayName("Test threshold(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperItemDamageFunction.threshold()"})
  void testThreshold_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f))
            .threshold());
  }

  /**
   * Test {@link PaperItemDamageFunction#base()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#base()}
   */
  @Test
  @DisplayName("Test base(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperItemDamageFunction.base()"})
  void testBase_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f))
            .base());
  }

  /**
   * Test {@link PaperItemDamageFunction#factor()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#factor()}
   */
  @Test
  @DisplayName("Test factor(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperItemDamageFunction.factor()"})
  void testFactor_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(
        10.0f,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f))
            .factor());
  }

  /**
   * Test {@link PaperItemDamageFunction#damageToApply(float)}.
   *
   * <ul>
   *   <li>Then return minus five.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#damageToApply(float)}
   */
  @Test
  @DisplayName("Test damageToApply(float); then return minus five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperItemDamageFunction.damageToApply(float)"})
  void testDamageToApply_thenReturnMinusFive() {
    // Arrange, Act and Assert
    assertEquals(
        -5,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 0.5f, -0.5f))
            .damageToApply(10.0f));
  }

  /**
   * Test {@link PaperItemDamageFunction#damageToApply(float)}.
   *
   * <ul>
   *   <li>Then return one hundred ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#damageToApply(float)}
   */
  @Test
  @DisplayName("Test damageToApply(float); then return one hundred ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperItemDamageFunction.damageToApply(float)"})
  void testDamageToApply_thenReturnOneHundredTen() {
    // Arrange, Act and Assert
    assertEquals(
        110,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f))
            .damageToApply(10.0f));
  }

  /**
   * Test {@link PaperItemDamageFunction#damageToApply(float)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemDamageFunction#damageToApply(float)}
   */
  @Test
  @DisplayName("Test damageToApply(float); when '0.5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperItemDamageFunction.damageToApply(float)"})
  void testDamageToApply_when05_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new PaperItemDamageFunction(new BlocksAttacks.ItemDamageFunction(10.0f, 10.0f, 10.0f))
            .damageToApply(0.5f));
  }
}
