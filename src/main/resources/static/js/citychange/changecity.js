var provinceList = {
    "昆明市":"K","曲靖市":"Q","大理州":"D","红河州":"H","玉溪市":"Y",
    "丽江市":"L","文山州":"W","楚雄州":"C","西双版纳州":"X","昭通市":"Z",
    "德宏州":"D","普洱市":"P","保山市":"B","临沧市":"L","迪庆州":"D",
    "怒江州":"N"
    //"B","C","D","H","K","L","N","P","Q","W","X","Y","Z"昆明市 曲靖市 玉溪市 保山市 昭通市 丽江市 普洱市 临沧市 楚雄彝族自治州 红河哈尼族彝族自治州 文山壮族苗族自治州 西双版纳傣族自治州 大理白族自治州 德宏傣族景颇族自治州 怒江傈僳族自治州 迪庆藏族自治州
}
var independentCityList = {
    "麒麟区":"ql|1010",
    "会泽县":"hz|1018",
    "官渡区":"gd|0013",
    "五华区":"wh|0011"
}
var cityList = {
    "昆明市":{
        "呈贡区":"cg|0010","五华区":"wh|0011","盘龙区":"pl|0012","官渡区":"gd|0013","西山区":"xs|0014",
        "东川区":"dc|0015","晋宁区":"jn|0016","安宁市":"an|0017","富民县":"fm|0018","宜良县":"yl|0019",
        "嵩明县":"sm|0020", "石林彝族自治县":"sl|0021","禄劝苗族自治县":"lq|0022","寻甸回族彝族自治县":"xd|0023"
// 五华区 盘龙区 官渡区 西山区 东川区 呈贡区 晋宁县 富民县 宜良县 石林彝族自治县 嵩明县 禄劝彝族苗族自治县 寻甸回族彝族自治县 安宁市
    },
    "曲靖市":{
        "麒麟区":"ql|1010","沾益区":"zy|1011","马龙区":"ml|1012","宣威市":"xw|1013"
        ,"陆良县":"ll|1014","师宗县":"sz|1015","罗平县":"lp|1016","富源县":"fy|1017","会泽县":"hz|1018"
    }
,"大理州":{
        "大理市":"dl|2010","漾濞彝族自治县":"yb|2011","祥云县":"xy|2012",
        "宾川县":"bc|2013","弥渡县":"md|2014","南涧彝族自治县":"nj|2015",
        "巍山彝族回族自治县":"ws|2016","永平县":"yp|2017","云龙县":"yl|2018",
        "洱源县":"ey|2019","剑川县":"jc|2020","鹤庆县":"hh|2021"
// 大理市 漾濞彝族自治县 祥云县 宾川县 弥渡县 南涧彝族自治县 巍山彝族回族自治县 永平县 云龙县 洱源县 剑川县 鹤庆县
    },
"红河州":{
    "个旧市":"gj|3010","开远市":"ky|3011","蒙自市":"mz|3012","弥勒市":"ml|3013",
    "屏边苗族自治县":"pb|3014","建水县":"js|3015","石屏县":"sp|3016","泸西县":"lx|3017",
    "元阳县":"yy|3018","红河县":"hh|3019","金平苗族瑶族傣族自治县":"jp|3020","绿春县":"lc|3021",
    "河口瑶族自治县":"hk|3022"
    //个旧市 开远市 蒙自市 弥勒市 屏边苗族自治县 建水县 石屏县 泸西县 元阳县 红河县 金平苗族瑶族傣族自治县 绿春县 河口瑶族自治县
},
"玉溪市":{
    "红塔区":"ht|4010","江川县":"jc|4011","澄江县":"cj|4012",
    "通海县":"th|4013","华宁县":"hn|4014","易门县":"ym|4015",
    "峨山彝族自治县":"es|4016","新平彝族傣族自治县":"xp|4017",
    "元江哈尼族彝族傣族自治县":"yj|4018"
        //红塔区 江川县 澄江县 通海县 华宁县 易门县 峨山彝族自治县 新平彝族傣族自治县 元江哈尼族彝族傣族自治县
}, "丽江市":{
        "古城区":"gc|5010" ,"玉龙纳西族自治县":"yl|5011", "永胜县":"ys|5012", "华坪县":"hp|5013", "宁蒗彝族自治县":"nl|5014"
    },
    "文山州":{
        "文山市":"ws|6010","砚山县":"ys|6011", "西畴县":"xc|6012", "麻栗坡县":"ml|6013", "马关县":"mg|6014",
        "丘北县":"bq|6015",
        "广南县":"gn|6016","富宁县" :"fn|6017"
    }
    ,"楚雄州":{
    "楚雄市":"cx|7010","双柏县":"sb|7011",
    "牟定县":"md|7012","南华县":"nh|7013",
    "姚安县":"ya|7014","大姚县":"dy|7015",
    "永仁县":"yr|7016","元谋县":"ym|7018",
    "武定县":"wd|7019","禄丰县":"lf|7020"
        // 楚雄市 双柏县 牟定县 南华县 姚安县 大姚县 永仁县 元谋县 武定县 禄丰县
    },
    "西双版纳州":{
        "景洪市":"jh|8010","勐海县":"mh|8011","勐腊县":"ml|8012"
// 景洪市 勐海县 勐腊县
    },
    "昭通市":{
        "昭阳区":"zy|9010","鲁甸县":"ld|9011","巧家县":"qj|9012","盐津县":"yj|9013",
        "大关县":"dg|9014","永善县":"ys|9015","绥江县":"tj|9016","镇雄县":"zx|9017",
        "彝良县":"yl|9018","威信县":"wx|9019", "水富县":"sf|9020"
    },
    "德宏州":{
        "瑞丽市":"rl|1110", "芒市":"ms|1111", "梁河县":"lh|1112", "盈江县":"yj|1113", "陇川县":"lc|1114"
    },
    "普洱市":{
        "思茅区":"sm|1210" ,"宁洱哈尼族彝族自治县":"ne|1211" ,"墨江哈尼族自治县":"mj|1212" ,"景东彝族自治县":"jd|1213",
        "景谷傣族彝族自治县":"jg|1214" ,"镇沅彝族哈尼族拉祜族自治县":"zy|1215", "江城哈尼族彝族自治县":"jc|1216"
        ,"孟连傣族拉祜族佤族自治县":"ml|1217", "澜沧拉祜族自治县":"lc|1218" ,"西盟佤族自治县":"mc|1219"
    },
    "保山市":{
        "隆阳区":"ly|1310", "施甸县":"sd|1311", "腾冲县":"tc|1312", "龙陵县":"ll|1313", "昌宁县":"cn|1314"
    },
    "临沧市":{
        "临翔区":"lx|1410", "凤庆县":"fq|1411" ,"云县":"yx|1412", "永德县":"yd|1413",
        "镇康县":"zk|1414", "双江拉祜族佤族布朗族傣族自治县":"sj|1415",
        "耿马傣族佤族自治县":"gm|1416" ,"沧源佤族自治县":"cy|1417"
    },
    "迪庆州":{
        "香格里拉县":"xg|1510", "德钦县":"dq|1511", "维西傈僳族自治县":"1512"
    },
    "怒江州":{
        "泸水县":"ls|1610" ,"福贡县":"fg|1611", "贡山独龙族怒族自治县":"gs|1612", "兰坪白族普米族自治县":"lp|1613"
    }
}
$(function(){

    $qrcode=$("#header-qrcode");  //二维码图片
    $headerLayer=$("#header-layer");//头部隐藏二维码图片
    $footerLayer=$("#footer-layer");//底部隐藏二维码图片
    $headerBtn=$("#header-tongzhen-btn");//头部按钮
    $footerBTN=$("#footer-tongzhen-btn");//底部按钮
    /**
     * 显示和隐藏二维码
     */
    $headerBtn.on("click",function(){event.stopPropagation();clickLog("pccitytown");
        $qrcode.toggle();
        $headerLayer.toggle()
    });
    /**
     *点击+关注按钮事件（显示和隐藏二维码）
     */
    $footerBTN.on("click",function(){
        event.stopPropagation();
        clickLog("pccitytown");
        $footerLayer.toggle()
    });
    /**
     *点击body按钮事件（显示和隐藏二维码）
     */
    $("body").on("click",function(event){
        $qrcode.show();
        $headerLayer.hide();
        $footerLayer.hide()});

    /**
     *设置省份下拉选择器
     * @param id
     * @param data
     * @param tag
     */
    function makeSelector(id,data,tag){
        var $selector=$("#"+id);
      // alert("打印id:"+id+"打印data:"+data+"打印data:"+tag);
        // id:selector-province
        // data:[object Object]
        // tag:undefined
        var $result=$("#"+id+"-result");
        var $options=$("#"+id+"-box");
        var $arrow=$("#"+id+"-arrow");
        $selector.off("click");      //off() 方法通常用于移除通过 on() 方法添加的事件处理程序。
        if(tag){
            $result.html("城市")
        }
        $options.empty();//empty() 方法从被选元素移除所有内容，包括所有文本和子节点。
        $options.css("max-height",15*30+"px");

        for(key in data){

            if(data.hasOwnProperty(key))//判断一个对象是否有你给出名称的属性或对象。
            {
                $options.append($('<li class="selector-list" data-city="'+data[key]+'">'+key+"</li>")) //添加下拉列表数据
            }
        }
        /**
         * 选择省份
         */
        $selector.on("click",function(event){
            event.preventDefault();
            for(var i=0;i<$(".selector-box").length;i++)
            {
                if($(".selector-box")[i]!=$options[0]){
                $(".selector-box").eq(i).hide()
                }
            }
            $options.toggle();
            $arrow.toggleClass("selector-arrow-up")
        });

        /**
         * 选择城市
         */
        $selector.on("click",".selector-list",function(event){
            event.preventDefault();
            $result.html(event.target.innerHTML);

            if(tag=="city")
            {
                var address="";
                if(catepath=="post")
                {
                    address="../changecity.com?city="+event.target.innerHTML+"&citycode="+event.target.dataset["city"].split("|")[1];;//"//post.58.com/"+event.target.dataset["city"].split("|")[1]+"/"
                } else{
                  address="../changecity.com?city="+event.target.innerHTML+"&citycode="+event.target.dataset["city"].split("|")[1];//"+event.target.dataset["city"].split("|")[0]+".58.com/"+catepath
                }
                window.location.href=address//跳转城市
                alert("打印："+address)
            }else{
                    makeSelector("selector-city",cityList[event.target.innerHTML],"city")
                   }
        });
              $("body").eq(0).on("click",function(event){
            if(event.target.className.indexOf("selector")==-1)
            {
                $options.hide();
                $arrow.removeClass("selector-arrow-up")
            }
              })
    }

    /**
     * 按字母排列城市名
     */
    function makeCityList()
    {
        var $contentBox=$("#content-box");
        var list=["B","C","D","H","K","L","N","P","Q","W","X","Y","Z"];
        for(var i=0;i<list.length;i++)
        {
            var $contentLetter=$('<div class="content-letter"><span class="content-letter-panel">'+list[i]+"</span></div>");
            $contentBox.append($contentLetter);
            for(var provinceName in provinceList){
                if(provinceList[provinceName]==list[i]){
                    var $contentProvince=$('<div class="content-province">' +
                        '<span class="content-province-triangle"></span>' +
                        '<div class="content-province-title">'+provinceName+"</div>" +
                        "</div>");
                    var $contentCities=$('<div class="content-cities"></div>');
                    var address="";
                    for(var cityName in cityList[provinceName]){
                        if(catepath=="post"){
                            address=""
                        }else
                            {
                              // alert(cityList[provinceName][cityName].split("|")[1])
                                address="../changecity.com?city="+cityName+"&citycode="+cityList[provinceName][cityName].split("|")[1];
//cityList[province][cityName].split("|")[1]
                            }
                        $contentCities.append($('<a href="'+address+'" class="content-city">'+cityName+"</a>"))}
                          $contentProvince.append($contentCities);$contentLetter.append($contentProvince)}}}
        if(catepath=="post"){
            //     "麒麟区":"ql|1010",
            //     "会泽县":"hz|1018",
            //     "官渡区":"gd|0013",
            //     "五华区":"wh|0011"
            $("#hot").append($('' +
                '<a href="" class="hot-city">麒麟区</a><a href="" class="hot-city">会泽县</a><' +
                'a href="" class="hot-city">官渡区</a><a href="" class="hot-city">五华区</a>'))}
        else{
            $("#hot").append($('' + '<a href="" class="hot-city">麒麟区</a><a href="" class="hot-city">会泽县</a><' +
                'a href="" class="hot-city">官渡区</a><a href="" class="hot-city">五华区</a>'
            ))
        }
    }



        var search=window.location.search.replace("?","").split("&");

        var arg=[];
        window.catepath="";
        window.searchpath="";
        var catename="";
        for(var i=0; i<search.length;i++)
        {
            arg[search[i].split("=")[0]]=search[i].split("=")[1]
        }
        for(key in arg){
            if(key=="catepath"&&arg[key]!=""){
                if(arg[key].indexOf(".shtml")>0){catepath=arg[key]}
                else if(arg[key].indexOf("post")==0){catepath="post"}
                else{catepath=arg[key]+"/"}searchpath=arg[key]}
            else if(key=="catename"&&arg[key]!=""){catename=decodeURIComponent(arg[key])}
            else if(key=="fullpath"){window.fullpath=arg[key]}}
        makeSelector("selector-province",provinceList);
        makeCityList();
            var $panels=$(".content-letter-panel");
            var $letters=$(".content-letter");
            var $provinceTitles=$(".content-province-title");
            var $provinceTriangle=$(".content-province-triangle");
            var $provinces=$(".content-province");
            $provinces.each(function(index,el){$provinceTitles.eq(index).css("height",$(el).css("height"));
            $(el).on("mouseover",function(event){$provinceTriangle.eq(index).addClass("content-province-triangle-hover");
            $(el).addClass("content-province-hover")});
            $(el).on("mouseout",function(event){$provinceTriangle.eq(index).removeClass("content-province-triangle-hover");
            $(el).removeClass("content-province-hover")})});

            $letters.each(function(index,el){$panels.eq(index).css({height:$(el).css("height"),"line-height":$(el).css("height")});
            $(el).on("mouseover",function(event){$panels.eq(index).addClass("content-letter-panle-hover")});
            $(el).on("mouseout",function(event){$panels.eq(index).removeClass("content-letter-panle-hover")})});

            $("#selector-search-input").on("keydown",function(event){if(event.keyCode==13){
                $("#selector-search-btn").click()}});

            $("#selector-search-btn").on("click",function(event){goCity(document.getElementById("selector-search-input").value,searchpath)});
            var HD=window.devicePixelRatio;
            if(HD>1){$("#header").addClass("header-HD");$("#logo").addClass("logo-HD");$("#bangbang").addClass("bangbang-HD");
            $("#header-qrcode").addClass("header-qrcode-HD");$("#header-tongzhen-btn").addClass("header-tongzhen-btn-HD");
            $("#footer-tongzhen-bangbang").addClass("footer-tongzhen-bangbang-HD");
            $("#footer-tongzhen-btn").addClass("footer-tongzhen-btn-HD");
            $(".tongzhen-iphone").addClass("tongzhen-iphone-HD");
            $(".tongzhen-qrcode").addClass("tongzhen-qrcode-HD");
            $(".selector-arrow").addClass("selector-arrow-HD");
            $(".content-province-triangle").addClass("content-province-triangle-HD")}

            $.ajax({url:"//www.58.com/ipscript.aspx",type:"get",dataType:"xml",complete:function(result){
                var city="bj";
            if(result.status==200){
                city=result.responseText.split("//")[1].split(".58.com")[0]}
                var cityname="北京";
            for(var province in cityList){
                for(var cityn in cityList[province]){
                    if(cityList[province][cityn].split("|")[0]==city){
                        cityname=cityn;console.log(1);
                        break}
                }
            }
            if(catename!=""&&catepath!=""){$("#header-home-title").html(cityname+catename)
            } else{$("#header-home-title").html(cityname+"58同城")}
            $("#header-home-btn").on("click",function(event){
                var address="";
            if(catepath=="post"){
                switch(city){
                    case"bj":address="//post.58.com/1/";break;
                    case"tj":address="//post.58.com/18/";break;
                    case"sh":address="//post.58.com/2/";break;
                    case"cq":address="//post.58.com/37/";break;
                    default:address="//post.58.com/"+cityList[province][cityname].split("|")[1]+"/"}}
            else{address="//"+city+".58.com/"+catepath}
            window.location.href=address
            });
            $.ajax({url:"//api.58.com/comm/nearCities-"+city,type:"get",dataType:"jsonp",jsonpCallback:"nearcity",data:{api_callback:"nearcity"}})}})});

/**
 * 附近的城市
 * @param data
 */
function nearcity(data){$("#header-recommend").html("周边城市推荐:&nbsp;");
if(catepath=="post")
{
    for(var i=0; i<data.length;i++)
    {$("#header-recommend").append($('<a href="//post.58.com/'+data[i].cityid+'/" class="recommend-city">'+data[i].name+"</a>"))}
} else{
    for(var i=0;i<data.length;i++){
        $("#header-recommend").append($('<a href="//'+data[i].city+".58.com/"+catepath+'" class="recommend-city">'+data[i].name+"</a>"))}}}

var _trackURL="{'cate':'"+window.fullpath+"','area':'','pagetype':'changecity','page':''}";