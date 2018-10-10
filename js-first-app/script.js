var counter = 0;
$("#counter").text(counter);

function inc(){
  counter++;
  $("#counter").text(counter);
}

function dec(){
  counter--;
  $("#counter").text(counter);
}