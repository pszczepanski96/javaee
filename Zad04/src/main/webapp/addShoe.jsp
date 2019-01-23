<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding shoe</title>
</head>
<body>
<h2>Add shoe</h2>
<form action='addingProces'>
	Producer: <input type='text' name='producer' /> <br />
	Date of production (yyyy-mm-dd): <input type='text' name='productionDate' /> <br />
	Price: <input type='text' name='price' /> <br />
	Quantity: <input type='number' name='quantity' /> <br />
	Waterproof: <select name='waterproof'>
	<option value='true'>Yes</option>
	<option value='false'>No</option>"
	</select></br>
	<input type='submit' value=' ADD' />
</form>
  <a href="zad04">Back to main sites</a>

</body>
</html>

