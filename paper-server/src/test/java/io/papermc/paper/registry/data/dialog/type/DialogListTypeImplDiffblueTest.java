package io.papermc.paper.registry.data.dialog.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.type.DialogListType.Builder;
import io.papermc.paper.registry.data.dialog.type.DialogListTypeImpl.BuilderImpl;
import io.papermc.paper.registry.set.NamedRegistryKeySetImpl;
import net.minecraft.core.HolderSet;
import net.minecraft.core.HolderSet.Named;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DialogListTypeImplDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#buttonWidth(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#buttonWidth(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl buttonWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.buttonWidth(int)"})
  void testBuilderImplButtonWidth() {
    // Arrange
    NamedRegistryKeySetImpl<Dialog, Object> dialogs =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));
    BuilderImpl builderImpl = new BuilderImpl(dialogs);

    // Act
    Builder actualButtonWidthResult = builderImpl.buttonWidth(1);

    // Assert
    DialogListType dialogListType = builderImpl.build();
    assertTrue(dialogListType instanceof DialogListTypeImpl);
    assertEquals(1, dialogListType.buttonWidth());
    assertSame(builderImpl, actualButtonWidthResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#columns(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#columns(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl columns(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.columns(int)"})
  void testBuilderImplColumns() {
    // Arrange
    NamedRegistryKeySetImpl<Dialog, Object> dialogs =
        new NamedRegistryKeySetImpl<>(null, mock(Named.class));
    BuilderImpl builderImpl = new BuilderImpl(dialogs);

    // Act
    Builder actualColumnsResult = builderImpl.columns(1);

    // Assert
    DialogListType dialogListType = builderImpl.build();
    assertTrue(dialogListType instanceof DialogListTypeImpl);
    assertEquals(1, dialogListType.columns());
    assertSame(builderImpl, actualColumnsResult);
  }
}
