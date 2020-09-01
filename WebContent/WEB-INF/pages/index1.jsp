<!DOCTYPE html>
<html lang="en">

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
  <div class="back">
      <header>
          <nav class="navbar">
              <ul>
                  <li><a href="merge">MERGE PDF</a></li>
                  <li><a href="split">SPLIT PDF</a></li>
                  <li><a href="extractData">EXTRACT PDF</a></li>
                  <li><a href="removePdfPage">REMOVE PAGE</a></li>
                  <li><a href="PdfToImage">PDF TO JPG</a></li>
                  <li><a href="protectPDF">PROTECT PDF</a></li>
                  <li><a href="RegisterUi">SIGN UP</a></li>
                  <li><a href="#">LOG IN</a></li>
              </ul>
          </nav>
          <div class="jumbotron jumbotron-img">
            <h1 class="display-4"><strong>I LOVE PDF</strong></h1>
            <p class="lead"><strong>Every tool you need to work with PDFs in one place</strong></p>
            <hr class="my-4">
            <p><strong>Every tool you need to use PDFs, at your fingerTips. All are 100% FREE and easy to use! Merge, split, compress, convert, rotate, unlock and watermark PDFs with just a few clicks.</strong></p>
            <p class="lead">
              <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
            </p>
          </div>
      </header>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap">
              <div class="card-body">
                <a href="merge" class="btn btn-outline-danger">MERGE PDF</a>
                <p class="card-text">Combines pdf in the order you want with the easiest pdf merger available.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <a href="split" class="btn btn-outline-danger">SPLIT PDF</a>
                <p class="card-text"> Seperate the one page or a whole set for easy conversion into independent PDF files.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <a href="extractData" class="btn btn-outline-danger">EXTRACT PDF</a>
                <p class="card-text">Extract all Unicode text from PDF very easy.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    <br>
    <br>
    <br>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <a href="removePdfPage" class="btn btn-outline-danger" >REMOVE PAGE</a>
                <p class="card-text">Easily Remove unwanted Pages from Pdf.The converted file is of 100% doccument format.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <a href="PdfToImage" class="btn btn-outline-danger" >PDF TO JPG</a>
                <p class="card-text">Turn your PDF files into PDF to easy to view Image or JPG file formate. You can get all images in zip formate .</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <a href="protectPDF" class="btn btn-outline-danger">PROTECT PDF</a>
                <p class="card-text">Pull data straight from PDF into excel spreadsheets. Then, we can easily edit it.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    <br>
    <br>
    <br>
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <button type="submit" class="btn btn-danger">WORD TO PDF</button>
                <p class="card-text">Make Doc and docx file easy to read by converting the into PDF. You can also edit them here.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image cap" alt="Card image cap">
              <div class="card-body">
                <button type="submit" class="btn btn-danger">POWERPOINT TO PDF</button>
                <p class="card-text">Make PPT easy to view by converting them into PDF. You can also edit your PPT here.</p>
              </div>
           </div>
          </div>
          <div class="col-md-4">
            <div class="card text-center" style="width: 18rem;">
              <img class="card-img-top" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRkCEObYeTjtTDkEPUuf3Hyk-0F7B1gvev_lMKTxCZ2xQC1mUey&usqp=CAU" alt="Card image " alt="Card image cap">
              <div class="card-body">
                <button type="submit" class="btn btn-danger">EDIT PDF</button>
                <p class="card-text">Edit the PDF by adding Text Images and many more things in it.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    <br>
    <br>
    <br>
      <footer>
        <div class="jumbotron jumbotron-fluid">
          <div class="container">
            <p class="lead">This is a User interface of I love pdf site. If you want to integrate it with your project than you can</p>
          </div>
          <div class="align">
            <h5>MADE BY:-</h5>
            <h6>ABHISHEK SAHU</h6>
          </div>
        </div>
      </footer>
  </div>
</body>
</html>