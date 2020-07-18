$(document).ready(function() {
  var api_url = 'http://localhost:4502/content/abott/content/jcr:content/root/contentfragmentlist.model.json';
     $.ajax({
        url: api_url,
        contentType: "application/json",
        dataType: 'json',
        success: function(result){
            console.log(result.items[0]);
        }
    });
});
