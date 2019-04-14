<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="container">
<div class="col-md-6 item-photo">
<img src="<c:url value="/resources/images/seller.JPG"/>"  height=500 width=1000 />
</div>
</div>
<div class="container">
 <div class="row main">
  <div class="main-login main-center">
   <h2>Register Now as Seller</h2>

      <form:form method="post" action="addSeller" >
      
      <div class="form-group">
        <label for="name" class="cols-sm-2 control-label">Your Name</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
            <input type="text" name="sellerName" id="sellerName"class="form-control input-sm chat-input" placeholder="Your name" />
          </div>
         </div>
        </div>

       
        
        <div class="form-group">
        <label for="username" class="cols-sm-2 control-label">UserName</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="username" id="username"class="form-control input-sm chat-input" placeholder="User Name" />
          </div>
         </div>
        </div>
        
        <div class="form-group">
        <label for="customerAddr" class="cols-sm-2 control-label">Address</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="text" name="address" id="address"class="form-control input-sm chat-input" placeholder="Address" />
          </div>
         </div>
        </div>
        
        <div class="form-group">
        <label for="password" class="cols-sm-2 control-label">Password</label>
         <div class="cols-sm-10">
          <div class="input-group">
           <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
            <input type="password" name="password" id="password"class="form-control input-sm chat-input" placeholder="Password" />
          </div>
         </div>
        </div>
        
        <div class="form-group">
           <input type="submit" value="Register"/>
        </div>
   </form:form>        

</div>
</div>
</div>
</body>
</html>