function find(num, total, arr) {
    console.log("total", total)
    if(total < 4 && total != 1) return false;
    // if(total == 1) {
    //     arr.push(1)
    //     return true;
    // }
    let n = Math.sqrt(total = (total - Math.pow(num, 2)));
    
    if((n < 1 && total != 0) || n >= arr[arr.length - 1]) return false;
    
    if(n.toString().indexOf(".") != -1) {
        let next = Math.pow(Math.floor(Math.sqrt(total)), 2);
        console.log(total, next)
        if(total - next == 18) 
            n = Math.floor(n) - 1;
        else 
            n = Math.floor(n);
        console.log("nnnn", n);
        arr.push(n);
        return find(n, total, arr);
    } else {
        arr.push(n);
        return true;
    }
}

function decompose(n) {
    console.log("n", n)
    let pow = Math.pow(n, 2);
    for(let i = n - 1; i >= 2; i--) {
        let arr = [i];
        if(find(i, pow, arr)) {
            arr.sort((a, b) => a - b);
            return arr;
        }
    }
    return null;
}
console.log("decompose", decompose(50));
// console.log("decompose", decompose(12));
// console.log("decompose", decompose(44));
// console.log("decompose", decompose(655));