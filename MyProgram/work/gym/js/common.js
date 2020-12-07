//切换页面200%
$("#face1_face2").click(function (event) {
    var $target = $(event.target);
        var $url = $target.attr("url");
        if($url != null){
        var $iframe = $("#iframe");
        $iframe.attr("src", $url);
        // 切换
        $(".wrapper_face").css({
            "margin-left": "-100%",
            "transition": "all .3s"
        })
    }
});
$("#face2_face1").click(function () {
    $(".wrapper_face").css({
        "margin-left": "0%",
        "transition": "all .3s"
    })
});
//设置高度
//结构高度计算
$("#wrapper_face").css("height", $(window).height())
window.onresize = function () {
    $("#wrapper_face").css("height", $(window).height() + "px")
}