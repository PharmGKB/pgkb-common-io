/*
 ----- BEGIN LICENSE BLOCK -----
 This Source Code Form is subject to the terms of the Mozilla Public License, v.2.0.
 If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ----- END LICENSE BLOCK -----
 */
package org.pharmgkb.common.io.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This is a JUnit test for {@link ZippedFileInputStream}.
 *
 * @author Mark Woon
 */
public class ZippedFileInputStreamTest {


  @Test
  public void testStream() throws Exception {

    String zipFilename = "ZippedFileInputStreamTest.txt.zip";
    String filename = "ZippedFileInputStreamTest.txt";
    try (InputStream in = getClass().getResourceAsStream(zipFilename)) {
      ZippedFileInputStream zfIs = new ZippedFileInputStream(in, filename);
      BufferedReader reader = new BufferedReader(new InputStreamReader(zfIs));
      String line = reader.readLine();
      assertEquals("hello, world", line);
    }
  }
}
