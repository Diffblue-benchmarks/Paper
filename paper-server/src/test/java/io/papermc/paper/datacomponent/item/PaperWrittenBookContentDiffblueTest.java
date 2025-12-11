package io.papermc.paper.datacomponent.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.datacomponent.item.PaperWrittenBookContent.BuilderImpl;
import io.papermc.paper.datacomponent.item.WrittenBookContent.Builder;
import io.papermc.paper.text.Filtered;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.server.network.Filterable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperWrittenBookContentDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPages(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPages(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addFilteredPages(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPages(List)"})
  void testBuilderImplAddFilteredPages() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    // Act
    Builder actualAddFilteredPagesResult = builderImpl.addFilteredPages(new ArrayList<>());

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    assertSame(builderImpl, actualAddFilteredPagesResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPages(List)}.
   *
   * <p>Method under test: {@link BuilderImpl#addPages(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addPages(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPages(List)"})
  void testBuilderImplAddPages() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    // Act
    Builder actualAddPagesResult = builderImpl.addPages(new ArrayList<>());

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    assertSame(builderImpl, actualAddPagesResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#filteredTitle(Filtered)}.
   *
   * <p>Method under test: {@link BuilderImpl#filteredTitle(Filtered)}
   */
  @Test
  @DisplayName("Test BuilderImpl filteredTitle(Filtered)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.filteredTitle(Filtered)"})
  void testBuilderImplFilteredTitle() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    Filtered<String> title2 = mock(Filtered.class);
    when(title2.filtered()).thenReturn("Filtered");
    when(title2.raw()).thenReturn("Raw");

    // Act
    Builder actualFilteredTitleResult = builderImpl.filteredTitle(title2);

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title2, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    verify(title2, atLeast(1)).raw();
    assertSame(builderImpl, actualFilteredTitleResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#filteredTitle(Filtered)}.
   *
   * <ul>
   *   <li>When {@link Filtered} {@link Filtered#filtered()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#filteredTitle(Filtered)}
   */
  @Test
  @DisplayName("Test BuilderImpl filteredTitle(Filtered); when Filtered filtered() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.filteredTitle(Filtered)"})
  void testBuilderImplFilteredTitle_whenFilteredFilteredReturnNull() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    Filtered<String> title2 = mock(Filtered.class);
    when(title2.filtered()).thenReturn(null);
    when(title2.raw()).thenReturn("Raw");

    // Act
    Builder actualFilteredTitleResult = builderImpl.filteredTitle(title2);

    // Assert
    verify(title2, atLeast(1)).filtered();
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    verify(title2, atLeast(1)).raw();
    assertSame(builderImpl, actualFilteredTitleResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#generation(int)}.
   *
   * <p>Method under test: {@link BuilderImpl#generation(int)}
   */
  @Test
  @DisplayName("Test BuilderImpl generation(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.generation(int)"})
  void testBuilderImplGeneration() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    // Act
    Builder actualGenerationResult = builderImpl.generation(1);

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    WrittenBookContent writtenBookContent = builderImpl.build();
    assertTrue(writtenBookContent instanceof PaperWrittenBookContent);
    assertEquals(1, ((PaperWrittenBookContent) writtenBookContent).getHandle().generation());
    assertSame(builderImpl, actualGenerationResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(Filtered, String)}.
   *
   * <ul>
   *   <li>Then return build Handle title filtered is {@code Filtered}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(Filtered, String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(Filtered, String); then return build Handle title filtered is 'Filtered'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(Filtered, String)"})
  void testBuilderImplNewBuilderImpl_thenReturnBuildHandleTitleFilteredIsFiltered() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl(title, "JaneDoe");

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    WrittenBookContent writtenBookContent = actualBuilderImpl.build();
    assertTrue(writtenBookContent instanceof PaperWrittenBookContent);
    net.minecraft.world.item.component.WrittenBookContent handle =
        ((PaperWrittenBookContent) writtenBookContent).getHandle();
    Filterable<String> titleResult = handle.title();
    Optional<String> filteredResult = titleResult.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("JaneDoe", handle.author());
    assertEquals("Raw", titleResult.raw());
    assertEquals(0, handle.generation());
    assertFalse(handle.resolved());
    assertTrue(handle.pages().isEmpty());
    assertTrue(filteredResult.isPresent());
    assertSame(handle, ((PaperWrittenBookContent) writtenBookContent).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#BuilderImpl(Filtered, String)}.
   *
   * <ul>
   *   <li>Then return not build Handle title filtered Present.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#BuilderImpl(Filtered, String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl new BuilderImpl(Filtered, String); then return not build Handle title filtered Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BuilderImpl.<init>(Filtered, String)"})
  void testBuilderImplNewBuilderImpl_thenReturnNotBuildHandleTitleFilteredPresent() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn(null);
    when(title.raw()).thenReturn("Raw");

    // Act
    BuilderImpl actualBuilderImpl = new BuilderImpl(title, "JaneDoe");

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    WrittenBookContent writtenBookContent = actualBuilderImpl.build();
    assertTrue(writtenBookContent instanceof PaperWrittenBookContent);
    net.minecraft.world.item.component.WrittenBookContent handle =
        ((PaperWrittenBookContent) writtenBookContent).getHandle();
    assertEquals("JaneDoe", handle.author());
    Filterable<String> titleResult = handle.title();
    assertEquals("Raw", titleResult.raw());
    assertEquals(0, handle.generation());
    assertFalse(titleResult.filtered().isPresent());
    assertFalse(handle.resolved());
    assertTrue(handle.pages().isEmpty());
    assertSame(handle, ((PaperWrittenBookContent) writtenBookContent).impl());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#title(String)}.
   *
   * <ul>
   *   <li>Then return {@link BuilderImpl#BuilderImpl(Filtered, String)} with title is {@link
   *       Filtered} and author is {@code JaneDoe}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#title(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl title(String); then return BuilderImpl(Filtered, String) with title is Filtered and author is 'JaneDoe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.title(String)"})
  void testBuilderImplTitle_thenReturnBuilderImplWithTitleIsFilteredAndAuthorIsJaneDoe() {
    // Arrange
    Filtered<String> title = mock(Filtered.class);
    when(title.filtered()).thenReturn("Filtered");
    when(title.raw()).thenReturn("Raw");
    BuilderImpl builderImpl = new BuilderImpl(title, "JaneDoe");

    // Act
    Builder actualTitleResult = builderImpl.title("Dr");

    // Assert
    verify(title, atLeast(1)).filtered();
    verify(title, atLeast(1)).raw();
    assertSame(builderImpl, actualTitleResult);
  }

  /**
   * Test {@link PaperWrittenBookContent#getHandle()}.
   *
   * <p>Method under test: {@link PaperWrittenBookContent#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.WrittenBookContent PaperWrittenBookContent.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperWrittenBookContent paperWrittenBookContent =
        new PaperWrittenBookContent(net.minecraft.world.item.component.WrittenBookContent.EMPTY);

    // Act and Assert
    net.minecraft.world.item.component.WrittenBookContent writtenBookContent =
        net.minecraft.world.item.component.WrittenBookContent.EMPTY;
    assertSame(writtenBookContent, paperWrittenBookContent.getHandle());
    assertSame(writtenBookContent, paperWrittenBookContent.impl());
  }

  /**
   * Test {@link PaperWrittenBookContent#author()}.
   *
   * <ul>
   *   <li>Given {@link PaperWrittenBookContent#PaperWrittenBookContent(WrittenBookContent)} with
   *       impl is {@link net.minecraft.world.item.component.WrittenBookContent#EMPTY}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PaperWrittenBookContent#author()}
   */
  @Test
  @DisplayName(
      "Test author(); given PaperWrittenBookContent(WrittenBookContent) with impl is EMPTY; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaperWrittenBookContent.author()"})
  void testAuthor_givenPaperWrittenBookContentWithImplIsEmpty_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new PaperWrittenBookContent(net.minecraft.world.item.component.WrittenBookContent.EMPTY)
            .author());
  }

  /**
   * Test {@link PaperWrittenBookContent#generation()}.
   *
   * <ul>
   *   <li>Given {@link PaperWrittenBookContent#PaperWrittenBookContent(WrittenBookContent)} with
   *       impl is {@link net.minecraft.world.item.component.WrittenBookContent#EMPTY}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PaperWrittenBookContent#generation()}
   */
  @Test
  @DisplayName(
      "Test generation(); given PaperWrittenBookContent(WrittenBookContent) with impl is EMPTY; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaperWrittenBookContent.generation()"})
  void testGeneration_givenPaperWrittenBookContentWithImplIsEmpty_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new PaperWrittenBookContent(net.minecraft.world.item.component.WrittenBookContent.EMPTY)
            .generation());
  }

  /**
   * Test {@link PaperWrittenBookContent#pages()}.
   *
   * <ul>
   *   <li>Given {@link PaperWrittenBookContent#PaperWrittenBookContent(WrittenBookContent)} with
   *       impl is {@link net.minecraft.world.item.component.WrittenBookContent#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperWrittenBookContent#pages()}
   */
  @Test
  @DisplayName(
      "Test pages(); given PaperWrittenBookContent(WrittenBookContent) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperWrittenBookContent.pages()"})
  void testPages_givenPaperWrittenBookContentWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperWrittenBookContent(net.minecraft.world.item.component.WrittenBookContent.EMPTY)
            .pages()
            .isEmpty());
  }

  /**
   * Test {@link PaperWrittenBookContent#resolved()}.
   *
   * <ul>
   *   <li>Given {@link PaperWrittenBookContent#PaperWrittenBookContent(WrittenBookContent)} with
   *       impl is {@link net.minecraft.world.item.component.WrittenBookContent#EMPTY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaperWrittenBookContent#resolved()}
   */
  @Test
  @DisplayName(
      "Test resolved(); given PaperWrittenBookContent(WrittenBookContent) with impl is EMPTY; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaperWrittenBookContent.resolved()"})
  void testResolved_givenPaperWrittenBookContentWithImplIsEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperWrittenBookContent(net.minecraft.world.item.component.WrittenBookContent.EMPTY)
            .resolved());
  }
}
