package com.destroystokyo.paper.event.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent.Completion;
import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent.CompletionImpl;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.kyori.adventure.text.Component;
import net.kyori.examination.ExaminableProperty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AsyncTabCompleteEventDiffblueTest {
  /**
   * Test Completion {@link Completion#completion(String)} with {@code suggestion}.
   *
   * <p>Method under test: {@link Completion#completion(String)}
   */
  @Test
  @DisplayName("Test Completion completion(String) with 'suggestion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Completion Completion.completion(String)"})
  void testCompletionCompletionWithSuggestion() {
    // Arrange and Act
    Completion actualCompletionResult = Completion.completion("Suggestion");

    // Assert
    assertTrue(actualCompletionResult instanceof CompletionImpl);
    assertEquals("Suggestion", actualCompletionResult.suggestion());
    assertNull(actualCompletionResult.tooltip());
  }

  /**
   * Test Completion {@link Completion#completion(String, Component)} with {@code suggestion},
   * {@code tooltip}.
   *
   * <p>Method under test: {@link Completion#completion(String, Component)}
   */
  @Test
  @DisplayName("Test Completion completion(String, Component) with 'suggestion', 'tooltip'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Completion Completion.completion(String, Component)"})
  void testCompletionCompletionWithSuggestionTooltip() {
    // Arrange
    Component tooltip = mock(Component.class);

    // Act
    Completion actualCompletionResult = Completion.completion("Suggestion", tooltip);

    // Assert
    assertTrue(actualCompletionResult instanceof CompletionImpl);
    assertEquals("Suggestion", actualCompletionResult.suggestion());
    assertSame(tooltip, actualCompletionResult.tooltip());
  }

  /**
   * Test Completion {@link Completion#examinableProperties()}.
   *
   * <p>Method under test: {@link Completion#examinableProperties()}
   */
  @Test
  @DisplayName("Test Completion examinableProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream Completion.examinableProperties()"})
  void testCompletionExaminableProperties() {
    // Arrange
    CompletionImpl completionImpl = new CompletionImpl("Suggestion", mock(Component.class));

    // Act
    Stream<? extends ExaminableProperty> actualExaminablePropertiesResult =
        completionImpl.examinableProperties();

    // Assert
    assertEquals(2, actualExaminablePropertiesResult.limit(5).collect(Collectors.toList()).size());
  }

  /**
   * Test CompletionImpl {@link CompletionImpl#equals(Object)}, and {@link
   * CompletionImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompletionImpl#equals(Object)}
   *   <li>{@link CompletionImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test CompletionImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompletionImpl.equals(Object)", "int CompletionImpl.hashCode()"})
  void testCompletionImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompletionImpl completionImpl = new CompletionImpl("Suggestion", mock(Component.class));

    // Act and Assert
    assertEquals(completionImpl, completionImpl);
    int expectedHashCodeResult = completionImpl.hashCode();
    assertEquals(expectedHashCodeResult, completionImpl.hashCode());
  }

  /**
   * Test CompletionImpl {@link CompletionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompletionImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CompletionImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompletionImpl.equals(Object)", "int CompletionImpl.hashCode()"})
  void testCompletionImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompletionImpl completionImpl = new CompletionImpl("Suggestion", mock(Component.class));

    // Act and Assert
    assertNotEquals(completionImpl, new CompletionImpl("Suggestion", mock(Component.class)));
  }

  /**
   * Test CompletionImpl {@link CompletionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompletionImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CompletionImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompletionImpl.equals(Object)", "int CompletionImpl.hashCode()"})
  void testCompletionImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompletionImpl completionImpl =
        new CompletionImpl(
            "com.destroystokyo.paper.event.server.AsyncTabCompleteEvent$CompletionImpl",
            mock(Component.class));

    // Act and Assert
    assertNotEquals(completionImpl, new CompletionImpl("Suggestion", mock(Component.class)));
  }

  /**
   * Test CompletionImpl {@link CompletionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompletionImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CompletionImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompletionImpl.equals(Object)", "int CompletionImpl.hashCode()"})
  void testCompletionImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompletionImpl("Suggestion", mock(Component.class)), null);
  }

  /**
   * Test CompletionImpl {@link CompletionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompletionImpl#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test CompletionImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompletionImpl.equals(Object)", "int CompletionImpl.hashCode()"})
  void testCompletionImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompletionImpl("Suggestion", mock(Component.class)),
        "Different type to CompletionImpl");
  }

  /**
   * Test CompletionImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompletionImpl#CompletionImpl(String, Component)}
   *   <li>{@link CompletionImpl#toString()}
   *   <li>{@link CompletionImpl#suggestion()}
   *   <li>{@link CompletionImpl#tooltip()}
   * </ul>
   */
  @Test
  @DisplayName("Test CompletionImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompletionImpl.<init>(String, Component)",
    "String CompletionImpl.suggestion()",
    "String CompletionImpl.toString()",
    "Component CompletionImpl.tooltip()"
  })
  void testCompletionImplGettersAndSetters() {
    // Arrange
    Component tooltip = mock(Component.class);

    // Act
    CompletionImpl actualCompletionImpl = new CompletionImpl("Suggestion", tooltip);
    String actualToStringResult = actualCompletionImpl.toString();
    String actualSuggestionResult = actualCompletionImpl.suggestion();

    // Assert
    assertEquals("CompletionImpl{suggestion=\"Suggestion\", tooltip=null{}}", actualToStringResult);
    assertEquals("Suggestion", actualSuggestionResult);
    assertSame(tooltip, actualCompletionImpl.tooltip());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, String, boolean,
   * Location)}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, String,
   * boolean, Location)}
   */
  @Test
  @DisplayName("Test new AsyncTabCompleteEvent(CommandSender, String, boolean, Location)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.<init>(CommandSender, String, boolean, Location)"})
  void testNewAsyncTabCompleteEvent() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    AsyncTabCompleteEvent actualAsyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Assert
    CommandSender sender2 = actualAsyncTabCompleteEvent.getSender();
    assertTrue(sender2 instanceof BufferedCommandSender);
    assertEquals("AsyncTabCompleteEvent", actualAsyncTabCompleteEvent.getEventName());
    assertEquals("Buffer", actualAsyncTabCompleteEvent.getBuffer());
    assertFalse(actualAsyncTabCompleteEvent.isCancelled());
    assertFalse(actualAsyncTabCompleteEvent.isHandled());
    assertTrue(actualAsyncTabCompleteEvent.isCommand());
    assertTrue(actualAsyncTabCompleteEvent.completions().isEmpty());
    assertTrue(actualAsyncTabCompleteEvent.getCompletions().isEmpty());
    assertTrue(actualAsyncTabCompleteEvent.isAsynchronous());
    assertEquals(loc, actualAsyncTabCompleteEvent.getLocation());
    assertSame(sender, sender2);
  }

  /**
   * Test {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List, String, boolean,
   * Location)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return completions size is two.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List,
   * String, boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new AsyncTabCompleteEvent(CommandSender, List, String, boolean, Location); given '42'; then return completions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncTabCompleteEvent.<init>(CommandSender, List, String, boolean, Location)"
  })
  void testNewAsyncTabCompleteEvent_given42_thenReturnCompletionsSizeIsTwo() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("42");
    completions.add("foo");
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    AsyncTabCompleteEvent actualAsyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, completions, "Buffer", true, loc);

    // Assert
    List<Completion> completionsResult = actualAsyncTabCompleteEvent.completions();
    assertEquals(2, completionsResult.size());
    Completion getResult = completionsResult.get(0);
    assertTrue(getResult instanceof CompletionImpl);
    Completion getResult2 = completionsResult.get(1);
    assertTrue(getResult2 instanceof CompletionImpl);
    assertEquals("42", getResult.suggestion());
    List<String> completions2 = actualAsyncTabCompleteEvent.getCompletions();
    assertEquals(2, completions2.size());
    assertEquals("42", completions2.get(0));
    assertEquals("foo", getResult2.suggestion());
    assertEquals("foo", completions2.get(1));
    assertNull(getResult2.tooltip());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List, String, boolean,
   * Location)}.
   *
   * <ul>
   *   <li>Given {@code Completions}.
   *   <li>Then return completions size is one.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List,
   * String, boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new AsyncTabCompleteEvent(CommandSender, List, String, boolean, Location); given 'Completions'; then return completions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncTabCompleteEvent.<init>(CommandSender, List, String, boolean, Location)"
  })
  void testNewAsyncTabCompleteEvent_givenCompletions_thenReturnCompletionsSizeIsOne() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    ArrayList<String> completions = new ArrayList<>();
    completions.add("Completions");
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    AsyncTabCompleteEvent actualAsyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, completions, "Buffer", true, loc);

    // Assert
    List<Completion> completionsResult = actualAsyncTabCompleteEvent.completions();
    assertEquals(1, completionsResult.size());
    Completion getResult = completionsResult.get(0);
    assertTrue(getResult instanceof CompletionImpl);
    assertEquals("Completions", getResult.suggestion());
    List<String> completions2 = actualAsyncTabCompleteEvent.getCompletions();
    assertEquals(1, completions2.size());
    assertEquals("Completions", completions2.get(0));
  }

  /**
   * Test {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List, String, boolean,
   * Location)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Handled.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#AsyncTabCompleteEvent(CommandSender, List,
   * String, boolean, Location)}
   */
  @Test
  @DisplayName(
      "Test new AsyncTabCompleteEvent(CommandSender, List, String, boolean, Location); when ArrayList(); then return not Handled")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncTabCompleteEvent.<init>(CommandSender, List, String, boolean, Location)"
  })
  void testNewAsyncTabCompleteEvent_whenArrayList_thenReturnNotHandled() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    ArrayList<String> completions = new ArrayList<>();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    // Act
    AsyncTabCompleteEvent actualAsyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, completions, "Buffer", true, loc);

    // Assert
    assertFalse(actualAsyncTabCompleteEvent.isHandled());
    assertTrue(actualAsyncTabCompleteEvent.completions().isEmpty());
    assertTrue(actualAsyncTabCompleteEvent.getCompletions().isEmpty());
    assertTrue(
        actualAsyncTabCompleteEvent
            .getLocation()
            .toHighestLocation()
            .getDirection()
            .toBlockVector()
            .toBlockVector()
            .toBlockVector()
            .toVector3f()
            .isFinite());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#setCompletions(List)}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#setCompletions(List)}
   */
  @Test
  @DisplayName("Test setCompletions(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.setCompletions(List)"})
  void testSetCompletions() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Act
    asyncTabCompleteEvent.setCompletions(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(asyncTabCompleteEvent.isHandled());
    assertTrue(asyncTabCompleteEvent.completions().isEmpty());
    assertTrue(asyncTabCompleteEvent.getCompletions().isEmpty());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#setCompletions(List)}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#setCompletions(List)}
   */
  @Test
  @DisplayName("Test setCompletions(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.setCompletions(List)"})
  void testSetCompletions2() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    ArrayList<String> completions = new ArrayList<>();
    completions.add("Completions");

    // Act
    asyncTabCompleteEvent.setCompletions(completions);

    // Assert
    List<Completion> completionsResult = asyncTabCompleteEvent.completions();
    assertEquals(1, completionsResult.size());
    Completion getResult = completionsResult.get(0);
    assertTrue(getResult instanceof CompletionImpl);
    assertEquals("Completions", getResult.suggestion());
    assertNull(getResult.tooltip());
    assertTrue(asyncTabCompleteEvent.isHandled());
    assertEquals(completions, asyncTabCompleteEvent.getCompletions());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#completions(List)} with {@code List}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#completions(List)}
   */
  @Test
  @DisplayName("Test completions(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.completions(List)"})
  void testCompletionsWithList() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Act
    asyncTabCompleteEvent.completions(new ArrayList<>());

    // Assert that nothing has changed
    assertFalse(asyncTabCompleteEvent.isHandled());
    assertTrue(asyncTabCompleteEvent.completions().isEmpty());
    assertTrue(asyncTabCompleteEvent.getCompletions().isEmpty());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#completions(List)} with {@code List}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#completions(List)}
   */
  @Test
  @DisplayName("Test completions(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.completions(List)"})
  void testCompletionsWithList2() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    ArrayList<Completion> newCompletions = new ArrayList<>();
    CompletionImpl completionImpl =
        new CompletionImpl("new completions cannot be null", mock(Component.class));
    newCompletions.add(completionImpl);

    // Act
    asyncTabCompleteEvent.completions(newCompletions);

    // Assert
    List<String> completions = asyncTabCompleteEvent.getCompletions();
    assertEquals(1, completions.size());
    assertEquals("new completions cannot be null", completions.get(0));
    List<Completion> completionsResult = asyncTabCompleteEvent.completions();
    assertEquals(1, completionsResult.size());
    assertTrue(asyncTabCompleteEvent.isHandled());
    assertSame(completionImpl, completionsResult.get(0));
  }

  /**
   * Test {@link AsyncTabCompleteEvent#completions(List)} with {@code List}.
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#completions(List)}
   */
  @Test
  @DisplayName("Test completions(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AsyncTabCompleteEvent.completions(List)"})
  void testCompletionsWithList3() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    ArrayList<Completion> newCompletions = new ArrayList<>();
    CompletionImpl completionImpl =
        new CompletionImpl("new completions cannot be null", mock(Component.class));
    newCompletions.add(completionImpl);
    CompletionImpl completionImpl2 =
        new CompletionImpl("new completions cannot be null", mock(Component.class));
    newCompletions.add(completionImpl2);

    // Act
    asyncTabCompleteEvent.completions(newCompletions);

    // Assert
    List<String> completions = asyncTabCompleteEvent.getCompletions();
    assertEquals(2, completions.size());
    assertEquals("new completions cannot be null", completions.get(1));
    List<Completion> completionsResult = asyncTabCompleteEvent.completions();
    assertEquals(2, completionsResult.size());
    assertSame(completionImpl2, completionsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AsyncTabCompleteEvent#setCancelled(boolean)}
   *   <li>{@link AsyncTabCompleteEvent#setHandled(boolean)}
   *   <li>{@link AsyncTabCompleteEvent#getHandlerList()}
   *   <li>{@link AsyncTabCompleteEvent#completions()}
   *   <li>{@link AsyncTabCompleteEvent#getBuffer()}
   *   <li>{@link AsyncTabCompleteEvent#getCompletions()}
   *   <li>{@link AsyncTabCompleteEvent#getHandlers()}
   *   <li>{@link AsyncTabCompleteEvent#getSender()}
   *   <li>{@link AsyncTabCompleteEvent#isCancelled()}
   *   <li>{@link AsyncTabCompleteEvent#isCommand()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AsyncTabCompleteEvent.completions()",
    "String AsyncTabCompleteEvent.getBuffer()",
    "List AsyncTabCompleteEvent.getCompletions()",
    "HandlerList AsyncTabCompleteEvent.getHandlerList()",
    "HandlerList AsyncTabCompleteEvent.getHandlers()",
    "CommandSender AsyncTabCompleteEvent.getSender()",
    "boolean AsyncTabCompleteEvent.isCancelled()",
    "boolean AsyncTabCompleteEvent.isCommand()",
    "void AsyncTabCompleteEvent.setCancelled(boolean)",
    "void AsyncTabCompleteEvent.setHandled(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Act
    asyncTabCompleteEvent.setCancelled(true);
    asyncTabCompleteEvent.setHandled(true);
    HandlerList actualHandlerList = asyncTabCompleteEvent.getHandlerList();
    List<Completion> actualCompletionsResult = asyncTabCompleteEvent.completions();
    String actualBuffer = asyncTabCompleteEvent.getBuffer();
    List<String> actualCompletions = asyncTabCompleteEvent.getCompletions();
    HandlerList actualHandlers = asyncTabCompleteEvent.getHandlers();
    CommandSender actualSender = asyncTabCompleteEvent.getSender();
    boolean actualIsCancelledResult = asyncTabCompleteEvent.isCancelled();

    // Assert
    assertEquals("Buffer", actualBuffer);
    assertEquals(0, actualHandlerList.getRegisteredListeners().length);
    assertTrue(actualIsCancelledResult);
    assertTrue(asyncTabCompleteEvent.isCommand());
    assertTrue(actualCompletionsResult.isEmpty());
    assertTrue(actualCompletions.isEmpty());
    assertSame(sender, actualSender);
    assertSame(actualHandlerList, actualHandlers);
  }

  /**
   * Test {@link AsyncTabCompleteEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@link Location#Location(World, double, double, double)} with {@link World}
   *       and x is two and y is three and z is ten.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#getLocation()}
   */
  @Test
  @DisplayName(
      "Test getLocation(); then return Location(World, double, double, double) with World and x is two and y is three and z is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location AsyncTabCompleteEvent.getLocation()"})
  void testGetLocation_thenReturnLocationWithWorldAndXIsTwoAndYIsThreeAndZIsTen() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Act and Assert
    assertEquals(loc, asyncTabCompleteEvent.getLocation());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#getLocation()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#getLocation()}
   */
  @Test
  @DisplayName("Test getLocation(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Location AsyncTabCompleteEvent.getLocation()"})
  void testGetLocation_thenReturnNull() {
    // Arrange
    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(new BufferedCommandSender(), "Buffer", true, null);

    // Act and Assert
    assertNull(asyncTabCompleteEvent.getLocation());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#isHandled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#isHandled()}
   */
  @Test
  @DisplayName("Test isHandled(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AsyncTabCompleteEvent.isHandled()"})
  void testIsHandled_thenReturnFalse() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);

    // Act and Assert
    assertFalse(asyncTabCompleteEvent.isHandled());
  }

  /**
   * Test {@link AsyncTabCompleteEvent#isHandled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncTabCompleteEvent#isHandled()}
   */
  @Test
  @DisplayName("Test isHandled(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AsyncTabCompleteEvent.isHandled()"})
  void testIsHandled_thenReturnTrue() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();
    Location loc = new Location(mock(World.class), 2.0d, 3.0d, 10.0d);

    AsyncTabCompleteEvent asyncTabCompleteEvent =
        new AsyncTabCompleteEvent(sender, "Buffer", true, loc);
    asyncTabCompleteEvent.setHandled(true);

    // Act and Assert
    assertTrue(asyncTabCompleteEvent.isHandled());
  }
}
