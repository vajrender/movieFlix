/**
 * 
 */

	$(document).ready(function() {

		$('#loginForm').submit(function(e) {
			var frm = $('#loginForm');
			e.preventDefault();

		    var data = {}
		    var Form = this;

		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		        
		    });
		    
		    
		    
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(callback){              
            	alert("Response:  Email: "+callback.email+"  Password: "+callback.password);
            },
            error : function(){
            
            	alert("User with this email Id already exists");
                $(this).html("Error!");
            }
        });
		});
	});