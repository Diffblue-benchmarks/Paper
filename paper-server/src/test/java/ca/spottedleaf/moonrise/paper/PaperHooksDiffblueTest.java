package ca.spottedleaf.moonrise.paper;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.mojang.datafixers.DSL.TypeReference;
import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.fixes.References;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperHooksDiffblueTest {
  /**
   * Test {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int, int)}.
   *
   * <p>Method under test: {@link PaperHooks#convertNBT(TypeReference, DataFixer, CompoundTag, int,
   * int)}
   */
  @Test
  @DisplayName("Test convertNBT(TypeReference, DataFixer, CompoundTag, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompoundTag PaperHooks.convertNBT(TypeReference, DataFixer, CompoundTag, int, int)"
  })
  void testConvertNBT() {
    // Arrange, Act and Assert
    assertNull(new PaperHooks().convertNBT(References.PLAYER, mock(DataFixer.class), null, 1, 1));
  }
}
