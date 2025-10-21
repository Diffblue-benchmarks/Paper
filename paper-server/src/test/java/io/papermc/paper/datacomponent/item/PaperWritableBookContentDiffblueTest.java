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
import io.papermc.paper.datacomponent.item.PaperWritableBookContent.BuilderImpl;
import io.papermc.paper.datacomponent.item.WritableBookContent.Builder;
import io.papermc.paper.text.Filtered;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.server.network.Filterable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PaperWritableBookContentDiffblueTest {
  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPage(Filtered)}.
   *
   * <ul>
   *   <li>Then return build Handle pages first filtered is {@code Filtered}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPage(Filtered)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPage(Filtered); then return build Handle pages first filtered is 'Filtered'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPage(Filtered)"})
  void testBuilderImplAddFilteredPage_thenReturnBuildHandlePagesFirstFilteredIsFiltered() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    Filtered<String> page = mock(Filtered.class);
    when(page.filtered()).thenReturn("Filtered");
    when(page.raw()).thenReturn("Raw");

    // Act
    Builder actualAddFilteredPageResult = builderImpl.addFilteredPage(page);

    // Assert
    verify(page, atLeast(1)).filtered();
    verify(page, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPageResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPageResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(1, pagesResult.size());
    Filterable<String> getResult = pagesResult.get(0);
    Optional<String> filteredResult = getResult.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("Raw", getResult.raw());
    assertEquals(1, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertTrue(filteredResult.isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPage(Filtered)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPage(Filtered)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPage(Filtered); then return build Handle pages size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPage(Filtered)"})
  void testBuilderImplAddFilteredPage_thenReturnBuildHandlePagesSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addPage("Cannot have page length more than %s, had %s");

    Filtered<String> page = mock(Filtered.class);
    when(page.filtered()).thenReturn("Filtered");
    when(page.raw()).thenReturn("Raw");

    // Act
    Builder actualAddFilteredPageResult = builderImpl.addFilteredPage(page);

    // Assert
    verify(page, atLeast(1)).filtered();
    verify(page, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPageResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPageResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(2, pagesResult.size());
    assertEquals("Cannot have page length more than %s, had %s", pagesResult.get(0).raw());
    Filterable<String> getResult = pagesResult.get(1);
    Optional<String> filteredResult = getResult.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("Raw", getResult.raw());
    assertEquals(2, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertTrue(filteredResult.isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPage(Filtered)}.
   *
   * <ul>
   *   <li>Then return not build Handle pages first filtered Present.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPage(Filtered)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPage(Filtered); then return not build Handle pages first filtered Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPage(Filtered)"})
  void testBuilderImplAddFilteredPage_thenReturnNotBuildHandlePagesFirstFilteredPresent() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    Filtered<String> page = mock(Filtered.class);
    when(page.filtered()).thenReturn(null);
    when(page.raw()).thenReturn("Raw");

    // Act
    Builder actualAddFilteredPageResult = builderImpl.addFilteredPage(page);

    // Assert
    verify(page, atLeast(1)).filtered();
    verify(page, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPageResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPageResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(1, pagesResult.size());
    Filterable<String> getResult = pagesResult.get(0);
    assertEquals("Raw", getResult.raw());
    assertEquals(1, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertFalse(getResult.filtered().isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPages(List)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is eleven.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPages(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPages(List); then return build Handle pages size is eleven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPages(List)"})
  void testBuilderImplAddFilteredPages_thenReturnBuildHandlePagesSizeIsEleven() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addPage("java.lang.String");

    Filtered<String> filtered = mock(Filtered.class);
    when(filtered.filtered()).thenReturn("Filtered");
    when(filtered.raw()).thenReturn("Raw");

    Filtered<String> filtered2 = mock(Filtered.class);
    when(filtered2.filtered()).thenReturn("Filtered");
    when(filtered2.raw()).thenReturn("Raw");

    Filtered<String> filtered3 = mock(Filtered.class);
    when(filtered3.filtered()).thenReturn("Filtered");
    when(filtered3.raw()).thenReturn("Raw");

    Filtered<String> filtered4 = mock(Filtered.class);
    when(filtered4.filtered()).thenReturn("Filtered");
    when(filtered4.raw()).thenReturn("Raw");

    Filtered<String> filtered5 = mock(Filtered.class);
    when(filtered5.filtered()).thenReturn("Filtered");
    when(filtered5.raw()).thenReturn("Raw");

    Filtered<String> filtered6 = mock(Filtered.class);
    when(filtered6.filtered()).thenReturn("Filtered");
    when(filtered6.raw()).thenReturn("Raw");

    Filtered<String> filtered7 = mock(Filtered.class);
    when(filtered7.filtered()).thenReturn("Filtered");
    when(filtered7.raw()).thenReturn("Raw");

    Filtered<String> filtered8 = mock(Filtered.class);
    when(filtered8.filtered()).thenReturn("Filtered");
    when(filtered8.raw()).thenReturn("Raw");

    Filtered<String> filtered9 = mock(Filtered.class);
    when(filtered9.filtered()).thenReturn("Filtered");
    when(filtered9.raw()).thenReturn("Raw");

    Filtered<String> filtered10 = mock(Filtered.class);
    when(filtered10.filtered()).thenReturn("Filtered");
    when(filtered10.raw()).thenReturn("Raw");

    ArrayList<Filtered<String>> pages = new ArrayList<>();
    pages.add(filtered10);
    pages.add(filtered9);
    pages.add(filtered8);
    pages.add(filtered7);
    pages.add(filtered6);
    pages.add(filtered5);
    pages.add(filtered4);
    pages.add(filtered3);
    pages.add(filtered2);
    pages.add(filtered);

    // Act
    Builder actualAddFilteredPagesResult = builderImpl.addFilteredPages(pages);

    // Assert
    verify(filtered10, atLeast(1)).filtered();
    verify(filtered9, atLeast(1)).filtered();
    verify(filtered8, atLeast(1)).filtered();
    verify(filtered7, atLeast(1)).filtered();
    verify(filtered6, atLeast(1)).filtered();
    verify(filtered5, atLeast(1)).filtered();
    verify(filtered4, atLeast(1)).filtered();
    verify(filtered3, atLeast(1)).filtered();
    verify(filtered2, atLeast(1)).filtered();
    verify(filtered, atLeast(1)).filtered();
    verify(filtered10, atLeast(1)).raw();
    verify(filtered9, atLeast(1)).raw();
    verify(filtered8, atLeast(1)).raw();
    verify(filtered7, atLeast(1)).raw();
    verify(filtered6, atLeast(1)).raw();
    verify(filtered5, atLeast(1)).raw();
    verify(filtered4, atLeast(1)).raw();
    verify(filtered3, atLeast(1)).raw();
    verify(filtered2, atLeast(1)).raw();
    verify(filtered, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPagesResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPagesResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(11, pagesResult.size());
    assertEquals("Raw", pagesResult.get(10).raw());
    assertEquals("Raw", pagesResult.get(9).raw());
    assertEquals("java.lang.String", pagesResult.get(0).raw());
    assertEquals(11, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPages(List)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPages(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPages(List); then return build Handle pages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPages(List)"})
  void testBuilderImplAddFilteredPages_thenReturnBuildHandlePagesSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    Filtered<String> filtered = mock(Filtered.class);
    when(filtered.filtered()).thenReturn("Filtered");
    when(filtered.raw()).thenReturn("Raw");

    ArrayList<Filtered<String>> pages = new ArrayList<>();
    pages.add(filtered);

    // Act
    Builder actualAddFilteredPagesResult = builderImpl.addFilteredPages(pages);

    // Assert
    verify(filtered, atLeast(1)).filtered();
    verify(filtered, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPagesResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPagesResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(1, pagesResult.size());
    Filterable<String> getResult = pagesResult.get(0);
    Optional<String> filteredResult = getResult.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("Raw", getResult.raw());
    assertEquals(1, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertTrue(filteredResult.isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPages(List)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPages(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPages(List); then return build Handle pages size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPages(List)"})
  void testBuilderImplAddFilteredPages_thenReturnBuildHandlePagesSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addPage("Cannot have page length more than %s, had %s");

    Filtered<String> filtered = mock(Filtered.class);
    when(filtered.filtered()).thenReturn("Filtered");
    when(filtered.raw()).thenReturn("Raw");

    ArrayList<Filtered<String>> pages = new ArrayList<>();
    pages.add(filtered);

    // Act
    Builder actualAddFilteredPagesResult = builderImpl.addFilteredPages(pages);

    // Assert
    verify(filtered, atLeast(1)).filtered();
    verify(filtered, atLeast(1)).raw();
    WritableBookContent writableBookContent = actualAddFilteredPagesResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddFilteredPagesResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(2, pagesResult.size());
    Filterable<String> getResult = pagesResult.get(0);
    assertEquals("Cannot have page length more than %s, had %s", getResult.raw());
    Filterable<String> getResult2 = pagesResult.get(1);
    Optional<String> filteredResult = getResult2.filtered();
    assertEquals("Filtered", filteredResult.get());
    assertEquals("Raw", getResult2.raw());
    assertEquals(2, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertFalse(getResult.filtered().isPresent());
    assertTrue(filteredResult.isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addFilteredPages(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addFilteredPages(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addFilteredPages(List); when ArrayList(); then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addFilteredPages(List)"})
  void testBuilderImplAddFilteredPages_whenArrayList_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddFilteredPagesResult = builderImpl.addFilteredPages(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualAddFilteredPagesResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPage(String)}.
   *
   * <ul>
   *   <li>Given {@link BuilderImpl} (default constructor).
   *   <li>Then {@link BuilderImpl} (default constructor) build Handle pages size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addPage(String)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addPage(String); given BuilderImpl (default constructor); then BuilderImpl (default constructor) build Handle pages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPage(String)"})
  void testBuilderImplAddPage_givenBuilderImpl_thenBuilderImplBuildHandlePagesSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddPageResult = builderImpl.addPage("Page");

    // Assert
    WritableBookContent writableBookContent = builderImpl.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    assertEquals(1, ((PaperWritableBookContent) writableBookContent).getHandle().pages().size());
    assertSame(builderImpl, actualAddPageResult);
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPage(String)}.
   *
   * <ul>
   *   <li>Then build return {@link PaperWritableBookContent}.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addPage(String)}
   */
  @Test
  @DisplayName("Test BuilderImpl addPage(String); then build return PaperWritableBookContent")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPage(String)"})
  void testBuilderImplAddPage_thenBuildReturnPaperWritableBookContent() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();
    builderImpl.addPage("Cannot have page length more than %s, had %s");

    // Act
    Builder actualAddPageResult = builderImpl.addPage("Page");

    // Assert
    WritableBookContent writableBookContent = actualAddPageResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddPageResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(2, pagesResult.size());
    assertEquals("Cannot have page length more than %s, had %s", pagesResult.get(0).raw());
    assertEquals("Page", pagesResult.get(1).raw());
    assertEquals(2, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPages(List)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is one.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addPages(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addPages(List); then return build Handle pages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPages(List)"})
  void testBuilderImplAddPages_thenReturnBuildHandlePagesSizeIsOne() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<String> pages = new ArrayList<>();
    pages.add("Cannot have more than %s pages, had %s");

    // Act
    Builder actualAddPagesResult = builderImpl.addPages(pages);

    // Assert
    WritableBookContent writableBookContent = actualAddPagesResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddPagesResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(1, pagesResult.size());
    Filterable<String> getResult = pagesResult.get(0);
    assertEquals("Cannot have more than %s pages, had %s", getResult.raw());
    assertEquals(1, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
    assertFalse(getResult.filtered().isPresent());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPages(List)}.
   *
   * <ul>
   *   <li>Then return build Handle pages size is two.
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addPages(List)}
   */
  @Test
  @DisplayName("Test BuilderImpl addPages(List); then return build Handle pages size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPages(List)"})
  void testBuilderImplAddPages_thenReturnBuildHandlePagesSizeIsTwo() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    ArrayList<String> pages = new ArrayList<>();
    pages.add("Cannot have page length more than %s, had %s");
    pages.add("Cannot have more than %s pages, had %s");

    // Act
    Builder actualAddPagesResult = builderImpl.addPages(pages);

    // Assert
    WritableBookContent writableBookContent = actualAddPagesResult.build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    WritableBookContent writableBookContent2 = builderImpl.build();
    assertTrue(writableBookContent2 instanceof PaperWritableBookContent);
    assertTrue(actualAddPagesResult instanceof BuilderImpl);
    List<Filterable<String>> pagesResult =
        ((PaperWritableBookContent) writableBookContent).getHandle().pages();
    assertEquals(2, pagesResult.size());
    assertEquals("Cannot have more than %s pages, had %s", pagesResult.get(1).raw());
    assertEquals("Cannot have page length more than %s, had %s", pagesResult.get(0).raw());
    assertEquals(2, ((PaperWritableBookContent) writableBookContent2).getHandle().pages().size());
  }

  /**
   * Test BuilderImpl {@link BuilderImpl#addPages(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link BuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BuilderImpl#addPages(List)}
   */
  @Test
  @DisplayName(
      "Test BuilderImpl addPages(List); when ArrayList(); then return BuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder BuilderImpl.addPages(List)"})
  void testBuilderImplAddPages_whenArrayList_thenReturnBuilderImpl() {
    // Arrange
    BuilderImpl builderImpl = new BuilderImpl();

    // Act
    Builder actualAddPagesResult = builderImpl.addPages(new ArrayList<>());

    // Assert
    assertSame(builderImpl, actualAddPagesResult);
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
  @MethodsUnderTest({"WritableBookContent BuilderImpl.build()"})
  void testBuilderImplBuild() {
    // Arrange and Act
    WritableBookContent actualWritableBookContent = new BuilderImpl().build();

    // Assert
    assertTrue(actualWritableBookContent instanceof PaperWritableBookContent);
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
    WritableBookContent writableBookContent = new BuilderImpl().build();
    assertTrue(writableBookContent instanceof PaperWritableBookContent);
    net.minecraft.world.item.component.WritableBookContent handle =
        ((PaperWritableBookContent) writableBookContent).getHandle();
    assertTrue(handle.pages().isEmpty());
    assertSame(handle, ((PaperWritableBookContent) writableBookContent).impl());
  }

  /**
   * Test {@link PaperWritableBookContent#getHandle()}.
   *
   * <p>Method under test: {@link PaperWritableBookContent#getHandle()}
   */
  @Test
  @DisplayName("Test getHandle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "net.minecraft.world.item.component.WritableBookContent PaperWritableBookContent.getHandle()"
  })
  void testGetHandle() {
    // Arrange
    PaperWritableBookContent paperWritableBookContent =
        new PaperWritableBookContent(net.minecraft.world.item.component.WritableBookContent.EMPTY);

    // Act
    net.minecraft.world.item.component.WritableBookContent actualHandle =
        paperWritableBookContent.getHandle();

    // Assert
    assertTrue(actualHandle.pages().isEmpty());
    net.minecraft.world.item.component.WritableBookContent writableBookContent =
        net.minecraft.world.item.component.WritableBookContent.EMPTY;
    assertSame(writableBookContent, actualHandle);
    assertSame(writableBookContent, paperWritableBookContent.impl());
  }

  /**
   * Test {@link PaperWritableBookContent#pages()}.
   *
   * <ul>
   *   <li>Given {@link PaperWritableBookContent#PaperWritableBookContent(WritableBookContent)} with
   *       impl is {@link net.minecraft.world.item.component.WritableBookContent#EMPTY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PaperWritableBookContent#pages()}
   */
  @Test
  @DisplayName(
      "Test pages(); given PaperWritableBookContent(WritableBookContent) with impl is EMPTY; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaperWritableBookContent.pages()"})
  void testPages_givenPaperWritableBookContentWithImplIsEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new PaperWritableBookContent(net.minecraft.world.item.component.WritableBookContent.EMPTY)
            .pages()
            .isEmpty());
  }
}
