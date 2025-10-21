package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperItemTool.BuilderImpl;
import io.papermc.paper.datacomponent.item.PaperItemTool.PaperRule;
import io.papermc.paper.datacomponent.item.Tool.Builder;
import io.papermc.paper.registry.set.NamedRegistryKeySetImpl;
import io.papermc.paper.registry.set.RegistryKeySet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import net.kyori.adventure.util.TriState;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Named;
import org.bukkit.block.BlockType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemToolDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addRules(Collection)}.
   *
   * <p>Method under test: {@link BuilderImpl#addRules(Collection)}
   */
  @Test
  @DisplayName("Test BuilderImpl addRules(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addRules(Collection)"})
  void testBuilderImplAddRules() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddRulesResult = builderImpl.addRules(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualAddRulesResult);
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
    "Tool BuilderImpl.build()",
    "Builder BuilderImpl.canDestroyBlocksInCreative(boolean)",
    "Builder BuilderImpl.defaultMiningSpeed(float)"
  })
  void testBuilderImplBuild() {
    // Arrange and Act
    Tool actualTool = new BuilderImpl().build();

    // Assert
    assertTrue(actualTool instanceof PaperItemTool);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#damagePerBlock(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#damagePerBlock(int)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl damagePerBlock(int); when one; then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.damagePerBlock(int)"})
  void testBuilderImplDamagePerBlock_whenOne_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualDamagePerBlockResult = builderImpl.damagePerBlock(1);

    // Assert
    assertSame(builderImpl, actualDamagePerBlockResult);
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
    Tool tool = new BuilderImpl().build();
    assertTrue(tool instanceof PaperItemTool);
    net.minecraft.world.item.component.Tool handle = ((PaperItemTool) tool).getHandle();
    assertEquals(1, handle.damagePerBlock());
    assertEquals(1.0f, handle.defaultMiningSpeed());
    assertTrue(handle.rules().isEmpty());
    assertTrue(handle.canDestroyBlocksInCreative());
    assertSame(handle, ((PaperItemTool) tool).impl());
  }

  /**
   * Test {@link PaperItemTool#getHandle()}.
   *
   * <p>Method under test: {@link PaperItemTool#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.item.component.Tool PaperItemTool.getHandle()"})
  void testGetHandle() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, true);

    // Act and Assert
    assertSame(impl, new PaperItemTool(impl).getHandle());
  }

  /**
   * Test PaperRule {@link PaperRule#fromUnsafe(RegistryKeySet, Float, TriState)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return speed is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaperRule#fromUnsafe(RegistryKeySet, Float, TriState)}
   */
  @Test
  @DisplayName(
      "Test PaperRule fromUnsafe(RegistryKeySet, Float, TriState); when 'null'; then return speed is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRule PaperRule.fromUnsafe(RegistryKeySet, Float, TriState)"})
  void testPaperRuleFromUnsafe_whenNull_thenReturnSpeedIsNull() {
    // Arrange
    NamedRegistryKeySetImpl<BlockType, Object> blocks =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));

    // Act
    PaperRule actualFromUnsafeResult = PaperRule.fromUnsafe(blocks, null, TriState.NOT_SET);

    // Assert
    RegistryKeySet<BlockType> blocksResult = actualFromUnsafeResult.blocks();
    assertTrue(blocksResult instanceof NamedRegistryKeySetImpl);
    assertNull(((NamedRegistryKeySetImpl<BlockType, Object>) blocksResult).tagKey());
    assertNull(actualFromUnsafeResult.speed());
    assertEquals(TriState.NOT_SET, actualFromUnsafeResult.correctForDrops());
    assertSame(blocks, blocksResult);
  }

  /**
   * Test PaperRule {@link PaperRule#fromUnsafe(RegistryKeySet, Float, TriState)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return speed floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperRule#fromUnsafe(RegistryKeySet, Float, TriState)}
   */
  @Test
  @DisplayName(
      "Test PaperRule fromUnsafe(RegistryKeySet, Float, TriState); when ten; then return speed floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PaperRule PaperRule.fromUnsafe(RegistryKeySet, Float, TriState)"})
  void testPaperRuleFromUnsafe_whenTen_thenReturnSpeedFloatValueIsTen() {
    // Arrange
    NamedRegistryKeySetImpl<BlockType, Object> blocks =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));

    // Act
    PaperRule actualFromUnsafeResult = PaperRule.fromUnsafe(blocks, 10.0f, TriState.NOT_SET);

    // Assert
    RegistryKeySet<BlockType> blocksResult = actualFromUnsafeResult.blocks();
    assertTrue(blocksResult instanceof NamedRegistryKeySetImpl);
    assertNull(((NamedRegistryKeySetImpl<BlockType, Object>) blocksResult).tagKey());
    assertEquals(10.0f, actualFromUnsafeResult.speed().floatValue());
    assertEquals(TriState.NOT_SET, actualFromUnsafeResult.correctForDrops());
    assertSame(blocks, blocksResult);
  }

  /**
   * Test {@link PaperItemTool#rules()}.
   *
   * <p>Method under test: {@link PaperItemTool#rules()}
   */
  @Test
  @DisplayName("Test rules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperItemTool.rules()"})
  void testRules() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, true);

    // Act and Assert
    assertTrue(new PaperItemTool(impl).rules().isEmpty());
  }

  /**
   * Test {@link PaperItemTool#rules()}.
   *
   * <p>Method under test: {@link PaperItemTool#rules()}
   */
  @Test
  @DisplayName("Test rules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperItemTool.rules()"})
  void testRules2() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new LinkedList<>(), 10.0f, 1, true);

    // Act and Assert
    assertTrue(new PaperItemTool(impl).rules().isEmpty());
  }

  /**
   * Test {@link PaperItemTool#defaultMiningSpeed()}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemTool#defaultMiningSpeed()}
   */
  @Test
  @DisplayName("Test defaultMiningSpeed(); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PaperItemTool.defaultMiningSpeed()"})
  void testDefaultMiningSpeed_thenReturnTen() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, true);

    // Act and Assert
    assertEquals(10.0f, new PaperItemTool(impl).defaultMiningSpeed());
  }

  /**
   * Test {@link PaperItemTool#damagePerBlock()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemTool#damagePerBlock()}
   */
  @Test
  @DisplayName("Test damagePerBlock(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperItemTool.damagePerBlock()"})
  void testDamagePerBlock_thenReturnOne() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, true);

    // Act and Assert
    assertEquals(1, new PaperItemTool(impl).damagePerBlock());
  }

  /**
   * Test {@link PaperItemTool#canDestroyBlocksInCreative()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemTool#canDestroyBlocksInCreative()}
   */
  @Test
  @DisplayName("Test canDestroyBlocksInCreative(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperItemTool.canDestroyBlocksInCreative()"})
  void testCanDestroyBlocksInCreative_thenReturnFalse() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, false);

    // Act and Assert
    assertFalse(new PaperItemTool(impl).canDestroyBlocksInCreative());
  }

  /**
   * Test {@link PaperItemTool#canDestroyBlocksInCreative()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemTool#canDestroyBlocksInCreative()}
   */
  @Test
  @DisplayName("Test canDestroyBlocksInCreative(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperItemTool.canDestroyBlocksInCreative()"})
  void testCanDestroyBlocksInCreative_thenReturnTrue() {
    // Arrange
    net.minecraft.world.item.component.Tool impl =
        new net.minecraft.world.item.component.Tool(new ArrayList<>(), 10.0f, 1, true);

    // Act and Assert
    assertTrue(new PaperItemTool(impl).canDestroyBlocksInCreative());
  }
}
