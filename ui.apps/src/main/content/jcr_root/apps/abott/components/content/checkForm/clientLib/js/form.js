var tags="";
var count=1;

$(".tag-container > p").click(function(event) {

        if($(this).hasClass("active")) {
		$(this).removeClass("active");
            $(".selected-tag").empty();
        	activeClass=$(".active");//document.getElementsByClassName("active");
            for(i=0;i<activeClass.length;i++) {
			$(".selected-tag").append("<p>"+activeClass[i].innerHTML+"</p>");
            }
            count = $(".selected-tag").children().length;

           }else{
	if(count<3){
    $(this).addClass("active");
    $(".selected-tag").append("<p>"+this.innerHTML+"</p>");
    alert(this.innerHTML);

    count = $(".selected-tag").children().length;
    alert(count);
          } else {
    alert("select atleast 1 and atmost 3");
    }

}
});

$("#shareStoryForm").submit(function(){
var tagValues=$(".selected-tag").children();
for(i=0;i<tagValues.length;i++) {
	tags=tags+tagValues[i].innerHTML+",";
}
$("#shareStoryForm").append("<input type='text' name='tags' value='"+tags+"'>");
    //$('input[name=tags]').val()=tags;
    alert($('input[name=tags]').val());
 /*$.ajax({
    type:"POST",
    url: "/bin/send", 
     data: {
         "name": $('input[name=name]').val(),
         "email": $('input[name=email]').val(),
         "experience": $('select[name=experience]').val(),
         "country": $('select[name=country]').val(),
         "postcode": $('input[name=postcode]').val(),
         "description": $('textarea[name=description]').val(),
         "tags": tags,
         "myfile":
     }
    success: function(result){
      $("#div1").html(result);
    }});*/
alert(tags);
});

