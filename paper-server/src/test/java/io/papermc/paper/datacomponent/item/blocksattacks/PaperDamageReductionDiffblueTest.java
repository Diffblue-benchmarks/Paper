package io.papermc.paper.datacomponent.item.blocksattacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction.Builder;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperDamageReduction.BuilderImpl;
import io.papermc.paper.registry.set.RegistryKeySet;
import java.util.Optional;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Direct;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.component.BlocksAttacks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDamageReductionDiffblueTest {
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
    "DamageReduction BuilderImpl.build()",
    "Builder BuilderImpl.factor(float)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    DamageReduction actualDamageReduction = new BuilderImpl().build();

    // Assert
    assertTrue(actualDamageReduction instanceof PaperDamageReduction);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#horizontalBlockingAngle(float)}.
   *
   * <ul>
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperDamageReduction}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#horizontalBlockingAngle(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl horizontalBlockingAngle(float); then BuilderImpl (default constructor) build PaperDamageReduction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.horizontalBlockingAngle(float)"})
  void testBuilderImplHorizontalBlockingAngle_thenBuilderImplBuildPaperDamageReduction() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualHorizontalBlockingAngleResult = builderImpl.horizontalBlockingAngle(10.0f);

    // Assert
    DamageReduction damageReduction = builderImpl.build();
    assertTrue(damageReduction instanceof PaperDamageReduction);
    assertEquals(
        10.0f, ((PaperDamageReduction) damageReduction).getHandle().horizontalBlockingAngle());
    assertSame(builderImpl, actualHorizontalBlockingAngleResult);
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
    DamageReduction damageReduction = new BuilderImpl().build();
    assertTrue(damageReduction instanceof PaperDamageReduction);
    BlocksAttacks.DamageReduction handle = ((PaperDamageReduction) damageReduction).getHandle();
    assertEquals(0.0f, handle.base());
    assertEquals(1.0f, handle.factor());
    assertEquals(90.0f, handle.horizontalBlockingAngle());
    assertFalse(handle.type().isPresent());
    assertSame(handle, ((PaperDamageReduction) damageReduction).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#type(RegistryKeySet)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#type(RegistryKeySet)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl type(RegistryKeySet); when 'null'; then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.type(RegistryKeySet)"})
  void testBuilderImplType_whenNull_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualTypeResult = builderImpl.type(null);

    // Assert
    assertSame(builderImpl, actualTypeResult);
  }

  /**
   * Test {@link PaperDamageReduction#getHandle()}.
   *
   * <p>Method under test: {@link PaperDamageReduction#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlocksAttacks.DamageReduction PaperDamageReduction.getHandle()"})
  void testGetHandle() {
    // Arrange
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act and Assert
    assertSame(impl, new PaperDamageReduction(impl).getHandle());
  }

  /**
   * Test {@link PaperDamageReduction#horizontalBlockingAngle()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#horizontalBlockingAngle()}
   */
  @Test
  @DisplayName("Test horizontalBlockingAngle(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperDamageReduction.horizontalBlockingAngle()"})
  void testHorizontalBlockingAngle_thenReturnTen() {
    // Arrange
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act and Assert
    assertEquals(10.0f, new PaperDamageReduction(impl).horizontalBlockingAngle());
  }

  /**
   * Test {@link PaperDamageReduction#base()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#base()}
   */
  @Test
  @DisplayName("Test base(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperDamageReduction.base()"})
  void testBase_thenReturnTen() {
    // Arrange
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act and Assert
    assertEquals(10.0f, new PaperDamageReduction(impl).base());
  }

  /**
   * Test {@link PaperDamageReduction#factor()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#factor()}
   */
  @Test
  @DisplayName("Test factor(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperDamageReduction.factor()"})
  void testFactor_thenReturnTen() {
    // Arrange
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act and Assert
    assertEquals(10.0f, new PaperDamageReduction(impl).factor());
  }
}
