var arr = [1,2,3,4,5,5,5,1,512,5,435,436,54,654,5,324356,346,456,54,65,213,12];
console.log(arr.length);
var i = 0;
for(; i < arr.length; i++) {
    console.log("arr[i]",arr[i])
    arr.splice(i,1);
    console.log(i);
}
console.log(i)