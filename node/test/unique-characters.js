import assert from 'assert';
import { isUniqueCharactersMap } from '../lib/unique-characters';

describe('unique-characters map version', () => {

  it('should check that the string does not have all the characters unique!', () => {
    const expected = isUniqueCharactersMap('aaaaaaaaa');
    assert.ok(!expected, 'the string has repeated chars');
  });

  it('should check that the string does have all the characters uniques!', () => {
    const expected = isUniqueCharactersMap('abcd');
    assert.ok(expected, 'the string has unique chars');
  });
});
