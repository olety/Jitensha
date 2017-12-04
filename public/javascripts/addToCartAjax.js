$(document).ready(function() {
    $('form[name=addToCart]').submit(function(e){
        e.preventDefault();
        $.ajax({
            type: 'POST',
            cache: false,
            url: './addItem/'+e.target.id.value
//                        success: function(msg) {
//                            $("#boxContentId").html(msg);
//                        }
        });
    });
});