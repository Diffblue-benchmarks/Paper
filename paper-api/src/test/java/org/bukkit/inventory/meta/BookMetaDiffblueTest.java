package org.bukkit.inventory.meta;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.KeybindComponent;
import org.bukkit.inventory.meta.BookMeta.Spigot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BookMetaDiffblueTest {
  /**
   * Test Spigot {@link Spigot#addPage(BaseComponent[][])}.
   *
   * <p>Method under test: {@link Spigot#addPage(BaseComponent[][])}
   */
  @Test
  @DisplayName("Test Spigot addPage(BaseComponent[][])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.addPage(BaseComponent[][])"})
  void testSpigotAddPage() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.addPage(new BaseComponent[] {new KeybindComponent()}));
  }

  /**
   * Test Spigot {@link Spigot#getPage(int)}.
   *
   * <p>Method under test: {@link Spigot#getPage(int)}
   */
  @Test
  @DisplayName("Test Spigot getPage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseComponent[] Spigot.getPage(int)"})
  void testSpigotGetPage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getPage(1));
  }

  /**
   * Test Spigot {@link Spigot#getPages()}.
   *
   * <p>Method under test: {@link Spigot#getPages()}
   */
  @Test
  @DisplayName("Test Spigot getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Spigot.getPages()"})
  void testSpigotGetPages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Spigot().getPages());
  }

  /**
   * Test Spigot {@link Spigot#setPage(int, BaseComponent[])}.
   *
   * <p>Method under test: {@link Spigot#setPage(int, BaseComponent[])}
   */
  @Test
  @DisplayName("Test Spigot setPage(int, BaseComponent[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.setPage(int, BaseComponent[])"})
  void testSpigotSetPage() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> spigot.setPage(1, new KeybindComponent()));
  }

  /**
   * Test Spigot {@link Spigot#setPages(BaseComponent[][])} with {@code BaseComponent[][]}.
   *
   * <p>Method under test: {@link Spigot#setPages(BaseComponent[][])}
   */
  @Test
  @DisplayName("Test Spigot setPages(BaseComponent[][]) with 'BaseComponent[][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.setPages(BaseComponent[][])"})
  void testSpigotSetPagesWithBaseComponent() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> spigot.setPages(new BaseComponent[] {new KeybindComponent()}));
  }

  /**
   * Test Spigot {@link Spigot#setPages(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given array of {@link BaseComponent} with {@link KeybindComponent#KeybindComponent()}.
   * </ul>
   *
   * <p>Method under test: {@link Spigot#setPages(List)}
   */
  @Test
  @DisplayName(
      "Test Spigot setPages(List) with 'List'; given array of BaseComponent with KeybindComponent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.setPages(List)"})
  void testSpigotSetPagesWithList_givenArrayOfBaseComponentWithKeybindComponent() {
    // Arrange
    Spigot spigot = new Spigot();

    ArrayList<BaseComponent[]> pages = new ArrayList<>();
    pages.add(new BaseComponent[] {new KeybindComponent()});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> spigot.setPages(pages));
  }

  /**
   * Test Spigot {@link Spigot#setPages(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given array of {@link BaseComponent} with {@link KeybindComponent#KeybindComponent()}.
   * </ul>
   *
   * <p>Method under test: {@link Spigot#setPages(List)}
   */
  @Test
  @DisplayName(
      "Test Spigot setPages(List) with 'List'; given array of BaseComponent with KeybindComponent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.setPages(List)"})
  void testSpigotSetPagesWithList_givenArrayOfBaseComponentWithKeybindComponent2() {
    // Arrange
    Spigot spigot = new Spigot();

    ArrayList<BaseComponent[]> pages = new ArrayList<>();
    pages.add(new BaseComponent[] {new KeybindComponent()});
    pages.add(new BaseComponent[] {new KeybindComponent()});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> spigot.setPages(pages));
  }

  /**
   * Test Spigot {@link Spigot#setPages(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Spigot#setPages(List)}
   */
  @Test
  @DisplayName("Test Spigot setPages(List) with 'List'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Spigot.setPages(List)"})
  void testSpigotSetPagesWithList_whenArrayList() {
    // Arrange
    Spigot spigot = new Spigot();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> spigot.setPages(new ArrayList<>()));
  }
}
