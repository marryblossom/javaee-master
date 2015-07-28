//$(function(){
//    $(document).on("click","a[name='cancel']",function(){
//        var userId = $(this).attr("value");
//        var tr = '#tr'+userId;
//        $.ajax({
//            type: "post",
//            dataType: "json",
//            url: "/web/userOperate/cancel?",
//            data: "userId=" + $(this).attr("value"),//"userId=" + $(this).attr("value")+$("form").serialize(),
//            success: function(result) {
//                var tr = '#tr'+result.userId;
//                appendMethod(tr,result);
//                },
//            error:function(result){
//                console.log("error"+result);
//            }
//        });
//    });
//
//    $(document).on("click","a[name='update']",function(){
//        var userId = $(this).attr("value");
//        var tr = '#tr'+userId;
//        $.ajax({
//            type: "post",
//            dataType: "json",
//            url: "/web/userOperate/update",
//            //data:"userId=" + $(this).attr("value")+$("form").serialize(),
//            data: "userId=" + $(this).attr("value")+"&userName="+$("input[name='userName']").val()+"&employeeName="+$("input[name='employeeName']").val()+"&gender="+$("input[name='gender']").val()+"&userIntroduction="+$("input[name='userIntroduction']").val()+"&userEmail="+$("input[name='userEmail']").val(),
//            success: function(result) {
//                var tr = '#tr'+result.userId;
//                appendMethod(tr,result);
//            },
//            error:function(result){
//                console.log("error"+result);
//            }
//        });
//    });
//
//    $(document).on("click","a[name='unlock']",function(){
//        var state = '#state'+$(this).attr("value");
//        $.ajax({
//            type: "get",
//            url: "/web/userOperate/unlock?",
//            data: "userId=" + $(this).attr("value"),
//            success: function(result) {
//                $(state).empty();
//                $(state).append(result);
//            },
//            error:function(result){
//                console.log("error"+result);
//            }
//        });
//    });
//
//    $(document).on("click","a[name='delete']",function(){
//        var state = '#state'+$(this).attr("value");
//        $.ajax({
//            type: "get",
//            url: "/web/userOperate/delete?",
//            data: "userId=" + $(this).attr("value"),
//            success: function(result) {
//                $(state).empty();
//                $(state).append(result);
//            },
//            error:function(result){
//                console.log("error"+result);
//            }
//        });
//    });
//    $(document).on("click","a[name='goToUpdate']",function(){
//        $.ajax({
//            type: "post",
//            dataType: "json",
//            url: "/web/userOperate/goToUpdate?",
//            data: "userId=" + $(this).attr("value"),
//            success: function(result) {
//                var tr = '#tr'+result.userId;
//                appendUpdateMethod(tr,result);
//                },
//            error:function(result){
//                console.log("error"+result);
//            }
//        });
//    });
//
//});
//function appendMethod(tr,result){
//    $(tr).empty();
//    $(tr).append("<td align='center'><div class='th-inner'>"+result.userName+"</div></td>");
//    //$(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.employeeName+"</div></td>");
//    //$(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.gender+"</div></td>");
//    //$(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.email+"</div></td>");
//    //$(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.introduction+"</div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.userState+"</div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.userType+"</div></td>");
//    $(tr).append("<td align='center'><div class='th-inner'><a name='unlock' class='btn user unlock' type='button' value='"+result.userId+"'>unlock</a></div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\"><a name='delete' class='btn user delete' type='button' value='" +result.userId+"'>delete</a></div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\"><a name='goToUpdate' class='btn user goToUpdate' type='button' value='" +result.userId+"'>update</a></div></td>");
//
//}
//function appendUpdateMethod(tr,result){
//    $(tr).empty();
//    $(tr).append("<td align='center'><div class='th-inner'><input  name='userName' class='input-insert' type='text' value='"+result.userName+"'></div></td>");
//    $(tr).append("<td align='center'><div class='th-inner'><input name='employeeName' class='input-insert' type='text' value='"+result.employeeName+"'></div></td>");
//    if(result.gender == "female"){
//        $(tr).append("<td align='center'><div class='th-inner'><input name='gender' class='input-insert' type='radio' value='female' checked> female" +
//        "<input name='gender' class='input-insert' type='radio' value='male'>male</div></td>");
//    }else{
//        $(tr).append("<td align='center'><div class='th-inner'><input name='gender' class='input-insert' type='radio' value='female'> female" +
//        "<input name='gender' class='input-insert' type='radio' value='male' checked>male</div></td>");
//    }
//    $(tr).append("<td align='center'><div class='th-inner'><input name='userEmail' class='input-insert' type='text' value='"+result.email+"'></div></td>");
//    $(tr).append("<td align='center'><div class='th-inner'><input name='userIntroduction' class='input-insert' type='text' value='"+result.introduction+"'></div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.userState+"</div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\">"+result.userType+"</div></td>");
//    $(tr).append("<td align='center'><div class='th-inner'><a name='update' class='btn user update' type='button' value='"+result.userId+"'>submit</a></div></td>");
//    $(tr).append("<td align=\"center\"><div class=\"th-inner\"><a name='cancel' class='btn user notUpdate' type='button' value='" +result.userId+"'>cancel</a></div></td>");
//
//}
