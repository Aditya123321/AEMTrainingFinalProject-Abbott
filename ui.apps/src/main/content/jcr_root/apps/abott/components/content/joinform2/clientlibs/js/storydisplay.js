$(document).ready(function(){
    $( window ).on( "load", function() {
        //$("#story-details").css("display", "block");
        var getname = window.localStorage.getItem('fname');

        $('.story-details-container').append(' <p id="story-details" class="story-author title">' + getname + '</p>');

        //document.getElementById("story-details").innerHTML = getname;
        //alert("Text: " + getname);

 });

});