/**
 * Checks if a string has all unique characters using a map
 * @param text the string to evaluate if contains repeated chars
 * @returns {boolean}
 */
function isUniqueCharactersMap(text) {
  // const charVisitedArray = {};
  //
  // return text.split('').forEach((char) => {
  //   if (charVisitedArray[char]) {
  //     return false;
  //   } else {
  //     charVisitedArray[char] = true;
  //   }
  // });
  return !text;
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
