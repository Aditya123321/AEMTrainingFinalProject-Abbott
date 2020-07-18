$(document).ready(function(){

    var inputBox = document.getElementById('story-text-textarea');

    if(inputBox!=undefined)
    inputBox.onkeyup = function(){

		alert(inputBox.value.length);
        $(".text-placeholder").css("display", "none");
        document.getElementById('story-posting').innerHTML = inputBox.value;

        if((inputBox.value.length) > 500) {

            	alert('hello from if');
            	document.getElementById('story-posting').classList.add("card-text-overflow");

        } else {
            //alert($("#story-posting").val().length);
            if($("#story-posting").hasClass("card-text-overflow")) {
				$("#story-posting").removeClass("card-text-overflow");
            }
        }
    }

});