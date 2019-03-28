function determinant(m) {
    if(m.length == 1) return m[0][0];
    if(m.length >= 3) {
        let n = [], tmp = [], result = 0;
        for(let i = 0; i < m[0].length; i++) {
            
            n = []
            for(let j = 1; j < m.length; j++) {
                if(0 == j) continue;
                tmp = []
                for(let k = 0; k < m[j].length; k++) {
                    if(i == k) continue;
                    tmp.push(m[j][k]);
                }
                n.push(tmp);
            }
            if(i % 2 == 0) result += m[0][i] *  determinant(n);
            else result -= m[0][i] *  determinant(n);
        }
        return result;
    } else {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }
};
var m2 = [ [2,5,3], [1,-2,-1], [1, 3, 4]]
console.log(determinant(m2))