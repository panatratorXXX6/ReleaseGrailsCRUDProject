
function editAuthor(id) {
    document.location="/author/edit/" + id
}

function deleteAuthor(id) {
    var txt;
    var r = confirm("Do you really want delete this Author?");
    if (r) {
        $("#five").attr("value", id);
        $(".deleteFunction").submit();
    } else {
        txt = "Good choice";
        alert(txt)
    }
}

function increase(){
    $("#table").css("background-color", "grey")
    $("#undoId").attr("type", "submit")
    $("#increaseA").attr("type", "hidden")
}

function undo() {
    $(".tab").css("background-color", "white")
    $("#undoId").attr("type", "hidden")
    $("#increaseA").attr("type", "submit")
}

