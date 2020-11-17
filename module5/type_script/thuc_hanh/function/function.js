function square(num) {
    return num * num;
}
document.write(square(5) + "<br>");
// Output: 25
// Function expression
var squareFE = function (num) {
    return num * num;
};
// Higher-order function
function add(a) {
    return function (b) {
        return a + b;
    };
}
var addWith5 = add(5);
document.write(addWith5(3) + "<br>");
document.write(addWith5(15) + "<br>");
