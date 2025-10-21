package org.bukkit.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TabCompleteEventDiffblueTest {
  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List, boolean, Location)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return Completions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List,
   * boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List, boolean, Location); given '42'; then return Completions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TabCompleteEvent.<init>(CommandSender, String, List, boolean, Location)"
  })
  void testNewTabCompleteEvent_given42_thenReturnCompletionsIsArrayList() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("42");
    completions.add("foo");
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    TabCompleteEvent actualTabCompleteEvent =
        new TabCompleteEvent(sender, "Buffer", completions, true, location);

    // Assert
    assertEquals(completions, actualTabCompleteEvent.getCompletions());
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List, boolean, Location)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Completions size is one.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List,
   * boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List, boolean, Location); given 'foo'; then return Completions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TabCompleteEvent.<init>(CommandSender, String, List, boolean, Location)"
  })
  void testNewTabCompleteEvent_givenFoo_thenReturnCompletionsSizeIsOne() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("foo");
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    TabCompleteEvent actualTabCompleteEvent =
        new TabCompleteEvent(sender, "Buffer", completions, true, location);

    // Assert
    CommandSender sender2 = actualTabCompleteEvent.getSender();
    assertTrue(sender2 instanceof BufferedCommandSender);
    assertEquals("Buffer", actualTabCompleteEvent.getBuffer());
    assertEquals("TabCompleteEvent", actualTabCompleteEvent.getEventName());
    assertEquals(1, actualTabCompleteEvent.getCompletions().size());
    assertFalse(actualTabCompleteEvent.isAsynchronous());
    assertFalse(actualTabCompleteEvent.isCancelled());
    assertTrue(actualTabCompleteEvent.isCommand());
    assertEquals(location, actualTabCompleteEvent.getLocation());
    assertSame(sender, sender2);
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabCompleteEvent.<init>(CommandSender, String, List)"})
  void testNewTabCompleteEvent_givenFoo_whenArrayListAddFoo() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("foo");
    completions.add("/");

    // Act
    TabCompleteEvent actualTabCompleteEvent = new TabCompleteEvent(sender, "Buffer", completions);

    // Assert
    assertEquals("Buffer", actualTabCompleteEvent.getBuffer());
    assertFalse(actualTabCompleteEvent.isCommand());
    assertEquals(completions, actualTabCompleteEvent.getCompletions());
    assertSame(sender, actualTabCompleteEvent.getSender());
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then return Completions is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List); given '/'; then return Completions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabCompleteEvent.<init>(CommandSender, String, List)"})
  void testNewTabCompleteEvent_givenSlash_thenReturnCompletionsIsArrayList() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("/");

    // Act
    TabCompleteEvent actualTabCompleteEvent = new TabCompleteEvent(sender, "Buffer", completions);

    // Assert
    assertEquals("Buffer", actualTabCompleteEvent.getBuffer());
    assertFalse(actualTabCompleteEvent.isCommand());
    assertEquals(completions, actualTabCompleteEvent.getCompletions());
    assertSame(sender, actualTabCompleteEvent.getSender());
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}.
   *
   * <ul>
   *   <li>Then return Sender is {@link ConsoleCommandSender}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List); then return Sender is ConsoleCommandSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabCompleteEvent.<init>(CommandSender, String, List)"})
  void testNewTabCompleteEvent_thenReturnSenderIsConsoleCommandSender() {
    // Arrange
    ConsoleCommandSender sender = mock(ConsoleCommandSender.class);

    // Act
    TabCompleteEvent actualTabCompleteEvent = new TabCompleteEvent(sender, "/", new ArrayList<>());

    // Assert
    assertEquals("/", actualTabCompleteEvent.getBuffer());
    assertTrue(actualTabCompleteEvent.getCompletions().isEmpty());
    assertTrue(actualTabCompleteEvent.isCommand());
    assertSame(sender, actualTabCompleteEvent.getSender());
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List, boolean, Location)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Completions Empty.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List,
   * boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List, boolean, Location); when ArrayList(); then return Completions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TabCompleteEvent.<init>(CommandSender, String, List, boolean, Location)"
  })
  void testNewTabCompleteEvent_whenArrayList_thenReturnCompletionsEmpty() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    ArrayList<String> completions = new ArrayList<>();
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    TabCompleteEvent actualTabCompleteEvent =
        new TabCompleteEvent(sender, "Buffer", completions, true, location);

    // Assert
    CommandSender sender2 = actualTabCompleteEvent.getSender();
    assertTrue(sender2 instanceof BufferedCommandSender);
    assertEquals("Buffer", actualTabCompleteEvent.getBuffer());
    assertEquals("TabCompleteEvent", actualTabCompleteEvent.getEventName());
    assertFalse(actualTabCompleteEvent.isAsynchronous());
    assertFalse(actualTabCompleteEvent.isCancelled());
    assertTrue(actualTabCompleteEvent.getCompletions().isEmpty());
    assertTrue(actualTabCompleteEvent.isCommand());
    assertEquals(location, actualTabCompleteEvent.getLocation());
    assertSame(sender, sender2);
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}.
   *
   * <ul>
   *   <li>When {@code Buffer}.
   *   <li>Then return {@code Buffer}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List); when 'Buffer'; then return 'Buffer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabCompleteEvent.<init>(CommandSender, String, List)"})
  void testNewTabCompleteEvent_whenBuffer_thenReturnBuffer() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    TabCompleteEvent actualTabCompleteEvent =
        new TabCompleteEvent(sender, "Buffer", new ArrayList<>());

    // Assert
    assertEquals("Buffer", actualTabCompleteEvent.getBuffer());
    assertFalse(actualTabCompleteEvent.isCommand());
    assertTrue(actualTabCompleteEvent.getCompletions().isEmpty());
    assertSame(sender, actualTabCompleteEvent.getSender());
  }

  /**
   * Test {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return Buffer is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#TabCompleteEvent(CommandSender, String, List)}
   */
  @Test
  @DisplayName(
      "Test new TabCompleteEvent(CommandSender, String, List); when '/'; then return Buffer is '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TabCompleteEvent.<init>(CommandSender, String, List)"})
  void testNewTabCompleteEvent_whenSlash_thenReturnBufferIsSlash() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    TabCompleteEvent actualTabCompleteEvent = new TabCompleteEvent(sender, "/", new ArrayList<>());

    // Assert
    assertEquals("/", actualTabCompleteEvent.getBuffer());
    assertTrue(actualTabCompleteEvent.getCompletions().isEmpty());
    assertTrue(actualTabCompleteEvent.isCommand());
    assertSame(sender, actualTabCompleteEvent.getSender());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TabCompleteEvent#setCancelled(boolean)}
   *   <li>{@link TabCompleteEvent#getHandlerList()}
   *   <li>{@link TabCompleteEvent#getBuffer()}
   *   <li>{@link TabCompleteEvent#getCompletions()}
   *   <li>{@link TabCompleteEvent#getHandlers()}
   *   <li>{@link TabCompleteEvent#getSender()}
   *   <li>{@link TabCompleteEvent#isCancelled()}
   *   <li>{@link TabCompleteEvent#isCommand()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TabCompleteEvent.getBuffer()",
    "List TabCompleteEvent.getCompletions()",
    "HandlerList TabCompleteEvent.getHandlerList()",
    "HandlerList TabCompleteEvent.getHandlers()",
    "CommandSender TabCompleteEvent.getSender()",
    "boolean TabCompleteEvent.isCancelled()",
    "boolean TabCompleteEvent.isCommand()",
    "void TabCompleteEvent.setCancelled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    TabCompleteEvent tabCompleteEvent = new TabCompleteEvent(sender, "Buffer", new ArrayList<>());

    // Act
    tabCompleteEvent.setCancelled(true);
    HandlerList actualHandlerList = tabCompleteEvent.getHandlerList();
    String actualBuffer = tabCompleteEvent.getBuffer();
    List<String> actualCompletions = tabCompleteEvent.getCompletions();
    HandlerList actualHandlers = tabCompleteEvent.getHandlers();
    CommandSender actualSender = tabCompleteEvent.getSender();
    boolean actualIsCancelledResult = tabCompleteEvent.isCancelled();

    // Assert
    assertEquals("Buffer", actualBuffer);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertFalse(tabCompleteEvent.isCommand());
    assertTrue(actualCompletions.isEmpty());
    assertTrue(actualIsCancelledResult);
    assertSame(sender, actualSender);
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link TabCompleteEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location TabCompleteEvent.getLocation()"})
  void testGetLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    ArrayList<String> completions = new ArrayList<>();
    Location location = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    TabCompleteEvent tabCompleteEvent =
        new TabCompleteEvent(sender, "Buffer", completions, true, location);

    // Act and Assert
    assertEquals(location, tabCompleteEvent.getLocation());
  }

  /**
   * Test {@link TabCompleteEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TabCompleteEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location TabCompleteEvent.getLocation()"})
  void testGetLocation_thenReturnNull() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    TabCompleteEvent tabCompleteEvent = new TabCompleteEvent(sender, "Buffer", new ArrayList<>());

    // Act and Assert
    assertNull(tabCompleteEvent.getLocation());
  }
}
