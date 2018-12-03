$('#ff').form({
    url:...,
    onSubmit: function(){
		// do some check
		// return false to prevent submit;
    },
    success:function(data){
		alert(data)
    }
});

// submit the form
$('#ff').submit();
// call 'submit' method of form plugin to submit the form
$('#ff').form('submit', {
    url:...,
    onSubmit: function(){
		// do some check
		// return false to prevent submit;
    },
    success:function(data){
		alert(data)
    }
});
$('#ff').form('submit', {
    url:...,
    onSubmit: function(param){
		param.p1 = 'value1';
		param.p2 = 'value2';
    }
});
{
    "success": true,
    "message": "Message sent successfully."
}
$('#ff').form('submit', {
    success: function(data){
		var data = eval('(' + data + ')'); // change the JSON string to javascript object
		if (data.success){
			alert(data.message)
		}
    }
});