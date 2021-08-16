function clickDer(){
var isCtrl = false;

document.onkeyup=function(e){
if(e.which == 17) isCtrl=false;
}
document.onkeydown=function(e){
if(e.which == 17) isCtrl=true;
if(e.which == 85 && isCtrl == true) {
return false;
} 
if(e.which == 73 && isCtrl == true) {
return false;
}
}
}