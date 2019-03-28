//console.log("-".charCodeAt(0), "+".charCodeAt(0))

function simplify(poly){
    let str = poly.split(/\W/g).filter(a => {
        return a && a!= '';
    })
    str = str.map(a => {
        a = a.split("").sort().join("");
        let num = a.match(/^[0-9]*/g)
        let chars = a.match(/[a-zA-Z]*$/g)
        return [num[0] == '' ? '1' : num[0], chars[0]];
    })
    let str2 = poly.replace(/\w*/g, "").split("")
    console.log(str, str2)
    if(str.length != str2.length) str2.unshift("+");
    for(let i = 0; i < str.length; i++) {
        a = str[i]
        for(let j = 0; j < str.length; j++) {
            if(a.length && str[j].length && a[1] == str[j][1]){
                a[0] = eval(a[0] + str2[j] + str[j][0]);
                str[j] = [];
                console.log(a, str[j])
            }
        }
        console.log(a);
        return a;
    }
    console.log(str)
}
simplify("-a+5ab+3a-c-2a")