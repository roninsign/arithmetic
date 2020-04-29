// 计时器的写法

var i = 0;
var q = 0;
function startTime(){
j = document.getElementById("startShow");
j.value = q + ":" + i;
i += 1;
if(i == 60){
i = 0;
q += 1;
}
t = setTimeout("startTime()",1000);
}

// function stopTime(){
// 	var k = document.getElementById("stopShow");
// 	k.innerHTML = j.innerHTML;
// 	j.innerHTML = 0 + ":" + 0;
// 	i = 0;
// 	m = 0;
// 	clearTimeout(t);
// }



function start(){
var today=new Date()
var h=today.getHours()
var m=today.getMinutes()
var s=today.getSeconds()
m=checkTime(m)
s=checkTime(s)
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('start()',500)
}

function checkTime(a){
if(a<10){
a="0" + a
}
return a
}




//判断输入条件
// $(function(){
// 	$("#range").blur(function(){
// 		if(this.value!=){
// 			var error = "请输入一个正整数";
// 			$(".range").text(error);
// 		}
// 		else{
// 			var right = "输入正确";
// 			$(".range").text(right);
// 		}
// 	});
// })