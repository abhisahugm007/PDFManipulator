<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="dist/css/app.b49cf26.css" rel="stylesheet"></head>
<body class="toolpage  lang-en-US">
<div class="header">
    <div class="header__main">
        <div class="brand">
    <div class="brand__logo">
        <a href="/PDFManipulator/indexPage"
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
            <h1 class="tool__header__title">MERGE PDF file</h1>
            <h2 class="tool__header__subtitle">to merge all the pdf that you wanna upload.</h2>
        </div>
        <div id="uploader" class="uploader">
	<form action="/PDFManipulator/mergePdf" method="post" enctype="multipart/form-data">
  <input class="uploader__btn tooltip--left" type="file" name="userfiles" multiple required/>
 
  <button class="uploader__btn tooltip--left"  type="submit">Submit</button>
</form>
</div>             
</div>
</div>
</div>
            <div class="footer">
    <div class="footer__copy">
       <strong>DEVELOP BY ABHISHEK</strong>  </div>
</div>    
</body>
</html>
