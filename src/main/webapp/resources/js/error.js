/**
 * 
 */
 function error_toggle()
{
   if(!document.getElementById("agree").checked)
   {
      document.getElementById("message").setAttribute("class","error");
      return false;
   }
   else
   {
      return true;
   }
}