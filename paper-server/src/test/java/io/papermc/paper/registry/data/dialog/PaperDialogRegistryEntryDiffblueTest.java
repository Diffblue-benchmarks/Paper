package io.papermc.paper.registry.data.dialog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.data.dialog.DialogBase.DialogAfterAction;
import io.papermc.paper.registry.data.dialog.DialogRegistryEntry.Builder;
import io.papermc.paper.registry.data.dialog.PaperDialogRegistryEntry.PaperBuilder;
import io.papermc.paper.registry.data.dialog.body.DialogBody;
import io.papermc.paper.registry.data.dialog.type.DialogType;
import io.papermc.paper.registry.data.dialog.type.NoticeTypeImpl;
import io.papermc.paper.registry.data.util.Conversions;
import io.papermc.paper.registry.set.RegistryValueSet;
import io.papermc.paper.registry.set.RegistryValueSetBuilder;
import io.papermc.paper.registry.set.RegistryValueSetBuilderImpl;
import java.util.ArrayList;
import net.kyori.adventure.text.Component;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.HolderLookupAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperDialogRegistryEntryDiffblueTest {
  /**
   * Test PaperBuilder {@link PaperBuilder#base(DialogBase)} with {@code DialogBase}.
   *
   * <p>Method under test: {@link PaperBuilder#base(DialogBase)}
   */
  @Test
  @DisplayName("Test PaperBuilder base(DialogBase) with 'DialogBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.base(DialogBase)"})
  void testPaperBuilderBaseWithDialogBase() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    PaperBuilder paperBuilder = new PaperBuilder(conversions, null);
    Component title = mock(Component.class);
    Component externalTitle = mock(Component.class);
    ArrayList<DialogBody> body = new ArrayList<>();

    DialogBaseImpl dialogBase =
        new DialogBaseImpl(
            title, externalTitle, true, true, DialogAfterAction.CLOSE, body, new ArrayList<>());

    // Act
    Builder actualBaseResult = paperBuilder.base(dialogBase);

    // Assert
    DialogBase dialogBase2 = paperBuilder.dialogBase;
    assertTrue(dialogBase2 instanceof DialogBaseImpl);
    assertEquals(DialogAfterAction.CLOSE, dialogBase2.afterAction());
    assertTrue(dialogBase2.canCloseWithEscape());
    assertTrue(dialogBase2.pause());
    assertSame(paperBuilder, actualBaseResult);
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#registryValueSet()}.
   *
   * <ul>
   *   <li>Then return {@link RegistryValueSetBuilderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PaperBuilder#registryValueSet()}
   */
  @Test
  @DisplayName("Test PaperBuilder registryValueSet(); then return RegistryValueSetBuilderImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegistryValueSetBuilder PaperBuilder.registryValueSet()"})
  void testPaperBuilderRegistryValueSet_thenReturnRegistryValueSetBuilderImpl() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    PaperBuilder paperBuilder = new PaperBuilder(conversions, null);

    // Act
    RegistryValueSetBuilder<Dialog, Builder> actualRegistryValueSetResult =
        paperBuilder.registryValueSet();

    // Assert
    assertTrue(actualRegistryValueSetResult instanceof RegistryValueSetBuilderImpl);
    RegistryValueSet<Dialog> registryValueSet = actualRegistryValueSetResult.build();
    assertEquals(0, registryValueSet.size());
    assertTrue(registryValueSet.isEmpty());
  }

  /**
   * Test PaperBuilder {@link PaperBuilder#type(DialogType)} with {@code DialogType}.
   *
   * <p>Method under test: {@link PaperBuilder#type(DialogType)}
   */
  @Test
  @DisplayName("Test PaperBuilder type(DialogType) with 'DialogType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder PaperBuilder.type(DialogType)"})
  void testPaperBuilderTypeWithDialogType() {
    // Arrange
    HolderLookupAdapter lookup =
        new HolderLookupAdapter(new ImmutableRegistryAccess(new ArrayList<>()));
    Conversions conversions = new Conversions(lookup);
    PaperBuilder paperBuilder = new PaperBuilder(conversions, null);

    // Act
    Builder actualTypeResult = paperBuilder.type(new NoticeTypeImpl());

    // Assert
    DialogType dialogType = paperBuilder.dialogType;
    assertTrue(dialogType instanceof NoticeTypeImpl);
    assertSame(paperBuilder, actualTypeResult);
    assertSame(NoticeTypeImpl.DEFAULT_ACTION, ((NoticeTypeImpl) dialogType).action());
  }
}
