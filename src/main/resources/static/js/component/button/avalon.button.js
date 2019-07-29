define(["avalon","css!./oniui-common.css","css!./avalon.button.css"],function(avalon){var baseClasses=["oni-button","oni-widget","oni-state-default"]
    function createButton(element,options){var buttonText,buttonClasses=baseClasses.concat(),iconText=false,icons=options.icon,corner=options.corner
        element.tabIndex=-1
        if(corner){buttonClasses.push("oni-corner-all")
            if(corner=parseInt(corner)){element.style.borderRadius=corner+"px"}}
        if(options.size){buttonClasses.push("oni-button-"+options.size)}
        if(options.color){buttonClasses.push("oni-button-"+options.color)}
        if(options.disabled){buttonClasses.push("oni-state-disabled")}
        avalon(element).addClass(buttonClasses.join(" "))
        switch(options.type){case "text":buttonText="<span class='oni-button-text'>"+options.text+"</span>"
            break;case "labeledIcon":iconText=true
            case "icon":switch(options.iconPosition){case "left":buttonText="<i class='oni-icon oni-icon-left'>"+
                icons.replace(/\\/g,"")+"</i>"+
                "<span class='oni-button-text oni-button-text-right"
                +(!iconText?" oni-button-text-hidden":"")+"'>"+options.text+"</span>"
                break;case "right":buttonText="<span class='oni-button-text oni-button-text-left"+
                (!iconText?" oni-button-text-hidden":"")+"'>"+options.text+"</span>"
                +"<i class='oni-icon oni-icon-right'>"+icons.replace(/\\/g,"")+"</i>"
                break;case "left-right":var iconArr=icons&&icons.split("-")||["",""],iconLeft=iconArr[0],iconRight=iconArr[1]
                buttonText="<i class='oni-icon oni-icon-left'>"+
                    iconLeft.replace(/\\/g,"")+"&nbsp;</i>"+
                    "<span class='oni-button-text oni-button-text-middle"+
                    (!iconText?" oni-button-text-hidden":"")+"'>"+options.text+"</span>"+
                    "<i class='oni-icon oni-icon-right'>&nbsp;"+iconRight.replace(/\\/g,"")+"</i>"
                break;}
                break;}
        options.$$template=function(){return buttonText}}
    avalon.component("ms:button",{$init:function(options,element){element.label=options.label
            createButton(element,options)
            function stop(event){if(options.disabled){event.preventDefault()
                event.stopImmediatePropagation()}}
            var $element=avalon(element)
            var buttonWidth
            if(buttonWidth=parseInt(options.width)){element.style.width=buttonWidth+"px"}
            $element.bind("mousedown",function(event){stop(event)
                $element.addClass("oni-state-active")})
            $element.bind("mouseup",function(event){stop(event)
                $element.removeClass("oni-state-active")})
            $element.bind("blur",function(){$element.removeClass("oni-state-active")
                $element.removeClass("oni-state-focus")})
            $element.bind("focus",function(){$element.addClass("oni-state-focus")})},$ready:function(vm,element){if(element.label){vm.label=element.label}},$slot:"label",type:"text",iconPosition:"left",icon:"",size:"",color:"",corner:true,style:"",disabled:false,label:"",width:""})
    avalon.component("ms:buttonset",{data:[],$init:function(options,element){var data=options.data
            var buttons=""
            options.corner=typeof options.corner==="boolean"?options.corner:true
            data.forEach(function(button,index){var buttonStr="<ms:button"
                if(button.type!==void 0){buttonStr+=" type='"+button.type+"'"}
                if(button.iconPosition!==void 0){buttonStr+=" icon-position='"+button.iconPosition+"'"}
                if(button.icon!==void 0){buttonStr+=" icon='"+button.icon+"'"}
                if(button.color!==void 0){buttonStr+=" color='"+button.color+"'"}
                if(button.size!==void 0){buttonStr+=" size='"+button.size+"'"}
                if(button.disabled!==void 0){buttonStr+=" disabled='"+button.disabled+"'"}
                if(button.label!==void 0){buttonStr+=" label='"+button.label+"'"}
                buttonStr+=">"+(button.text||"")+"</ms:button>"
                buttons+=buttonStr})
            if(buttons){options.$$template=function(){return buttons}}else{options.$$template=false}},$buttons:[],monospace:true,direction:"",corner:void 0,width:NaN,$childReady:function(options,element,e){var button=e.target
            options.$buttons.push(button)
            var $button=avalon(button)
            $button.removeClass("oni-corner-all")
            if(options.$$template&&isFinite(options.width)){button.style.width=(~~options.width-
                parseInt($button.css("border-left-width"))-
                parseInt($button.css("border-right-width"))-
                parseInt($button.css("padding-left"))*2)+"px"}},$ready:function(options,element){var buttons=options.$buttons,elementClass=[],firstButtonClass="oni-corner-left",lastButtonClass="oni-corner-right",n=buttons.length,buttonsetCorner=options.corner,direction=options.direction,$element=avalon(element)
            elementClass.push("oni-buttonset")
            avalon(buttons[0]).addClass("oni-button-first")
            if(n&&buttonsetCorner){if(direction==="vertical"){firstButtonClass="oni-corner-top"
                lastButtonClass="oni-corner-bottom"}
                avalon(buttons[0]).addClass(firstButtonClass)
                avalon(buttons[n-1]).addClass(lastButtonClass)}
            if(direction==="vertical"){elementClass.push("oni-buttonset-vertical")}
            $element.addClass(elementClass.join(" "))
            if(options.monospace||direction==="vertical"){var widths=[]
                for(var i=0,button;button=buttons[i++];){widths.push(avalon(button).outerWidth()+1)}
                var maxWidth=Math.max.apply(Math,widths)
                for(i=0;button=buttons[i++];){var $button=avalon(button)
                    button.style.width=(maxWidth
                        -parseInt($button.css("border-left-width"))
                        -parseInt($button.css("border-right-width"))
                        -parseInt($button.css("padding-left"))*2)+"px"}}}})
    return avalon})