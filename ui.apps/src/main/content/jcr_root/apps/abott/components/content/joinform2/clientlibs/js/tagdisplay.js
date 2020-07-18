$(document).ready(function(){
    var count=1;
    
    $(".one-col > span").click(function () {
            //var count;
             var tagValue = $(this).attr("id");
            //alert(tagValue);
    
             if($(this).hasClass("check")) {
    
                $(this).removeClass("check");
    
                $("#tags-display").empty();
                activeClass=$(".check");//document.getElementsByClassName("active");
    
                for(i=0;i<activeClass.length;i++) {
                $('#tags-display').append('<div class="span-text checked">'+ activeClass[i].innerHTML + '</div>');
                //$("#tags-display").append("<p>"+activeClass[i].innerHTML+"</p>");
                }
    
                count = $("#tags-display").children().length;
                //alert(count);
    
               }else{
    
                    if(count<3){
                            $(this).addClass("check");
                            //$(".placeholder").css("display", "none");
                            //$(".span-text").css("background-color"," #ffd100");
                            $('#tags-display').append('<div class="span-text checked">'+ tagValue + '</div>');
                            //alert(this.innerHTML);
    
                            count = $("#tags-display").children().length;
                            //alert(count);
    
                          } else {
                              
                                alert("select atleast 1 and atmost 3");
                          }
              }

    });
});