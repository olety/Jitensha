$(document).ready(function() {
    $('form[name=addToCart]').submit(function(e){
        e.preventDefault();
        $.ajax({
            type: 'POST',
            cache: false,
            url: './addItem/'+e.target.id.value,
            data: $(this).serialize()
//                        success: function(msg) {
//                            $("#boxContentId").html(msg);
//                        }
        });
    });
});