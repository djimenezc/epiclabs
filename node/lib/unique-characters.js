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
 * Checks if a string has all unique characters using a map
 * @returns {boolean}
 * @param text
 */
function isUniqueCharacters(text) {
  return !text;
}

export {
  isUniqueCharactersMap,
  isUniqueCharacters,
};
