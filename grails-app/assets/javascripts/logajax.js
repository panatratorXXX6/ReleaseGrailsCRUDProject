
function deleteLogs() {
    var txt;
    var r = confirm("Do you really want delete all Logs?");
    if (r) {
        $("#ten").attr("value", id);
        $(".deleteLogFunction").submit();
    } else {
        txt = "Good choice";
        alert(txt);
    }
}