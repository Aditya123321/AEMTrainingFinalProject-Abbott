$(document).ready(function(){
	$('.your-class').slick({
        infinite: true,
        slidesToShow: 2,
        slidesToScroll: 1,
        arrows: true,
        autoplay: false,
        centerMode: true,
        variableWidth: false,
        nextArrow: '.nn',
        prevArrow: '.pp',
        asNavFor: '.your-class',
        responsive: [{
          breakpoint: 1024,
          settings: {
              dots: true
          }
      }]
    });
});