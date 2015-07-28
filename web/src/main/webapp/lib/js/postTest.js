$(function(){
$(document).on("click","button",function() {
        var city = $("#city").val();
        var state = $("#state").val();
        var url = "/web/xmlTest/xml";
        $.post(url, {city: city, state: state}, function (result) {
            $("#zipCode").val(result);
        });
    });
});

