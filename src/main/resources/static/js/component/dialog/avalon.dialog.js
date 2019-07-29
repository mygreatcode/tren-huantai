// avalon 1.3.6
/**
 *
 * @cnName 瀵硅瘽妗�
 * @enName dialog
 * @introduce
 *    <p>dialog缁勪欢鎻愪緵寮圭獥鏄剧ず鎴栬€呴殣钘�,閫氳繃绠€鍗曢厤缃彲浠ユ按骞冲眳涓樉绀篸ialog寮圭獥锛屾缁勪欢鏀寔寮圭獥涓啀寮圭獥锛屼篃鍙互鐢ㄦ潵妯℃嫙alert鐨勮涓猴紝闈炲父鏂逛究</p>
 */
define([
    "avalon",
    "text!./avalon.dialog.html",
    "../button/avalon.button",
    "css!./avalon.dialog.css?2",
], function (avalon, template) {
    var _interface = function () {
    }
    var maskLayerExist = false // 椤甸潰涓嶅瓨鍦ㄩ伄缃╁眰灏辨坊鍔爉askLayer鑺傜偣锛屽瓨鍦ㄥ垯蹇界暐
    var maskLayer = avalon.parseHTML('<div class="oni-dialog-layout"></div>').firstChild
    var maskLayerShim //涓€涓猧frame,鐢ㄤ簬澶勭悊IE6select BUG
    var dialogShows = [] //瀛樺湪灞備笂灞傛椂鐢辨鏁扮粍鍒ゆ柇灞傜殑涓暟
    var dialogNum = 0 //淇濆瓨椤甸潰dialog鐨勬暟閲忥紝褰揹ialogNum涓�0鏃讹紝娓呴櫎maskLayer
    var isIE6 = document.document === 5 || (document.compatMode && !window.XMLHttpRequest)
    var root = document.documentElement
    avalon.component("ms:dialog", {
        $template: template,
        width: 480, //@config 璁剧疆dialog鐨剋idth
        title: "&nbsp;", //@config 璁剧疆寮圭獥鐨勬爣棰�
        draggable: false, //@config 璁剧疆dialog鏄惁鍙嫋鍔�
        type: "confirm", //@config 閰嶇疆寮圭獥鐨勭被鍨嬶紝鍙互閰嶇疆涓篴lert鏉ユā鎷熸祻瑙堝櫒
        content: "", //@config 閰嶇疆dialog鐨刢ontent锛岄粯璁ゅ彇dialog鐨刬nnerHTML浣滀负dialog鐨刢ontent锛屽鏋渋nnerHTML涓虹┖锛屽啀鍘诲彇content閰嶇疆椤�.闇€瑕佹敞鎰忕殑鏄細content鍙湪鍒濆鍖栭厤缃殑璧蜂綔鐢紝涔嬪悗闇€瑕侀€氳繃setContent鏉ュ姩鎬佺殑淇敼
        //@config閰嶇疆dialog鏄惁鏄剧ず"鍙栨秷"鎸夐挳锛屼絾鏄鏋渢ype涓篴lert锛屼笉璁簊howClose涓簍rue or false閮戒笉浼氭樉绀�"鍙栨秷"鎸夐挳
        showClose: false,
        maskClickClose:true,
        $skipArray: ["container", "widgetElement"],
        toggle: false, //@config 閫氳繃姝ゅ睘鎬х殑鍐冲畾dialog鐨勬樉绀烘垨鑰呴殣钘忕姸鎬�
        widgetElement: "", //@config 淇濆瓨瀵圭粦瀹氬厓绱犵殑寮曠敤
        container: "body", //@config dialog鍏冪礌鐨勪笂涓嬫枃鐖跺厓绱狅紝container蹇呴』鏄痙ialog瑕乤ppendTo鐨勭埗鍏冪礌鐨刬d鎴栬€呭厓绱燿om瀵硅薄
        confirmText: "纭畾", //@config 閰嶇疆dialog鐨�"纭畾"鎸夐挳鐨勬樉绀烘枃瀛�
        cancelText: "鍙栨秷", //@config 閰嶇疆dialog鐨�"鍙栨秷"鎸夐挳鐨勬樉绀烘枃瀛�
        position: isIE6 ? "absolute" : "fixed",
        buttonColor:'success',
        isReady:0,
        /**
         * @config {Function} 瀹氫箟鐐瑰嚮"纭畾"鎸夐挳鍚庣殑鍥炶皟鎿嶄綔
         * @param event {Number} 浜嬩欢瀵硅薄
         * @param vmodel {Object} 缁勪欢瀵瑰簲鐨刅model
         * @returns {Boolean} 濡傛灉return false锛宒ialog涓嶄細鍏抽棴锛岀敤浜庡紓姝ユ搷浣�
         */
        onConfirm: _interface,
        /**
         * @config {Function} 瀹氫箟鏄剧ずdialog鏃剁殑鍥炶皟
         * @param vmodel {Object} 缁勪欢瀵瑰簲鐨刅model
         */
        onOpen: _interface,
        /**
         * @config {Function} 瀹氫箟鐐瑰嚮"鍙栨秷"鎸夐挳鍚庣殑鍥炶皟鎿嶄綔
         * @param event {Object} 浜嬩欢瀵硅薄
         * @param vmodel {Object} 缁勪欢瀵瑰簲鐨刅model
         * @returns {Boolean} 濡傛灉return false锛宒ialog涓嶄細鍏抽棴锛岀敤浜庡紓姝ユ搷浣�
         */
        onCancel: _interface,
        /**
         * @config {Function} 瀹氫箟鐐瑰嚮"鍏抽棴"鎸夐挳鍚庣殑鍥炶皟鎿嶄綔
         * @param event {Object} 浜嬩欢瀵硅薄
         * @param vmodel {Object} 缁勪欢瀵瑰簲鐨刅model
         */
        onClose: _interface, //鐐瑰嚮鍙充笂瑙掔殑鈥滃叧闂€濇寜閽殑鍥炶皟
        //@config 鍔ㄦ€佷慨鏀筪ialog鐨則itle,涔熷彲閫氳繃dialogVM.title鐩存帴淇敼
        setTitle: _interface,
        setContent: _interface,
        _close: _interface,
        _open: _interface,
        _cancel: _interface,
        _confirm: _interface,
        /**
         * @config {Function} 閲嶆柊娓叉煋妯℃澘
         * @param m {Object} 閲嶆柊娓叉煋dialog鐨勯厤缃璞★紝鍖呮嫭title銆乧ontent銆乧ontent涓秹鍙婄殑鎻掑€艰〃杈惧紡锛岄渶瑕佹敞鎰忕殑鏄紝title鍜宑ontent涓嶆槸鐪熸娓叉煋鐨勫唴瀹癸紝鎵€浠ヤ笉闇€瑕乤valon杩涜鎵弿鐩戞帶锛屽畾涔夌殑鏃跺€欏繀椤诲湪鍏跺墠闈㈠姞涓�"$",鍚﹀垯缁勪欢涓嶄細娓叉煋鎴愭兂瑕佺殑鏁堟灉
         */
        setModel: _interface,
        $construct: function (a, b, c) {
            var options = avalon.mix(a, b, c)
            options.confirmText = options.confirmText || options.confirmName
            options.cancelText = options.cancelText || options.cancelName

            var $container = options.$container || options.container
            options.$container = $container && $container.nodeType === 1 ? $container : document.body

            // 濡傛灉鏄剧ず妯″紡涓篴lert鎴栬€呴厤缃簡showClose涓篺alse锛屼笉鏄剧ず鍏抽棴鎸夐挳
            options.showClose = options.type === "alert" ? false : options.showClose
            delete options.confirmName
            delete options.cancelName
            delete options.container
            return options
        },
        $init: function (vm, element) {
            dialogNum++
            var body = document.body
            var windowHeight = avalon(window).height()
            if (avalon(body).height() < windowHeight) {
                avalon(body).css("min-height", windowHeight)
            }
            vm.widgetElement = element


            avalon(element).addClass("oni-dialog")
            element.setAttribute("ms-visible", "toggle")
            element.setAttribute("ms-css-position", "position")
            element.setAttribute("ms-css-width", "width")
            // 褰撶獥鍙ｅ昂瀵稿彂鐢熷彉鍖栨椂閲嶆柊璋冩暣dialog鐨勪綅缃紝濮嬬粓浣垮叾姘村钩鍨傜洿灞呬腑
            element.resizeCallback = avalon(window).bind("resize", throttle(resetCenter, 50, 100, [vm, element]))
            element.scrollCallback = avalon(window).bind("scroll", throttle(resetCenter, 50, 100, [vm, element]))



            vm._open = function () {
                var len = 0 //褰撳墠鏄剧ず鐨刣ialog鐨勪釜鏁�
                var selectLength = document.getElementsByTagName("select").length

                avalon.Array.ensure(dialogShows, vm)
                len = dialogShows.length
                if (len && vm.modal) {
                    avalon(maskLayer).css("display", "block")
                }
                // 閫氳繃zIndex鐨勬彁鍗囨潵璋冩暣閬僵灞傦紝淇濊瘉灞備笂灞傚瓨鍦ㄦ椂閬僵灞傚缁堝湪椤跺眰dialog涓嬮潰(椤跺眰dialog zIndex-1)浣嗘槸鍦ㄥ叾浠杁ialog涓婇潰
                adjustZIndex(element,vm.zIndex)
                // root.style.overflow = "hidden"
                element.openScrollTop = root.scrollTop + body.scrollTop
                resetCenter(vm, element)
                // IE6涓嬮伄缃╁眰鏃犳硶瑕嗙洊select瑙ｅ喅鍔炴硶
                if (isIE6 && selectLength && maskLayerShim === null && vm.modal) {
                    maskLayerShim = createIframe()
                }
                if (maskLayerShim) {
                    element.parentNode.insertBefore(maskLayerShim, maskLayer)
                    var style = maskLayerShim.style
                    style.display = "block"
                    style.width = maskLayer.style.width
                    style.height = maskLayer.style.height
                    style.zIndex = maskLayer.style.zIndex
                }

                vm.onOpen.call(element, vm)
            }

            // 闅愯棌dialog
            vm._close = function () {
                if (vm.toggle === false)
                    return
                avalon.Array.remove(dialogShows, vm)
                var len = dialogShows.length
                var topShowDialog = len && dialogShows[len - 1]
                vm.toggle = false
                /* 澶勭悊灞備笂灞傜殑鎯呭喌锛屽洜涓簃askLayer鍏敤锛屾墍浠ラ渶瑕佸叾浠ュ皢瑕佹樉绀虹殑dialog鐨則oggle鐘舵€佷负鍑� */
                if (topShowDialog && topShowDialog.modal) {
                    var topElement = topShowDialog.widgetElement

                    adjustZIndex(topElement)
                    resetCenter(topShowDialog, topElement)
                    if (maskLayerShim) {
                        topShowDialog.$container.insertBefore(maskLayerShim, maskLayer)
                        maskLayerShim.style.zIndex = maskLayer.style.zIndex
                    }
                } else {
                    avalon(maskLayer).css("display", "none")
                    if (maskLayerShim && maskLayerShim.parentNode) {
                        maskLayerShim.parentNode.removeChild(maskLayerShim)
                        maskLayerShim = null
                    }
                }
                vm.onClose.call(element, vm)
            }

            // 鐐瑰嚮"鍙栨秷"鎸夐挳锛屾牴鎹洖璋冭繑鍥炲€兼槸鍚︿负false鍐冲畾鏄惁鍏抽棴dialog
            vm._cancel = function (e) {
                if (typeof vm.onCancel != "function") {
                    throw new Error("onCancel蹇呴』鏄竴涓洖璋冩柟娉�")
                }
                // 鍦ㄧ敤鎴峰洖璋冭繑鍥瀎alse鏃讹紝涓嶅叧闂脊绐�
                if (vm.onCancel.call(e.target, e, vm) !== false) {
                    vm._close(e)
                }
            }
            // 鐐瑰嚮纭畾鎸夐挳锛屾牴鎹洖璋冭繑鍥炲€兼槸鍚︿负false鍐冲畾鏄惁鍏抽棴寮圭獥
            vm._confirm = function (e) {
                if (typeof vm.onConfirm !== "function") {
                    throw new Error("onConfirm蹇呴』鏄竴涓洖璋冩柟娉�")
                }
                // 鍦ㄧ敤鎴峰洖璋冭繑鍥瀎alse鏃讹紝涓嶅叧闂脊绐�
                if (vm.onConfirm.call(e.target, e, vm) !== false) {
                    vm._close(e)
                }
            }
        },
        $dispose: function (vm, element) {
            dialogNum--
            element.innerHTML = ""
            avalon.unbind(window, "resize", element.resizeCallback)
            avalon.unbind(window, "scroll", element.scrollCallback)
            if (!dialogNum) {
                maskLayer.parentNode.removeChild(maskLayer)
                maskLayer.parentNode.removeChild(element)
                maskLayerExist = false
            }
        },
        $ready: function (vm, element) {

            resetCenter(vm, element)
            element.parentNode.insertBefore(maskLayer, element)
            avalon.bind(maskLayer,'click', function () {
                vm.maskClickClose&&vm._close();
            })
            adjustZIndex(element,vm.zIndex)

            vm.$watch("toggle", function (val) {
                if (val) {
                    vm._open()
                } else {
                    vm._close()
                }
            })
            vm.isReady++;


        },
        modal: true, //@config 鏄惁鏄剧ず閬僵
        zIndex: 10, //@config 閫氳繃璁剧疆vmodel鐨剒Index鏉ユ敼鍙榙ialog鐨剒-index,榛樿鏄痓ody鐩存帴瀛愬厓绱犱腑鐨勬渶澶-index鍊硷紝濡傛灉閮芥病鏈夎缃氨榛樿鐨勪负10
        zIndexIncrementGlobal: 1 //@config 鐩稿浜巣Index鐨勫閲�, 鐢ㄤ簬鍏ㄥ眬閰嶇疆锛屽鏋滃彧鏄綔鐢ㄤ簬鍗曚釜dialog閭ｄ箞zIndex鐨勯厤缃凡瓒冲锛岃缃叏灞€闇€瑕侀€氳繃avalon.ui.dialog.defaults.zIndexIncrementGlobal = Number鏉ヨ缃�
    })

    function adjustZIndex(elem,init) {
        init = init ||0;
        var nodes = elem.parentNode.children;
        var zindexes = []
        for (var i = 0, el; el = nodes[i++]; ) {
            if (el !== elem && el !== maskLayer) {
                zindexes.push(~~avalon.css(el, "zIndex"))
            }
        }

        var max = Math.max.apply(0, zindexes) +init;
        avalon(maskLayer).css("z-index", max + 1)
        avalon(elem).css("z-index", max + 2)
    }





// resize銆乻croll绛夐绻佽Е鍙戦〉闈㈠洖娴佺殑鎿嶄綔瑕佽繘琛屽嚱鏁拌妭娴�
    function throttle(fn, delay, mustRunDelay, args) {
        var timer = null
        var t_start
        return function () {
            var context = this, t_curr = +new Date()
            clearTimeout(timer)
            if (!t_start) {
                t_start = t_curr
            }
            if (t_curr - t_start >= mustRunDelay) {
                fn.apply(context, args)
                t_start = t_curr
            }
            else {
                timer = setTimeout(function () {
                    fn.apply(context, args)
                }, delay)
            }
        }
    }




    // 浣縟ialog濮嬬粓鍑虹幇鍦ㄨ绐椾腑闂�
    function resetCenter(vmodel, target) {


        if (!vmodel.toggle)
            return



        for (var i = 0, el; el = dialogShows[i++]; ) {
            el.widgetElement.style.display = "block"
        }

        var windowWidth = avalon(window).width()
        var windowHeight = avalon(window).height()
        var scrollTop = document.body.scrollTop + root.scrollTop
        var scrollLeft = document.body.scrollLeft + root.scrollLeft

        var dialogWidth = target.offsetWidth
        var dialogHeight = target.offsetHeight

        var top = Math.max((windowHeight - dialogHeight) / 2, 0)
        var left = Math.max((windowWidth - dialogWidth) / 2, 0)

        if(isIE6){
            avalon(maskLayer).css({
                height: windowHeight + scrollTop,
                width: windowWidth + scrollLeft,
                position: "absolute",
                overflow: "auto",
                top: scrollTop,
                left: 0
            })
        }

        if (maskLayerShim) {
            avalon(maskLayerShim).css({
                height: windowHeight + scrollTop,
                width: windowWidth + scrollLeft,
                top: scrollTop,
                left: 0
            })
        }
        var curTop = top
        if (dialogHeight > windowHeight) {//濡傛灉寮瑰嚭灞傜殑楂樺害澶т簬绐楀彛楂�,涓轰簡鑳界湅鍒板脊鍑哄眰鐨勫唴瀹�,闇€瑕侀€氳繃婊氬姩,涓婁笅绉诲姩寮瑰嚭灞�
            var curTop = top + target.openScrollTop - scrollTop

            var minTop = windowHeight - dialogHeight - 15
            if (curTop < minTop && minTop < 0) {
                curTop = minTop
            } else if (curTop > target.openScrollTop) {
                curTop = target.openScrollTop
            }
        }

        avalon(target).css({"top": curTop, "left": left})
    }



    function createIframe() {
        return document.createElement('<iframe src="javascript:\'\'" ' +
            'style="position:absolute;top:0;left:0;bottom:0;margin:0;padding:0;right:0;zoom:1;"></iframe>')

    }

    return avalon

})