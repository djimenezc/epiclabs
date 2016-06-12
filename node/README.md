# unique-characters [![NPM version][npm-image]][npm-url] [![Build Status][travis-image]][travis-url] [![Dependency Status][daviddm-image]][daviddm-url] [![Coverage percentage][coveralls-image]][coveralls-url]
> Implement an algorithm that checks if a string has all unique characters. Try to do the same reducing amount of memory used

I have choose two strategies to resolve this problem:
1. Looping through each char of a string and keeping the visited chars in a map. If a char is visited more than once the string does not have unique chars.
2. The second aproach is to sort the chars in the string and look over all the chars. Two consecutive chars cannot be equal in a unique character string

## Installation

```sh
$ npm install --save unique-characters
```

## Usage

```js
var uniqueCharacters = require('unique-characters');

uniqueCharacters.isUniqueCharactersMap('aaaaa'); //false
uniqueCharacters.isUniqueCharactersMap('abczd'); //true

uniqueCharacters.isUniqueCharactersSorting('aaaaa'); //false
uniqueCharacters.isUniqueCharactersSorting('abczd'); //true
```
## License

MIT © [David Jimenez]()


[npm-image]: https://badge.fury.io/js/unique-characters.svg
[npm-url]: https://npmjs.org/package/unique-characters
[travis-image]: https://travis-ci.org/djimenezc/unique-characters.svg?branch=master
[travis-url]: https://travis-ci.org/djimenezc/unique-characters
[daviddm-image]: https://david-dm.org/djimenezc/unique-characters.svg?theme=shields.io
[daviddm-url]: https://david-dm.org/djimenezc/unique-characters
[coveralls-image]: https://coveralls.io/repos/djimenezc/unique-characters/badge.svg
[coveralls-url]: https://coveralls.io/r/djimenezc/unique-characters
