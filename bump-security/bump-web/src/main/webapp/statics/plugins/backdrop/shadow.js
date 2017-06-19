;
(function($) {
	$.fn.shadow = function(funName) {
		if (!funName || funName == 'show') {
			$(this).backdrop({
				area : 'page'
			}).showBackdrop(100);
		} else if (funName == 'hide') {
			$(this).backdrop("destroy");
		}
	}
})(jQuery);