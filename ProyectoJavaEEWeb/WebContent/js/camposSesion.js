/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function inicio(){
    var usuario = document.getElementById("usu").value;
    var contrasena = document.getElementById("cont").value;
    
    if(usuario=='' || contrasena==''){
        alert("Hay campos vacios");
        return false;
    }else{
        return true;
    }
}