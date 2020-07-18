$(document).ready(function(){
    $("#remove-image").click(function(){
		$("#image-wrapper").css("display", "none");
        $(".placeholder").css("display", "block");
        
		//alert(document.getElementById('file-id').value);
		document.getElementById('file-id').form.reset();
        //alert(document.getElementById('file-id').value);
    });

});
