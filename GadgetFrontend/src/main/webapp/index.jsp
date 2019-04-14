<%@ include file="/WEB-INF/views/Header.jsp" %>    

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide"  data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
      <li data-target="#myCarousel" data-slide-to="4"></li>
      <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

       
      <div class="item active" align="center">
      <a href="<c:url value="/creditsHomePage"/>">
        <img src="<c:url value="/resources/images/voucher.jpg"/>" width=600 height=300>
      </a>
      </div>
      
      
      <div class="item" align="center">
      <a href="<c:url value="/productsDisplay"/>">
        <img src="<c:url value="/resources/images/carousel-10.jpg"/>" width=600 height=300>
        </a>
      </div>
     
      <div class="item" align="center">
        <img src="<c:url value="/resources/images/seller.JPG"/>" width=600 height=300>
      </div>
      
       <div class="item" align="center">
        <a href="<c:url value="/productsDisplay"/>">
        <img src="<c:url value="/resources/images/carousel-1.jpeg"/>" width=600 height=300>
        </a>
      </div>
      
      <div class="item" align="center"> 
           <a href="<c:url value="/productsDisplay"/>">
      
        <img src="<c:url value="/resources/images/carousel-2.jpg"/>" width=600 height=300>
        </a>
      </div>

      <div class="item" align="center">
            <a href="<c:url value="/productsDisplay"/>">
      
        <img src="<c:url value="/resources/images/carousel-9.jpg"/>" width=600 height=300>
        </a>
      </div>
       
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>

</body>
</html>