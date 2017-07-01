/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function datosCompletos(){
    var nickname = document.getElementById("nick").value;
    var contrasena = document.getElementById("password").value;
    var contrasena2 = document.getElementById("password2").value;
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var email = document.getElementById("email").value;
    var fecha = document.getElementById("fecha").value;
    
    if(contrasena!=contrasena2){
        alert("Las contrasenas no coinciden");
        return false;
    }
    
    if(nickname=='' || contrasena=='' || contrasena2=='' || nombre=='' || apellido=='' || email=='' || fecha==''){
        alert("Hay campos vacios");
        return false;
    }else{
        return true;
    }
}

