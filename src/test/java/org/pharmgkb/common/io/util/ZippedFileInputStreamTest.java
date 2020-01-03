package org.pharmgkb.common.io.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This is a JUnit test for {@link ZippedFileInputStream}.
 *
 * @author Mark Woon
 */
class ZippedFileInputStreamTest {


  @Test
  void testStream() throws Exception {

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
