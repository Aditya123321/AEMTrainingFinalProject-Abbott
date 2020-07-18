$(document).ready(function(){
   
    if(document.getElementsByClassName('share-victories')[0]!=undefined){
     if(parseInt($('.share-victories .carousel-inner .active .description')[0].scrollHeight)>240)
                {
					$('.share-victories .carousel-inner .active .button')[0].style.display="block";
                }
	console.log($('.share-victories .carousel-inner .active .description')[0].scrollHeight);
        $('.share-victories .carousel-indicators li')[0].click();
        $('.share-victories .carousel-indicators li').click(function(){
            setTimeout(function(){
           console.log($('.share-victories .carousel-inner .active .description')[0].scrollHeight);
                if(parseInt($('.share-victories .carousel-inner .active .description')[0].scrollHeight)>240)
                {
					$('.share-victories .carousel-inner .active .button')[0].style.display="block";
                }
            },637);
        });
         $('.share-victories .carousel-inner .carousel-control').click(function(){
            setTimeout(function(){
           console.log($('.share-victories .carousel-inner .active .description')[0].scrollHeight);
                if(parseInt($('.share-victories .carousel-inner .active .description')[0].scrollHeight)>240)
                {

					$('.share-victories .carousel-inner .active .button')[0].style.display="block";
                }
            },637);
        });
}
});
function isHeight(){
    console.log($('.active .description')[0].scrollHeight);
}
