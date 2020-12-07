//取消功能
$("#select_opacity").click(function () {
    $(this).css("display", "none");
    // 再带调用一下渲染
    window.location.href = "index.html";
})

//搜索功能,手指离开键盘时触发
$("#select").keyup(function () {
    // 显示取消键
    $("#select_opacity").css("display", "block");
    search()
});
//搜索功能,提交ajax数据到后台
function search() {
    var menu = "";
    var key = $("#select").val()
    var datas = {
        'name': key
    };
    $.ajax({
        url: 'http://localhost:8081/GymClassSelect',
        data: datas,
        type: 'POST',
        dataType: 'json',
        success: function (result, status) {
            if (status == "success" && result.length != 0) {
                menu += `<ul>`
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    menu += `
                    <li><img src="images/banner2.jpg" alt="" url="oneclass.html?id=${item.id}">
                    <div class="gymclass toface2" url="oneclass.html?id=${item.id}">
                        <label url="oneclass.html?id=${item.id}">${item.name}</label>
                        <div url="oneclass.html?id=${item.id}">
                            <span url="oneclass.html?id=${item.id}">k${item.difficulty}难度</span>
                            <span url="oneclass.html?id=${item.id}">课程1</span>
                        </div>
                    </div>
                </li>`
                })
                menu += `</ul>`
                $('.face1_body').html(menu) //显示数据，同时覆盖上一次搜索的数据
            }




        }
    });
}


$(function () {
    onaaa()
});


//页面渲染
function onaaa() {
    console.log($.ajax())
    $.ajax({
        url: "http://localhost:8081/GymClassSelect",
        //data: {"username":"aaa","age":22},//携带参数
        //data:"username=aaa&age=23",
        dataType: "json",
        type: "get",
        // cache: true,//true  缓存
        // async: true,// 异步  ， false 同步
        // contentType: "application/x-www/form-urlencoded",//application-json
        success: function (result, status) { //响应成功后回调
            if (status == "success" && result.length != 0) {
                var wrapper = "";
                var classlist = "";
                result.forEach(function (item) {
                    //字符串模板 拼接左侧选项菜单
                    if (item.state == 1) {
                        if (item.top == 1) {
                            wrapper += `
                        <div class="swiper-slide">
                         <img src="images/${item.img}" alt="" url="oneclass.html?id=${item.id}">
                        </div>`
                        }
                        classlist += `<li><img src="images/banner2.jpg" alt="" url="oneclass.html?id=${item.id}">
                    <div class="gymclass toface2" url="oneclass.html?id=${item.id}">
                        <label url="oneclass.html?id=${item.id}">${item.name}</label>
                        <div url="oneclass.html?id=${item.id}">
                            <span url="oneclass.html?id=${item.id}">k${item.difficulty}难度</span>
                            `
                        if (item.u_id != 0) {
                            classlist += `<span url="oneclass.html?id=${item.id}">线下</span>`
                        } else {
                            classlist += `<span url="oneclass.html?id=${item.id}">线上</span>`
                        }
                        classlist += `</div>
                            </div>
                            </li>`
                    }
                })
                $(".swiper-wrapper").html(wrapper);
                $(".face1_body ul").html(classlist);

                //轮播图      初始化
                var mySwiper = new Swiper('.swiper-container', {
                    // direction: 'vertical', // 垂直切换选项
                    loop: true, // 循环模式选项

                    // 如果需要分页器
                    pagination: {
                        el: '.swiper-pagination',
                    },

                    // 如果需要前进后退按钮
                    // navigation: {
                    //   nextEl: '.swiper-button-next',
                    //   prevEl: '.swiper-button-prev',
                    // },

                    // 如果需要滚动条
                    // scrollbar: {
                    //   el: '.swiper-scrollbar',
                    // },
                })

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