
function loop(i, tmpStr, obj, max, v) {
    let s = tmpStr[i];
    if(!obj[s]){
        if(i < max) {
            obj[s] = {};
        }
    }
    
    if(i < max) {
        i++;
        loop(i, tmpStr, obj[s], max, v);
    } else {
        obj[s] = v;
    }
}

function constructObject(strs) {
    let objects = [];
    let obj = {};
    for(let i = 0, len = strs.length; i < len; i++) {
        
        let tmpStr = strs[i].split("=");
        let k, v;
        k = decodeURIComponent(tmpStr[0]), v = decodeURIComponent(tmpStr[1]);
        tmpStr = k.split(".");
        // objects.forEach((item, idx) => {
        //     if(item[tmpStr[0]]) {
        //         obj = item;
        //         return;
        //     }
        // })
        loop(0, tmpStr, obj, tmpStr.length - 1, v);
        // for(let j = 0, len = tmpStr.length; j < len; j++) {
        //     if(!obj[tmpStr[i]]) obj[tmpStr[i]] = {};

        // }

        // objects.push(obj);
    }
    // return objects[0];
    return obj;
}
function convertQueryToMap(query) {
    if(!query || query == "") return query;
    query = query.split("&");
    return constructObject(query);
}

var q = 'user.name.firstname=Bob&user.name.lastname=Smith&user.favoritecolor=Light%20Blue';
console.log(convertQueryToMap(q));
console.log(convertQueryToMap("a=1&b=2"));
console.log(convertQueryToMap("a=a%26b%3Dc%3F"));