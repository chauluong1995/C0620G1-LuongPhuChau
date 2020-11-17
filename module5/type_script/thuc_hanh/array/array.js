/**
 * Array
 */
// declare an array
var list = [1, 2, 3];
var categories = ['Sport', 'IT', 'Car'];
document.write('List' + "<br>");
list.forEach(function (num) {
    return document.write(num.toFixed(1) + "<br>");
});
document.write('categories' + "<br>");
categories.forEach(function (str) {
    return document.write(str.indexOf('IT') + "<br>");
});
// convert mảng từ dạng này sang dạng khác.
var listSquare = list.map(function (num) { return num * num; });
document.write(listSquare + "<br>");
// Output: [1, 4, 9]
// lọc các phần tử thỏa mãn
var result = categories.filter(function (str) { return str.length > 4; });
document.write(result + "<br>");
// Output: ['Sport', 'Car']
/**
 * Tuple
 */
// Declare a tuple type
var x;
// Initialize it
x = ["hello ", 10]; // OK
document.write(x[0].toString() + "<br>");
// Initialize it incorrectly
// x = [10, "hello"]; // Error
// console.log(x[1].substr(1));
// Error, Property 'substr' does not exist on type 'number'.
x[0] = "world";
document.write(x[0].toString() + "<br>");
// OK, 'string' can be assigned to 'string | number'
x[1] = 100.25;
document.write(x[1].toString() + "<br>");
// OK, 'string' and 'number' both have 'toString'
// x[6] = true; // Error, 'boolean' isn't 'string | number'
