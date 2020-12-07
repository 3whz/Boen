// 	侧边栏的点击
$("#left").click(function (event) {
    var $target = $(event.target);
    //iframe跳转
    if ($target.hasClass("secitem")) { 
        //移除active                         
        $(".active").removeClass("active");
        $target.parent().addClass("active");//添加父元素节点的actice
        var $url = $target.attr("url");
        var $iframe = $("#iframe");
        $iframe.attr("src", $url);
    }
});

//退出登录
function outlogin(){
    $.removeCookie('admin', {
        path: '/'
    });
    window.location.href = "login.html"
    }

   