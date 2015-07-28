$(function(){
    $(document).on("click","button",function() {
        var city = $("#city").val();
        var state = $("#state").val();
    $.ajax({
        type: "post",
        url: "/web/xmlTest/xml?",
        data: "city=" + city + "&state=" + state,
        success: function(result) {
            $("#zipCode").val(result);
        }
    });
    });
});