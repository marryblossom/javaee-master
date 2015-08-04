$(function() {
    $("#serialization").on("click", function (event) {
        event.preventDefault();
        var object = $.param({username: $("#userName").val(), employeename: $("#employeeName").val()});
        $.ajax({
            type: "POST",
            //dataType: "json",
            url: "/web/xmlTest/xml",
            //data: $("form").serialize(),
            data: $("form").serializeArray(),
            //contentType:"json",
            //data: object,
            //data:{"data": decodeURIComponent($.param({ a: { b: 1, c: 2 }, d: [ 3, 4, { e: 5 } ]}))},
            success: function (result) {
                console.log("success" + result);
                $("#success").show()
            },
            error: function (result) {
                console.log("error" + result);
            }
        });
    });
});
