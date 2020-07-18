$(document).ready(function(){
    $("#sharestory").submit(function(event){

        if(($("#tags-display").children().length<1) || (document.getElementById('story-posting').innerHTML== '')) {
            alert("enter the details");
			event.preventDefault();
        } else {
                var name = window.localStorage.getItem('fname');
                var email = window.localStorage.getItem('uemail');
                var freestyle = window.localStorage.getItem('freestyle');
                var country = window.localStorage.getItem('country');
                var postcode = window.localStorage.getItem('upostcode');
                var checkbox1 = window.localStorage.getItem('checkbox1');
                var checkbox2 = window.localStorage.getItem('checkbox2');
                var checkbox3 = window.localStorage.getItem('checkbox3');
        
            $("#sharestory").append("<input type='text' style='display:none;' name='name' value='"+name+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='email' value='"+email+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='experience' value='"+freestyle+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='country' value='"+country+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='postcode' value='"+postcode+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='checkbox1' value='"+checkbox1+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='checkbox2' value='"+checkbox2+"'>");
                $("#sharestory").append("<input type='text' style='display:none;' name='checkbox3' value='"+checkbox3+"'>");
        
                var tagValues=$("#tags-display").children();
        
                var tags='';
        
                    for(i=0;i<tagValues.length;i++) {

                        tags=tags+tagValues[i].innerHTML+",";
                        console.log(tagValues[i].innerHTML)
                    }
        
                //alert(tags);
                $("#sharestory").append("<input type='text' name='tags' value='"+tags+"'>");
        }

    });

});