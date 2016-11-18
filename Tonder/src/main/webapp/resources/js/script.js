$(document).ready(function(){
	$("#formu").hide();
	token();
	$("#start").click(function(){
		
		$(".header-content-inner").hide();
		$(".form-box").show();
	});
	
});
var token = function(){
	$("#tokenfield").tokenfield({
		limit: 4
	});
	var count = 0;
	$("#tokenfield").on('tokenfield:createdtoken', function (e) {
	   count = count + 1;
	   if(count < 4){
		   $("#tag").addClass('invalid')
	   }
	});
}