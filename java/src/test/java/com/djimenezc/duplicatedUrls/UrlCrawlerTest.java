package com.djimenezc.duplicatedUrls;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;


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

    Set<String> duplicatedUrls = urlCrawler.findDuplicatedLines("1m-urls.txt");

    Assert.assertNotNull(duplicatedUrls);
    Assert.assertTrue("Found some duplicated lines", duplicatedUrls.size() == 8);

    System.out.println("Duplicated lines: " + duplicatedUrls.toString());
  }

}
