package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.BlocksAttacks.Builder;
import io.papermc.paper.datacomponent.item.PaperBlocksAttacks.BuilderImpl;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperDamageReduction;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperItemDamageFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.key.Key;
import net.kyori.examination.ExaminableProperty;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Direct;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.component.BlocksAttacks.DamageReduction;
import net.minecraft.world.item.component.BlocksAttacks.ItemDamageFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperBlocksAttacksDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addDamageReduction(DamageReduction)}.
   *
   * <p>Method under test: {@link
   * BuilderImpl#addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)}
   */
  @Test
  @DisplayName("Test BuilderImpl addDamageReduction(DamageReduction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder BuilderImpl.addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)"
  })
  void testBuilderImplAddDamageReduction() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction impl = new DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act
    Builder actualAddDamageReductionResult =
        builderImpl.addDamageReduction(new PaperDamageReduction(impl));

    // Assert
    BlocksAttacks blocksAttacks = builderImpl.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    assertEquals(1, ((PaperBlocksAttacks) blocksAttacks).getHandle().damageReductions().size());
    assertSame(builderImpl, actualAddDamageReductionResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addDamageReduction(DamageReduction)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor) damageReductions {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BuilderImpl#addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addDamageReduction(DamageReduction); given BuilderImpl (default constructor) damageReductions ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder BuilderImpl.addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)"
  })
  void testBuilderImplAddDamageReduction_givenBuilderImplDamageReductionsArrayList() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.damageReductions(new ArrayList<>());
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction impl = new DamageReduction(10.0f, type, 10.0f, 10.0f);

    // Act
    Builder actualAddDamageReductionResult =
        builderImpl.addDamageReduction(new PaperDamageReduction(impl));

    // Assert
    BlocksAttacks blocksAttacks = builderImpl.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    assertEquals(1, ((PaperBlocksAttacks) blocksAttacks).getHandle().damageReductions().size());
    assertSame(builderImpl, actualAddDamageReductionResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addDamageReduction(DamageReduction)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperBlocksAttacks}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BuilderImpl#addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addDamageReduction(DamageReduction); then build return PaperBlocksAttacks")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder BuilderImpl.addDamageReduction(io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction)"
  })
  void testBuilderImplAddDamageReduction_thenBuildReturnPaperBlocksAttacks() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction impl = new DamageReduction(10.0f, type, 10.0f, 10.0f);
    builderImpl.addDamageReduction(new PaperDamageReduction(impl));
    Optional<HolderSet<DamageType>> type2 = Optional.of(mock(Direct.class));
    DamageReduction impl2 = new DamageReduction(10.0f, type2, 10.0f, 10.0f);

    // Act
    Builder actualAddDamageReductionResult =
        builderImpl.addDamageReduction(new PaperDamageReduction(impl2));

    // Assert
    BlocksAttacks blocksAttacks = actualAddDamageReductionResult.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    BlocksAttacks blocksAttacks2 = builderImpl.build();
    assertTrue(blocksAttacks2 instanceof PaperBlocksAttacks);
    assertTrue(actualAddDamageReductionResult instanceof BuilderImpl);
    List<DamageReduction> damageReductionsResult =
        ((PaperBlocksAttacks) blocksAttacks).getHandle().damageReductions();
    assertEquals(2, damageReductionsResult.size());
    List<DamageReduction> damageReductionsResult2 =
        ((PaperBlocksAttacks) blocksAttacks2).getHandle().damageReductions();
    assertEquals(2, damageReductionsResult2.size());
    assertSame(impl2, damageReductionsResult.get(1));
    assertSame(impl2, damageReductionsResult2.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#blockDelaySeconds(float)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperBlocksAttacks}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#blockDelaySeconds(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl blockDelaySeconds(float); when ten; then BuilderImpl (default constructor) build PaperBlocksAttacks")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.blockDelaySeconds(float)"})
  void testBuilderImplBlockDelaySeconds_whenTen_thenBuilderImplBuildPaperBlocksAttacks() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualBlockDelaySecondsResult = builderImpl.blockDelaySeconds(10.0f);

    // Assert
    BlocksAttacks blocksAttacks = builderImpl.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    assertEquals(10.0f, ((PaperBlocksAttacks) blocksAttacks).getHandle().blockDelaySeconds());
    assertSame(builderImpl, actualBlockDelaySecondsResult);
  }

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
    "Builder BuilderImpl.blockSound(Key)",
    "BlocksAttacks BuilderImpl.build()",
    "Builder BuilderImpl.bypassedBy(io.papermc.paper.registry.tag.TagKey)",
    "Builder BuilderImpl.disableSound(Key)",
    "Builder BuilderImpl.itemDamage(io.papermc.paper.datacomponent.item.blocksattacks.ItemDamageFunction)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    BlocksAttacks actualBlocksAttacks = new BuilderImpl().build();

    // Assert
    assertTrue(actualBlocksAttacks instanceof PaperBlocksAttacks);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#damageReductions(List)}.
   *
   * <ul>
   *   <li>Then return build Handle damageReductions size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#damageReductions(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl damageReductions(List); then return build Handle damageReductions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.damageReductions(List)"})
  void testBuilderImplDamageReductions_thenReturnBuildHandleDamageReductionsSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction> reductions =
        new ArrayList<>();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction impl = new DamageReduction(10.0f, type, 10.0f, 10.0f);
    reductions.add(new PaperDamageReduction(impl));

    // Act
    Builder actualDamageReductionsResult = builderImpl.damageReductions(reductions);

    // Assert
    BlocksAttacks blocksAttacks = actualDamageReductionsResult.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    BlocksAttacks blocksAttacks2 = builderImpl.build();
    assertTrue(blocksAttacks2 instanceof PaperBlocksAttacks);
    assertTrue(actualDamageReductionsResult instanceof BuilderImpl);
    List<DamageReduction> damageReductionsResult =
        ((PaperBlocksAttacks) blocksAttacks).getHandle().damageReductions();
    assertEquals(1, damageReductionsResult.size());
    List<DamageReduction> damageReductionsResult2 =
        ((PaperBlocksAttacks) blocksAttacks2).getHandle().damageReductions();
    assertEquals(1, damageReductionsResult2.size());
    assertSame(impl, damageReductionsResult.get(0));
    assertSame(impl, damageReductionsResult2.get(0));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#damageReductions(List)}.
   *
   * <ul>
   *   <li>Then return build Handle damageReductions size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#damageReductions(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl damageReductions(List); then return build Handle damageReductions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.damageReductions(List)"})
  void testBuilderImplDamageReductions_thenReturnBuildHandleDamageReductionsSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction> reductions =
        new ArrayList<>();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction impl = new DamageReduction(10.0f, type, 10.0f, 10.0f);
    reductions.add(new PaperDamageReduction(impl));
    Optional<HolderSet<DamageType>> type2 = Optional.of(mock(Direct.class));
    DamageReduction impl2 = new DamageReduction(10.0f, type2, 10.0f, 10.0f);
    reductions.add(new PaperDamageReduction(impl2));

    // Act
    Builder actualDamageReductionsResult = builderImpl.damageReductions(reductions);

    // Assert
    BlocksAttacks blocksAttacks = actualDamageReductionsResult.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    BlocksAttacks blocksAttacks2 = builderImpl.build();
    assertTrue(blocksAttacks2 instanceof PaperBlocksAttacks);
    assertTrue(actualDamageReductionsResult instanceof BuilderImpl);
    List<DamageReduction> damageReductionsResult =
        ((PaperBlocksAttacks) blocksAttacks).getHandle().damageReductions();
    assertEquals(2, damageReductionsResult.size());
    List<DamageReduction> damageReductionsResult2 =
        ((PaperBlocksAttacks) blocksAttacks2).getHandle().damageReductions();
    assertEquals(2, damageReductionsResult2.size());
    assertSame(impl2, damageReductionsResult.get(1));
    assertSame(impl2, damageReductionsResult2.get(1));
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#damageReductions(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#damageReductions(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl damageReductions(List); when ArrayList(); then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.damageReductions(List)"})
  void testBuilderImplDamageReductions_whenArrayList_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualDamageReductionsResult = builderImpl.damageReductions(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualDamageReductionsResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#disableCooldownScale(float)}.
   *
   * <ul>
   *   <li>Then {@link BuilderImpl} (default constructor) build {@link PaperBlocksAttacks}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#disableCooldownScale(float)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl disableCooldownScale(float); then BuilderImpl (default constructor) build PaperBlocksAttacks")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.disableCooldownScale(float)"})
  void testBuilderImplDisableCooldownScale_thenBuilderImplBuildPaperBlocksAttacks() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualDisableCooldownScaleResult = builderImpl.disableCooldownScale(10.0f);

    // Assert
    BlocksAttacks blocksAttacks = builderImpl.build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    assertEquals(10.0f, ((PaperBlocksAttacks) blocksAttacks).getHandle().disableCooldownScale());
    assertSame(builderImpl, actualDisableCooldownScaleResult);
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
    BlocksAttacks blocksAttacks = new BuilderImpl().build();
    assertTrue(blocksAttacks instanceof PaperBlocksAttacks);
    net.minecraft.world.item.component.BlocksAttacks handle =
        ((PaperBlocksAttacks) blocksAttacks).getHandle();
    assertEquals(0.0f, handle.blockDelaySeconds());
    ItemDamageFunction itemDamageResult = handle.itemDamage();
    assertEquals(0.0f, itemDamageResult.base());
    assertEquals(1.0f, handle.disableCooldownScale());
    assertEquals(1.0f, itemDamageResult.factor());
    assertEquals(1.0f, itemDamageResult.threshold());
    Optional<Holder<SoundEvent>> blockSoundResult = handle.blockSound();
    assertFalse(blockSoundResult.isPresent());
    assertTrue(handle.damageReductions().isEmpty());
    assertSame(handle, ((PaperBlocksAttacks) blocksAttacks).impl());
    assertSame(blockSoundResult, handle.bypassedBy());
    assertSame(blockSoundResult, handle.disableSound());
  }

  /**
   * Test {@link PaperBlocksAttacks#getHandle()}.
   *
   * <p>Method under test: {@link PaperBlocksAttacks#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.BlocksAttacks PaperBlocksAttacks.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    net.minecraft.world.item.component.BlocksAttacks impl =
        new net.minecraft.world.item.component.BlocksAttacks(
            10.0f, 10.0f, damageReductions, itemDamage, bypassedBy, blockSound, disableSound);

    // Act and Assert
    assertSame(impl, new PaperBlocksAttacks(impl).getHandle());
  }

  /**
   * Test {@link PaperBlocksAttacks#blockDelaySeconds()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#blockDelaySeconds()}
   */
  @Test
  @DisplayName("Test blockDelaySeconds(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperBlocksAttacks.blockDelaySeconds()"})
  void testBlockDelaySeconds_thenReturnTen() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act and Assert
    assertEquals(
        10.0f,
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .blockDelaySeconds());
  }

  /**
   * Test {@link PaperBlocksAttacks#disableCooldownScale()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#disableCooldownScale()}
   */
  @Test
  @DisplayName("Test disableCooldownScale(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperBlocksAttacks.disableCooldownScale()"})
  void testDisableCooldownScale_thenReturnTen() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act and Assert
    assertEquals(
        10.0f,
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .disableCooldownScale());
  }

  /**
   * Test {@link PaperBlocksAttacks#damageReductions()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#damageReductions()}
   */
  @Test
  @DisplayName("Test damageReductions(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperBlocksAttacks.damageReductions()"})
  void testDamageReductions_thenReturnEmpty() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act and Assert
    assertTrue(
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .damageReductions()
            .isEmpty());
  }

  /**
   * Test {@link PaperBlocksAttacks#damageReductions()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#damageReductions()}
   */
  @Test
  @DisplayName("Test damageReductions(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperBlocksAttacks.damageReductions()"})
  void testDamageReductions_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction damageReduction = new DamageReduction(10.0f, type, 10.0f, 10.0f);
    damageReductions.add(damageReduction);
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act
    List<io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction>
        actualDamageReductionsResult =
            new PaperBlocksAttacks(
                    new net.minecraft.world.item.component.BlocksAttacks(
                        10.0f,
                        10.0f,
                        damageReductions,
                        itemDamage,
                        bypassedBy,
                        blockSound,
                        disableSound))
                .damageReductions();

    // Assert
    assertEquals(1, actualDamageReductionsResult.size());
    io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction getResult =
        actualDamageReductionsResult.get(0);
    assertTrue(getResult instanceof PaperDamageReduction);
    assertSame(damageReduction, ((PaperDamageReduction) getResult).getHandle());
    assertSame(damageReduction, ((PaperDamageReduction) getResult).impl());
  }

  /**
   * Test {@link PaperBlocksAttacks#damageReductions()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#damageReductions()}
   */
  @Test
  @DisplayName("Test damageReductions(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperBlocksAttacks.damageReductions()"})
  void testDamageReductions_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    Optional<HolderSet<DamageType>> type = Optional.of(mock(Direct.class));
    DamageReduction damageReduction = new DamageReduction(10.0f, type, 10.0f, 10.0f);
    damageReductions.add(damageReduction);
    Optional<HolderSet<DamageType>> type2 = Optional.of(mock(Direct.class));
    DamageReduction damageReduction2 = new DamageReduction(10.0f, type2, 10.0f, 10.0f);
    damageReductions.add(damageReduction2);
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act
    List<io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction>
        actualDamageReductionsResult =
            new PaperBlocksAttacks(
                    new net.minecraft.world.item.component.BlocksAttacks(
                        10.0f,
                        10.0f,
                        damageReductions,
                        itemDamage,
                        bypassedBy,
                        blockSound,
                        disableSound))
                .damageReductions();

    // Assert
    assertEquals(2, actualDamageReductionsResult.size());
    io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction getResult =
        actualDamageReductionsResult.get(1);
    assertTrue(getResult instanceof PaperDamageReduction);
    assertSame(damageReduction2, ((PaperDamageReduction) getResult).getHandle());
    assertSame(damageReduction2, ((PaperDamageReduction) getResult).impl());
  }

  /**
   * Test {@link PaperBlocksAttacks#itemDamage()}.
   *
   * <ul>
   *   <li>Then return {@link PaperItemDamageFunction}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#itemDamage()}
   */
  @Test
  @DisplayName("Test itemDamage(); then return PaperItemDamageFunction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "io.papermc.paper.datacomponent.item.blocksattacks.ItemDamageFunction PaperBlocksAttacks.itemDamage()"
  })
  void testItemDamage_thenReturnPaperItemDamageFunction() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act
    io.papermc.paper.datacomponent.item.blocksattacks.ItemDamageFunction actualItemDamageResult =
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .itemDamage();

    // Assert
    assertTrue(actualItemDamageResult instanceof PaperItemDamageFunction);
    assertSame(itemDamage, ((PaperItemDamageFunction) actualItemDamageResult).getHandle());
    assertSame(itemDamage, ((PaperItemDamageFunction) actualItemDamageResult).impl());
  }

  /**
   * Test {@link PaperBlocksAttacks#bypassedBy()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#bypassedBy()}
   */
  @Test
  @DisplayName("Test bypassedBy(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.papermc.paper.registry.tag.TagKey PaperBlocksAttacks.bypassedBy()"})
  void testBypassedBy_thenReturnNull() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy = Optional.empty();
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act and Assert
    assertNull(
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .bypassedBy());
  }

  /**
   * Test {@link PaperBlocksAttacks#blockSound()}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#blockSound()}
   */
  @Test
  @DisplayName("Test blockSound(); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBlocksAttacks.blockSound()"})
  void testBlockSound_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    Holder<SoundEvent> holder = mock(Holder.class);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    when(holder.value()).thenReturn(soundEvent);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(holder);
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act
    Key actualBlockSoundResult =
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .blockSound();

    // Assert
    verify(holder).value();
    assertEquals("KeyImpl", actualBlockSoundResult.examinableName());
    assertEquals("argument.id.invalid", actualBlockSoundResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualBlockSoundResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test {@link PaperBlocksAttacks#blockSound()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#blockSound()}
   */
  @Test
  @DisplayName("Test blockSound(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBlocksAttacks.blockSound()"})
  void testBlockSound_thenReturnNull() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.empty();
    Optional<Holder<SoundEvent>> disableSound = Optional.of(mock(Holder.class));

    // Act and Assert
    assertNull(
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .blockSound());
  }

  /**
   * Test {@link PaperBlocksAttacks#disableSound()}.
   *
   * <ul>
   *   <li>Then return examinableName is {@code KeyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#disableSound()}
   */
  @Test
  @DisplayName("Test disableSound(); then return examinableName is 'KeyImpl'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBlocksAttacks.disableSound()"})
  void testDisableSound_thenReturnExaminableNameIsKeyImpl() {
    // Arrange
    Holder<SoundEvent> holder = mock(Holder.class);
    ResourceLocation location = ResourceLocation.withDefaultNamespace("argument.id.invalid");
    Optional<Float> fixedRange = Optional.of(10.0f);

    SoundEvent soundEvent = new SoundEvent(location, fixedRange);
    when(holder.value()).thenReturn(soundEvent);
    Optional<Holder<SoundEvent>> disableSound = Optional.of(holder);
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));

    // Act
    Key actualDisableSoundResult =
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .disableSound();

    // Assert
    verify(holder).value();
    assertEquals("KeyImpl", actualDisableSoundResult.examinableName());
    assertEquals("argument.id.invalid", actualDisableSoundResult.asMinimalString());
    Stream<? extends ExaminableProperty> examinablePropertiesResult =
        actualDisableSoundResult.examinableProperties();
    assertEquals(2, examinablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test {@link PaperBlocksAttacks#disableSound()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBlocksAttacks#disableSound()}
   */
  @Test
  @DisplayName("Test disableSound(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Key PaperBlocksAttacks.disableSound()"})
  void testDisableSound_thenReturnNull() {
    // Arrange
    ArrayList<DamageReduction> damageReductions = new ArrayList<>();
    ItemDamageFunction itemDamage = new ItemDamageFunction(10.0f, 10.0f, 10.0f);
    Optional<TagKey<DamageType>> bypassedBy =
        Optional.of(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS);
    Optional<Holder<SoundEvent>> blockSound = Optional.of(mock(Holder.class));
    Optional<Holder<SoundEvent>> disableSound = Optional.empty();

    // Act and Assert
    assertNull(
        new PaperBlocksAttacks(
                new net.minecraft.world.item.component.BlocksAttacks(
                    10.0f,
                    10.0f,
                    damageReductions,
                    itemDamage,
                    bypassedBy,
                    blockSound,
                    disableSound))
            .disableSound());
  }
}
