var index="0";
function mytitleclick(e){
    index=$(e).attr("tabindex");
    init(index)

}
function init(s){
    var hintplace="请输入新房源信息"
    var table= $("#titlebox");
    table.children().eq(0).children().eq(1).children().eq(s).eq(0).removeClass("hint").siblings().addClass("hint")
switch (s) {
    case "0":
        hintplace="请输入新房源信息";
        break;
    case "1":
        hintplace="请输入小区信息";
        break;
    case "2":
        hintplace="请输入二手房源信息";
        break;
    case "3":
        hintplace="请输入出租房源信息";
        break;
}
    $(".nice-select").find("ul").hide();
$(".put").attr("placeholder",hintplace)
}

var actionurl=""
function searchsubmitclick(e){

    switch (index) {
          case "0":
              actionurl="";
          break;
          case "1":
              actionurl="";
          break;
          case "2":
              actionurl="";
          break;
          case "3":
              actionurl="";
          break;

    }

   $("#search_form").attr("action",actionurl).submit();
}
// input 点击事件
$(document).on('click','.nice-select',function(e){
    $(".nice-select").find("ul").hide();// 让ul隐藏（当你一个页面多个这样的输入框时你就会用到）
    $(".nice-select ul li").show();// 列表展示
    $(this).find('ul').show();// 当前子节点显示
    e.stopPropagation();// 阻止事件冒泡
})

$(document).on('input','#searchinput',function(){
    var keywords = $(this).val();
    var count = 0;
    if (keywords != "") {
        $(".nice-select ul li").each(function(i) {
            var contentValue = $(this).text();
            if(contentValue.toLowerCase().indexOf(keywords.toLowerCase()) < 0) {
                $(this).hide();
                count++;
            } else {
                $(this).show();
            }
            if (count == (i + 1)) {
                $(this).parent().find("ul").hide();
                // $(".nice-select").find("ul").hide();
            } else {
                $(this).parent().find("ul").show();
                // $(".nice-select").find("ul").show();
            }
        });
    } else {
        $(".nice-select ul li").each(function(i) {
            $(this).show();
        });
    }
});
// 点击页面的任何一点让input列表隐藏
$(document).click(function(){
    $(".nice-select").find("ul").hide();
});


var val= $(".put").val()
$(function(){
    init(index)

});