<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AppCraft Assignment</title>
<script>
$(document).ready(function() {
    $('#ajaxCall').submit(
        function(event) {
        	event.preventDefault();
            var productCode = $('#productCode').val();
            var size = $('#size').val();  
            var stock= $('#stock').val();
            var data = 'productCode='
                    + encodeURIComponent(productCode)
                    + '&size='
                    + encodeURIComponent(size)
                    + '&stock='
                    + encodeURIComponent(stock);
            $.ajax({
                url : $("#ajaxCall").attr("action"),
                data : data,
                type : "POST",
 
                success : function(response) {
                     console.log(response) ;
                     alert("Product is added");
                },
                error : function(xhr, status, error) {
                    console.log(xhr.responseText);
                    alert("Unable to add product");
                }
            });
            return false;
        });
    });
</script>
</head>
<body>

<h3>Welcome to Product Page</h3>


<form id="ajaxCall" action="/addProduct">
  Product Code <input type="text" name="productCode" id="productCode"> <br>
  Size <input type="text" name="size" id="size" > <br>
  Stock <input type="text" name="stock" id="stock"> <br>
  <button type="submit">Submit</button>
</form>
<br>
<br>
See more product details <a href="/productDetail">here</a>


</body>

</html>