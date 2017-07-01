/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('#nick').blur(function (event) {
        var nombreVar = $('#nick').val();
        var div = $('#divNick');
        var span1 = $('#primerSpan');
        var span2 = $('#inputSuccess2Status');
        // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
        $.post('Usuario', {
            usu: nombreVar
        }, function (responseText) {
            if(responseText==0){
                div.attr('class', 'form-group has-success has-feedback');
                span1.attr('class', 'glyphicon glyphicon-ok form-control-feedback');
                span1.css('display','block');
                span2.css('display','block');
            }else{
                div.attr('class','form-group has-error has-feedback');
                span1.attr('class', 'glyphicon glyphicon-remove form-control-feedback');
                span1.css('display', 'block');
                span2.css('display','block');
            }
        });
    });
});

$(document).ready(function(){
    $('#mail').blur(function(event){
        var mailIngresado = $('#mail').val();
        var div = $('#divMail');
        var span1 = $('#segundoSpan');
        var span2 = $('#inputGroupSuccess1Status');
        $.post('Mail', {
            mail: mailIngresado
        }, function(response){
            if(response == 0){
                div.attr('class', 'form-group has-success has-feedback');
                span1.attr('class', 'glyphicon glyphicon-ok form-control-feedback');
                span1.css('display','block');
                span2.css('display','block');
            }else{
                div.attr('class','form-group has-error has-feedback');
                span1.attr('class', 'glyphicon glyphicon-remove form-control-feedback');
                span1.css('display', 'block');
                span2.css('display','block');
            }
        });
    });
});