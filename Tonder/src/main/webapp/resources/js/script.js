$(document).ready(function(){
	
	$("#formu").hide();
	$("#in").click(function(){
		$("#regi").hide();
		$("#inicio").show();
	});
	$("#sign").click(function(){
		$("#regi").show();
		$("#inicio").hide();
	});
	$("#start").click(function(){
		$(".header-content-inner").hide();
		$(".form-box").show();
		$("#inicio").hide();
	});

});
