
function descriptionAuthor(id) {

    $.ajax({
        url:'/author/ajax' ,
        type: 'POST',
        data: JSON.stringify({id: id}),
        dataType: 'json',
        contentType: 'application/json',
        cache: false,
        success: function(authorKey) {

           $("#modalname").html(authorKey.authorKey.name);
           $("#modaladdress").html(authorKey.authorKey.address);
           $("#modaldescription").html(authorKey.authorKey.description);

           $("#dialog").dialog("open");

        },
        error: function() {
            alert('error loading ajax call')
        }
    });
};


$(document).ready(function() {
    $("#dialog").dialog({
        autoOpen: false
    });
});