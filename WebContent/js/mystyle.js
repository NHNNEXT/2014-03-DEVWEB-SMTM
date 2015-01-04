(function(){

function setNavbarStyle() {
	var url = window.location.pathname;
	var menuUl = document.getElementsByClassName('navbar-nav')[0];
	var menuLi = menuUl.getElementsByTagName('li');

	[].forEach.call(menuLi, function(item){
		var menuUrl = item.getElementsByTagName('a')[0].getAttribute("href");

		if (menuUrl == url) {
			item.className = "active";
		}
	});
}

window.addEventListener('load', setNavbarStyle, false);

})();