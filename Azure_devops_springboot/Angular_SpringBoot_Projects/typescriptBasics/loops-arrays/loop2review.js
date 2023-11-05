var reviews = [1, 4, 5, 8, 0];
var total = 0;
for (var i = 0; i < reviews.length; i++) {
    console.log(reviews[i]);
    total += reviews[i];
}
var average = (total) / (reviews.length);
console.log("Review Average=" + average);
