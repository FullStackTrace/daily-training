function count(n) {
    if(n > 0) {
        let arr = []
        for(let i = 0; i <= n; i++) {
            arr.push(i);
        }
        let str = arr.join("");
        let total, after;
        total = str.split("").length;
        after = str.replace(/[1]*/g, '').split("").length;
        return total - after;
    }
    return 0;
}

console.log(count(13))