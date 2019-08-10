$(function () {
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        $("iframe").attr("src","../user/register");
        //监听导航点击
        element.on('nav(demo)', function(elem){

            //console.log(elem)
            layer.msg(elem.text());
        });
    });
});
function myclick(e) {
    var   index=$(e).attr("tabindex");
    alert(index)
}
