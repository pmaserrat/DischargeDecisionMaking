/**
 * Main AngularJS Web Application
 */
var app = angular.module('angularProject', [
  'ngRoute'
]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
  	.when("", {templateUrl: "src/partials/home.html", controller: "PageCtrl"})
  	.when("/", {templateUrl: "src/partials/home.html", controller: "PageCtrl"})
    // Home
    .when("/index", {templateUrl: "src/partials/home.html", controller: "PageCtrl"})
    .when("/test", {templateUrl: "src/test.html", controller: "PageCtrl"})
    // Pages
    .when("/PAGE1", {templateUrl: "partials/PAGE1.html", controller: "PageCtrl"})
    .when("/PAGE2", {templateUrl: "partials/PAGE2.html", controller: "PageCtrl"})
    // else 404
    .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});
}]);


/**
 * Controls all other Pages
 */
app.controller('PageCtrl', function (/* $scope, $location, $http */) {
  console.log("Page Controller reporting for duty.");

  
	$('.nav a').on('click', function(){
		$('.navbar-collapse').collapse('hide');
	});
  	$(document).on('click',function(){
		$('.navbar-collapse').collapse('hide');
	});
  	
  	
});

//Create the XHR object.
function createCORSRequest(method, url) {
  var xhr = new XMLHttpRequest();
  if ("withCredentials" in xhr) {
    // XHR for Chrome/Firefox/Opera/Safari.
    xhr.open(method, url, true);
  } else if (typeof XDomainRequest != "undefined") {
    // XDomainRequest for IE.
    xhr = new XDomainRequest();
    xhr.open(method, url);
  } else {
    // CORS not supported.
    xhr = null;
  }
  return xhr;
}

// Helper method to parse the title tag from the response.
function getTitle(text) {
  return text.match('<title>(.*)?</title>')[1];
}

// Make the actual CORS request.
function makeCorsRequest() {
  // This is a sample server that supports CORS.
  var url = 'http://html5rocks-cors.s3-website-us-east-1.amazonaws.com/index.html';

  var xhr = createCORSRequest('GET', url);
  if (!xhr) {
    alert('CORS not supported');
    return;
  }

  // Response handlers.
  xhr.onload = function() {
    var text = xhr.responseText;
    var title = getTitle(text);
    alert('Response from CORS request to ' + url + ': ' + title);
  };

  xhr.onerror = function() {
    alert('Woops, there was an error making the request.');
  };

  xhr.send();
}


