$(document).ready(function(){
    $("#nextbutton").click(function(event){

 

        if(($('#name').val() === "") || ($('#email').val() === "")){

 

                $('#email-error-text').css("display","block");
                $('#name-error-text').css("display","block");
                event.preventDefault();

 

        } else {

 

                $('#email-error-text').css("display","none");
                $('#name-error-text').css("display","none");

 

                var name = $("#name").val();
                var email = $("#email").val();
                var selectedFreestyle = $(".freestyle").children("option:selected").val();
                var selectedCountry = $(".country").children("option:selected").val();
                var postcode = $("#postcode").val();
                var checkbox1 = document.getElementById("disclaimer1");
                var checkbox2 = document.getElementById("disclaimer2");
                var checkbox3 = document.getElementById("disclaimer3");

 


                if(disclaimer1.checked === true) {
                   
                    $('#checkbox-error-text').css("display","none");
                    window.localStorage.clear();

 

                    window.localStorage.setItem('fname', name);
                    window.localStorage.setItem('uemail', email);
                    window.localStorage.setItem('freestyle', selectedFreestyle);
                    window.localStorage.setItem('country',selectedCountry);
                    window.localStorage.setItem('upostcode', postcode);
                    window.localStorage.setItem("checkbox1", disclaimer1.checked);
                    window.localStorage.setItem("checkbox2", disclaimer2.checked);
                    window.localStorage.setItem("checkbox3", disclaimer3.checked);
                }else {
                     $('#checkbox-error-text').css("display","block");
                     event.preventDefault();
                }
        }

 

    });

 

});