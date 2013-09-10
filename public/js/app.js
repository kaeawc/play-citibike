'use strict';

require(['angular.min'],function() { 
  /* App Module */

  angular.module('citibike', []).
    config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/branches', {templateUrl: '/branches' }).
        when('/helmets', {templateUrl: '/helmets' }).
        when('/stations', {templateUrl: '/stations' }).
        otherwise({redirectTo: '/home'});
  }]);
})