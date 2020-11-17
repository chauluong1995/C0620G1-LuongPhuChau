function square(num: number): number {
    return num * num;
}

document.write(square(5) + "<br>");
// Output: 25

// Function expression
const squareFE = function (num: number): number {
    return num * num;
}

// Higher-order function
function add(a: number): Function {
    return function(b: number): number {
        return a + b;
    }
}

const addWith5 = add(5);
document.write(addWith5(3) + "<br>");
document.write(addWith5(15) + "<br>");