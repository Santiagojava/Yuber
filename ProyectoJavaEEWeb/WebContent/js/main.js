$(document).ready(function(){
	var altura = $('.menus').offset().top;

	$(window).on('scroll', function(){
		if($(window).scrollTop() > altura){
			$('.menus').addClass('menu-fixed');
		}else{
			$('.menus').removeClass('menu-fixed')
		}
	});
});