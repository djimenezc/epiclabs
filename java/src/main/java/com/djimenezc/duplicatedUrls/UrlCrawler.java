package com.djimenezc.duplicatedUrls;

import com.google.code.externalsorting.ExternalSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * You have a file with 10 billion of urls (one per line).
 * These are the full list of urls to be crawled by your crawler.
 * How do you determine what url’s are duplicated?
 * Assume you have just 1 GB of memory available for this
 * <p>
 * <b>Solution</b>: The key is that your data will not fit into memory,
 * so the algorithm tries to sort the data using a external sorting algorithm.
 * When we get a file with all the lines sorted we can assure that
 * duplicated lines are placed consecutively. Then the algorithm look over the lines,
 * keeping in a Set structure the lines that match with the previous line read,
 * of that way it will be build the duplicated lines array.
 * <p>
 * <p>
 * References:
 * - https://github.com/lemire/externalsortinginjava
 * <p>
 * Created by david on 19/06/2016.
 */
class UrlCrawler {

  /**
   * Extract the duplicated lines include in a file
   *
   * @param inputFileName name of the file in the src/main/resources folder
   * @return list of duplicated lines in a file
   * @throws IOException
   */
  Set<String> findDuplicatedLines(String inputFileName) throws IOException {

    File sortedLinesFile = sortFileLines(inputFileName);

    Set<String> duplicatedLines = getDuplicatesLinesFromSortedFile(sortedLinesFile);

    sortedLinesFile.delete();

    return duplicatedLines;
  }

  /**
   * Having a file with all the lines sorted the method return the lines
   * that are duplicated because are placed consecutively
   *
   * @param sortedLinesFile File with all lines sorted
   * @return a set of string that contains lines duplicated
   * @throws FileNotFoundException
   */
  private Set<String> getDuplicatesLinesFromSortedFile(File sortedLinesFile) throws FileNotFoundException {

    Set<String> duplicatedLines = new HashSet<>();

    Scanner sc = new Scanner(sortedLinesFile);

    String previousLine = "";

    while (sc.hasNextLine()) {
      String currentLine = sc.nextLine();

      if (currentLine.equals(previousLine)) {
        duplicatedLines.add(currentLine);
      }
      previousLine = currentLine;
    }
    sc.close();

    return duplicatedLines;
  }

  /**
   * Sort out the lines of the input file using a external sorting algorithm.
   * The idea behind is to split the file in small chunks of data that can be sorted out
   * and after merging the chunks in bigger chunks.
   * This process continue until we have one big chunk.
   * This process does not need too much memory considering
   * the chunks are stored in the hard disk.
   * <p>
   * More info about external sorting mechanisms.
   * https://en.wikipedia.org/wiki/External_sorting
   * https://github.com/lemire/externalsortinginjava
   *
   * @param inputFileName the name of the input file to be sorted out
   * @return a File that contains the same content than the input file but the lines are sorted out
   * @throws IOException
   */
  private File sortFileLines(String inputFileName) throws IOException {

    Path currentRelativePath = Paths.get("");
    String filePath = currentRelativePath.toAbsolutePath().toString() + "/src/main/resources/" + inputFileName;
    File inputFile = new File(filePath);

    List<File> chunks = ExternalSort.sortInBatch(inputFile);

    File outputFile = new File("tmp.txt");
    ExternalSort.mergeSortedFiles(chunks, outputFile);

    return outputFile;
  }
}
