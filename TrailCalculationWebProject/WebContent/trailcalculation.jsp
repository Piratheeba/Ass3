<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="HTML/Header.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Trail Calculation Page</title>
</head>
<body>
	<%
		if (request.getAttribute("error") != null) {
	%>
			<div class="alert alert-danger"><strong>ERROR!</strong><% out.println(request.getAttribute("error")); %></div>
	<%
		}
	%>
                <div class="container" id="trailcalculation">

 				<a href="../TrailCalculationWebProject" class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Back</a>

                    <h2>Loan Details</h2>

                    <form class="form-horizontal" role="form" action="calculation" id="calcuationform" onsubmit=" onsubmit="submitForm(event)" name="calcuationform" method="POST">
                        <div class="form-group">
                            <label for="LoanAmount" class="col-sm-3 control-label">Loan Amount</label>
                            <div class="col-sm-9">
                                <input type="text" name="lAmount" id="LoanAmount" placeholder="Enter Loan_Amount" class="form-control" autofocus>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="interestRate" class="col-sm-3 control-label">Interest Rate</label>
                            <div class="col-sm-9">
                                <input type="text" name="iRate" id="interestRate" placeholder="Enter Interest_Rate" class="form-control" autofocus>                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="repaymentPeriod" class="col-sm-3 control-label">Repayment_Period</label>
                            <div class="col-sm-9">
                                <input type="text" id="repaymentPeriod" name="rpayment" placeholder="Enter Repayment_period" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="NIC_NO" class="col-sm-3 control-label">NIC_NO</label>
                            <div class="col-sm-9">
                                <input type="text" id="NIC_NO" name="nicno" class="form-control">
                            </div>
                        </div>                    
                        
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <button name="CalculateButton" class="btn btn-primary btn-block" type="submit" id="CalculationButton" value="Submit">Calculate</button>
                                
                            </div>
                        </div>
                        
                    </form>
                </div>
	
</body>
</html>