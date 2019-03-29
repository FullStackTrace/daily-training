function initPrimes(num) {
    let arr = [2];
    let half = Math.abs(Math.floor(num / 2));
    for (let i = 3; i <= half; i++) {
        if ((i % 2) == 0) continue;
        let flag = true;
        let iHalf = Math.floor(i / 2);
        for (let j = 2; j <= iHalf; j++) {
            if ((i % j) == 0) {
                flag = false;
                break;
            }
        }
        if (flag) arr.push(i);
    }
    return arr;
}

function checkSelf(num) {
    num = Math.abs(num);
    if(num < 2) return false;
    let half = Math.floor(num / 2);
    for (let i = 2; i <= half; i++) {
        if (num % i == 0) return false
    }
    return true;
}

function merge(primes, selves) {
    primes = primes.concat(selves);
    primes = primes.filter((s, idx) => {
        for(let i = (idx + 1), len = primes.length; i < len; i++) {
            if(s == primes[i]) return false;
        }
        return true;
    })
    return primes;
}

function sumOfDivided(list) {
    if (!list || !list.length) return [];
    let selves = list.map(num => {
        if (checkSelf(num)) return Math.abs(num);
    }).filter(num => num)
    list.sort((a, b) =>  Math.abs(b) - Math.abs(a));

    let primes = initPrimes(list[0]);
    // primes = primes.concat(selves);
    primes = merge(primes, selves);
    primes.sort((a, b) => a - b)

    return primes.map(prime => {
        let sum = 0;
        let flag = false;
        list.forEach(num => {
            if (num % prime == 0) {
                sum += num;
                flag = true;
            }
        })
        if (flag) {
            return [prime, sum];
        } else {
            return [];
        }
    }).filter(a => a.length)
}

console.log(sumOfDivided([ 57, 91, 60, -22, 154, 113, 164, 11, 89, -12, 39, -36, 89, 48, -4, 85, -83 ]))