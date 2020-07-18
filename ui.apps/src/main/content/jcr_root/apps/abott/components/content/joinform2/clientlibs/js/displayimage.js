$("#file-id").change(function () {
	//alert("hello from js");
    filePreview(this);
});

function filePreview(input) {

            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
					$(".placeholder").css("display", "none");
                    $("#image-wrapper").css("display", "block");
                    $('#imageupload').attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }