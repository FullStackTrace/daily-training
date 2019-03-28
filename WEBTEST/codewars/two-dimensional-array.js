var arr = [], count = 0, weidu = [5,5];
for(let i = 0; i < weidu[0]; i++) {
    let tmp = [];
    for(let j = 0; j < weidu[1]; j++) {
        tmp.push(++count);
    }
    arr.push(tmp);
}
console.log(arr)
let str = '', t = 0, r = c = cycle = 0;
function show() {
    let xunhuan = 1;
    while(t < weidu[0] * weidu[1]) {
        if(xunhuan == 1) {
            xunhuan++;
            for(; r < arr[c].length - cycle; r++) {
                str += arr[c][r] + ",";
                t++;
            }
            r--;
            c++;
        } else if(xunhuan == 2) {
            xunhuan++;
            for(; c < arr.length - cycle; c++) {
                str += arr[c][r] + ",";
                t++;
            }
            c--;
            r--;
        } else if(xunhuan == 3) {
            xunhuan++;
            for(; r >= cycle; r--) {
                str += arr[c][r] + ",";
                t++;
            }
            r++;
            c--;
        } else {
            xunhuan = 1;
            let flag = false;
            if(c > cycle) {
                flag = true;
            }
            console.log(c, t, cycle);
            for(; c > cycle; c--) {
                str += arr[c][r] + ",";
                t++;
            }
            if(flag) cycle++;
            c = cycle;
            r = cycle;
        }
    }
}
show()
console.log(str)

