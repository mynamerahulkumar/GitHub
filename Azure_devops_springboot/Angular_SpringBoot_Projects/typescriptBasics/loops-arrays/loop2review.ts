let reviews:number[]=[1,4,5,8,0];
let total:number=0;
for(let i=0;i<reviews.length;i++){
    console.log(reviews[i])
    total+=reviews[i];
}
let average:number=(total)/(reviews.length);
console.log("Review Average="+average)