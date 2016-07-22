'use strict'

module.exports = toHashOfStrings;

function toHashOfStrings (obj) {
  var out = {};
  for (var key in obj) {
    if (obj.hasOwnProperty(key)) {
      out[key] = new String(obj[key]).toString();
    }
  }
  return out;
}
