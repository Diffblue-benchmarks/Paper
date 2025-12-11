package io.papermc.paper.datacomponent.item.blocksattacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction.Builder;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperDamageReduction.BuilderImpl;
import io.papermc.paper.registry.set.NamedRegistryKeySetImpl;
import io.papermc.paper.registry.set.RegistryKeySet;
import java.util.ArrayList;
import java.util.Optional;
import net.kyori.adventure.key.Key;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Direct;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.component.BlocksAttacks;
import org.bukkit.NamespacedKey;
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
   * Test {@link PaperDamageReduction#type()}.
   *
   * <ul>
   *   <li>Given {@link HolderSet.Direct} {@link HolderSet.Direct#iterator()} return {@link
   *       ArrayList#ArrayList()} iterator.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#type()}
   */
  @Test
  @DisplayName(
      "Test type(); given Direct iterator() return ArrayList() iterator; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet PaperDamageReduction.type()"})
  void testType_givenDirectIteratorReturnArrayListIterator_thenReturnSizeIsZero() {
    // Arrange
    Direct<DamageType> direct = mock(Direct.class);

    ArrayList<Holder<DamageType>> holderList = new ArrayList<>();
    when(direct.iterator()).thenReturn(holderList.iterator());
    Optional<HolderSet<DamageType>> type = Optional.of(direct);
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act
    RegistryKeySet<org.bukkit.damage.DamageType> actualTypeResult =
        new PaperDamageReduction(impl).type();

    // Assert
    verify(direct).iterator();
    assertEquals(0, actualTypeResult.size());
    assertTrue(actualTypeResult.isEmpty());
  }

  /**
   * Test {@link PaperDamageReduction#type()}.
   *
   * <ul>
   *   <li>Then return {@link NamedRegistryKeySetImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#type()}
   */
  @Test
  @DisplayName("Test type(); then return NamedRegistryKeySetImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet PaperDamageReduction.type()"})
  void testType_thenReturnNamedRegistryKeySetImpl() {
    // Arrange
    Named<DamageType> named = mock(Named.class);
    when(named.key()).thenReturn(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<HolderSet<DamageType>> type = Optional.of(named);
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 0.0f, 10.0f);

    // Act
    RegistryKeySet<org.bukkit.damage.DamageType> actualTypeResult =
        new PaperDamageReduction(impl).type();

    // Assert
    verify(named).key();
    assertTrue(actualTypeResult instanceof NamedRegistryKeySetImpl);
    Key keyResult =
        ((NamedRegistryKeySetImpl<org.bukkit.damage.DamageType, Object>) actualTypeResult).key();
    assertTrue(keyResult instanceof NamespacedKey);
    assertEquals("always_hurts_ender_dragons", ((NamespacedKey) keyResult).getKey());
    assertEquals("minecraft", keyResult.namespace());
    assertEquals("minecraft", ((NamespacedKey) keyResult).getNamespace());
  }

  /**
   * Test {@link PaperDamageReduction#type()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperDamageReduction#type()}
   */
  @Test
  @DisplayName("Test type(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryKeySet PaperDamageReduction.type()"})
  void testType_thenReturnNull() {
    // Arrange
    Optional<HolderSet<DamageType>> type = Optional.empty();
    BlocksAttacks.DamageReduction impl =
        new BlocksAttacks.DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act and Assert
    assertNull(new PaperDamageReduction(impl).type());
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
