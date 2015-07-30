//$(document).on("click","a[name='unlock']",function(){
//    var state = '#state'+$(this).attr("value");
//    $.ajax({
//        type: "get",
//        url: "/web/courseOperate/unlockCourse?",
//        data: "courseId=" + $(this).attr("value"),
//        success: function(result) {
//            $(state).empty();
//            $(state).append(result);
//        },
//        error:function(result){
//            console.log("error"+result);
//        }
//    });
//});
//
//$(document).on("click","a[name='delete']",function(){
//    var state = '#state'+$(this).attr("value");
//    $.ajax({
//        type: "get",
//        url: "/web/courseOperate/deleteCourse?",
//        data: "courseId=" + $(this).attr("value"),
//        success: function(result) {
//            $(state).empty();
//            $(state).append(result);
//        },
//        error:function(result){
//            console.log("error"+result);
//        }
//    });
//});