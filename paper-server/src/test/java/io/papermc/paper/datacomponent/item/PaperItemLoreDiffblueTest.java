package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperItemLore.BuilderImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperItemLoreDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#build()}.
   *
   * <p>Method under test: {@link BuilderImpl#build()}
   */
  @Test
  @DisplayName("Test BuilderImpl build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ItemLore BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    ItemLore actualItemLore = new BuilderImpl().build();

    // Assert
    assertTrue(actualItemLore instanceof PaperItemLore);
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
    ItemLore itemLore = new BuilderImpl().build();
    assertTrue(itemLore instanceof PaperItemLore);
    net.minecraft.world.item.component.ItemLore handle = ((PaperItemLore) itemLore).getHandle();
    assertTrue(handle.lines().isEmpty());
    assertTrue(handle.styledLines().isEmpty());
    assertSame(handle, ((PaperItemLore) itemLore).impl());
  }

  /**
   * Test {@link PaperItemLore#getHandle()}.
   *
   * <p>Method under test: {@link PaperItemLore#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"net.minecraft.world.item.component.ItemLore PaperItemLore.getHandle()"})
  void testGetHandle() {
    // Arrange
    PaperItemLore paperItemLore =
        new PaperItemLore(net.minecraft.world.item.component.ItemLore.EMPTY);

    // Act and Assert
    net.minecraft.world.item.component.ItemLore itemLore =
        net.minecraft.world.item.component.ItemLore.EMPTY;
    assertSame(itemLore, paperItemLore.getHandle());
    assertSame(itemLore, paperItemLore.impl());
  }

  /**
   * Test {@link PaperItemLore#lines()}.
   *
   * <ul>
   *   <li>Given {@link PaperItemLore#PaperItemLore(ItemLore)} with impl is {@link
   *       net.minecraft.world.item.component.ItemLore#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemLore#lines()}
   */
  @Test
  @DisplayName("Test lines(); given PaperItemLore(ItemLore) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperItemLore.lines()"})
  void testLines_givenPaperItemLoreWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperItemLore(net.minecraft.world.item.component.ItemLore.EMPTY).lines().isEmpty());
  }

  /**
   * Test {@link PaperItemLore#styledLines()}.
   *
   * <ul>
   *   <li>Given {@link PaperItemLore#PaperItemLore(ItemLore)} with impl is {@link
   *       net.minecraft.world.item.component.ItemLore#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperItemLore#styledLines()}
   */
  @Test
  @DisplayName(
      "Test styledLines(); given PaperItemLore(ItemLore) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PaperItemLore.styledLines()"})
  void testStyledLines_givenPaperItemLoreWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperItemLore(net.minecraft.world.item.component.ItemLore.EMPTY)
            .styledLines()
            .isEmpty());
  }
}
