/*
 ----- BEGIN LICENSE BLOCK -----
 This Source Code Form is subject to the terms of the Mozilla Public License, v.2.0.
 If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ----- END LICENSE BLOCK -----
 */
package org.pharmgkb.common.io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/**
 * Simple InputStream for reading a zipped file (i.e. zip file only contains itself, like a gzipped file).
 *
 * @author Mark Woon
 */
public class ZippedFileInputStream extends InputStream {
  private ZipInputStream m_zipInputStream;


  public ZippedFileInputStream(File zipFile) throws IOException {

    m_zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
    String baseFilename = zipFile.getName().substring(0, zipFile.getName().length() - 4);
    boolean foundFile = false;
    ZipEntry entry;
    while((entry = m_zipInputStream.getNextEntry()) != null) {
      String fileName = entry.getName();
      int idx = fileName.lastIndexOf("/");
      if (idx != -1) {
        fileName = fileName.substring(idx + 1);
      }
      System.out.println(fileName);
      if (fileName.equals(baseFilename)) {
        foundFile = true;
        break;
      }
    }
    if (!foundFile) {
      throw new FileNotFoundException("Cannot find " + baseFilename + " in zipped file");
    }
  }


  public ZippedFileInputStream(InputStream in, String filename) throws IOException {

    if (in instanceof ZipInputStream) {
      m_zipInputStream = (ZipInputStream)in;
    } else {
      m_zipInputStream = new ZipInputStream(in);
    }
    boolean foundFile = false;
    ZipEntry entry;
    while((entry = m_zipInputStream.getNextEntry()) != null) {
      if (entry.getName().equals(filename)) {
        foundFile = true;
        break;
      }
    }
    if (!foundFile) {
      throw new FileNotFoundException("Cannot find " + filename + " in zipped file");
    }
  }



  @Override
  public int available() throws IOException {
    return m_zipInputStream.available();
  }

  @Override
  public void close() throws IOException {
    m_zipInputStream.close();
  }

  @Override
  public synchronized void mark(int readlimit) {
    m_zipInputStream.mark(readlimit);
  }

  @Override
  public boolean markSupported() {
    return m_zipInputStream.markSupported();
  }

  @Override
  public int read() throws IOException {
    return m_zipInputStream.read();
  }

  @Override
  public int read(byte[] b) throws IOException {
    return m_zipInputStream.read(b);
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    return m_zipInputStream.read(b, off, len);
  }

  @Override
  public synchronized void reset() throws IOException {
    m_zipInputStream.reset();
  }

  @Override
  public long skip(long n) throws IOException {
    return m_zipInputStream.skip(n);
  }
}
