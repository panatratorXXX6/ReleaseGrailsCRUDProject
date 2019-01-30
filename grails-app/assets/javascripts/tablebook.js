
function editBook(id) {
    document.location="/book/edit/"+ id;
}


function deleteBook(id) {
    var txt;
    var r = confirm("Do you really want delete this Book?");
    if (r) {
        $("#six").attr("value", id);
        $(".deleteFunctionBook").submit();
    } else {
        txt = "Good choice";
        alert(txt);
    }
}