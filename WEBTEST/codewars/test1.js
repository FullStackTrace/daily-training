/*
找到字母数量相同且字母相同的字符串
如
'abba' & 'baab' == true

'abba' & 'bbaa' == true

'abba' & 'abbba' == false

anagrams('abba', ['aabb', 'abcd', 'bbaa', 'dada']) => ['aabb', 'bbaa']

anagrams('racer', ['crazer', 'carer', 'racar', 'caers', 'racer']) => ['carer', 'racer']

anagrams('laser', ['lazing', 'lazy',  'lacer']) => []
*/

function anagrams(word, words) {
    word = word.split("").sort().join("");
    let arr = []
    words.forEach((a, i) => {
        if(word == a.split("").sort().join("")) arr.push(a);
    });
    return arr;
}

console.log(anagrams('abba', ['aabb', 'abcd', 'bbaa', 'dada']))