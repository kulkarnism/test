<#include "./header.ftl"> 
<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>
<form>
<br/>
<#if universityObject?has_content>
<h1><div align="center">Details of University</div></h1>
<div ="input page">
<div align="left">
 <table class="datatable" border="1" cellpadding="5">
 <#list universityObject as universityObject>
    <tr>
        <th rowspan ="2" >School Name</th>  
        <th rowspan ="2">Tution Fees</th>
        <th rowspan="2">Location</th>
        <th rowspan = "2">Contact</th>
<th colspan="2">Application Date</th>
    </tr>
    <tr>
     <td><b>Spring Term</td>
     <td><b>Fall Term</td>     
    </tr> 
    <tr>
     <td>${universityObject.getSchoolName()}</td>
     <td>${universityObject.getTuitionFees()}</td>
     <td>${universityObject.getLocation()}</td>
      <td>${universityObject.getContact()}</td>
      <td>${universityObject.getSpringApplnDate()}</td>
      <td>${universityObject.getFallApplnDate()}</td>
    </tr>   
  </table>
</div>
</br>
</br>
</br>
</br>
</br>
<div align="center">
<table class="datatable" border="1" cellpadding="5">
  <tr>
  		<th>Department</th>  
        <th>GRE Score</th>
        <th>TOEFL Score</th>
        <th>IELTS Score</th>
   </tr>
   
   <tr>
   		<td>${universityObject.getDepartment()}</td>
   		<td>${universityObject.getGreScore()}</td>
   		<td>${universityObject.getToeflScore()}</td>
   		<td>${universityObject.getIeltsScore()}</td>
   </tr>
 </#list>
</table>
</div>
<#else>
<div align="center">Enter the university: <input type="text" name="searchText" /> <br/><br/>
<input type="submit" value="submit" name="submit" /></div>
</#if>
</form>
<#include "./footer.ftl"> 