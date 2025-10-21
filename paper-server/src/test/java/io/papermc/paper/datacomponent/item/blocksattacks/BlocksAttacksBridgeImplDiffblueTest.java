package io.papermc.paper.datacomponent.item.blocksattacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.blocksattacks.DamageReduction.Builder;
import io.papermc.paper.datacomponent.item.blocksattacks.PaperDamageReduction.BuilderImpl;
import net.minecraft.world.item.component.BlocksAttacks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlocksAttacksBridgeImplDiffblueTest {
  /**
   * Test {@link BlocksAttacksBridgeImpl#blocksAttacksDamageReduction()}.
   *
   * <p>Method under test: {@link BlocksAttacksBridgeImpl#blocksAttacksDamageReduction()}
   */
  @Test
  @DisplayName("Test blocksAttacksDamageReduction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BlocksAttacksBridgeImpl.blocksAttacksDamageReduction()"})
  void testBlocksAttacksDamageReduction() {
    // Arrange and Act
    Builder actualBlocksAttacksDamageReductionResult =
        new BlocksAttacksBridgeImpl().blocksAttacksDamageReduction();

    // Assert
    DamageReduction damageReduction = actualBlocksAttacksDamageReductionResult.build();
    assertTrue(damageReduction instanceof PaperDamageReduction);
    assertTrue(actualBlocksAttacksDamageReductionResult instanceof BuilderImpl);
    BlocksAttacks.DamageReduction handle = ((PaperDamageReduction) damageReduction).getHandle();
    assertEquals(0.0f, handle.base());
    assertEquals(1.0f, handle.factor());
    assertEquals(90.0f, handle.horizontalBlockingAngle());
    assertFalse(handle.type().isPresent());
    assertSame(handle, ((PaperDamageReduction) damageReduction).impl());
  }

  /**
   * Test {@link BlocksAttacksBridgeImpl#blocksAttacksItemDamageFunction()}.
   *
   * <p>Method under test: {@link BlocksAttacksBridgeImpl#blocksAttacksItemDamageFunction()}
   */
  @Test
  @DisplayName("Test blocksAttacksItemDamageFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ItemDamageFunction.Builder BlocksAttacksBridgeImpl.blocksAttacksItemDamageFunction()"
  })
  void testBlocksAttacksItemDamageFunction() {
    // Arrange and Act
    ItemDamageFunction.Builder actualBlocksAttacksItemDamageFunctionResult =
        new BlocksAttacksBridgeImpl().blocksAttacksItemDamageFunction();

    // Assert
    ItemDamageFunction itemDamageFunction = actualBlocksAttacksItemDamageFunctionResult.build();
    assertTrue(itemDamageFunction instanceof PaperItemDamageFunction);
    assertTrue(
        actualBlocksAttacksItemDamageFunctionResult instanceof PaperItemDamageFunction.BuilderImpl);
    BlocksAttacks.ItemDamageFunction handle =
        ((PaperItemDamageFunction) itemDamageFunction).getHandle();
    assertEquals(0.0f, handle.base());
    assertEquals(1.0f, handle.factor());
    assertEquals(1.0f, handle.threshold());
    assertSame(handle, ((PaperItemDamageFunction) itemDamageFunction).impl());
  }
}
