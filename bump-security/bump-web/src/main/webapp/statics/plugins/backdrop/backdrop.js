/**
 * 遮罩组件
 * 汤松山 2015-9-10.
 */
(function($){

    //创建进度条的Dom
    function createProgress(options){
        //用Bootstrap的格式构造一个进度条Dom
        var progressDiv = $("<div />").addClass("progress progress-striped active")
            .css({
                "width":options.progressWidth+"px",
                //"height":"28px",
                "position":"absolute",
                "top": "50%",
                "left": "50%",
                "margin": "-14px 0 0 -"+(options.progressWidth/2)+"px",
                "z-index": options.zIndex+1
            });
        var progressBar = $("<div />")
            .attr({
                "role":"progressbar",
                "aria-valuenow":options.progressValue,
                "aria-valuemin":0,
                "aria-valuemax":100})
            .css("width",options.progressValue+'%')
            .addClass("progress-bar")
            .addClass("progress-bar-success")
            .appendTo(progressDiv);
        var titleSpan = $("<span />")
            .addClass("sr-only")
            .html(options.progressValue+"%")
            .appendTo(progressBar);

        return progressDiv;
    }

    //动态改变进度条的值
    function _setProgressValue(progress,val){
        var progressBar = $("div[role='progressbar']",progress);
        var titleSpan = $("span",progressBar);
        if(val) {
            progressBar.parent().attr("data-percent", val + "%");
            progressBar.attr("aria-valuenow", val);
            progressBar.css("width", val + '%');
            titleSpan.html(val + "%");
        }else{
            //如果未传入val则以100%显示且不显示文本
            progressBar.parent().removeAttr("data-percent");
            progressBar.attr("aria-valuenow", 100);
            progressBar.css("width", 100 + '%');
            titleSpan.html(100 + "%");
        }
    }

    //初始化Dom结构
    function init(target,options){
        var $this = target;
        var panel = $('<div />');
        var progress = createProgress(options);
        progress.appendTo(panel);

        //是否隐藏进度条
        if(options.progress==false){
            progress.hide();
        }else{
            progress.show();
        }

        //默认样式,适合page级别的遮罩
        var panelCss = {"position":"fixed",
            "top": 0,
            "right": 0,
            "bottom": 0,
            "left": 0,
            "z-index": options.zIndex,
            "background-color": "rgba("+options.backgroundColor+")"
            };

        //局部遮罩
        if(options.area=="this"){
            //遮罩当前标签的宽高范围
            var offset = $this.offset();

          $.extend(panelCss,{
              "position":"absolute",
              "width":$this.outerWidth(),
              "height":$this.outerHeight(),
              "top": offset.top,
              "left": offset.left,
              "right": "auto",
              "bottom": "auto"
            });

            $this.append(panel);
        } else if(options.area=="window"){
            //实现跨iframe的全局遮罩
            //全局遮罩,遮罩层所在的位置决定着它的遮罩范围
            //向上找到顶层窗口
            var pw = window.parent;
            while(pw){
                if(pw==pw.parent) break;//如果已经是顶层窗口则跳出
                pw = pw.parent;
            }
            //判断是否存在顶层窗口
            if(pw){
                //如果存在父窗口就将遮罩插入父窗口中显示
                var $parent = $("body",pw.document);
                panel.appendTo($parent);
            }else {
                //不存在父窗口的情况下,将遮罩层插入当前标签内
                panel.appendTo($this);
            }
        }else if(options.area=="page"){
            //遮罩当前标签所在的页面范围
            $this.append(panel);
        }
        panel.css(panelCss).hide();

        return {
            panel:panel,
            progress:progress
        };
    }

    //调用show方法
    $.fn.showBackdrop = function(val){
        $(this).backdrop("show",val);
        return this;
    };
    //调用hide方法
    $.fn.hideBackdrop = function(){
        $(this).backdrop("hide");
        return this;
    };
    //调用destroy方法
    $.fn.destroyBackdrop = function(){
        $(this).backdrop("destroy");
        return this;
    };

    $.fn.backdrop = function(options,args){
        if (typeof options == 'string'){
            return $.fn.backdrop.methods[options](this, args);
        }

        options = options || {};

        //构造遮罩
        return this.each(function(){
            var data = $.data(this, "backdrop");
            if (data) {
                $.extend(data.options, options);
                return;
            } else {
                options = optionsParser(this,options);
                var r = init($(this),options);
                data = $.data(this, "backdrop", {
                    options: options,
                    panel: r.panel,
                    progress: r.progress
                });
            }
        });
    };

    $.fn.backdrop.methods = {
        //显示
        show:function(target,val){
            var state = $(target).data("backdrop");
            if(state){
                state.panel.show();
                state.options.onShow.call(target,val);
                $(target).backdrop("setProgressValue",val);
            }
        },
        //隐藏
        hide:function(target,args){
            var state = $(target).data("backdrop");
            if(state){
                state.panel.hide();
                state.options.onHide.call(target);
            }
        },
        //设置进度条的值
        setProgressValue:function(target,val){
            var state = $(target).data("backdrop");
            if(state){
                _setProgressValue(state.progress,val);
                state.options.onValChange.call(target,val);
                state.options.progressValue = val;
            }
        },
        //销毁
        destroy:function(target,args){
            var state = $(target).data("backdrop");
            if(state){
                state.panel.remove();
                state.options.onDestroy.call(target);
                $(target).data("backdrop",null);
            }
        }
    };

    $.fn.backdrop.defaults = {
        backgroundColor:"80,80,80,0.65",//遮罩背景颜色(用RGBA描述)
        zIndex:1040,//遮罩层Z索引
        /*
        * 遮罩范围
        * this:遮罩当前元素的宽高范围
        * page:遮罩当前元素所在的页面
        * window:跨iframe,将整个浏览器工作区进行遮罩
         */
        area:'this',
        progress:true, //是否显示进度条
        progressWidth:280, //进度条宽度
        progressValue:0, //进度条的进度值
        onShow:function(e){},//显示事件
        onHide:function(e){},//隐藏事件
        onDestroy:function(e){},//销毁事件
        onValChange:function(e){} //进度值改变时触发
    };

    //options转换器
    function optionsParser(target,options){
        var $this = $(target);
        var options = $.extend({}, $.fn.backdrop.defaults, options || {}, $this.data());
        return options;
    }

    //自动渲染组件
    $(function(){
        $("form[data-toggle='backdrop']").each(function(){
            $(this).backdrop();
        });

    });
})(jQuery);