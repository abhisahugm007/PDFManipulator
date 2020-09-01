<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="dist/css/app.b49cf26.css" rel="stylesheet"></head>
<body class="toolpage  lang-en-US">
<div class="header">
    <div class="header__main">
        <div class="brand">
    <div class="brand__logo">
        <a href="/PDFManipulator/index1"
           title="iLovePDF">
                <img src="ilovepdf.svg" alt="iLovePDF">
        </a>
    </div>
</div>      
</div>
</div>
<div class="main">

<div class="tool">
    <div class="tool__workarea" id="workArea">
        <div id="dropArea"></div>
        <div class="tool__header">
            <h1 class="tool__header__title">Split PDF file</h1>
            <h2 class="tool__header__subtitle">Separate one page or a whole set for easy conversion into independent PDF files.</h2>
        </div>
        <div id="uploader" class="uploader">
       
	<form action="/PDFManipulator/splitPdf" method="post">
  <input class="uploader__btn tooltip--left" type="file" name="userfileString"/><br><br>
  <button class="uploader__btn tooltip--left"  type="submit">Submit</button>
  
</form>
</div>             
</div>
</div>

</div>
            <div class="footer">
    <div class="footer__copy">
       <strong>DEVELOP BY ABHISHEK_SAHU</strong>  </div>
</div>      
</body>
</html>
