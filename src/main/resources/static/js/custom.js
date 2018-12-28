
jQuery(document).ready(function(){

	//============================== header =========================

	jQuery(document).ready(function($) {

	    // Fixa navbar ao ultrapassa-lo
	    var navbar = $('.navbar-main'),
	    		distance = navbar.offset().top,
	        $window = $(window);

		    $window.scroll(function() {
		    	if(($window.scrollTop() >= distance) && ($(".navbar-default").hasClass("navbar-main")))
		        {
		            navbar.removeClass('navbar-fixed-top').addClass('navbar-fixed-top');
		          	$("body").css("padding-top", "0px");
		        } else {
		            navbar.removeClass('navbar-fixed-top');
		            $("body").css("padding-top", "0px");
		        }
		    });
		
	});

	//============================== bxSlider =========================
	$('#footerSlider').bxSlider({
	  mode: 'vertical',
	  slideMargin: 12,
	  auto: true,
  	  autoControls: true,
  	  minSlides: 3,
  	  maxSlides: 3
	});
	

	//============================== Date-picker =========================
	$('.ed-datepicker').datepicker({
	    startDate: "dateToday",
		autoclose: true
	});

	//============================== Filter =========================
	$('.filter-container').mixItUp();

	//============================== Booking bar =========================
	
	$('.ed-booking-tab  ul > li:nth-child(1)').click(function () {
		var $this = $(this);
		if ($this.hasClass('ed-done')) {
			$this.removeClass('ed-done').siblings().removeClass('ed-done');
		}
	});
	$('.ed-booking-tab  ul > li:nth-child(2)').click(function () {
		var $this = $(this);
		$this.prev('li').addClass('ed-done');
		$this.next('li').removeClass('ed-done');
		if ($this.hasClass('ed-done')) {
			$this.removeClass('ed-done');
		}
	});
	$('.ed-booking-tab  ul > li:nth-child(3)').click(function () {
		$(this).siblings().addClass('ed-done');
		
		if ($('.ed-booking-tab  ul > li:nth-child(3)').hasClass('ed-done')) {
			$(this).removeClass('ed-done');
		}
	});

	//============================== Select room =========================
	$('.ed-room-select').click(function (e) {
		e.preventDefault();
		$(this).children().toggleClass('ed-room-select-fill');
	});

});

//============================== Rs-Slider =========================
jQuery(document).ready(function() {
      jQuery('.fullscreenbanner').revolution({
	    delay: 5000,
	    startwidth: 1170,
	    startheight: 500,
	    fullWidth: "on",
	    fullScreen: "on",
	    hideCaptionAtLimit: "",
	    navigationStyle: "preview4",
	    fullScreenOffsetContainer: "",
	    hideTimerBar:"on",
	});
});

//============================== Magnific popup =========================
$(function () {
	$('.popup-modal').magnificPopup({
		type: 'inline',
		preloader: false,
		focus: '#username',
		modal: true
	});
	$(document).on('click', '.popup-modal-dismiss', function (e) {
		e.preventDefault();
		$.magnificPopup.close();
	});
});

$(document).ready(function() {
	$('.popup-gallery').magnificPopup({
		delegate: 'a',
		type: 'image',
		tLoading: 'Loading image #%curr%...',
		mainClass: 'mfp-img-mobile',
		closeBtnInside: false,
		gallery: {
			enabled: true,
			navigateByImgClick: true,
			preload: [0,1] // Will preload 0 - before current, and 1 after the current image
		},
		image: {
			tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
			titleSrc: function(item) {
				return item.el.attr('title') + '<small>by Marsel Van Oosten</small>';
			}
		}
	});
});

//============================== Flexslider =========================
$(window).load(function() {
	$('#single-slider').flexslider({
	    animation: "slide",
	    controlNav: false,
	    prevText: "",           
    	nextText: ""
	});

	$('#carousel').flexslider({
	    animation: "slide",
	    controlNav: false,
	    animationLoop: false,
	    slideshow: false,
	    itemWidth: 210,
	    itemMargin: 5,
	    asNavFor: '#slider'
	});
	 
	$('#slider').flexslider({
	    animation: "slide",
	    controlNav: false,
	    animationLoop: false,
	    slideshow: false,
	    sync: "#carousel"
	});
});

$(window).load(function() {
  $('#testimonialSlider').flexslider({
    animation: "slide"
  });
});

//============================== Count down =========================
jQuery(document).ready(function() {
	$('#simple_timer').syotimer({
        year: 2017,
        month: 5,
        day: 9,
        hour: 20,
        minute: 30,
    });
});

jQuery(document).ready(function() {
	$('#input-id').rating('update', 1);
});
