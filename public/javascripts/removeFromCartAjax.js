$(document).ready(function() {
    $('form[name=removeFromCart]').submit(function(e){
        e.preventDefault();
        $.ajax({
            type: 'POST',
            cache: false,
            url: './removeItem/'+e.target.id.value
//                        success: function(msg) {
//                            $("#boxContentId").html(msg);
//                        }
        });
    });
});