'use strict';
(function(){
  var app = angular.module('store',[]);
  app.controller('StoreController',function($scope){
    this.products = phones;
  });
  
  var phone = {name: "Nexus S",
         snippet: "Fast just got faster with Nexus S."};
  var phones = [
        {name: "Nexus S",
         snippet: "Fast just got faster with Nexus S."},
        {name: "Motorola XOOM™ with Wi-Fi",
         snippet: "The Next, Next Generation tablet."},
        {name: "MOTOROLA XOOM™",
         snippet: "The Next, Next Generation tablet."}
      ];
})();


