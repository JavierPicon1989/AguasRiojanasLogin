<?php

include 'conexion.php';
$usuario = filter_input(INPUT_POST,"usuario");
$password = filter_input(INPUT_POST, "password");

//if($usuario == "rashid" && $password=="coder" ){
//    echo '1';
//}else{
//    echo '0';
//}
$query= "SELECT nombre, password FROM users WHERE nombre = '$usuario' and password= '$password'";
 $result= mysqli_query($connect, $query);
 
 if($data = mysqli_fetch_array($result)){
     echo '1';
 }




?>