function findAll(n, k) {
    if(9 * k < n) return [];
    let mo = n % k;
    let x = (n - mo) / k;
    let result = 0, count = 1;
    if(mo == 0) {
        for(let i = 0; i < k; i++) {
            result += x * Math.pow(10, i);
        }
        if(x == 9) return [1, result.toString(), result.toString()]
    } else {
        for(let i = 0; i < k; i++) {
            result += x * Math.pow(10, i);
        }
        result += mo;
    }
    let max = result;
    result = result.toString().split("").map(a => {
        return parseInt(a);
    });
    for(let i = 0; i < result.length; i++) {
        for(let j = result.length - 1; j > i; j--) {
            if(result[j] < 9 && result[i] > 1) {
                let need;
                if(result[i] + result[j] > 10) {
                    need = 9 - result[j];
                    result[i] -= need;
                    result[j] = 9;
                } else {
                    need = result[i] - 1;
                    result[i] = 1;
                    result[j] += need;
                    
                }
                count += need 
            }
        }
    }
    return [count, result.join(""), max.toString()];
}

console.log(findAll(10, 3))