<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>I love Pdf</title>
    

    <style>
        .navbar{
            background-color: black;
            border-radius: 30px;
        }
        .navbar ul{
            overflow: auto;
        }
        .navbar li{
            float:left;
            list-style: none; 
            margin: 13px 20px;
            
        }
        .navbar li a{
            padding: 3px 3px;
            text-decoration: none;
            color: white;
        }
        .navbar li a:hover{
            color: red
        }
        .search{
            float: right;
            color: white;
            padding: 12px 75px;
        }
        .navbar input{
            border: 2px solid black;
            border-radius: 14px;
            padding: 3px 17px;
            width: 129px;
        }
        .sub-menu-1{
          display:none;
        }
        .navbar ul li:hover .sub-menu-1{
          display: block;
          position: absolute;
          background: black;
          margin-top: 15px;
          margin-left: -15px;
        }
        .navbar ul li:hover .sub-menu-1{
          display: block;
          margin:10px;
        }
        .jumbotron-img{
          background-image: url(https://live.staticflickr.com/908/41281384105_6fab834b14_b.jpg);
          background-size: auto 100%;
          color:red;
          font-family: sans-serif;
        }
        .content {
          max-width: 500px;
          margin: auto;
        }
        .container {
          display: flex;
          justify-content: center;
          flex-direction: row;
        }
        .back{
          background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ1QOPwA3UFVxTvTH5lUub8_hunnf1NmtZ2LmRraSPUhcqPSIhw&usqp=CAU);
          background-size: cover;
        }
        .align{
          text-align: right;
        }
    </style>
</head>
<body>
<form action="pdftoImage" method="get">
<h1>Select PDF file to convert in jpg</h1>
<input type="file" name="userfileString"><br>
<input type="submit">

</form>
</body>
</html>