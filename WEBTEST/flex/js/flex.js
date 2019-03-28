/// <reference path="_references.js" />
$(function () {
	$(".uitem ul").hide();
	$(".litem>a").toggle(function () {
		$(this).next().slideDown();
	}, function () {
		$(this).next().slideUp();
	});
});