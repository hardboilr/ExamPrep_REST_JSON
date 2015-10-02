$(document).ready(function () {
    //random quote of today
    getRandomPersons();
});

function getRandomPersons() {
    var url = "http://localhost:8080/ExamPrep_REST_JSON/api/addresses/10/fname,lname,city";
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

