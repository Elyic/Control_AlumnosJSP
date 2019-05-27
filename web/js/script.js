$(document).ready(function(){
    
    
    $('.show-menu').on('click', function(){
        
        $('.content-menu').slideToggle();
    })
    
    $(window).resize(function(){
        
        if($(window).height() < 900){
            $('.content-menu').css("overflow-y","scroll");
        }else{
            $('.content-menu').css("overflow-y","hidden");
        }

        if($(window).width() > 983){
            $('.content-menu').show();
            
        }else{
            $('.content-menu').hide();
        }
        
    });
    
});

if($(window).height() < 900){
            $('.content-menu').css("overflow-y","scroll");
        }else{
            $('.content-menu').css("overflow-y","hidden");
        }
        
$(document).ready(function(){
    $('select').formSelect();
  });