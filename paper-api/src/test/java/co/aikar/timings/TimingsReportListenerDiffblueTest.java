package co.aikar.timings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.format.TextDecoration.State;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TimingsReportListenerDiffblueTest {
  /**
   * Test {@link TimingsReportListener#TimingsReportListener(CommandSender)}.
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(CommandSender)}
   */
  @Test
  @DisplayName("Test new TimingsReportListener(CommandSender)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(CommandSender)"})
  void testNewTimingsReportListener() {
    // Arrange
    BufferedCommandSender senders = new BufferedCommandSender();

    // Act
    TimingsReportListener actualTimingsReportListener = new TimingsReportListener(senders);

    // Assert
    Iterable<? extends Audience> audiencesResult = actualTimingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertNull(actualTimingsReportListener.getTimingsURL());
    assertNull(actualTimingsReportListener.getServer());
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    assertSame(senders, ((List<? extends Audience>) audiencesResult).get(0));
  }

  /**
   * Test {@link TimingsReportListener#TimingsReportListener(CommandSender, Runnable)}.
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(CommandSender,
   * Runnable)}
   */
  @Test
  @DisplayName("Test new TimingsReportListener(CommandSender, Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(CommandSender, Runnable)"})
  void testNewTimingsReportListener2() {
    // Arrange
    BufferedCommandSender sender = new BufferedCommandSender();

    // Act
    TimingsReportListener actualTimingsReportListener =
        new TimingsReportListener(sender, mock(Runnable.class));

    // Assert
    Iterable<? extends Audience> audiencesResult = actualTimingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertNull(actualTimingsReportListener.getTimingsURL());
    assertNull(actualTimingsReportListener.getServer());
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    assertSame(sender, ((List<? extends Audience>) audiencesResult).get(0));
  }

  /**
   * Test {@link TimingsReportListener#TimingsReportListener(List)}.
   *
   * <ul>
   *   <li>Given {@link BufferedCommandSender} (default constructor).
   *   <li>Then audiences return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(List)}
   */
  @Test
  @DisplayName(
      "Test new TimingsReportListener(List); given BufferedCommandSender (default constructor); then audiences return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(List)"})
  void testNewTimingsReportListener_givenBufferedCommandSender_thenAudiencesReturnList() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    senders.add(bufferedCommandSender);

    // Act and Assert
    Iterable<? extends Audience> audiencesResult = new TimingsReportListener(senders).audiences();
    assertTrue(audiencesResult instanceof List);
    assertEquals(2, ((List<? extends Audience>) audiencesResult).size());
    assertSame(bufferedCommandSender, ((List<? extends Audience>) audiencesResult).get(1));
  }

  /**
   * Test {@link TimingsReportListener#TimingsReportListener(List, Runnable)}.
   *
   * <ul>
   *   <li>Given {@link BufferedCommandSender} (default constructor).
   *   <li>Then audiences return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(List, Runnable)}
   */
  @Test
  @DisplayName(
      "Test new TimingsReportListener(List, Runnable); given BufferedCommandSender (default constructor); then audiences return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(List, Runnable)"})
  void testNewTimingsReportListener_givenBufferedCommandSender_thenAudiencesReturnList2() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    senders.add(bufferedCommandSender);

    // Act
    TimingsReportListener actualTimingsReportListener =
        new TimingsReportListener(senders, mock(Runnable.class));

    // Assert
    Iterable<? extends Audience> audiencesResult = actualTimingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertEquals(2, ((List<? extends Audience>) audiencesResult).size());
    assertSame(bufferedCommandSender, ((List<? extends Audience>) audiencesResult).get(1));
  }

  /**
   * Test {@link TimingsReportListener#TimingsReportListener(List)}.
   *
   * <ul>
   *   <li>Then return TimingsURL is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(List)}
   */
  @Test
  @DisplayName("Test new TimingsReportListener(List); then return TimingsURL is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(List)"})
  void testNewTimingsReportListener_thenReturnTimingsURLIsNull() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());

    // Act
    TimingsReportListener actualTimingsReportListener = new TimingsReportListener(senders);

    // Assert
    assertNull(actualTimingsReportListener.getTimingsURL());
    assertNull(actualTimingsReportListener.getServer());
    assertEquals(senders, actualTimingsReportListener.audiences());
  }

  /**
   * Test {@link TimingsReportListener#TimingsReportListener(List, Runnable)}.
   *
   * <ul>
   *   <li>Then return TimingsURL is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#TimingsReportListener(List, Runnable)}
   */
  @Test
  @DisplayName("Test new TimingsReportListener(List, Runnable); then return TimingsURL is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.<init>(List, Runnable)"})
  void testNewTimingsReportListener_thenReturnTimingsURLIsNull2() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());

    // Act
    TimingsReportListener actualTimingsReportListener =
        new TimingsReportListener(senders, mock(Runnable.class));

    // Assert
    assertNull(actualTimingsReportListener.getTimingsURL());
    assertNull(actualTimingsReportListener.getServer());
    assertEquals(senders, actualTimingsReportListener.audiences());
  }

  /**
   * Test {@link TimingsReportListener#done()}.
   *
   * <p>Method under test: {@link TimingsReportListener#done()}
   */
  @Test
  @DisplayName("Test done()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.done()"})
  void testDone() {
    // Arrange
    Runnable onDone = mock(Runnable.class);
    doNothing().when(onDone).run();
    TimingsReportListener sender = new TimingsReportListener(new BufferedCommandSender(), onDone);

    Runnable onDone2 = mock(Runnable.class);
    doNothing().when(onDone2).run();

    TimingsReportListener timingsReportListener = new TimingsReportListener(sender, onDone2);

    // Act
    timingsReportListener.done();

    // Assert
    verify(onDone).run();
    verify(onDone2).run();
  }

  /**
   * Test {@link TimingsReportListener#done(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#done(String)}
   */
  @Test
  @DisplayName("Test done(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.done(String)"})
  void testDoneWithString() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    TimingsReportListener timingsReportListener = new TimingsReportListener(senders);

    // Act
    timingsReportListener.done("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", timingsReportListener.getTimingsURL());
  }

  /**
   * Test {@link TimingsReportListener#done(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#done(String)}
   */
  @Test
  @DisplayName("Test done(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.done(String)"})
  void testDoneWithString2() {
    // Arrange
    Runnable onDone = mock(Runnable.class);
    doNothing().when(onDone).run();
    TimingsReportListener timingsReportListener =
        new TimingsReportListener(new BufferedCommandSender(), onDone);

    // Act
    timingsReportListener.done("https://example.org/example");

    // Assert
    verify(onDone).run();
    assertEquals("https://example.org/example", timingsReportListener.getTimingsURL());
  }

  /**
   * Test {@link TimingsReportListener#done(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#done(String)}
   */
  @Test
  @DisplayName("Test done(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.done(String)"})
  void testDoneWithString3() {
    // Arrange
    Runnable onDone = mock(Runnable.class);
    doNothing().when(onDone).run();
    TimingsReportListener sender = new TimingsReportListener(new BufferedCommandSender(), onDone);

    Runnable onDone2 = mock(Runnable.class);
    doNothing().when(onDone2).run();

    TimingsReportListener timingsReportListener = new TimingsReportListener(sender, onDone2);

    // Act
    timingsReportListener.done("https://example.org/example");

    // Assert
    verify(onDone).run();
    verify(onDone2).run();
    assertEquals("https://example.org/example", timingsReportListener.getTimingsURL());
  }

  /**
   * Test {@link TimingsReportListener#done()}.
   *
   * <ul>
   *   <li>Given {@link Runnable} {@link Runnable#run()} does nothing.
   *   <li>Then calls {@link Runnable#run()}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#done()}
   */
  @Test
  @DisplayName("Test done(); given Runnable run() does nothing; then calls run()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.done()"})
  void testDone_givenRunnableRunDoesNothing_thenCallsRun() {
    // Arrange
    Runnable onDone = mock(Runnable.class);
    doNothing().when(onDone).run();
    TimingsReportListener timingsReportListener =
        new TimingsReportListener(new BufferedCommandSender(), onDone);

    // Act
    timingsReportListener.done();

    // Assert
    verify(onDone).run();
  }

  /**
   * Test {@link TimingsReportListener#sendMessage(Identity, Component, MessageType)} with {@code
   * Identity}, {@code Component}, {@code MessageType}.
   *
   * <p>Method under test: {@link TimingsReportListener#sendMessage(Identity, Component,
   * MessageType)}
   */
  @Test
  @DisplayName(
      "Test sendMessage(Identity, Component, MessageType) with 'Identity', 'Component', 'MessageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.sendMessage(Identity, Component, MessageType)"})
  void testSendMessageWithIdentityComponentMessageType() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    TimingsReportListener timingsReportListener = new TimingsReportListener(senders);
    Identity source = mock(Identity.class);

    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component message = mock(Component.class);
    when(message.children()).thenReturn(new ArrayList<>());
    when(message.style()).thenReturn(style);

    // Act
    timingsReportListener.sendMessage(source, message, MessageType.CHAT);

    // Assert
    verify(message).children();
    verify(message).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    Iterable<? extends Audience> audiencesResult = timingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    Audience getResult = ((List<? extends Audience>) audiencesResult).get(0);
    assertTrue(getResult instanceof BufferedCommandSender);
    assertEquals("\n", ((BufferedCommandSender) getResult).getBuffer());
  }

  /**
   * Test {@link TimingsReportListener#sendMessage(Identity, Component, MessageType)} with {@code
   * Identity}, {@code Component}, {@code MessageType}.
   *
   * <p>Method under test: {@link TimingsReportListener#sendMessage(Identity, Component,
   * MessageType)}
   */
  @Test
  @DisplayName(
      "Test sendMessage(Identity, Component, MessageType) with 'Identity', 'Component', 'MessageType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.sendMessage(Identity, Component, MessageType)"})
  void testSendMessageWithIdentityComponentMessageType2() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    TimingsReportListener timingsReportListener =
        new TimingsReportListener(new BufferedCommandSender(), mock(Runnable.class));
    senders.add(timingsReportListener);
    TimingsReportListener timingsReportListener2 = new TimingsReportListener(senders);
    Identity source = mock(Identity.class);

    Style style = mock(Style.class);
    when(style.color()).thenReturn(mock(TextColor.class));
    when(style.decoration(Mockito.<TextDecoration>any())).thenReturn(State.NOT_SET);

    Component message = mock(Component.class);
    when(message.children()).thenReturn(new ArrayList<>());
    when(message.style()).thenReturn(style);

    // Act
    timingsReportListener2.sendMessage(source, message, MessageType.CHAT);

    // Assert
    verify(message).children();
    verify(message).style();
    verify(style).color();
    verify(style, atLeast(1)).decoration(Mockito.<TextDecoration>any());
    Iterable<? extends Audience> audiencesResult = timingsReportListener2.audiences();
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    Audience getResult = ((List<? extends Audience>) audiencesResult).get(0);
    assertTrue(getResult instanceof TimingsReportListener);
    assertTrue(audiencesResult instanceof List);
    Iterable<? extends Audience> audiencesResult2 = ((TimingsReportListener) getResult).audiences();
    assertTrue(audiencesResult2 instanceof List);
    assertEquals(1, ((List<? extends Audience>) audiencesResult2).size());
    Audience getResult2 = ((List<? extends Audience>) audiencesResult2).get(0);
    assertTrue(getResult2 instanceof BufferedCommandSender);
    assertEquals("\n", ((BufferedCommandSender) getResult2).getBuffer());
  }

  /**
   * Test {@link TimingsReportListener#sendMessage(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#sendMessage(String)}
   */
  @Test
  @DisplayName("Test sendMessage(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.sendMessage(String)"})
  void testSendMessageWithString() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    TimingsReportListener timingsReportListener = new TimingsReportListener(senders);

    // Act
    timingsReportListener.sendMessage("Not all who wander are lost");

    // Assert
    Iterable<? extends Audience> audiencesResult = timingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    Audience getResult = ((List<? extends Audience>) audiencesResult).get(0);
    assertTrue(getResult instanceof BufferedCommandSender);
    assertEquals("Not all who wander are lost\n", ((BufferedCommandSender) getResult).getBuffer());
  }

  /**
   * Test {@link TimingsReportListener#sendMessage(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#sendMessage(String)}
   */
  @Test
  @DisplayName("Test sendMessage(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.sendMessage(String)"})
  void testSendMessageWithString2() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    senders.add(new BufferedCommandSender());
    senders.add(new BufferedCommandSender());
    TimingsReportListener timingsReportListener = new TimingsReportListener(senders);

    // Act
    timingsReportListener.sendMessage("Not all who wander are lost");

    // Assert
    Iterable<? extends Audience> audiencesResult = timingsReportListener.audiences();
    assertTrue(audiencesResult instanceof List);
    assertEquals(2, ((List<? extends Audience>) audiencesResult).size());
    Audience getResult = ((List<? extends Audience>) audiencesResult).get(0);
    assertTrue(getResult instanceof BufferedCommandSender);
    Audience getResult2 = ((List<? extends Audience>) audiencesResult).get(1);
    assertTrue(getResult2 instanceof BufferedCommandSender);
    assertEquals("Not all who wander are lost\n", ((BufferedCommandSender) getResult).getBuffer());
    assertEquals("Not all who wander are lost\n", ((BufferedCommandSender) getResult2).getBuffer());
  }

  /**
   * Test {@link TimingsReportListener#sendMessage(String)} with {@code String}.
   *
   * <p>Method under test: {@link TimingsReportListener#sendMessage(String)}
   */
  @Test
  @DisplayName("Test sendMessage(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimingsReportListener.sendMessage(String)"})
  void testSendMessageWithString3() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    TimingsReportListener timingsReportListener =
        new TimingsReportListener(new BufferedCommandSender(), mock(Runnable.class));
    senders.add(timingsReportListener);
    TimingsReportListener timingsReportListener2 = new TimingsReportListener(senders);

    // Act
    timingsReportListener2.sendMessage("Not all who wander are lost");

    // Assert
    Iterable<? extends Audience> audiencesResult = timingsReportListener2.audiences();
    assertEquals(1, ((List<? extends Audience>) audiencesResult).size());
    Audience getResult = ((List<? extends Audience>) audiencesResult).get(0);
    assertTrue(getResult instanceof TimingsReportListener);
    assertTrue(audiencesResult instanceof List);
    Iterable<? extends Audience> audiencesResult2 = ((TimingsReportListener) getResult).audiences();
    assertTrue(audiencesResult2 instanceof List);
    assertEquals(1, ((List<? extends Audience>) audiencesResult2).size());
    Audience getResult2 = ((List<? extends Audience>) audiencesResult2).get(0);
    assertTrue(getResult2 instanceof BufferedCommandSender);
    assertEquals("Not all who wander are lost\n", ((BufferedCommandSender) getResult2).getBuffer());
  }

  /**
   * Test {@link TimingsReportListener#audiences()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BufferedCommandSender} (default
   *       constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TimingsReportListener#audiences()}
   */
  @Test
  @DisplayName(
      "Test audiences(); given ArrayList() add BufferedCommandSender (default constructor); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TimingsReportListener.audiences()"})
  void testAudiences_givenArrayListAddBufferedCommandSender_thenReturnArrayList() {
    // Arrange
    ArrayList<CommandSender> senders = new ArrayList<>();
    BufferedCommandSender bufferedCommandSender = new BufferedCommandSender();
    senders.add(bufferedCommandSender);

    // Act
    Iterable<? extends Audience> actualAudiencesResult =
        new TimingsReportListener(senders).audiences();

    // Assert
    assertEquals(senders, actualAudiencesResult);
    Iterator<? extends Audience> actualIteratorResult = actualAudiencesResult.iterator();
    Audience actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertSame(bufferedCommandSender, actualNextResult);
  }
}
