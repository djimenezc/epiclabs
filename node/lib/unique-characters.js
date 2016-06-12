/**
 * Checks if a string has all unique characters using a map,
 * the idea behind is to look over all the chars of the text
 * and store the visited values in an a temporary array,
 * if a chars was visited more than once the string does not contains unique chars
 * @param text the string to evaluate if contains repeated chars
 * @returns {boolean}
 */
function isUniqueCharactersMap(text) {
  const charVisitedArray = {};

  return text.split('').every(char => {

    if (charVisitedArray[char]) {
      charVisitedArray[char]++;
    } else {
      charVisitedArray[char] = 1;
    }
    return charVisitedArray[char] < 2;
  });
}

/**
 * Checks if a string has all unique characters using a sorting algorithm,
 * the idea behind is that when all the chars are sorted out,
 * two consecutive chars in the sorted array have to be different
 * @returns {boolean}
 * @param text
 */
function isUniqueCharactersSorting(text) {

  const stringSorted = text.split('').sort();

  const isCharRepeated = (elem, index, array) => {
    const previousElemIndex = index - 1;
    return index === 0 || elem !== array[previousElemIndex];
  };

  return stringSorted.every((isCharRepeated));
}

export {
  isUniqueCharactersMap,
  isUniqueCharactersSorting,
};
