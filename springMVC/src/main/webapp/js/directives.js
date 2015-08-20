'use strict';

/* Directives */


angular.module('myApp.directives',[]).
  directive('datepickerFrom', function() {
    return  {
       restrict: 'A',
       require: 'ngModel',
	   link: function(scope, element, attrs, ngModel) {
                console.log('call datepicker-from link...');
                var picker = element.datetimepicker({
                	 weekStart: 1,
                     todayBtn:  1,
                     autoclose: 1,
                     todayHighlight: 1,
                     startView: 2,
                     minView: 2,
                     forceParse: 0,
                    pickerPosition: "bottom-left",
                }).on('changeDate', function(ev) {
                    var startDate = new Date(ev.date);
                    console.log("##########"+startDate);
                    scope.$apply(function(){
                        ngModel.$setViewValue(startDate);
                        scope.isStartEmpty = false;
                    });
                });

    }
	};
  })
  .directive('datepickerTo', function() {
        return {
            restrict: 'A',
            require: 'ngModel',
            link: function(scope, element, attrs, ngModel) {
                console.log('call datepicker-to link...');
                var picker = element.datetimepicker({
                	 weekStart: 1,
                     todayBtn:  1,
                     autoclose: 1,
                     todayHighlight: 1,
                     startView: 2,
                     minView: 2,
                     forceParse: 0,
                    pickerPosition: "bottom-left"
                }).on('changeDate', function(ev) {
                    var endDate = new Date(ev.date);
                    console.log("##########"+endDate);
                    scope.$apply(function(){
                        ngModel.$setViewValue(endDate);
                        scope.isEndEmpty = false;
                    });
                });

                // Listen for change events to enable binding
                /*element.on('blur keyup change', function() {
                 scope.$apply(function(){
                 ngModel.$setViewValue($("#dtp_input_f").val());
                 scope.isFromEmpty = false;
                 });
                 });*/
            }
        };
    });
