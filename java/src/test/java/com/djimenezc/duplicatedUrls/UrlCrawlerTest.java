package com.djimenezc.duplicatedUrls;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * Test to check that the delete node method works successfully
 * Created by david on 12/06/2016.
 */
public class UrlCrawlerTest {

  private UrlCrawler urlCrawler;

  @Before
  public void setUp() {
    urlCrawler = new UrlCrawler();
    System.out.println("@Before - setUp");
  }

  @After
  public void tearDown() {
    urlCrawler = null;
    System.out.println("@After - tearDown");
  }

  @Test
  public void testSearchDuplicatedUrls() throws Exception {

    Path currentRelativePath = Paths.get("");
    String filePath = currentRelativePath.toAbsolutePath().toString() + "/top-1m.csv";
    File file = new File(filePath);

    List<String> duplicatedUrls = urlCrawler.findDuplicatedLines(file);

    Assert.assertNotNull(duplicatedUrls);
    Assert.assertTrue("Found some duplicated lines", duplicatedUrls.size() > 0);

  }

}
