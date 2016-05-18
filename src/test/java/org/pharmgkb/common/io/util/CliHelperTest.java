package org.pharmgkb.common.io.util;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * JUnit test for {@link CliHelper}.
 * 
 * @author Mark Woon
 */
public class CliHelperTest {


  @Test
  public void testHelp() {

    CliHelper ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory", true, "dir");

    assertFalse(ch.parse(new String[]{ "-h" }));
    assertTrue(ch.isHelpRequested());
    assertFalse(ch.hasError());


    // with other args
    ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory", true, "dir");

    assertFalse(ch.parse(new String[]{ "-h", "-d", "/some/path" }));
    assertTrue(ch.isHelpRequested());
    assertFalse(ch.hasError());
  }


  @Test
  public void testNoArgs() {

    CliHelper ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory", true, "dir");

    //noinspection ConstantConditions
    assertFalse(ch.parse(null));
    assertFalse(ch.isHelpRequested());
    assertTrue(ch.hasError());
    assertEquals("Missing required option: d", ch.getError());
  }


  @Test
  public void testUnknownArg() {

    CliHelper ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory", true, "dir");

    assertFalse(ch.parse(new String[] { "-h", "-q" }));
    assertFalse(ch.isHelpRequested());
    assertTrue(ch.hasError());
    assertEquals("Unrecognized option: -q", ch.getError());
  }


  @Test
  public void testGotDir() {

    CliHelper ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory desc", true, "dir");

    assertTrue(ch.parse(new String[]{ "-d", "/some/path" }));
    assertFalse(ch.isHelpRequested());
    assertFalse(ch.hasError());
    assertEquals("/some/path", ch.getValue("d"));
  }


  @Test
  public void testRequiredParam() {

    CliHelper ch = new CliHelper(CliHelperTest.class);
    ch.addOption("d", "directory", "directory", true, "dir");

    assertFalse(ch.parse(new String[] { "-d" }));
    assertFalse(ch.isHelpRequested());
    assertTrue(ch.hasError());
    assertEquals("Missing argument for option: d", ch.getError());
  }
}
