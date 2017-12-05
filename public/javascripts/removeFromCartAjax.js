$(document).ready(function() {
    $('form[name=removeFromCart]').submit(function(e){
        e.preventDefault();
        console.log(e)
        console.log(e.target)
        $.ajax({
            type: 'POST',
            cache: false,
            url: './removeItem/'+e.target.id.value,
            data: $(this).serialize()
//                        success: function(msg) {
//                            $("#boxContentId").html(msg);
//                        }
        });
        $("#cart-table").deleteRow(index + 1);
    });
});