/**
 * Checks if a string has all unique characters using a map
 * @param text the string to evaluate if contains repeated chars
 * @returns {boolean}
 */
function isUniqueCharactersMap(text) {
  const charVisitedArray = {};

  return text.split('').every((char) => {

    if (charVisitedArray[char]) {
      charVisitedArray[char]++;
    } else {
      charVisitedArray[char] = 1;
    }
    return charVisitedArray[char] < 2;
  });
}

/**
 * Checks if a string has all unique characters using a sorting algorithm
 * @returns {boolean}
 * @param text
 */
function isUniqueCharactersSorting(text) {
  return !text;
}

export {
  isUniqueCharactersMap,
  isUniqueCharactersSorting,
};
