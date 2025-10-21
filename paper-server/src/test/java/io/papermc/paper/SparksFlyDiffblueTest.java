package io.papermc.paper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.papermc.paper.SparksFly.CommandImpl;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SparksFlyDiffblueTest {
  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Permission is {@code foo;;}.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); given 'foo'; then return Permission is 'foo;;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_givenFoo_thenReturnPermissionIsFoo() {
    // Arrange
    ArrayList<String> permissions = new ArrayList<>();
    permissions.add("foo");
    permissions.add(";");

    // Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", permissions);

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertEquals("foo;;", actualCommandImpl.getPermission());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>Given {@code ;}.
   *   <li>Then return Permission is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); given ';'; then return Permission is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_givenSemicolon_thenReturnPermissionIsSemicolon() {
    // Arrange
    ArrayList<String> permissions = new ArrayList<>();
    permissions.add(";");

    // Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", permissions);

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals(";", actualCommandImpl.getPermission());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test CommandImpl {@link CommandImpl#CommandImpl(String, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Permission is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CommandImpl#CommandImpl(String, Collection)}
   */
  @Test
  @DisplayName(
      "Test CommandImpl new CommandImpl(String, Collection); when ArrayList(); then return Permission is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CommandImpl.<init>(String, Collection)"})
  void testCommandImplNewCommandImpl_whenArrayList_thenReturnPermissionIsEmptyString() {
    // Arrange and Act
    CommandImpl actualCommandImpl = new CommandImpl("Name", new ArrayList<>());

    // Assert
    assertEquals("", actualCommandImpl.getDescription());
    assertEquals("", actualCommandImpl.getPermission());
    assertEquals("/Name", actualCommandImpl.getUsage());
    assertEquals("Name", actualCommandImpl.getLabel());
    assertEquals("Name", actualCommandImpl.getName());
    assertEquals("Name", actualCommandImpl.getTimingName());
    assertNull(actualCommandImpl.timings);
    assertNull(actualCommandImpl.getPermissionMessage());
    assertNull(actualCommandImpl.permissionMessage());
    assertFalse(actualCommandImpl.isRegistered());
    assertTrue(actualCommandImpl.getAliases().isEmpty());
  }

  /**
   * Test {@link SparksFly#isPluginPreferred()}.
   *
   * <p>Method under test: {@link SparksFly#isPluginPreferred()}
   */
  @Test
  @DisplayName("Test isPluginPreferred()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparksFly.isPluginPreferred()"})
  void testIsPluginPreferred() {
    // Arrange, Act and Assert
    assertFalse(SparksFly.isPluginPreferred());
  }
}
