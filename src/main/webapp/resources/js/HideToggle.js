/**
 * 
 */

window.onload = function()
{
    var first = document.getElementById("faqMenuParent").firstChild;
    
    first.className += " current";
}


function menu_toggle(obj)
{
   var nextEle = obj.nextElementSibling;

   nextEle.classList.toggle("hide");
}

function openFaqMenu(evt, faqMenuName)
{
    var i, faq_cell, category_list;
    
    faq_cell = document.getElementsByClassName("faq_cell");
    for (i = 0; i<faq_cell.length; i++)
    {
       faq_cell[i].style.display = "none";
    }
    
    category_list = document.getElementsByClassName("category_list");
    for (i = 0; i<category_list.length; i++)
    {
       category_list[i].className = category_list[i].className.replace(" current", "");
    }
    
    for (i = 0; i<faq_cell.length; i++)
    {
       if(faq_cell[i].classList.contains(faqMenuName) )
       {
          faq_cell[i].style.display = "block";
       }
    }
    
    evt.currentTarget.className += " current";
}