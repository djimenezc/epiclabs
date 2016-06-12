import assert from 'assert';
import {
  isUniqueCharactersMap,
  isUniqueCharactersSorting,
} from '../lib/unique-characters';

const textNoUniqueChars = 'aaaaaaaaa';
const textUniqueChars = 'abcd';

describe('unique-characters map version', () => {

  it('should check that the string does not have all the characters unique!', () => {
    const expected = isUniqueCharactersMap(textNoUniqueChars);
    assert.ok(!expected, 'the string has repeated chars');
  });

  it('should check that the string does have all the characters uniques!', () => {
    const expected = isUniqueCharactersMap(textUniqueChars);
    assert.ok(expected, 'the string has unique chars');
  });
});

describe('unique-characters sorting version', () => {

  it('should check that the string does not have all the characters unique!', () => {
    const expected = isUniqueCharactersSorting(textNoUniqueChars);
    assert.ok(!expected, 'the string has repeated chars');
  });

  it('should check that the string does have all the characters uniques!', () => {
    const expected = isUniqueCharactersSorting(textUniqueChars);
    assert.ok(expected, 'the string has unique chars');
  });
});
