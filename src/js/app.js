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
  	.when("", {templateUrl: "partials/home.html", controller: "PageCtrl"})
  	.when("/", {templateUrl: "partials/home.html", controller: "PageCtrl"})
    // Home
    .when("/index.html", {templateUrl: "partials/home.html", controller: "PageCtrl"})
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




