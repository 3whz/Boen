// 轮播图
var mySwiper = new Swiper('.swiper-container', {
    // slidesPerView: 2,
    // slidesPerView : 'auto',  //  根据slide的宽度自动调整展示数量。此时需要设置slide的宽度，如下style所示
    //slidesPerView : 3.7,
    slidesPerView: 2.7,
    observer: true, //修改swiper自己或子元素时，自动初始化swiper
    observeParents: true //修改swiper的父元素时，自动初始化swiper
})
//页面加载时执行

$(function () {
    ondrawing()
    onwrapper()
});

//全部课程页面渲染
function ondrawing() {
    var usera = $.cookie('user');
    //反序列化对象数组
    var user = JSON.parse(usera);
    var u_id = user[0].id

    $.ajax({
        url: "http://localhost:8081/GymClassByUIdSelect",
        data: {
            "id": u_id
        }, //携带参数
        //data:"username=aaa&age=23",
        dataType: "json",
        type: "get",
        // cache: true,//true  缓存
        // async: true,// 异步  ， false 同步
        // contentType: "application/x-www/form-urlencoded",//application-json
        success: function (result, status) { //响应成功后回调
            if (status == "success" && result.length != 0) {
                var classlist = "";
                var wrapper = "";
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    if (item.state == 1) {
                        if (item.u_id != 0) {
                            classlist += `<li class="ondrawingon">
                        <div url="oneclass.html?id=${item.id}">${item.name}
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-favorites-fill"></use>
                            </svg></div>
                        <i url="404.html">删除</i>
                        </li>`
                        } else {
                            classlist += `<li class="ondrawingbotton">
                        <div url="oneclass.html?id=${item.id}">${item.name}
                        <svg class="icon" aria-hidden="true">
                            <use xlink:href="#icon-bussiness-man"></use>
                            </svg></div>
                        <i url="404.html">删除</i>
                        </li>`
                        }

                    }
                })
                $(".face1_body .list ul").html(classlist);

                //侧滑显示删除按钮
                var expansion = null; //是否存在展开的list
                var container = document.querySelectorAll('.list ul li');
                for (var i = 0; i < container.length; i++) {
                    var x, y, X, Y, swipeX, swipeY;
                    container[i].addEventListener('touchstart', function (event) {
                        x = event.changedTouches[0].pageX;
                        y = event.changedTouches[0].pageY;
                        swipeX = true;
                        swipeY = true;
                        if (expansion) { //判断是否展开，如果展开则收起
                            expansion.className = "";
                        }
                    });
                    container[i].addEventListener('touchmove', function (event) {

                        X = event.changedTouches[0].pageX;
                        Y = event.changedTouches[0].pageY;
                        // 左右滑动
                        if (swipeX && Math.abs(X - x) - Math.abs(Y - y) > 0) {
                            // 阻止事件冒泡
                            event.stopPropagation();
                            if (X - x > 10) { //右滑
                                event.preventDefault();
                                this.className = ""; //右滑收起
                            }
                            if (x - X > 10) { //左滑
                                event.preventDefault();
                                this.className = "swipeleft"; //左滑展开
                                expansion = this;
                            }
                            swipeY = false;
                        }
                        // 上下滑动
                        if (swipeY && Math.abs(X - x) - Math.abs(Y - y) < 0) {
                            swipeX = false;
                        }
                    });
                }
            } else {
                console.log("暂无数据")
            }
        },
        //fail
        error: function () {
            alert("出错了")
        }
    });
};



//切换
$("#face1_body_top").click(function (event) {
    var $target = $(event.target);
    $(".li_on").removeClass("li_on");
    $target.addClass("li_on");
});

function ondrawingonbotton() {
    $(".ondrawingon").css("display", "flex")
    $(".ondrawingbotton").css("display", "flex")
}

function ondrawingon() {
    $(".ondrawingon").css("display", "flex")
    $(".ondrawingbotton").css("display", "none")
}

function ondrawingbotton() {
    $(".ondrawingon").css("display", "none")
    $(".ondrawingbotton").css("display", "flex")
}



//轮播图部分渲染
function onwrapper() {
    $.ajax({
        url: "http://localhost:8081/GymClassSelect",
        //data: {"id":u_id},//携带参数
        //data:"username=aaa&age=23",
        dataType: "json",
        type: "get",
        // cache: true,//true  缓存
        // async: true,// 异步  ， false 同步
        // contentType: "application/x-www/form-urlencoded",//application-json
        success: function (result, status) { //响应成功后回调
            if (status == "success" && result.length != 0) {
                var classlist = "";
                var wrapper = "";
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    if (item.state == 1) {
                        if (item.difficulty == 2) {
                            wrapper += `
                        <div class="swiper-slide"><img src="images/${item.img}" alt="" url="oneclass.html?id=${item.id}"></div>
                           `
                        }
                    }
                })
                $(".swiper-container .swiper-wrapper").html(wrapper);

            } else {
                console.log("暂无数据")
            }
        },
        //fail
        error: function () {
            alert("出错了")
        }
    });
};