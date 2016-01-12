//-------------------------------
//Implementation using AngularJS
//-------------------------------

var DataApp = angular.module('DataApp', []);


DataApp.controller('DataController', ['DataFactory', function (DataFactory) {
        var self = this;

        self.data = [];

        self.getRandomData = function (num, input) {
            DataFactory.getRandomData(num, input).then(function (success) {
                self.data = success.data;
            }, function (error) {
                console.log("something went wrong");
            });
        };

    }]);

DataApp.factory('DataFactory', ['$http', function ($http) {

        var getRandomData = function (num, input) {
            var url = "api/addresses/" + num + "/" + input;
//            var url = "api/addresses/" + 10 + "/" + "fname,lname,city";
            return $http.get(url);
        };

        return {
            getRandomData: getRandomData
        };

    }]);


//----------------------------------------------------------------

/*

//----------------------------
//Implementation using jQuery
//----------------------------
 
 $(document).ready(function () {
 //random quote of today
 getRandomPersons();
 });
 
 function getRandomPersons() {
 var url = "http://localhost:8080/SP5_ExamPrep_REST_JSON/api/addresses/10/fname,lname,city";
 $.ajax({
 url: url,
 method: "GET",
 success: function (data) {
 var table = $.makeTable(data);
 $(table).appendTo("#table");
 },
 error: function (data) {
 }
 });
 }
 
 $.makeTable = function (mydata) {
 var table = $('<table border=1>');
 var tblHeader = "<tr>";
 for (var k in mydata[0])
 tblHeader += "<th>" + k + "</th>";
 tblHeader += "</tr>";
 $(tblHeader).appendTo(table);
 $.each(mydata, function (index, value) {
 var TableRow = "<tr>";
 $.each(value, function (key, val) {
 TableRow += "<td>" + val + "</td>";
 });
 TableRow += "</tr>";
 $(table).append(TableRow);
 });
 return ($(table));
 };
 //----------------------------------------------
 */

